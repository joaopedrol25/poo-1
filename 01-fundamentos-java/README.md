# 01 · Fundamentos de Java

Na A1, este conteúdo vem antes da introdução à orientação a objetos. Você vai escrever programas pequenos, acompanhar o estado das variáveis e extrair regras para métodos que possam ser chamados mais de uma vez.

## Roteiro

| Ordem | Tópico | Exemplo | O que observar |
| --- | --- | --- | --- |
| 1 | Estrutura, tipos e conversões | [DemoEstrutura](src/fundamentos/DemoEstrutura.java) | Ponto de entrada, argumentos, variáveis, constante local e cálculo percentual |
| 2 | Operadores | [DemoOperadores](src/fundamentos/DemoOperadores.java) | Divisão, resto, precedência, curto-circuito e valor de incrementos |
| 3 | Decisão e repetição | [DemoControleFluxo](src/fundamentos/DemoControleFluxo.java) | Faixas de nota, seleção de turno, soma, duplicação e tentativas |
| 4 | Strings e caracteres | [DemoStrings](src/fundamentos/DemoStrings.java) | Normalização, comparação, contagem de vogais e montagem de texto |
| 5 | Vetores | [DemoVetores](src/fundamentos/DemoVetores.java) | Inicialização, soma, índices e desempate por posição |
| 6 | Matrizes | [DemoMatrizes](src/fundamentos/DemoMatrizes.java) | Linhas de tamanhos diferentes e agregação de valores por linha |
| 7 | Métodos | [DemoMetodos](src/fundamentos/DemoMetodos.java) | Parâmetros, retorno, sobrecarga e alteração de um vetor |

## Estrutura e tipos

Um arquivo como `DemoEstrutura.java` contém a classe pública `DemoEstrutura`. Sua declaração `package fundamentos;` corresponde à pasta `fundamentos` dentro de `src`. O Java inicia a execução em `public static void main(String[] args)`. Os elementos de `args` são os argumentos recebidos pela linha de comando. A declaração `import java.util.Locale;` permite referenciar `Locale` pelo nome simples.

`int` guarda inteiros, `double` guarda números de ponto flutuante, `boolean` guarda `true` ou `false` e `char` guarda uma unidade UTF-16. Uma variável `String` guarda uma referência a uma sequência de caracteres. Use aspas simples para um literal `char` e aspas duplas para um literal `String`. A palavra-chave `final` permite uma única atribuição à variável.

Em `18 / 24`, os dois operandos são inteiros e o resultado é `0`. Em `(double) 18 / 24`, a conversão acontece antes da divisão e o resultado é `0.75`. A conversão explícita de `double` para `int` trunca a parte fracionária na direção do zero para valores dentro da faixa de `int`.

## Operadores e controle de fluxo

Em `2 + 3 * 4`, a multiplicação é avaliada primeiro e o resultado é `14`. Com `(2 + 3) * 4`, o resultado é `20`. Operadores de comparação como `<` e `==` produzem um booleano. Ao usar `&&`, Java avalia o lado direito quando o lado esquerdo é verdadeiro. Com `||`, ele avalia o lado direito quando o lado esquerdo é falso. Isso permite verificar se o divisor é zero antes de calcular o resto.

O prefixo `++x` incrementa a variável e fornece o valor novo à expressão. O pós-fixo `x++` fornece o valor antigo e também incrementa a variável. Os operadores `--x` e `x--` seguem a mesma distinção ao decrementar.

`if` e `else if` são úteis para faixas, como os limites de aprovação. `switch` é útil para alternativas discretas, como códigos de turno. Na expressão `switch` do exemplo, cada braço com `->` fornece o resultado de seu caso, e `default` cobre os valores sem caso explícito.

No `for`, a inicialização, a condição e o avanço ficam visíveis no cabeçalho. No `while`, a condição é testada antes de cada iteração. No `do-while`, ela é testada depois, e o corpo executa pelo menos uma vez. Para conferir um laço à mão, anote o valor inicial do índice, a expressão que o altera e a condição de parada.

## Texto, vetores e matrizes

`String` é imutável. Operações como `strip()` e `toUpperCase(...)` retornam o resultado, que você pode guardar em outra variável. Use `equals` para comparar o conteúdo de duas strings. O operador `==`, aplicado a referências, verifica se elas apontam para o mesmo objeto. `StringBuilder` oferece um objeto mutável para montar texto em partes antes de obter a `String` final.

`texto.length()` mede o comprimento em unidades UTF-16 e `texto.charAt(i)` lê uma dessas unidades. Alguns símbolos, como muitos emojis, usam duas unidades UTF-16. O exemplo de vogais percorre letras portuguesas pré-compostas e usa `Locale.ROOT` para tornar a conversão independente da configuração da máquina.

Um vetor tem tamanho fixo e índices de `0` a `vetor.length - 1`. Um `new int[3]` começa com três zeros. O `for` aprimorado lê os elementos quando a posição é dispensável. Para encontrar o índice do primeiro maior valor, percorra com um contador e atualize a posição vencedora apenas quando encontrar um valor maior.

Em Java, `int[][]` é um vetor de vetores. Cada linha pode ter comprimento próprio. Se você escrever `matriz[0].length` como limite de toda iteração, linhas mais curtas podem fazer o programa acessar uma posição inválida. Use `matriz[linha].length` ao processar a linha corrente.

## Métodos

O tipo de retorno `void` descreve um método que conclui sua operação sem devolver um valor. Em um método com retorno, `return` entrega o resultado ao chamador. Parâmetros e variáveis locais, como `produto` no cálculo de área, só existem no seu escopo.

A sobrecarga permite usar o mesmo nome com listas de parâmetros diferentes. Por exemplo, `area(double)` usa a versão `area(double, double)` passando o lado duas vezes. Tipos de retorno diferentes, por si só, são insuficientes para criar outra sobrecarga.

Java passa argumentos por valor. Quando o argumento é um `int`, o parâmetro recebe uma cópia desse número. Quando o argumento é um vetor, o parâmetro recebe uma cópia da referência e pode alterar elementos do mesmo vetor. Compare `somarBonus` e `bonificar` para observar as duas situações.

## Como executar

Execute os exemplos da raiz do repositório e informe o nome completo de cada classe.

```bash
bash scripts/executar.sh fundamentos.DemoEstrutura
bash scripts/executar.sh fundamentos.DemoControleFluxo
bash scripts/executar.sh fundamentos.DemoMatrizes
bash scripts/executar.sh fundamentos.VerificacaoFundamentos
```

Também é possível chamar `javac` e `java` diretamente da raiz do repositório.

```bash
javac --release 17 -encoding UTF-8 -d build/fundamentos 01-fundamentos-java/src/fundamentos/*.java
java -cp build/fundamentos fundamentos.DemoEstrutura "Oficina de robótica"
```

Veja a saída de `DemoEstrutura`.

```text
Oficina de robótica — turma A
Vagas livres: 6. Inscrições abertas: true
Ocupação: 75,0%
Percentual inteiro: 75
```

Resolva os [exercícios](exercicios/README.md) e confira as [soluções comentadas](exercicios/gabarito.md).
