# Roteiro da Lista 4 da A1

Síntese dos dez itens de **Exercícios 4 · Associações entre objetos**, material de POO I, IFF Campus Itaperuna, prof. Jonnathan Carvalho, 2026/1. Use o número e a página para encontrar cada enunciado no material da disciplina. A coluna final aponta aspectos para testar durante a revisão.

| Questão | Modelo e regras a revisar | Casos para verificar |
| --- | --- | --- |
| 1 · p. 1 | Motorista referencia um carro e a apresentação dos dados percorre a associação. | Motoristas diferentes exibem os dados de seus respectivos veículos. |
| 2 · p. 1 | Disciplina aponta para seu professor responsável no recorte 1:1 da lista. | A apresentação da disciplina inclui o professor vinculado. |
| 3 · p. 1 | Turma concentra um array com até 40 alunos e lista as matrículas registradas. | Turma vazia, última vaga e tentativa de inserir o 41º aluno. Veja [`Turma`](../src/associacoes/turma/Turma.java). |
| 4 · p. 1 | Pedido soma os subtotais de até 10 linhas. Cada item liga um produto a uma quantidade. | Item com múltiplas unidades, soma de itens diferentes e tentativa de exceder o limite. Veja [`Pedido`](../src/associacoes/pedidos/Pedido.java). |
| 5 · p. 1 | Cada funcionário referencia seu setor. O setor mantém até 20 funcionários, calcula a folha e compara com seu orçamento. | Folha igual ao orçamento, abaixo e acima dele. |
| 6 · p. 1 | Biblioteca gerencia livros com até um leitor associado em cada momento. | Empréstimo disponível, tentativa de emprestar livro ocupado, devolução e novo empréstimo. |
| 7 · p. 2 | Cada festival ocorre em uma cidade e reúne eventos exclusivos daquele festival. Cada evento tem um artista principal, que só pode liderar um evento por festival. O orçamento é comparado à soma dos cachês. | Dois festivais na mesma cidade, artista repetido no mesmo festival, reutilização em festival distinto e orçamento no limite. |
| 8 · p. 3 | Time recebe até 11 titulares e 12 reservas, com transferência entre times. | Destino lotado, jogador ausente e transferência bem-sucedida com atualização dos dois times. |
| 9 · p. 4 | E-mail reúne destinatários e anexos com limite total de 50.000 bytes. O envio depende de pelo menos um destinatário. | Limite exato, excesso de um byte e simulação de envio sem destinatário. |
| 10 · p. 5 | Comanda referencia mesa, contém até 20 itens e agrupa pedidos repetidos de um prato. O fechamento exige consumo, aplica taxa de 10% e libera a mesa. | Mesa ocupada ou reservada, item repetido, comanda vazia, segunda tentativa de fechar e inclusão depois do fechamento. |
