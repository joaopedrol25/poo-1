# Exercícios de abstração e encapsulamento

> [Voltar ao módulo](../README.md)

Para cada exercício, crie uma classe de demonstração com `main` que mostre um fluxo de sucesso e pelo menos um caso-limite. Guarde as regras na classe que possui os dados. Assuma que as operações serão chamadas por uma pessoa de cada vez.

## Abstração

### A1 · Sessão de planetário — inicial

**Objetivo.** Modelar as informações e operações necessárias para uma sessão que vende lugares por quantidade.

**Requisitos.** Uma sessão tem título, data e hora de início e capacidade inteira positiva. A criação exige título não vazio e data e hora informadas. Implemente `reservar(int quantidade)`, `cancelarReserva(int quantidade)` e `lugaresDisponiveis()`. Reservas e cancelamentos recebem quantidades positivas. As operações retornam `true` em caso de sucesso ou `false` quando a reserva excede o espaço restante ou o cancelamento excede o total reservado. Uma quantidade menor que 1 deve lançar `IllegalArgumentException`. O sistema trabalha com lugares sem identificação e controla a ocupação acumulada. Explique quais informações de uma sessão real ficaram fora do modelo.

**Exemplo.** Com capacidade 12, reservar 8 lugares funciona, reservar mais 5 falha e cancelar 3 deixa 7 lugares disponíveis.

**Casos-limite.** Lotar a sessão, cancelar todos os lugares reservados e tentar cancelar além do que foi reservado.

### A2 · Uma peça, dois cadastros — intermediário

**Objetivo.** Produzir representações de uma mesma peça de acervo para duas equipes com necessidades diferentes.

**Requisitos.** A equipe de empréstimos controla código, título e disponibilidade. O exemplar começa disponível. `emprestar()` e `devolver()` retornam `true` quando a transição é possível e `false` nos demais casos. A equipe de conservação usa código e data da última inspeção. Comece com uma data de inspeção e crie `registrarInspecao(LocalDate data)` e `inspecaoEmAtraso(LocalDate hoje)`. Rejeite datas anteriores à última inspeção registrada, inclusive na consulta. Considere atraso a partir do 31º dia depois da inspeção. Use o mesmo código nos dois objetos para representar a mesma peça.

**Exemplo.** O exemplar `AC-20` pode estar emprestado enquanto a representação de conservação registra uma inspeção em 1º de maio. Em 31 de maio, a inspeção está no prazo. Em 1º de junho, está em atraso.

**Casos-limite.** Segundo empréstimo, devolução de exemplar disponível, consulta na data da inspeção e regressão de data. Explique qual das equipes precisa do título para cumprir essa tarefa.

### A3 · Medidor de chuva — intermediário

**Objetivo.** Criar um resumo que ajude a decidir se um alerta de chuva deve ser emitido.

**Requisitos.** Modele uma estação usando código, limite de alerta inteiro em milímetros e acumulado do dia. O limite tem de ser positivo. Ofereça `registrarChuva(int milimetros)`, `deveAlertar()` e `iniciarNovoDia()`. Aceite contribuições não negativas e recuse entrada que faria o acumulado ultrapassar o limite numérico do tipo escolhido. Emita alerta a partir de um acumulado igual ao limite. A troca de dia zera o acumulado. Documente se a unidade exige arredondamento no momento em que a leitura é produzida.

**Exemplo.** Com limite de 30 mm, contribuições de 12 mm e 18 mm disparam o alerta. Ao iniciar o dia seguinte, o alerta é desativado.

**Casos-limite.** Contribuição zero, contribuição negativa, valor um abaixo do limite e valor exatamente no limite.

## Encapsulamento

### E1 · Estoque de equipamentos de proteção — inicial

**Objetivo.** Fazer com que entradas e retiradas sejam os únicos caminhos de alteração do saldo.

**Requisitos.** Cada estoque representa um tipo de equipamento, com nome, estoque mínimo e saldo. O saldo começa em zero. O nome deve ter conteúdo e o mínimo pode ser zero. Implemente `receber(int quantidade)`, `retirar(int quantidade)` e `precisaRepor()`. Rejeite quantidades menores que 1 e entradas que ultrapassariam o maior saldo representável. A retirada sem saldo suficiente retorna `false` sem alterar o saldo. A reposição é indicada se o saldo estiver abaixo do mínimo.

**Exemplo.** Para mínimo 4 e saldo inicial zero, receber 6 e retirar 3 deixa saldo 3 e indica reposição. Tentar retirar 4 dessa posição falha.

**Casos-limite.** Retirar o saldo exato, ficar exatamente no mínimo e tentar uma entrada que ultrapasse o limite do tipo. Defina como o erro de entrada será informado.

### E2 · Horários de silêncio do estúdio — avançado

**Objetivo.** Proteger dados mutáveis que contêm outras referências mutáveis.

**Requisitos.** Modele uma agenda diária de silêncio com uma matriz `int[][]`. Cada linha deve conter exatamente dois valores representando minutos do dia no intervalo `[início, fim)`. Aceite horários entre 0 e 1440, exija início menor que fim e recuse sobreposição. Assuma linhas ordenadas por horário de início e rejeite uma matriz fora dessa ordem. Intervalos adjacentes são permitidos e uma matriz sem linhas indica dia sem restrições. Crie `estaEmSilencio(int minuto)`, aceitando consultas de 0 a 1439, e um método que devolva uma cópia da agenda.

**Exemplo.** Em `{{480, 540}, {600, 660}}`, o minuto 539 está em silêncio e o minuto 540 está fora dos intervalos.

**Casos-limite.** Altere tanto a matriz original como uma linha da cópia retornada e verifique se a agenda continua íntegra. Tente construir uma agenda com linha nula, intervalo invertido, horário fora do dia e intervalos sobrepostos.

### E3 · Ordem de manutenção — intermediário

**Objetivo.** Definir operações que controlem transições de estado e mantenham os dados consistentes.

**Requisitos.** A ordem tem código e nome do equipamento, ambos com conteúdo. Começa em `ABERTA`. `iniciar()` muda para `EM_ANDAMENTO` somente a partir de `ABERTA`. `concluir(String relato)` muda para `CONCLUIDA` somente a partir de `EM_ANDAMENTO` e exige relato com conteúdo. Operações em estado incompatível retornam `false`. Na transição válida, um relato vazio ou nulo lança `IllegalArgumentException` sem mudar o estado. Os dois métodos retornam `true` em caso de sucesso. Disponibilize consultas ao estado e ao relato final.

**Exemplo.** A ordem `OM-08` começa aberta. Concluir de imediato falha. Iniciar e concluir com “Lâmpada substituída” funciona.

**Casos-limite.** Iniciar duas vezes, finalizar com relato vazio, concluir novamente e conferir que o relato final continua o mesmo.

[Conferir os gabaritos comentados](gabarito.md).
