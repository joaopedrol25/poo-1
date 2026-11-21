# 07 · Revisão da A1

A prova do grupo 2 de Programação Orientada a Objetos I do IFF Campus Itaperuna reuniu operações numéricas, avaliação de expressões e modelagem com vetores. Os dois anexos da prova eram cópias idênticas. Os exemplos abaixo retomam os conceitos com código e dados próprios.

Esta revisão corresponde à semana 10 do [cronograma da A1](../docs/mapa-das-aulas.md#etapa-a1).

## Execute os exemplos

Execute os comandos da raiz do repositório com JDK 17 ou superior.

```bash
bash scripts/executar.sh revisao.DemoProdutorio
bash scripts/executar.sh revisao.DemoPrecedencia
bash scripts/executar.sh revisao.DemoCifraDeCesar
bash scripts/executar.sh revisao.VerificacaoRevisao
```

### 1. Produtório e divisão em ponto flutuante

O [produtório](src/revisao/Produtorio.java) usa um acumulador iniciado em `1.0` e multiplica o termo calculado para cada índice, incluindo os limites do intervalo. Para os índices 1, 2 e 3, os termos são 2, 2,5 e aproximadamente 3,3333. O resultado é aproximadamente 16,6667. Em intervalos grandes, o produto pode ultrapassar o maior valor finito de `double` e resultar em `Infinity`.

A primeira questão tem gabarito **C**. A alternativa usa o índice do laço no lugar dos limites fixos. Escrever `1.0 / indice` faz a divisão em ponto flutuante, preservando a fração mesmo quando o índice é maior que 1.

### 2. Precedência, avaliação e efeitos sobre a variável

O [exemplo de precedência](src/revisao/DemoPrecedencia.java) começa cada expressão com um lugar disponível. O pré-decremento reduz a quantidade antes da comparação. O pós-decremento compara a quantidade inicial e reduz a variável na mesma avaliação. Quando o lado esquerdo de `&&` vale `false`, o lado direito é pulado e o contador mantém seu valor inicial.

A segunda questão tem gabarito **D**. A expressão de referência produz `false` após decrementar o último valor de 1 para 0. A alternativa D também produz `false`, pois a comparação à esquerda de `&&` já é falsa. Nesse caso o valor final da variável permanece 1.

### 3. Estudo guiado com cifra de César

A cifra de César aparece como exercício histórico de aritmética com caracteres. Faça primeiro uma versão que cumpra a premissa da prova, com deslocamentos cujas letras de saída permanecem no intervalo de cada caixa. A implementação sinaliza com exceção quando um dado de teste viola a premissa.

1. [Usuario](src/revisao/Usuario.java) guarda o nome e a quantidade de mensagens processadas. O método que atualiza o contador tem visibilidade de pacote.
2. [Mensagem](src/revisao/Mensagem.java) transforma a `String` inicial em `char[]` e reserva um segundo vetor de mesma extensão. Aplica o deslocamento às letras de `a` a `z` e de `A` a `Z`. Demais caracteres conservam seus valores. A soma é convertida para `char` após verificar os limites. Ao consultar o resultado, a classe devolve uma cópia do vetor.
3. [GerenciadorCifras](src/revisao/GerenciadorCifras.java) guarda o usuário, o array de mensagens e um contador manual. O comprimento do array fornece a capacidade. A busca por índice retorna `null` quando a posição está fora da faixa ou ainda está vazia. As contagens são atualizadas depois de cifrar e armazenar a mensagem.
4. A [demonstração](src/revisao/DemoCifraDeCesar.java) processa dois textos e exibe o aviso de histórico cheio quando o gerenciador retorna `false`. Nessa versão, o `main` se responsabiliza pela escrita no terminal. Comece por `"Abc-2!"` com deslocamento 2 e confira `"Cde-2!"`. A [verificação](src/revisao/VerificacaoRevisao.java) testa capacidade, índice inválido, mensagem vazia, contagem em caso de falha e a cópia defensiva.

Faça o [simulado original](exercicios/README.md) antes de abrir as respostas comentadas.

## Materiais de referência

- Cronograma de Aulas de Programação Orientada a Objetos I — 2026.1, Etapa A1.
- Avaliação A1, grupo 2, partes I e II.
