package heranca.exercicio;

public class Ingresso {
    private final String evento;
    private final int precoBaseEmCentavos;

    public Ingresso(String evento, int precoBaseEmCentavos) {
        if (evento == null || evento.isBlank()) {
            throw new IllegalArgumentException("Informe o evento.");
        }
        if (precoBaseEmCentavos < 0) {
            throw new IllegalArgumentException("O preço deve ser não negativo.");
        }
        this.evento = evento.strip();
        this.precoBaseEmCentavos = precoBaseEmCentavos;
    }

    public int precoEmCentavos() {
        return precoBaseEmCentavos;
    }

    public String resumo() {
        return "%s — %d centavo(s)".formatted(evento, precoEmCentavos());
    }
}
