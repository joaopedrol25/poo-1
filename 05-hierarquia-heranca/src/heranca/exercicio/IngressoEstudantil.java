package heranca.exercicio;

public final class IngressoEstudantil extends Ingresso {
    private final String matricula;

    public IngressoEstudantil(String evento, int precoBaseEmCentavos, String matricula) {
        super(evento, precoBaseEmCentavos);
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Informe a matrícula.");
        }
        this.matricula = matricula.strip();
    }

    public String matricula() {
        return matricula;
    }

    @Override
    public int precoEmCentavos() {
        int precoBase = super.precoEmCentavos();
        return precoBase / 2 + precoBase % 2;
    }
}
