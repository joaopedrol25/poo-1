# 06 · Sobrescrita, polimorfismo e classes abstratas

O polimorfismo permite que um chamador use o mesmo método para objetos de tipos diferentes. O compilador confere se o método está disponível pelo tipo declarado da referência. Quando o método de instância é sobrescrito, o Java escolhe a implementação em tempo de execução de acordo com a classe concreta do objeto.

## Exemplos em Java

| Exemplo | O que observar | Classe executável |
| --- | --- | --- |
| [Boletins de laboratório](src/polimorfismo/sobrescrita/DemoSobrescrita.java) | Compare duas sobrecargas de `formatar` e acompanhe a chamada a `resumo()` dentro de cada uma. A referência `Object` também exibe o resumo via `toString()`. | `polimorfismo.sobrescrita.DemoSobrescrita` |
| [Áreas de figuras](src/polimorfismo/figuras/DemoFiguras.java) | Uma classe abstrata mantém o nome e monta a etiqueta. Um array de `Figura` reúne objetos de classes diferentes e a soma usa a fórmula de cada um. | `polimorfismo.figuras.DemoFiguras` |
| [Painel de temperatura](src/polimorfismo/temperaturas/DemoInterfaces.java) | Uma interface determina a unidade da leitura. O painel usa uma leitura manual em Celsius e um termômetro em Fahrenheit pela mesma operação. | `polimorfismo.temperaturas.DemoInterfaces` |
| [Cotação de frete](src/polimorfismo/exercicio/DemoCotacaoFrete.java) | Três modalidades usam a mesma validação de peso e o mesmo arredondamento. O cálculo da tarifa é escolhido pelo objeto. | `polimorfismo.exercicio.DemoCotacaoFrete` |

Execute os exemplos a partir da raiz do repositório.

```bash
bash scripts/executar.sh polimorfismo.sobrescrita.DemoSobrescrita
bash scripts/executar.sh polimorfismo.figuras.DemoFiguras
bash scripts/executar.sh polimorfismo.temperaturas.DemoInterfaces
bash scripts/executar.sh polimorfismo.exercicio.DemoCotacaoFrete
```

## Sobrescrita e sobrecarga

Uma **sobrescrita** fornece outra implementação para um método de instância herdado com a mesma assinatura. `@Override` permite ao compilador verificar essa intenção, de modo que ele acusa, por exemplo, um erro de digitação no nome do método. Uma **sobrecarga** oferece o mesmo nome com uma lista diferente de parâmetros. Trocar somente o retorno causa erro de compilação.

No exemplo dos boletins, `Boletim referenciaGeral = detalhado` aponta para um `BoletimDetalhado`. A chamada `formatar(referenciaGeral)` escolhe a versão que recebe `Boletim` com base no tipo declarado. Dentro desse método, `boletim.resumo()` chama a implementação de [`BoletimDetalhado`](src/polimorfismo/sobrescrita/BoletimDetalhado.java), pois o objeto é detalhado. `Object` é a classe base de todas as classes Java. [`Boletim`](src/polimorfismo/sobrescrita/Boletim.java) sobrescreve `toString()` e delega a `resumo()`, aproveitando novamente o despacho em execução.

## Classe abstrata e interface

[`Figura`](src/polimorfismo/figuras/Figura.java) é abstrata porque toda figura do exemplo precisa de uma fórmula concreta para calcular sua área. Seu construtor inicializa o nome compartilhado, e seus métodos concretos cuidam da apresentação e da validação. `new Figura(...)` causa erro de compilação. Cada subclasse concreta implementa os métodos abstratos pendentes. Outra subclasse abstrata pode delegar essa responsabilidade para suas próprias subclasses.

A interface [`FonteTemperatura`](src/polimorfismo/temperaturas/FonteTemperatura.java) define a capacidade de fornecer uma leitura em Celsius. As implementações armazenam os dados de formas próprias. A interface pode ser implementada mesmo por uma classe que já estende outra. Uma classe abstrata é uma opção quando os subtipos pertencem à mesma hierarquia e precisam compartilhar estado de instância, validação ou parte do algoritmo. Uma interface funciona bem quando o chamador precisa de uma capacidade comum. É possível combinar as duas numa mesma solução.

## Prática

- Use os [exercícios de polimorfismo](exercicios/README.md) para variar as tarifas de frete, acrescentar uma figura e criar implementações de um contrato de conversão.
- Compare o código com o [gabarito comentado](exercicios/gabarito.md) e confira os cenários de fronteira.
