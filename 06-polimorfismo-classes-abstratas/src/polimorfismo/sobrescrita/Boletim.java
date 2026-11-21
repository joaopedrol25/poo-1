package polimorfismo.sobrescrita;

public class Boletim {
    private final String titulo;

    public Boletim(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Informe o título do boletim.");
        }
        this.titulo = titulo.strip();
    }

    public String resumo() {
        return titulo;
    }

    @Override
    public String toString() {
        return resumo();
    }
}
