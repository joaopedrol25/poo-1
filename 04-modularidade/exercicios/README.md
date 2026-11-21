# Exercícios de modularidade

Implemente um `main` para experimentar cada caso e separe as verificações do código que escreve no terminal. Nos exercícios de refatoração, mantenha uma versão inicial em outro pacote e rode os mesmos cenários nas duas versões. Consulte o [gabarito comentado](gabarito.md) depois de tentar.

## 1. Devoluções da midiateca · coesão

A classe `DevolucaoLegada` recebe o nome do título e os dias de atraso. Ela calcula a multa, transforma os dados em texto, registra o texto em uma lista e imprime o comprovante. Implemente essa versão e refatore de modo que o cálculo, o histórico e a apresentação possam evoluir de forma independente.

**Regras**

- Dias de atraso incluem zero. Rejeite dias negativos e título vazio antes de registrar qualquer evento.
- Cobre R$ 1,50 por dia de atraso. Use valores em centavos e declare um limite de dias que mantenha o cálculo dentro do tipo numérico.
- O histórico deve preservar a ordem das devoluções. Uma consulta deve retornar uma cópia imutável.
- Retorne o comprovante formatado como texto. A classe com `main` decide quando imprimir.

| Cenário | Resultado esperado |
| --- | --- |
| `Mapa das Águas`, com 0 dias | Multa de R$ 0,00 e registro criado |
| `Arco do Norte`, com 2 dias | Multa de R$ 3,00 e registro criado após o primeiro |
| Qualquer título válido com −1 dia | Falha e histórico com os dois registros anteriores |

**Extensão.** Troque o texto do comprovante de uma linha por duas e explique em qual parte do código fica a mudança.

## 2. Oficina com autorização por credenciais · acoplamento

Em uma oficina comunitária, o atendente recebe uma `SolicitacaoUso` para uso de ferramentas elétricas. Na primeira versão, o atendente busca `solicitacao.getPessoa().getCadastro().getCertificado().isValido()`. Modele a versão inicial e refatore a consulta para que o atendente possa perguntar pela autorização diretamente à solicitação.

**Regras**

- Só autorize uma pessoa quando a oficina estiver aberta e ela tiver certificado ativo de ferramentas elétricas.
- Uma pessoa pode existir com cadastro vazio. O resultado é acesso negado.
- Depois de refatorar, mude o cadastro para manter vários certificados, incluindo um de segurança geral. O código da operação do atendente deve continuar funcionando com a mesma assinatura.
- Registre no `main` o motivo pelo qual a oficina fechada impede a autorização, inclusive com certificado ativo.

| Cenário | Resultado esperado |
| --- | --- |
| Oficina aberta, certificado elétrico ativo e certificado geral | Acesso permitido |
| Oficina aberta, certificado elétrico vencido e certificado geral ativo | Acesso negado |
| Oficina aberta e sem certificados | Acesso negado |
| Oficina fechada e certificado elétrico ativo | Acesso negado |

**Extensão.** Permita uma segunda estação de trabalho que só exige o certificado geral. Defina em qual classe fica a relação entre a estação e a exigência.

## 3. Exportação de presença · sequência de chamadas

A API antiga exige `iniciar()`, `adicionarLinha(registro)` para cada pessoa e `finalizar()`. Escreva uma primeira versão e experimente finalizar antes de iniciar. Refatore para expor `exportar(List<RegistroPresenca> registros)`, que recebe a lista completa e devolve o conteúdo em formato CSV como uma `String`.

**Regras**

- Use o cabeçalho `nome,presente` e finalize todas as linhas com `\n`.
- Cada registro tem nome e marca de presença. Escreva `sim` ou `nao` e preserve a ordem de entrada.
- Aceite lista vazia e retorne apenas o cabeçalho. Rejeite lista nula, registro nulo e nome nulo ou em branco. O formato deste exercício também rejeita vírgula, aspas duplas e quebras de linha no nome. Remova espaços externos dos nomes válidos.
- Em caso de falha, lance `IllegalArgumentException` e disponibilize o exportador para outra chamada. A próxima exportação começa com um cabeçalho novo.

Com Ana Reis presente e Bia Lima ausente, a saída esperada é

```text
nome,presente
Ana Reis,sim
Bia Lima,nao
```

**Casos-limite.** Exporte uma lista vazia. Depois tente uma lista com uma linha válida seguida de uma inválida. Exporte a lista de Ana e Bia novamente e confira cada linha, inclusive a quebra final.

## 4. Agendamento de sala · fronteiras e verificação

Modele um agendamento de sala de estudos. O serviço decide se pode aceitar uma reserva, salva a reserva aceita e devolve o resultado ao ponto de entrada. Use armazenamento em memória e faça as verificações da regra de conflito sem precisar abrir o terminal ou ler arquivos.

**Regras**

- Uma reserva tem sala, dia e intervalo de horas inteiras `[inicio, fim)`. Aceite início de 8 a 19, fim de 9 a 20 e exija `inicio < fim`.
- Considere conflito quando as reservas são da mesma sala e do mesmo dia e seus intervalos se sobrepõem. Horários que apenas se tocam são válidos.
- Reserve um método para consultar a disponibilidade sem modificar o histórico. A tentativa efetiva registra uma única vez quando aceita.
- No `main`, apresente uma mensagem para resultado aceito ou conflito. O núcleo da regra deve ser chamável sem `System.out`.

| Situação após agendar a sala A de 10 a 12 | Resultado esperado |
| --- | --- |
| Sala A de 12 a 13 no mesmo dia | Aceita |
| Sala A de 11 a 13 no mesmo dia | Conflito |
| Sala B de 11 a 13 no mesmo dia | Aceita |
| Sala A de 10 a 12 no dia seguinte | Aceita |
| Sala A de 12 a 12 | Entrada inválida |
| Sala A de 19 a 20 em dia livre | Aceita |

**Extensão.** Passe um calendário com reservas iniciais à lógica de agendamento e prove que duas instâncias podem ser testadas de forma independente.
