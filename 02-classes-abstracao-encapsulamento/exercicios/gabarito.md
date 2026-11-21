# Gabaritos de abstração e encapsulamento

> [Voltar aos exercícios](README.md)

## A1 · Sessão de planetário

A sessão precisa de título, início, capacidade e quantidade reservada. O valor disponível é calculado por `capacidade - lugaresReservados`, o que elimina a necessidade de manter dois contadores sincronizados. `reservar` compara com a disponibilidade antes de somar. `cancelarReserva` verifica o total reservado antes de subtrair. Preço, nomes de pessoas e numeração das poltronas ficariam para requisitos de cobrança e emissão de ingressos.

[Solução em Java](../src/objetos/solucoes/SessaoPlanetario.java) · [Demonstração](../src/objetos/solucoes/DemoSessaoPlanetario.java)

```bash
bash scripts/executar.sh objetos.solucoes.DemoSessaoPlanetario
```

## A2 · Uma peça, dois cadastros

Modele `ExemplarEmprestimo` com código, título e disponibilidade. Modele `FichaConservacao` com código e data da última inspeção. A equipe de empréstimos usa o título para identificar o material com quem o procura. A conservação verifica o prazo usando as datas e identifica o material pelo código.

Depois de validar a ordem das datas, calcule `ChronoUnit.DAYS.between(ultimaInspecao, hoje) > 30`. Um segundo empréstimo deve falhar até ocorrer uma devolução. Uma data de inspeção igual à última é válida e mantém a mesma referência temporal.

## A3 · Medidor de chuva

O acumulado é o único estado que varia durante o dia. Um `long` oferece espaço para representar a soma de muitas contribuições. `Math.addExact(acumulado, milimetros)` detecta estouro antes da atribuição. Uma contribuição negativa é inválida. O alerta fica ativo quando `acumulado >= limite` e volta a ficar inativo quando o acumulado volta a zero.

O requisito usa milímetros inteiros. Defina, por exemplo, que toda leitura chega já arredondada ao milímetro mais próximo. Assim, a classe pode somar os valores recebidos diretamente.

## E1 · Estoque de equipamentos de proteção

Declare mínimo e nome como `final` e mantenha `saldo` privado. Em `receber`, valide quantidade positiva e atribua o resultado de `Math.addExact(saldo, quantidade)`. Na retirada, só subtraia após confirmar que a quantidade é menor ou igual ao saldo. `precisaRepor()` compara `saldo < minimo`. O caso de igualdade deve retornar `false`. Uma recusa por saldo insuficiente precisa preservar o saldo anterior.

## E2 · Horários de silêncio do estúdio

Copie a matriz e cada linha antes de armazená-las. Durante a construção, valide a presença da linha, o tamanho e os limites. Para cada linha a partir da segunda, exija `inicioAtual >= fimAnterior`. A validade dos intervalos garante que essa comparação também detecte registros fora de ordem.

Na consulta, teste `inicio <= minuto && minuto < fim` para cada intervalo. Ao devolver a agenda, copie de novo cada linha. Um `clone()` na matriz externa cria um array novo que ainda aponta para as linhas originais.

## E3 · Ordem de manutenção

Represente os estados com um `enum` e mantenha a propriedade privada. `iniciar` admite somente `ABERTA`. `concluir` primeiro confirma `EM_ANDAMENTO`, depois valida o relato e então grava relato e estado final. A consulta ao relato retorna `null` enquanto a ordem está aberta ou em andamento. Chamar `concluir` novamente deve retornar `false` e preservar o relato armazenado.

[Solução em Java](../src/objetos/solucoes/OrdemManutencao.java) · [Demonstração](../src/objetos/solucoes/DemoOrdemManutencao.java)

```bash
bash scripts/executar.sh objetos.solucoes.DemoOrdemManutencao
```
