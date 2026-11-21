# 04 · Modularidade

Um módulo agrupa decisões relacionadas. Em Java, as classes dão nome às responsabilidades e os pacotes organizam as classes que colaboram. Este módulo acompanha três mudanças de projeto: separar responsabilidades, reduzir a dependência da estrutura interna e encapsular uma sequência de operações.

## Coesão e acoplamento

| Conceito | Pergunta para revisar o código | O que procurar |
| --- | --- | --- |
| Coesão | Os atributos e métodos contribuem para o mesmo propósito? | Uma classe que emite ingressos decide preço e disponibilidade. Formatar recibos e manter o histórico são responsabilidades próprias. |
| Acoplamento | Quantos detalhes de um objeto o outro precisa conhecer? | A chamada informa a intenção do cliente. As classes por trás dela podem trocar sua representação interna. |
| Protocolo temporal | O cliente precisa acertar a ordem de várias chamadas? | Uma operação pública executa e encerra a sequência que tem sentido como unidade. |

Ao separar classes, nomeie a decisão ou o comportamento que cada uma concentra. Se duas classes sempre mudam juntas pela mesma razão, revise a fronteira entre elas. Um pacote `util` que mistura cálculo de preço, normalização de nomes e formatação de recibo dificulta localizar a responsabilidade de cada método.

## 1. Bilheteria com responsabilidades claras

A [bilheteria legada](src/modularidade/coesao/BilheteriaLegada.java) usa a mesma classe para consultar lotação, calcular preço, gerar texto, guardar comprovantes e imprimir. A versão refatorada divide o trabalho em [Bilheteria](src/modularidade/coesao/Bilheteria.java), [RegistroIngressos](src/modularidade/coesao/RegistroIngressos.java) e [FormatadorIngresso](src/modularidade/coesao/FormatadorIngresso.java). Um [Ingresso](src/modularidade/coesao/Ingresso.java) imutável carrega os dados entre elas. O registro conserva os dados dos ingressos, e cada apresentação é gerada quando solicitada.

A troca do formato do recibo fica no formatador. A regra de lotação fica na bilheteria. A [demo](src/modularidade/coesao/DemoCoesao.java) usa a mesma sessão de duas vagas nas duas versões, com inteira de R$ 24,00 e meia de R$ 12,00. As classes refatoradas podem ser verificadas em memória, e o `main` cuida da saída no terminal.

```bash
bash scripts/executar.sh modularidade.coesao.DemoCoesao
```

## 2. Entrada em laboratório com Lei de Deméter

Na [versão legada](src/modularidade/acoplamento/DemoAcoplamento.java), quem libera a entrada percorre `reserva.responsavel().identificacao().credencial()`. O cliente passa a conhecer a relação entre reserva, pesquisador, identificação e credencial. Se o pesquisador passa a manter várias credenciais, a consulta precisa mudar nos clientes que percorreram a cadeia.

Na versão refatorada, [ControleEntrada](src/modularidade/acoplamento/ControleEntrada.java) conhece o horário de funcionamento como um estado aberto ou fechado e consulta `reserva.autorizaEntrada()`. A [reserva](src/modularidade/acoplamento/ReservaLaboratorio.java) pergunta ao seu responsável se ele pode operar equipamentos. O [pesquisador](src/modularidade/acoplamento/Pesquisador.java) guarda um conjunto de credenciais e responde à pergunta usando esse conjunto.

A **Lei de Deméter** orienta um objeto a conversar principalmente com seus colaboradores diretos. Aqui, as operações descrevem o comportamento de cada colaborador e concentram a estrutura de credenciais em `Pesquisador`. Uma cadeia de métodos em um construtor fluente ou sobre uma `String` pode operar sobre o mesmo valor e merece uma avaliação diferente.

```bash
bash scripts/executar.sh modularidade.acoplamento.DemoAcoplamento
```

## 3. Impressão com o protocolo encapsulado

O [motor em memória](src/modularidade/protocolo/MotorDeImpressao.java) aceita etiquetas entre a abertura e o fechamento de um lote. A [demo](src/modularidade/protocolo/DemoProtocolo.java) começa mostrando o erro ao enviar uma etiqueta antes de abrir o lote. A [impressora](src/modularidade/protocolo/ImpressoraEtiquetas.java) oferece uma operação de alto nível, `imprimir(textos)`. Ela abre o lote, monta as etiquetas e devolve uma cópia imutável do resultado. O bloco `finally` fecha o lote inclusive quando uma etiqueta inválida interrompe a operação. Como o exemplo simula a produção em memória, descartar o lote parcial basta para permitir uma nova chamada.

O pacote `modularidade.protocolo` expõe `ImpressoraEtiquetas`. A classe `MotorDeImpressao` tem visibilidade de pacote. Pelo mesmo mecanismo, o construtor de `Ingresso` pode ser usado pelas classes de `modularidade.coesao`. Os subpacotes têm seus próprios limites de visibilidade.

```bash
bash scripts/executar.sh modularidade.protocolo.DemoProtocolo
```

## Pratique e verifique

- [Exercícios originais](exercicios/README.md)
- [Gabarito comentado](exercicios/gabarito.md)
- [Verificação em Java](src/modularidade/VerificacaoModularidade.java)

```bash
bash scripts/executar.sh modularidade.VerificacaoModularidade
```

A verificação usa `assert` e cobre lotação exata, preço, fotografia do registro, laboratório fechado, credencial ausente, falha no segundo item de um lote, reutilização da impressora e exportação de presenças.

Material de referência da disciplina POO I, IFF Campus Itaperuna. *Modularidade — Coesão e Acoplamento* e *Princípios da Orientação a Objetos — Modularidade e Hierarquia*, de Jonnathan Carvalho.
