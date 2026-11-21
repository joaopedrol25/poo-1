# Gabarito comentado de herança

## H1 · Meia-entrada

[`Ingresso`](../src/heranca/exercicio/Ingresso.java) concentra o estado e a formatação comuns. [`IngressoEstudantil`](../src/heranca/exercicio/IngressoEstudantil.java) valida a matrícula após `super(...)` e recupera o preço integral por `super.precoEmCentavos()`. A soma `precoBase / 2 + precoBase % 2` acrescenta um centavo para um preço-base ímpar. A expressão também evita o possível estouro de `(precoBase + 1) / 2` se o preço for `Integer.MAX_VALUE`.

`resumo()` pertence à classe base. Ao chamar `precoEmCentavos()` para um objeto estudantil, o Java usa a versão sobrescrita, de modo que o resumo exibe o valor com desconto.

```bash
bash scripts/executar.sh heranca.exercicio.DemoIngresso
bash scripts/executar.sh heranca.exercicio.VerificacaoIngresso
```

## H2 · Catálogo da escola

O construtor de `MaterialCatalogado` valida e guarda código e título. As subclasses chamam `super(codigo, titulo)` e validam apenas o próprio campo. Como a etiqueta tem o mesmo formato para todos, `etiqueta()` pode ser `final` e devolver `codigo + " - " + titulo`. Uma rotina que aceita `MaterialCatalogado` usa esse método para qualquer subtipo.

Um agendamento associa um material a uma pessoa e uma data. O campo `MaterialCatalogado material` permite trabalhar com livros e kits aproveitando a hierarquia existente.

## H3 · Relógio e despertador

A classe base valida a hora inicial e avança com `minutoDoDia = (minutoDoDia + 1) % 1440`. Essa operação comum pode ser `final` para proteger o contrato. `Despertador` valida a configuração do alarme no próprio construtor e pode oferecer a operação adicional a seguir.

```java
public boolean avancarEDisparar() {
    avancarUmMinuto();
    return minutoDoDia() == minutoDoAlarme;
}
```

Se uma tentativa de disparar às 08:00 fizer o relógio passar diretamente de 07:59 para 00:00, o avanço comum deixará de cumprir o passo de um minuto. A hora do dia e o resultado do alarme são informações independentes.
