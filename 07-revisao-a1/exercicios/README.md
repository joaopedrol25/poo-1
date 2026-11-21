# Simulado original da A1

Resolva as seis questões em Java. Nas questões com código, escreva um `main` para executar os casos indicados.

## 1. Fatores de uma simulação

Uma simulação começa com um fator acumulado igual a 1. Para cada dia `d` entre `inicio` e `fim`, incluindo ambos os limites, o fator diário é `(d + 1) / (d + 2)`.

Implemente `double calcularFator(int inicio, int fim)`. Os dias começam em 0. Lance `IllegalArgumentException` para início negativo ou fim anterior ao início. Para os dias de 0 a 2, obtenha 0,25. Para o intervalo de 2 a 2, obtenha 0,75. Compare valores fracionários com tolerância de `0.000001`.

## 2. Inscrição em uma oficina

Comece com `confirmados = 2`, `minimo = 3` e `vagas = 1`. Qual é o valor da expressão `confirmados >= minimo && vagas-- > 0`? Qual é o valor final de `vagas`?

Com os mesmos valores iniciais, responda às duas perguntas para `confirmados >= minimo || vagas-- > 0`. Compare também `--vagas > 0` e `vagas-- > 0` quando executadas isoladamente, começando com uma vaga em cada caso.

## 3. Placas que precisam ser conferidas

Uma oficina registra placas de teste com letras ASCII maiúsculas e minúsculas, dígitos e hífens. Implemente `int contarDigitos(String placa)` e `String marcarDigitos(String placa)`. A primeira operação conta somente caracteres de `'0'` a `'9'`. A segunda devolve um texto com cada dígito trocado por `'*'`, mantendo os demais caracteres.

Use um `char[]` para construir o resultado. Para `"Qe-42B"`, espere 2 e `"Qe-**B"`. Para `"AB-CD"` e para a string vazia, espere zero e o texto original.

## 4. Credenciais de uma mostra

Modele `Visitante`, `Credencial` e `Mostra`. Cada visitante guarda nome e um código de identificação fornecido no construtor. A credencial associa um visitante a um número sequencial, inicializado em 1. A mostra tem um `Credencial[]` com capacidade fornecida no construtor e mantém um contador das credenciais emitidas.

Implemente `boolean emitir(Visitante visitante)`, `Credencial buscarPorNumero(int numero)` e `int vagasRestantes()`. Recuse emitir uma segunda credencial para o mesmo código de visitante, mesmo quando forem instâncias diferentes. A busca devolve `null` para um número ainda não emitido ou menor que 1.

Com capacidade 2, emita a credencial de Ana com código `V1`, verifique que outra instância com esse código é recusada e confira que restou uma vaga. Depois emita a de Jo com código `V2` e rejeite uma terceira pessoa. Busque os números 0, 1, 2 e 3.

## 5. Programação de laboratório

Um laboratório tem um código e um array fixo de até quatro objetos `Sessao`. Cada sessão possui nome, hora de início e duração em minutos. Modele horários como minutos desde meia-noite. Uma sessão deve ter início entre 0 e 1439, duração positiva e término até 1440. Sessões consecutivas são permitidas quando o fim da primeira coincide com o início da segunda.

Implemente `boolean agendar(Sessao sessao)`, que recusa uma sessão que se sobreponha a uma já agendada ou exceda a capacidade, e `int calcularMinutosOcupados()`. Agende sessões que começam em 540 e 600, ambas com duração 60. Tente agendar outra às 570 por 15 minutos. O total deve seguir em 120 minutos.

## 6. Contador de páginas revisadas

Modele `Revisor`, `Texto` e `FilaDeRevisao`. O revisor tem nome e número de páginas revisadas. Um texto tem título, número de páginas positivo e estado `PENDENTE` ou `REVISADO`. Use um `enum` ou um campo `boolean`. A fila tem um `Texto[]` de capacidade 3 e é associada a um revisor.

Adicione `boolean incluir(Texto texto)` para inserir um texto pendente na primeira posição livre, recusando o mesmo objeto duas vezes e qualquer texto já revisado. Adicione `boolean revisar(int indice)` para marcar um texto incluído como revisado e somar suas páginas uma única vez. Revisar um índice inválido, uma posição vazia ou um texto já revisado deve retornar `false` sem alterar o contador. Mantenha os textos revisados no vetor.

Inclua textos de 5 e 8 páginas. Revise o texto de índice 0 duas vezes e teste o índice 2 antes de ocupá-lo. O contador deve mostrar 5. Revise o índice 1 e confirme o total de 13.

<details>
<summary>Respostas comentadas</summary>

### 1. Fatores

```java
static double calcularFator(int inicio, int fim) {
    if (inicio < 0 || fim < inicio) {
        throw new IllegalArgumentException("Intervalo de dias inválido.");
    }
    double resultado = 1.0;
    for (long dia = inicio; dia <= fim; dia++) {
        resultado *= (dia + 1.0) / (dia + 2.0);
    }
    return resultado;
}
```

Os fatores são 1/2, 2/3 e 3/4. As divisões fracionárias sobrevivem porque os operandos são promovidos para `double`. O índice `long` permite ultrapassar o maior limite do tipo `int` no incremento final.

### 2. Expressões

Com `&&`, a comparação da esquerda vale `false` e o decremento fica sem execução. O resultado é `false` e resta uma vaga.

Com `||`, a comparação da esquerda vale `false` e a expressão precisa avaliar o lado direito. O pós-decremento compara o valor anterior de `vagas`, que é 1, com zero. O resultado é `true` e sobram zero vagas.

Isolado, `--vagas > 0` compara 0 e retorna `false`. Já `vagas-- > 0` compara 1 e retorna `true`. Em ambos os casos, a variável termina em 0.

### 3. Caracteres

Use `c >= '0' && c <= '9'` nos dois métodos. Em `contarDigitos`, some 1 quando a condição for verdadeira. Em `marcarDigitos`, obtenha uma cópia com `placa.toCharArray()`, percorra os índices e mude para `'*'` só as posições que cumprem a condição. Ao final, devolva `new String(caracteres)`. A cópia da string vazia tem tamanho zero e o laço executa zero vezes.

### 4. Credenciais

O contador indica onde gravar a próxima credencial. Faça a busca por código com `equals` nas posições já usadas antes de construir e armazenar a nova credencial. Use `quantidade + 1` como número e incremente o contador apenas após gravar. Para buscar por número, valide `1 <= numero && numero <= quantidade` e consulte `credenciais[numero - 1]`. Ana tem a credencial 1, Jo tem a 2 e as buscas por 0 e 3 devolvem `null`.

### 5. Sessões

Considere cada sessão com início incluído e fim excluído. Há sobreposição quando `novoInicio < fimExistente && inicioExistente < novoFim`. Assim, a sessão de 540 a 600 e a de 600 a 660 encostam e podem coexistir. A tentativa de 570 a 585 cruza a primeira sessão e deve deixar o array intacto. Somar as durações guardadas dá 120 minutos.

### 6. Revisão

O método de inclusão deve verificar se há capacidade, se o texto está pendente e se a mesma referência já está no array. A comparação de identidade entre objetos usa `==`. Em `revisar`, verifique o índice, obtenha o objeto e verifique se está pendente. Só então altere seu estado e some suas páginas ao total do revisor. A segunda tentativa de revisar o índice 0 e a tentativa sobre o índice 2 falham antes de atualizar o estado. As duas revisões válidas somam 13 páginas.

</details>
