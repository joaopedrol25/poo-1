package associacoes.planetario;

public final class Visitante {
    private final String codigo;
    private final String nome;

    public Visitante(String codigo, String nome) {
        if (codigo == null || codigo.isBlank() || nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe código e nome do visitante.");
        }
        this.codigo = codigo.strip();
        this.nome = nome.strip();
    }

    public String codigo() {
        return codigo;
    }

    public String nome() {
        return nome;
    }
}
