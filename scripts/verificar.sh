#!/usr/bin/env bash
set -euo pipefail

scripts=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)
classes=$(mktemp -d)
trap 'rm -rf -- "$classes"' EXIT
java=${JAVA_HOME:+"${JAVA_HOME}/bin/"}java

bash "$scripts/compilar.sh" "$classes"

verificacoes=0
demos=0
while IFS= read -r arquivo; do
    classe=${arquivo#"$classes/"}
    classe=${classe%.class}
    classe=${classe//\//.}
    case "${arquivo##*/}" in
        Verificacao*.class)
            printf 'Verificando %s\n' "$classe"
            "$java" -ea -cp "$classes" "$classe"
            verificacoes=$((verificacoes + 1))
            ;;
        *)
            if ! "$java" -ea -cp "$classes" "$classe" >/dev/null; then
                printf 'Falha ao executar %s.\n' "$classe" >&2
                exit 1
            fi
            demos=$((demos + 1))
            ;;
    esac
done < <(find "$classes" -type f \
    \( -name 'Verificacao*.class' -o -name 'Demo*.class' -o -name 'Gabarito*.class' \) \
    ! -name '*$*' | sort)

if (( verificacoes == 0 || demos == 0 )); then
    printf 'Esperava encontrar verificações e demonstrações.\n' >&2
    exit 1
fi

printf '%d verificações e %d programas de exemplo e de solução executados com sucesso.\n' \
    "$verificacoes" "$demos"
