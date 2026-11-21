# Exercícios de polimorfismo e classes abstratas

## P1 · Comparador de fretes

**Objetivo.** Compartilhar validação em uma classe abstrata e executar regras especializadas por uma referência comum.

A loja exibe cotações para caixas de 1 a 30.000 g. O preço usa centavos inteiros. Cada quilo começado é cobrado por inteiro. Por exemplo, 1000 g contam como um quilo e 1001 g contam como dois.

1. Modele `Frete` como classe abstrata que guarda o nome da modalidade. Faça `cotarEmCentavos(int pesoEmGramas)` validar o intervalo e calcular a quantidade de quilos cobrados antes de delegar a um método abstrato.
2. Implemente `FretePadrao` com tarifa de 900 centavos mais 150 por quilo cobrado. Implemente `FreteExpresso` com tarifa de 1700 centavos mais 280 por quilo. A modalidade `Retirada` custa zero.
3. Percorra um array `Frete[]` com as três opções. A rotina de exibição chama a mesma operação de cotação para cada elemento.
4. Verifique que as três modalidades rejeitam pesos fora da faixa com `IllegalArgumentException`, inclusive a retirada.

| Peso | Padrão | Expresso | Retirada |
| --- | --- | --- | --- |
| 1 g | 1050 | 1980 | 0 |
| 1000 g | 1050 | 1980 | 0 |
| 1001 g | 1200 | 2260 | 0 |
| 30.000 g | 5400 | 10100 | 0 |
| 0 g ou 30.001 g | Exceção | Exceção | Exceção |

## P2 · Triângulo no painel de figuras

**Objetivo.** Adicionar uma implementação concreta e aproveitá-la em uma rotina que já usa a classe base.

Acrescente `Triangulo` ao [exemplo de figuras](../src/polimorfismo/figuras/). Modele o nome, a base e a altura em centímetros inteiros. Use a regra de medidas positivas já definida em `Figura`.

1. Implemente a fórmula da área `base × altura ÷ 2`. Preserve o meio centímetro quadrado dos casos em que o produto é ímpar.
2. Acrescente a nova figura ao array do exemplo e confira a etiqueta e a soma.
3. Rode o método de soma com um array vazio e explique por que funciona após acrescentar o terceiro tipo.

| Cenário | Resultado esperado |
| --- | --- |
| Base 3 e altura 5 | 7,5 cm² |
| Base 4 e altura 6 | 12 cm² |
| Triângulo 3 × 5 e retângulo 3 × 4 | Soma de 19,5 cm² |
| Base 0 com altura 6 | `IllegalArgumentException` |
| Array vazio | Soma de 0 cm² |

## P3 · Medições de trilha

**Objetivo.** Usar uma interface para unificar dados que chegam em unidades diferentes.

Um relatório recebe distâncias medidas em metros por um mapa e comprimentos obtidos contando passos. Ele trabalha apenas com medidas em metros e precisa somar vários trechos.

1. Declare `ComprimentoEmMetros` com um método `double emMetros()`.
2. Implemente `DistanciaDoMapa`, que recebe metros entre 0 e 1.000.000, e `DistanciaPorPassos`, que recebe entre 0 e 1.000.000 de passos e uma passada estritamente positiva de até 3 metros. Recuse valores fora dos intervalos e valores fracionários não finitos com `IllegalArgumentException`.
3. Faça o relatório percorrer um array `ComprimentoEmMetros[]` e somar os resultados de `emMetros()`.
4. Explique o que mudaria no relatório se surgisse uma classe que converte de quilômetros para metros.

| Cenário | Resultado esperado |
| --- | --- |
| Mapa com 100 m e 80 passos de 0,75 m | Soma de 160 m |
| Zero passos de 0,75 m | 0 m |
| Passada de zero metro, distância negativa ou `Double.NaN` | `IllegalArgumentException` |
| Array vazio | 0 m |

## P4 · Prever a chamada de método

**Objetivo.** Identificar quando a escolha ocorre em compilação ou em execução.

No pacote do [exemplo de sobrescrita](../src/polimorfismo/sobrescrita/), crie uma classe com `main` e execute o trecho.

```java
BoletimDetalhado detalhado = new BoletimDetalhado("Agenda", 0);
Boletim boletim = detalhado;
Object objeto = detalhado;

System.out.println(DemoSobrescrita.formatar(boletim));
System.out.println(DemoSobrescrita.formatar(detalhado));
System.out.println(objeto.toString());
```

1. Antes de executar, escreva as três linhas que espera que apareçam. Em cada uma, indique o tipo declarado e a classe do objeto.
2. Tente trocar o primeiro argumento por `objeto`. Anote se compila e qual ajuste na assinatura permitiria essa chamada.
3. Explique o que acontece se `BoletimDetalhado` trocar `resumo()` por `resumo(int limite)` e mantiver `@Override`.

[Consultar o gabarito comentado](gabarito.md)
