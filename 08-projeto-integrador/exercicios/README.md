# Exercícios de extensão — oficina comunitária

Rode `bash scripts/executar.sh projeto.VerificacaoOficina` antes de alterar o projeto. Ao concluir cada exercício, mantenha as verificações existentes e acrescente os cenários descritos abaixo.

## 1. Equipamento de precisão — herança e polimorfismo

Inclua um `EquipamentoDePrecisao` cuja cobrança some as diárias e uma taxa fixa de calibração de **800 centavos**. Cadastre as três categorias no mesmo acervo e imprima o valor de uma locação de três dias.

| Cenário | Resultado esperado |
| --- | --- |
| Chave manual com diária de 500 | 1.500 centavos |
| Furadeira com diária de 1.500 e taxa de 300 | 4.800 centavos |
| Calibrador com diária de 1.200 e taxa de 800 | 4.400 centavos |
| Locação de qualquer tipo por zero dias | Operação recusada e histórico preservado |

**Dica.** Estenda `Equipamento`, invoque o construtor da superclasse e sobrescreva o cálculo da taxa fixa. Execute todas as locações pelo método `CentralLocacoes.abrir`.

## 2. Vencidas em uma data — abstração e encapsulamento

Adicione uma consulta `locacoesVencidasEm(LocalDate referencia)` à central. Inclua locações abertas cuja devolução prevista seja estritamente anterior à data de referência. Preserve a ordem de abertura e entregue uma lista somente para leitura.

| Cenário | Resultado esperado |
| --- | --- |
| Locação aberta com prazo em 12/06, consulta em 12/06 | Fora do resultado |
| A mesma locação, consulta em 13/06 | Presente no resultado |
| A locação já foi devolvida, consulta em 13/06 | Fora do resultado |
| Oficina sem locações | Lista vazia |

**Dica.** Use `isBefore` e `estaAberta()` para filtrar os registros. Passe a data explicitamente nas verificações para que possam ser repetidas.

## 3. Fila de espera por unidade — associações e modularidade

Ao solicitar uma ferramenta indisponível, um associado pode entrar em uma fila específica daquela unidade. Use a ordem de inscrição. Após uma devolução, permita que apenas o primeiro da fila abra a próxima locação. Remova essa pessoa da fila após a abertura bem-sucedida. Identifique cada associado por uma matrícula imutável e recuse inscrições repetidas na mesma fila. Uma unidade sem fila pode ser alugada por qualquer associado.

**Cenário de aceitação.** Durante a retirada de `E1`, inscreva Beto e Nara, nessa ordem. Recuse uma segunda inscrição de Beto. Após a devolução, recuse a abertura por Nara sem alterar a fila. Recuse também uma abertura de Beto por zero dias sem retirá-lo da fila. Quando Beto abrir uma locação válida e devolver a unidade, Nara se torna a próxima da fila. As inscrições de `E1` não afetam `M1`.

**Dica.** Modele uma fila com `Deque` e mantenha a estrutura associada ao código do equipamento. Consulte o início com `peekFirst` e só depois de registrar a locação retire o associado com `removeFirst`.
