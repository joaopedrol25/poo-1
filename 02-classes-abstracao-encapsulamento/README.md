# 02 · Classes, abstração e encapsulamento

> [Voltar ao índice da trilha](../README.md)

Neste módulo, você transforma requisitos em classes, cria objetos com estado próprio e projeta operações que protegem esse estado. O ponto de partida é a introdução à OO da A1. Os exemplos desenvolvem os princípios de abstração e encapsulamento das apostilas.

## Classe e instância

Uma **classe** declara os dados e os comportamentos de um tipo. Uma **instância** é um objeto criado a partir dela. O construtor estabelece o estado inicial e permite validar os argumentos antes de entregar o objeto ao restante do programa.

```java
CartaoTransporte primeiro = new CartaoTransporte("T-42", "Passe escolar");
CartaoTransporte alias = primeiro;
CartaoTransporte segundo = new CartaoTransporte("T-43", "Passe escolar");
alias.recarregar(500);
```

- Cada `new` cria uma instância com seu próprio saldo.
- `alias = primeiro` copia a referência. `alias` e `primeiro` apontam para a mesma instância e observam a mesma recarga.
- Para objetos, `==` verifica se as referências apontam para a mesma instância. A comparação `primeiro.getCodigo().equals(segundo.getCodigo())` avalia o conteúdo dos códigos. Um cadastro pode impor unicidade do código como regra adicional.
- Em `this.codigo = codigo`, `this.codigo` identifica o atributo da instância e `codigo` é o parâmetro recebido. O argumento de um método é passado por valor. Quando esse valor é uma referência, o método pode operar sobre a instância referenciada.

## Pilar da abstração

O domínio fornece o vocabulário. Os requisitos indicam os dados e as operações que valem a pena representar. No balcão de aluguel, a bicicleta tem diária e disponibilidade. A oficina usa o código para identificar a bicicleta e registra datas de revisão. Os dois modelos escolhem aspectos diferentes da mesma entidade física.

A abstração como princípio é a seleção do que o problema precisa. Em Java, uma classe declarada com `abstract` oferece uma base para criar subclasses concretas. `BicicletaLocacao` e `BicicletaOficina` são classes concretas e ambas aplicam o princípio da abstração.

## Pilar do encapsulamento

Uma invariante é uma condição que deve valer após a construção e depois das operações públicas. O cartão mantém saldo não negativo e um código imutável. A operação `pagarPassagem` consulta o saldo e aplica o débito em uma única chamada. Quando o saldo é insuficiente, retorna `false` e preserva o valor disponível. O cartão aceita `setApelido` porque apelidos podem mudar isoladamente, com validação de conteúdo.

Um getter pode oferecer uma consulta útil. Campos mutáveis exigem cuidado na devolução. `PainelNotas` copia o array recebido pelo construtor e retorna uma nova cópia a cada consulta. A palavra-chave `final` no campo impede a troca da referência interna. Cada posição do array continua mutável pelo método `alterarNota`.

| Visibilidade de um membro | Acesso permitido |
| --- | --- |
| `private` | Código dentro do tipo de nível superior que contém a declaração, incluindo seus tipos aninhados |
| Sem modificador | Código do mesmo pacote |
| `protected` | Mesmo pacote e subclasses. Fora do pacote, há restrições ao acesso por referência |
| `public` | Código que pode acessar o tipo que declara o membro |

## Exemplos executáveis

Execute os comandos a partir da raiz do repositório.

| Exemplo | O que observar | Comando |
| --- | --- | --- |
| [Bicicleta em dois domínios](src/objetos/DemoAbstracao.java) | O mesmo código identifica duas representações com atributos e responsabilidades diferentes | `bash scripts/executar.sh objetos.DemoAbstracao` |
| [Cartão de transporte](src/objetos/DemoEncapsulamento.java) | R$ 10 de recarga pagam duas tarifas de R$ 4,80. A terceira operação retorna `false` e deixa 40 centavos | `bash scripts/executar.sh objetos.DemoEncapsulamento` |
| [Referências e identidade](src/objetos/DemoReferencias.java) | Dois nomes para a mesma instância observam a mesma recarga. Outra instância começa em zero | `bash scripts/executar.sh objetos.DemoReferencias` |
| [Cópias defensivas](src/objetos/DemoCopiasDefensivas.java) | Alterar arrays externos preserva as notas internas. Uma alteração válida no painel muda a média para 90 | `bash scripts/executar.sh objetos.DemoCopiasDefensivas` |

A classe [VerificacaoObjetos](src/objetos/VerificacaoObjetos.java) verifica estados, limites, cópias e soluções da lista.

## Lista de prática

[Resolva os seis exercícios](exercicios/README.md) de abstração e encapsulamento. Depois, consulte os [gabaritos comentados](exercicios/gabarito.md).
