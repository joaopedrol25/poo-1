# Programação Orientada a Objetos I em Java

Trilha de revisão e prática inspirada na disciplina de Programação Orientada a Objetos I do IFF, Campus Itaperuna, em 2026.1. A trilha começa pela sintaxe de Java e termina com uma locadora de ferramentas que reúne os quatro pilares da orientação a objetos.

## Comece aqui

Instale o **JDK 17 ou superior** e abra um terminal com Bash. No Windows, use Git Bash ou WSL. Os exemplos usam apenas a biblioteca padrão do Java.

```bash
git clone https://github.com/joaopedrol25/poo-1.git
cd poo-1
java -version
javac -version
bash scripts/executar.sh fundamentos.DemoEstrutura
```

Passe ao script o nome completo da classe, incluindo o pacote. Cada módulo indica os comandos para seus exemplos. O comando abaixo compila tudo e roda as verificações, demonstrações e soluções com asserções ativadas.

```bash
bash scripts/verificar.sh
```

Se estiver usando uma IDE, abra a pasta do repositório, selecione o JDK e marque a pasta `src` de cada módulo como raiz de código-fonte. Depois execute o `main` da classe da demonstração.

## Trilha de estudo

| Módulo | Exemplos e conceitos | Prática |
| --- | --- | --- |
| [01 · Fundamentos de Java](01-fundamentos-java/README.md) | Estrutura, tipos, operadores, decisões, laços, Strings, arrays, matrizes e métodos | [Exercícios](01-fundamentos-java/exercicios/README.md) |
| [02 · Classes, abstração e encapsulamento](02-classes-abstracao-encapsulamento/README.md) | Instâncias, referências, construtores, visibilidade, estado válido e cópias defensivas | [Exercícios](02-classes-abstracao-encapsulamento/exercicios/README.md) |
| [03 · Associações entre objetos](03-associacoes/README.md) | Multiplicidade, associação, agregação, composição e coleções com capacidade | [Exercícios](03-associacoes/exercicios/README.md) · [Lista da A1](03-associacoes/exercicios/lista-a1.md) |
| [04 · Modularidade](04-modularidade/README.md) | Pacotes, responsabilidades, coesão, acoplamento e ordem de chamadas | [Exercícios](04-modularidade/exercicios/README.md) |
| [05 · Hierarquia e herança](05-hierarquia-heranca/README.md) | Especialização, `extends`, `super`, `protected` e composição | [Exercícios](05-hierarquia-heranca/exercicios/README.md) |
| [06 · Polimorfismo e classes abstratas](06-polimorfismo-classes-abstratas/README.md) | Sobrescrita, sobrecarga, despacho em execução, classes abstratas e interfaces | [Exercícios](06-polimorfismo-classes-abstratas/exercicios/README.md) |
| [07 · Revisão da prova A1](07-revisao-a1/README.md) | Produtório, precedência, Cifra de César e histórico com array de objetos | [Simulado](07-revisao-a1/exercicios/README.md) |
| [08 · Projeto integrador](08-projeto-integrador/README.md) | Cadastro, locação, tarifação por tipo de ferramenta e devolução | [Extensões](08-projeto-integrador/exercicios/README.md) |

Para revisar a **A1**, siga os módulos **01 → 02 → 03 → 07**. Depois, siga **04 → 05 → 06 → 08** para aprofundar o desenho orientado a objetos. O [mapa das aulas](docs/mapa-das-aulas.md) relaciona os tópicos aos materiais da disciplina.

### Pratique os quatro pilares

- **Abstração.** Escreva as operações de que o domínio precisa e escolha os dados que as sustentam. Modele o mesmo objeto em dois contextos no [módulo 02](02-classes-abstracao-encapsulamento/exercicios/README.md).
- **Encapsulamento.** Crie operações que mantenham o objeto em estado válido. Teste dados inválidos e alterações externas no [módulo 02](02-classes-abstracao-encapsulamento/exercicios/README.md).
- **Herança.** Crie uma especialização que preserve o comportamento esperado de sua superclasse. Experimente `extends` e `super` no [módulo 05](05-hierarquia-heranca/exercicios/README.md).
- **Polimorfismo.** Percorra um conjunto de objetos pelo tipo comum e observe qual implementação roda para cada instância. Experimente adicionar um tipo no [módulo 06](06-polimorfismo-classes-abstratas/exercicios/README.md).

Antes de abrir um gabarito, defina uma entrada comum, um valor de fronteira e uma operação que deve ser recusada. Compare o estado do objeto antes e depois de cada tentativa.
