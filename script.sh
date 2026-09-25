#!/usr/bin/env bash

set -Eeuo pipefail

ROOT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
BUILD_DIR="${ROOT_DIR}/build"
CPP_BUILD_DIR="${BUILD_DIR}/cpp"

log() {
    printf '[build] %s\n' "$*"
}

fail() {
    printf '[build] erreur: %s\n' "$*" >&2
    exit 1
}

command -v mvn >/dev/null 2>&1 || fail "Maven est requis pour compiler Java."
command -v g++ >/dev/null 2>&1 || fail "g++ est requis pour compiler C++."
command -v ar >/dev/null 2>&1 || fail "ar est requis pour créer la bibliothèque C++."

mapfile -t CPP_SOURCES < <(
    find "${ROOT_DIR}/src" \
        -type f \
        \( -name '*.cc' -o -name '*.cpp' -o -name '*.cxx' \) \
        -print | sort
)

if ((${#CPP_SOURCES[@]} == 0)); then
    fail "Aucune source C++ trouvée sous ${ROOT_DIR}/src."
fi

mkdir -p "${CPP_BUILD_DIR}"

log "Compilation Java avec Maven..."
(cd "${ROOT_DIR}" && mvn -B clean package)

log "Compilation C++..."
CPP_OBJECTS=()
for source in "${CPP_SOURCES[@]}"; do
    relative="${source#"${ROOT_DIR}"/}"
    object="${CPP_BUILD_DIR}/${relative%.*}.o"
    mkdir -p "$(dirname -- "${object}")"

    g++ \
        -std=c++17 \
        -Wall \
        -Wextra \
        -I"${ROOT_DIR}/src/main/idl" \
        -c "${source}" \
        -o "${object}"

    CPP_OBJECTS+=("${object}")
done

ar rcs "${CPP_BUILD_DIR}/libreservation.a" "${CPP_OBJECTS[@]}"

log "Compilation terminée."
log "Classes Java : ${ROOT_DIR}/target/classes"
log "Bibliothèque C++ : ${CPP_BUILD_DIR}/libreservation.a"
