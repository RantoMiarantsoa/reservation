#!/usr/bin/env bash

set -e

ROOT="$(cd "$(dirname "$0")" && pwd)"
BUILD="$ROOT/build"
IDL="$ROOT/src/main/idl/Reservation.idl"
JAVA_DIR="$ROOT/src/main/java"

mkdir -p "$BUILD/omni" "$BUILD/cpp"

echo "Generation omniORB..."
omniidl -bcxx -C "$BUILD/omni" "$IDL"

echo "Compilation Java..."
mapfile -t JAVA_SOURCES < <(find "$JAVA_DIR" -type f -name '*.java' -print | sort)
if [ "${#JAVA_SOURCES[@]}" -eq 0 ]; then
  echo "Aucun fichier Java trouve dans $JAVA_DIR"
  exit 1
fi

echo "${#JAVA_SOURCES[@]} fichier(s) Java trouve(s)"
(cd "$ROOT" && mvn -q clean package)

echo "Compilation C++..."
mapfile -t SOURCES < <(
  find "$ROOT/src/main/cpp" "$BUILD/omni" -type f \
    \( -name '*.cpp' -o -name '*.cc' -o -name '*.cxx' \) -print | sort
)

OBJECTS=()
for SOURCE in "${SOURCES[@]}"; do
  NAME="$(basename "${SOURCE%.*}")"
  OBJECT="$BUILD/cpp/$NAME.o"

  g++ -std=c++17 -Wall -Wextra \
    -I"$BUILD/omni" -I"$ROOT/src/main/idl" \
    -c "$SOURCE" -o "$OBJECT"

  OBJECTS+=("$OBJECT")
done

ar rcs "$BUILD/cpp/libreservation.a" "${OBJECTS[@]}"

echo "Compilation terminee."

if [ -n "${CPP_EXECUTABLE:-}" ]; then
  "$CPP_EXECUTABLE"
fi

if [ -n "${JAVA_MAIN_CLASS:-}" ]; then
  (cd "$ROOT" && mvn -q exec:java -Dexec.mainClass="$JAVA_MAIN_CLASS")
fi