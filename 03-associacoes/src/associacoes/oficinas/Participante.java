package associacoes.oficinas;

public final class Participante {
    private final String nome;

    public Participante(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome do participante.");
        }
        this.nome = nome.strip();
    }

    public String nome() {
        return nome;
    }
}
