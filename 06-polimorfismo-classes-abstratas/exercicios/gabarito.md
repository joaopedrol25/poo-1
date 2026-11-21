# Gabarito comentado de polimorfismo e classes abstratas

## P1 · Comparador de fretes

[`Frete`](../src/polimorfismo/exercicio/Frete.java) oferece uma operação pública `final` que valida o peso e calcula `(pesoEmGramas - 1) / 1000 + 1`. Subtrair uma unidade antes da divisão inteira mantém 1000 g em um quilo e faz a cobrança subir a dois em 1001 g. O método abstrato recebe o número inteiro já validado. O array de [`DemoCotacaoFrete`](../src/polimorfismo/exercicio/DemoCotacaoFrete.java) trata todas as modalidades pela classe base, e a escolha da regra específica ocorre em execução.

```bash
bash scripts/executar.sh polimorfismo.exercicio.DemoCotacaoFrete
bash scripts/executar.sh polimorfismo.exercicio.VerificacaoCotacaoFrete
```

## P2 · Triângulo no painel de figuras

Chame `super(nome)` primeiro e use `exigirMedidaPositiva` para cada dimensão. Declare `areaEmCentimetrosQuadrados()` com `@Override` e calcule `(double) baseEmCentimetros * alturaEmCentimetros / 2.0`. A conversão acontece antes do produto e preserva o valor mesmo para dimensões que fariam uma multiplicação de dois `int` estourar. A soma percorre o array pela classe base e começa em zero, de modo que o array vazio produz zero e um triângulo aciona sua própria fórmula.

## P3 · Medições de trilha

O método de uma distância direta devolve o valor do mapa. A classe por passos devolve `quantidade * metrosPorPasso` e valida a finitude com `Double.isFinite`. O relatório soma `trecho.emMetros()` para cada trecho. Uma nova implementação que recebe quilômetros pode multiplicar a entrada por 1000 em seu `emMetros()`, preservando o contrato que o relatório já usa.

## P4 · Prever a chamada de método

```text
Edição geral: Agenda (0 itens)
Edição detalhada: Agenda (0 itens)
Agenda (0 itens)
```

As duas primeiras linhas selecionam a sobrecarga de `formatar` pelos tipos declarados `Boletim` e `BoletimDetalhado`. Ambas chegam ao `resumo()` de `BoletimDetalhado` porque usam o mesmo objeto. Na terceira linha, o método `toString()` existe em `Object`, e a implementação herdada de `Boletim` volta a despachar para o resumo detalhado.

Com uma variável de tipo `Object`, as duas sobrecargas existentes são restritas demais para receber o argumento. Uma terceira sobrecarga `formatar(Object)` permitiria a chamada. Trocar `resumo()` por `resumo(int limite)` na subclasse cria outra assinatura, e `@Override` faz o compilador sinalizar a ausência de um método herdado correspondente.
