package revisao;

import java.util.Objects;

public class Usuario {
    private final String nome;
    private int mensagensCifradas;

    public Usuario(String nome) {
        this.nome = Objects.requireNonNull(nome, "O nome é obrigatório.").strip();
        if (this.nome.isEmpty()) {
            throw new IllegalArgumentException("Informe um nome.");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getMensagensCifradas() {
        return mensagensCifradas;
    }

    void registrarMensagemCifrada() {
        mensagensCifradas++;
    }
}
