package associacoes.oficinas;

public final class Oficina {
    private final String titulo;

    public Oficina(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Informe o título da oficina.");
        }
        this.titulo = titulo.strip();
    }

    public String titulo() {
        return titulo;
    }
}
