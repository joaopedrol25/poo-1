# Exercícios de associações

Em cada exercício, desenhe as classes e indique a multiplicidade dos dois lados de cada associação. Implemente as operações pedidas e escreva uma classe com `main` para reproduzir os cenários. Considere um único usuário por vez nos exemplos de execução.

## 1 · Reservas do planetário

**Objetivo.** Modelar uma composição com array de tamanho fixo e associar cada reserva a um cadastro reutilizável.

Uma sessão tem título e capacidade positiva. Cada assento é numerado a partir de 1. Um assento livre tem zero reservas e um ocupado tem exatamente uma. Uma reserva pertence à sessão e aponta para um visitante identificado pelo código do cadastro. O mesmo cadastro pode aparecer em sessões diferentes e pode reservar apenas um assento por sessão. Compare códigos após retirar espaços das extremidades, preservando maiúsculas e minúsculas.

Implemente `Visitante`, `Sessao` e `Reserva`. Em `Sessao`, crie `reservar(int assento, Visitante visitante)`, `cancelar(int assento, Visitante visitante)`, `reservaNoAssento(int assento)` e `vagasDisponiveis()`. A reserva retorna `false` para assento ocupado, código já presente ou assento fora do intervalo. O cancelamento retorna `false` se o assento estiver livre, fora do intervalo ou pertencer a outro código. Uma consulta a assento livre ou fora do intervalo retorna `null`. Valide capacidade, título, nome e código na criação e exija um visitante nas operações.

**Cenário mínimo.** Em uma sessão com três assentos, Íris reserva o assento 2 e restam duas vagas. Rui tenta o assento 2 e é recusado. Uma segunda instância com o código de Íris tenta o assento 1 e é recusada. Íris cancela e Rui reserva o assento 2. Restam duas vagas. Tente reservar os assentos 0 e 4 e use o cadastro de Íris em outra sessão.

## 2 · Armários de um laboratório

**Objetivo.** Modelar um vínculo opcional 1:1 e permitir sua remoção de forma consistente.

Cada armário guarda até um equipamento e cada equipamento cabe em um único armário por vez. Equipamento tem etiqueta patrimonial, armário tem identificador. Um laboratório registra os armários e os equipamentos disponíveis, com identificadores únicos em cada grupo. No modelo, cada identificador corresponde a uma instância cadastrada.

Implemente `guardar(String etiqueta, String armario)`, `retirar(String etiqueta)` e `buscarArmarioDoEquipamento(String etiqueta)` no laboratório. Guardar deve falhar se algum identificador estiver ausente, se o equipamento já estiver guardado ou se o armário estiver ocupado. Retirar retorna `false` quando o equipamento estiver ausente ou sem armário. A busca retorna o armário atual ou `null`.

**Cenário mínimo.** Guarde o projetor P1 no armário A1. Tente guardar P1 em A2 e P2 em A1. As duas operações devem falhar e a busca por P1 deve continuar apontando A1. Retire P1 duas vezes, com sucesso na primeira tentativa, e guarde P2 em A1.

## 3 · Clube de leitura

**Objetivo.** Representar a relação N:N por meio de uma classe que guarde dados do vínculo.

Uma pessoa participa de várias rodas de leitura e uma roda aceita várias pessoas. Cada participação guarda a data da inscrição e se a pessoa já compareceu. Neste exercício, use as mesmas instâncias de pessoa e roda durante toda a execução e compare as referências.

Implemente `Pessoa`, `Roda`, `Participacao` e `Clube`. O clube deve permitir inscrever um par pessoa e roda, registrar presença apenas para inscrições existentes, consultar quem se inscreveu em uma roda e listar rodas de uma pessoa. A inscrição retorna `false` se o par já existir. Registrar presença é idempotente. Repetir a operação para um par inscrito mantém o estado e retorna `true`. Para um par ausente, retorna `false`.

**Cenário mínimo.** Lia se inscreve em duas rodas e Caio em uma delas. Consulte as duas rodas de Lia e as duas inscrições de uma mesma roda. Recuse uma inscrição duplicada em outra data, confirme que a data inicial foi preservada e registre a presença de Caio duas vezes. A consulta informa que Caio compareceu e mantém apenas uma inscrição dele naquela roda.

## 4 · Circuito de visitas guiadas

**Objetivo.** Criar partes sob controle do todo e compartilhar uma referência externa ao todo.

Um circuito possui um título e até oito paradas em ordem de visita. Cada parada aponta para um local identificado por um código e guarda a duração prevista em minutos. Um local pode participar de circuitos diferentes. Dentro do mesmo circuito, um código de local só pode aparecer uma vez.

Implemente `Circuito`, `Parada` e `Local`. Faça o circuito criar as paradas ao receber o local e a duração. Devolva `false` se o local já estiver no circuito ou se todas as posições estiverem preenchidas. Uma duração menor que um minuto é inválida e deve gerar `IllegalArgumentException`. Exponha as paradas em ordem de inclusão sem devolver a estrutura interna e calcule a duração total como `long`.

**Cenário mínimo.** Insira paradas de 25 e 15 minutos em dois locais no mesmo circuito. O total deve ser 40 minutos. Tente inserir novamente o primeiro código com outra instância de local. A inclusão falha e o total permanece 40. Reuse o local no segundo circuito, preencha as oito vagas do primeiro e confirme que a nona é recusada.

## 5 · Bicicletas compartilhadas

**Objetivo.** Manter uma associação bidirecional coerente ao mover um objeto entre dois grupos.

Uma bicicleta pode ficar em uma estação ou estar em trânsito. Cada estação possui uma capacidade de bicicletas maior que zero. A estação oferece uma consulta às bicicletas presentes, enquanto a bicicleta informa a estação atual. Uma central de operação cuida de conectar, retirar e transferir bicicletas. Suponha uma instância por bicicleta e por estação, sempre reutilizada.

Implemente `Bicicleta`, `Estacao` e `Central`. Iniciar um empréstimo retira a bicicleta da estação e a coloca em trânsito. Devolver uma bicicleta em trânsito requer vaga na estação escolhida. Transferir uma bicicleta que está em uma estação requer outra estação, com pelo menos uma vaga. As operações retornam `false` se o estado impedir a ação e preservam os vínculos existentes. Os clientes consultam os vínculos sem obter acesso direto às estruturas mutáveis da estação.

**Cenário mínimo.** Devolva B1 à estação Norte e B2 à estação Sul, cada uma com capacidade para uma bicicleta. Tente transferir B1 para Sul e verifique que B1 permaneceu em Norte. Empreste B2, transfira B1 para Sul e devolva B2 para Norte. Confira as duas navegações e tente emprestar B2 duas vezes seguidas.

## Respostas

Consulte o [gabarito comentado](gabarito.md) depois de reproduzir os cenários.
