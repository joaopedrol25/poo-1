#!/usr/bin/env bash
set -euo pipefail

raiz=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")/.." && pwd)
classes=${1:?Informe o diretório de saída da compilação.}
javac=${JAVA_HOME:+"${JAVA_HOME}/bin/"}javac

if ! command -v "$javac" >/dev/null 2>&1; then
    printf 'JDK 17 ou superior necessário. Ajuste JAVA_HOME ou inclua javac no PATH.\n' >&2
    exit 1
fi

pastas=()
for pasta in "$raiz"/[0-9][0-9]-*/src; do
    if [[ -d "$pasta" ]]; then
        pastas+=("$pasta")
    fi
done

if (( ${#pastas[@]} == 0 )); then
    printf 'Nenhuma pasta de código-fonte encontrada.\n' >&2
    exit 1
fi

fontes=()
while IFS= read -r -d '' fonte; do
    fontes+=("$fonte")
done < <(find "${pastas[@]}" -type f -name '*.java' -print0)

if (( ${#fontes[@]} == 0 )); then
    printf 'Nenhum arquivo Java encontrado.\n' >&2
    exit 1
fi

mkdir -p -- "$classes"
"$javac" --release 17 -encoding UTF-8 -Xlint:all -d "$classes" "${fontes[@]}"
