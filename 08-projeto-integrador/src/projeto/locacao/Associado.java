package projeto.locacao;

import java.util.Objects;

public final class Associado {
    private final String nome;

    public Associado(String nome) {
        this.nome = Objects.requireNonNull(nome, "Nome").strip();
        if (this.nome.isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do associado.");
        }
    }

    public String nome() {
        return nome;
    }
}
