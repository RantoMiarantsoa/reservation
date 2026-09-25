#!/usr/bin/env bash

set -e

ROOT="$(cd "$(dirname "$0")" && pwd)"
BUILD="$ROOT/build"
SERVER="$BUILD/reservation-server"

"$ROOT/compile.sh"

echo "Edition du serveur C++..."
g++ -std=c++17 \
  "$BUILD/cpp/"*.o \
  $(pkg-config --libs omniORB4 2>/dev/null || echo -lomniORB4 -lomnithread) \
  -lmysqlcppconn \
  -o "$SERVER"

rm -f "$ROOT/config/reservation.ior"

echo "Execution du serveur C++..."
(cd "$ROOT" && "$SERVER") &
SERVER_PID=$!
trap 'kill "$SERVER_PID" 2>/dev/null || true' EXIT

for _ in $(seq 1 30); do
  [ -f "$ROOT/config/reservation.ior" ] && break
  kill -0 "$SERVER_PID" 2>/dev/null || exit 1
  sleep 1
done

[ -f "$ROOT/config/reservation.ior" ] || {
  echo "Erreur: le serveur n'a pas genere config/reservation.ior" >&2
  exit 1
}

echo "Execution du client Java..."
cd "$ROOT"
mvn -q dependency:build-classpath \
  -Dmdep.outputFile="$BUILD/java.classpath"

java -Dreservation.ior="$ROOT/config/reservation.ior" \
  -cp "$ROOT/target/classes:$(cat "$BUILD/java.classpath")" \
  main.java.Client