# Gabarito comentado · modularidade

## 1. Devoluções da midiateca

Modele `Devolucao` como um valor que guarda título e dias de atraso. Valide os dados no construtor e devolva `atraso * 150` em `multaEmCentavos()`. Um limite de 365 dias produz multa máxima de 54.750 centavos e cabe em `int`. `RegistroDevolucoes` conserva objetos `Devolucao` e devolve `List.copyOf(registros)`. `ComprovanteDevolucao` formata os dados para exibição. Teste a devolução inválida depois de dois sucessos e compare o histórico com a captura anterior à falha. A apresentação em duas linhas fica em `ComprovanteDevolucao`.

## 2. Oficina com autorização por credenciais

Em `Atendente`, verifique `oficina.aberta() && solicitacao.autorizaUso()`. A solicitação conhece a pessoa e delega a consulta ao cadastro dela. Modele cada certificado como tipo e situação, por exemplo `ELETRICO` e `ATIVO`. Ao introduzir múltiplos certificados, concentre no cadastro a regra de procurar pelo tipo solicitado entre os ativos. Representar a ausência com um cadastro sem certificados simplifica a consulta. Para a extensão, associe à estação o tipo de certificado exigido e use a mesma consulta de autorização.

## 3. Exportação de presença

O [exportador](../src/modularidade/solucoes/ExportadorPresencas.java) guarda o cabeçalho e as linhas de cada chamada em uma variável local. Ele valida e monta cada linha antes de acrescentá-la ao resultado. Se qualquer linha falhar, a exceção encerra a chamada e o `StringBuilder` fica inacessível. A chamada seguinte cria seu próprio acumulador. [RegistroPresenca](../src/modularidade/solucoes/RegistroPresenca.java) usa um `record` de Java para transportar nome e marca de presença como valores.

O exemplo de impressão usa `try/finally` porque o motor tem uma sessão com estado próprio. Nesta solução, todo o estado da montagem existe durante uma única chamada. Escolher o tempo de vida dos dados é parte do desenho da API.

```bash
bash scripts/executar.sh modularidade.solucoes.DemoSolucaoPresencas
```

## 4. Agendamento de sala

Faça `Reserva` validar a sala, o dia e a faixa de horas. Para decidir conflito, compare sala e dia e use `nova.inicio() < atual.fim() && atual.inicio() < nova.fim()`. A fórmula considera `[10, 12)` e `[12, 13)` disjuntos. `Agenda` mantém as reservas e oferece uma consulta de disponibilidade. A operação de agendar consulta a disponibilidade e só registra quando livre. Considere retornar `boolean` ou um `enum` com `ACEITA` e `CONFLITO` para o `main` converter em mensagem. Teste que o tamanho do histórico fica estável após um conflito e que a disponibilidade de outra sala independe dele.
