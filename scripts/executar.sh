#!/usr/bin/env bash
set -euo pipefail

if (( $# == 0 )); then
    printf 'Uso: bash scripts/executar.sh pacote.Classe [argumentos]\n' >&2
    exit 2
fi

scripts=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)
classes=$(mktemp -d)
trap 'rm -rf -- "$classes"' EXIT
java=${JAVA_HOME:+"${JAVA_HOME}/bin/"}java

bash "$scripts/compilar.sh" "$classes"
"$java" -ea -cp "$classes" "$@"
