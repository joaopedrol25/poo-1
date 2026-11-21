# Gabarito comentado · Fundamentos de Java

As classes abaixo têm um `main` que usa dados fixos, iguais aos de alguns exemplos dos enunciados. Na [verificação do módulo](../src/fundamentos/VerificacaoFundamentos.java) há ainda chamadas com entradas inválidas e casos-limite.

## Fluxo de execução

- No **F01**, `Math.min(horas, 2)` determina as horas da primeira faixa. A diferença entre esse valor e a duração total indica quantas horas têm preço adicional. A divisão inteira de `preco / 10` calcula o desconto de 10% e descarta sua parte fracionária.
- No **F02**, a sequência ganha um elemento a cada leitura estritamente acima do limite. A melhor sequência é atualizada imediatamente, por isso também funciona quando a maior sequência termina na última posição. Uma leitura menor ou igual ao limite zera o contador da sequência corrente.

[Implementação de F01 e F02](../src/fundamentos/GabaritoFluxo.java)

## Texto, vetores e matrizes

- No **F03**, o tamanho e a posição do hífen são verificados antes dos demais caracteres. As comparações usam os intervalos ASCII exigidos pelo enunciado. Após validar, `toUpperCase(Locale.ROOT)` normaliza o código.
- No **F04**, enquanto existirem elementos dos dois lados, copie o menor dos dois elementos correntes. Em um empate, copie o da esquerda e deixe o da direita disponível para uma próxima iteração. Quando uma entrada acabar, copie o restante da outra. O trabalho cresce linearmente com a soma dos comprimentos.
- No **F05**, conte os horários de uma linha inteira para validar as suas células e obter o total. Atualize a escolhida somente quando encontrar uma ocupação menor. A primeira bancada com o menor total vence eventuais empates.

[Implementação de F03, F04 e F05](../src/fundamentos/GabaritoDados.java)

## Métodos sobrecarregados

- No **F06**, as duas versões compartilham a mesma regra para validar o tamanho de cada foto. Na versão de tamanho fixo, a conversão do primeiro operando para `long` faz a multiplicação acontecer com esse tipo. Na outra versão, o acumulador em `long` tem o mesmo papel durante a soma.

[Implementação de F06](../src/fundamentos/GabaritoMetodos.java)

## Execução

```bash
bash scripts/executar.sh fundamentos.GabaritoFluxo
bash scripts/executar.sh fundamentos.GabaritoDados
bash scripts/executar.sh fundamentos.GabaritoMetodos
bash scripts/executar.sh fundamentos.VerificacaoFundamentos
```
