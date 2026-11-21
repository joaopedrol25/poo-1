# Exercícios de herança

## H1 · Meia-entrada da mostra de cinema

**Objetivo.** Reutilizar construção, validação e exibição por herança.

Modele `Ingresso` com o nome do evento e o preço-base em centavos. A operação comum `precoEmCentavos()` devolve o preço integral. `resumo()` combina o nome do evento e o resultado de `precoEmCentavos()`.

1. Recuse eventos em branco ou nulos e preços negativos no construtor de `Ingresso`.
2. Modele `IngressoEstudantil` como especialização de `Ingresso`. Use `super(...)` para entregar os dados comuns à classe base. Exija uma matrícula não vazia e não nula.
3. Sobrescreva `precoEmCentavos()` e use `super.precoEmCentavos()` para recuperar o preço-base. Cobre metade e arredonde para cima quando o preço-base for ímpar.
4. Guarde um ingresso comum e um estudantil em referências do tipo `Ingresso`. Exiba os resumos e confira os valores.

| Cenário | Resultado esperado |
| --- | --- |
| Inteira de 2501 centavos | 2501 centavos |
| Estudantil de 2501 centavos | 1251 centavos |
| Estudantil de 2500 centavos | 1250 centavos |
| Estudantil com preço-base zero | Zero |
| Matrícula feita só de espaços | `IllegalArgumentException` |

## H2 · Catálogo da escola

**Objetivo.** Compartilhar estado e preservar regras de acesso.

O catálogo identifica cada material por um código e um título. Existem livros, que possuem o número de páginas, e kits, que possuem uma quantidade de peças. Todo material pode ser identificado por `codigo()`. A secretaria imprime `etiqueta()` com o código e o título, num formato único para todos os materiais.

1. Crie a classe-base `MaterialCatalogado`. Mantenha código e título privados e obrigatórios. Defina `codigo()` e `etiqueta()` na base.
2. Crie `Livro` e `Kit` com `extends` e inicialize a parte comum com `super(...)`. As quantidades específicas devem ser inteiras estritamente positivas.
3. Escreva um método `imprimirEtiqueta(MaterialCatalogado material)` e use-o com um objeto de cada classe.
4. Acrescente `Agendamento` para representar quem reservou o material e para qual dia. Represente a relação com um campo do tipo `MaterialCatalogado` e explique a decisão em duas frases.

| Cenário | Resultado esperado |
| --- | --- |
| Livro com código `L-01`, título `Atlas` e uma página | Etiqueta `L-01 - Atlas` |
| Kit com código `K-11`, título `Robótica` e quatro peças | Etiqueta `K-11 - Robótica` |
| Kit com zero peças ou livro com título em branco | `IllegalArgumentException` |
| Agendamento de um livro e de um kit em dias diferentes | Cada agendamento mantém a referência ao seu material |

## H3 · Relógio e despertador

**Objetivo.** Preservar o contrato da classe base ao acrescentar uma operação.

`Relogio` recebe a hora inicial como um número inteiro de minutos desde a meia-noite, no intervalo de 0 a 1439. `avancarUmMinuto()` soma um minuto e volta para zero ao cruzar a meia-noite. `Despertador` deve funcionar como relógio e, além disso, oferecer `avancarEDisparar()`, que avança um minuto e devolve `true` quando o novo minuto coincide com a hora configurada do alarme.

1. Implemente o relógio com estado privado e um método de leitura `minutoDoDia()`.
2. Implemente `Despertador` com os minutos iniciais de relógio e alarme. Reaproveite o avanço da classe base dentro de `avancarEDisparar()`.
3. Crie uma rotina de demonstração que recebe `Relogio` e o avança um minuto. Passe um relógio comum e um despertador.
4. Analise uma implementação que zera o relógio ao disparar. Use o avanço entre 07:59 e 08:00 para demonstrar onde ela quebra o contrato herdado.

| Cenário | Resultado esperado |
| --- | --- |
| Relógio às 23:59 avança um minuto | Minuto 0 |
| Despertador às 07:59 com alarme às 08:00 em `avancarEDisparar()` | `true` e minuto 480 |
| Outra chamada de `avancarEDisparar()` | `false` e minuto 481 |
| Alarme configurado para o minuto 1440 | `IllegalArgumentException` |

[Consultar o gabarito comentado](gabarito.md)
