# Gabarito comentado

## 1 · Reservas do planetário

`Sessao` cria `Reserva` e usa um `Reserva[]` com o tamanho da sala. O assento 1 ocupa o índice 0. `null` representa uma cadeira livre. A sessão verifica a disponibilidade do assento e percorre as reservas existentes para comparar o código de cada visitante. Se uma condição falhar, a sessão devolve `false` antes de alterar a posição.

Cada sessão tem até tantas reservas quanto assentos. Cada reserva pertence a uma sessão e referencia exatamente um visitante. Um visitante pode participar de várias sessões. A contagem de vagas é a quantidade de posições `null`.

O cancelamento compara o código do visitante que pede a remoção com o código do cadastro associado à reserva. O assento volta a receber `null` quando os códigos coincidem. Um objeto diferente com o mesmo código representa o mesmo cadastro.

A [implementação de `Sessao`](../src/associacoes/planetario/Sessao.java) e a [verificação automatizada](../src/associacoes/planetario/VerificacaoPlanetario.java) cobrem os extremos do array, a repetição de código e o cancelamento incorreto.

```bash
bash scripts/executar.sh associacoes.planetario.DemoPlanetario
bash scripts/executar.sh associacoes.planetario.VerificacaoPlanetario
```

## 2 · Armários de um laboratório

Use duas multiplicidades `0..1`. Manter o vínculo `Armario → Equipamento` atende aos dois sentidos de consulta se o laboratório puder procurar o equipamento em seus armários. O laboratório deve localizar primeiro as duas instâncias e testar as duas disponibilidades. Depois, atribui o equipamento ao armário. Retirar usa a mesma busca e limpa a referência encontrada.

O estado esperado depois das tentativas recusadas tem P1 em A1 e A2 vazio. A retirada bem-sucedida deixa A1 livre e uma nova busca por P1 devolve `null`.

## 3 · Clube de leitura

`Participacao` referencia uma `Pessoa` e uma `Roda` e guarda data e presença. `Clube` pode guardar uma lista única de participações. Inscrever percorre a lista até encontrar o par ou chegar ao fim. As duas consultas filtram a mesma lista por atributos diferentes. Uma busca por par também serve para registrar presença.

A segunda chamada de registro de presença atribui o mesmo valor `true` ao atributo. Uma inscrição repetida falha antes de criar outra participação ou alterar a data. O [exemplo de oficinas](../src/associacoes/oficinas/AgendaOficinas.java) mostra como fazer as buscas por referência.

## 4 · Circuito de visitas guiadas

`Circuito` compõe de zero a oito paradas. Cada parada pertence a um circuito e se associa a um local. O local pode ser referenciado por várias paradas em circuitos distintos. A criação fica em `Circuito.adicionarParada`, que verifica duração, capacidade e código antes de instanciar a parada. A duração total percorre as paradas e acumula seus minutos em `long`.

Um array acompanhado por contador mantém a ordem natural de inserção. Uma alternativa é usar `ArrayList` com limite explícito e devolver `List.copyOf(paradas)`. Os dois métodos preservam a ordem.

## 5 · Bicicletas compartilhadas

`Estacao` tem de zero até sua capacidade de bicicletas. `Bicicleta` tem uma referência opcional a `Estacao`. A central valida existência da bicicleta na origem, distinção entre as estações e disponibilidade do destino antes de qualquer alteração. Após essas verificações, ela remove a bicicleta da origem, adiciona ao destino e ajusta a referência da bicicleta.

A retirada deixa a bicicleta com referência `null`. A devolução consegue usar o mesmo método interno que insere uma bicicleta no destino e ajusta a referência. A central controla os únicos caminhos de escrita. Exponha uma visão imutável ou uma cópia das bicicletas da estação para a consulta.

Antes das duas tentativas finais de empréstimo, B1 aponta para Sul e consta em Sul, enquanto B2 aponta para Norte e consta em Norte. Após emprestar B2 novamente, é esperado encontrá-la em trânsito e Norte livre. A segunda tentativa de empréstimo mantém os dois estados.
