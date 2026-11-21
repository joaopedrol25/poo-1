# Exercícios · Fundamentos de Java

Implemente um método para cada problema e crie um `main` para testar as entradas. Os valores de saída nas tabelas são os retornos esperados. As entradas de referência fornecidas aos métodos, como vetores e textos, podem ser consideradas inicializadas.

## F01 · Locação de uma sala

**Nível inicial.** Pratique tipos primitivos, operadores e decisões.

Implemente `int calcularLocacao(int horas, boolean estudante)` para calcular o custo de uma sala em centavos. As primeiras duas horas custam 1.050 centavos cada e as seguintes custam 475 centavos cada. Estudantes recebem 10% de desconto sobre o total. Descarte a parte fracionária do desconto antes de subtraí-lo. Aceite de 0 a 24 horas. Rejeite valores fora desse intervalo com `IllegalArgumentException`.

| Horas | Estudante | Resultado em centavos |
| ---: | :---: | ---: |
| 0 | sim | 0 |
| 2 | não | 2.100 |
| 3 | não | 2.575 |
| 3 | sim | 2.318 |
| 24 | não | 12.550 |
| 25 | não | exceção |

**Dica.** Descubra quantas horas entram em cada faixa antes de calcular o desconto.

## F02 · Umidade acima do limite

**Nível inicial.** Pratique repetição, condições e vetores.

Implemente `int maiorSequenciaAcima(int[] leituras, int limite)`. Cada leitura é um percentual inteiro de 0 a 100. Retorne a quantidade de leituras na maior sequência de medições consecutivas estritamente acima do limite. Uma leitura igual ao limite encerra a sequência. Se o vetor estiver vazio, retorne zero. O limite segue a mesma faixa das leituras. Use `IllegalArgumentException` para qualquer percentual inválido.

| Leituras | Limite | Resultado |
| --- | ---: | ---: |
| `[80, 90, 85, 70, 71, 70]` | 80 | 2 |
| `[10, 90, 99, 100]` | 80 | 3 |
| `[100, 100]` | 100 | 0 |
| `[]` | 50 | 0 |
| `[101]` | 100 | exceção |

**Dica.** Guarde o tamanho da sequência em curso e o maior tamanho encontrado.

## F03 · Código de identificação

**Nível inicial.** Pratique `String`, `char`, comparações e funções da biblioteca padrão.

Implemente `String normalizarCodigo(String entrada)`. Remova espaços externos conforme `String.strip()`. O padrão exige três letras de `A` a `Z` (aceite minúsculas), um hífen e três dígitos de `0` a `9`. Retorne o código em maiúsculas e rejeite entradas fora do padrão com `IllegalArgumentException`.

| Entrada | Resultado |
| --- | --- |
| `"  iFf-230 "` | `"IFF-230"` |
| `"abc-007"` | `"ABC-007"` |
| `"IW-20"` | exceção |
| `"ÉFF-230"` | exceção |
| `"IFF-２30"` | exceção |

**Dica.** Verifique o comprimento antes de acessar posições específicas.

## F04 · Mesclagem de agendas

**Nível intermediário.** Pratique vetores ordenados, índices e laços `while`.

Implemente `int[] mesclarOrdenados(int[] primeiros, int[] segundos)`. Cada vetor já está em ordem crescente, admitindo valores repetidos e negativos. Devolva um vetor novo, ordenado, com todos os elementos das duas entradas. Mantenha as repetições e preserve os vetores recebidos. Percorra cada entrada uma vez.

| Primeiro vetor | Segundo vetor | Resultado |
| --- | --- | --- |
| `[1, 3, 3]` | `[-2, 3, 4]` | `[-2, 1, 3, 3, 3, 4]` |
| `[]` | `[2, 6]` | `[2, 6]` |
| `[2, 6]` | `[]` | `[2, 6]` |
| `[]` | `[]` | `[]` |

**Dica.** Mantenha uma posição de leitura em cada entrada e uma posição de escrita no resultado.

## F05 · Bancadas do laboratório

**Nível intermediário.** Pratique matrizes irregulares, agregação e desempate.

Implemente `int indiceMenosOcupado(int[][] ocupacao)`. Cada linha é uma bancada, e cada posição da linha é um horário. Um horário livre vale `0` e um horário ocupado vale `1`. Uma bancada pode ter um número diferente de horários, inclusive zero. Retorne o índice com a menor **quantidade** de horários ocupados. Em caso de empate, devolva o primeiro índice. Uma matriz vazia resulta em `-1`. Uma célula fora de `{0, 1}` gera `IllegalArgumentException`.

| Ocupação | Resultado |
| --- | --- |
| `[[1, 0, 1], [0, 1], [1, 0, 0]]` | `1` |
| `[[1], []]` | `1` |
| `[]` | `-1` |
| `[[], [2]]` | exceção |

**Dica.** Passe cada linha a um método que conte os horários ocupados e valide as células.

## F06 · Espaço ocupado por fotografias

**Nível intermediário.** Pratique sobrecarga, contratos de entrada e conversão para `long`.

Implemente duas versões de `volumeUsado`. A versão `long volumeUsado(int quantidadeDeFotos, int megabytesPorFoto)` calcula o total quando todas as fotos ocupam o mesmo tamanho. A versão `long volumeUsado(int[] tamanhosEmMegabytes)` soma os tamanhos individuais. Aceite quantidade zero e vetor vazio. A quantidade precisa ser maior ou igual a zero, e cada tamanho fornecido precisa ser positivo. Rejeite valores inválidos com `IllegalArgumentException`.

| Chamada | Resultado em MB |
| --- | ---: |
| `volumeUsado(12, 5)` | 60 |
| `volumeUsado(new int[] {4, 7, 5})` | 16 |
| `volumeUsado(0, 5)` | 0 |
| `volumeUsado(new int[0])` | 0 |
| `volumeUsado(Integer.MAX_VALUE, 2)` | 4.294.967.294 |
| `volumeUsado(1, 0)` | exceção |

**Dica.** Converta um dos operandos para `long` antes de multiplicar.

Depois de testar suas soluções, consulte o [gabarito comentado](gabarito.md).
