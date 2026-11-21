package polimorfismo.exercicio;

public abstract class Frete {
    private final String modalidade;

    protected Frete(String modalidade) {
        if (modalidade == null || modalidade.isBlank()) {
            throw new IllegalArgumentException("Informe a modalidade.");
        }
        this.modalidade = modalidade.strip();
    }

    public final int cotarEmCentavos(int pesoEmGramas) {
        if (pesoEmGramas < 1 || pesoEmGramas > 30_000) {
            throw new IllegalArgumentException("O peso deve estar entre 1 e 30.000 g.");
        }
        int quilosCobrados = (pesoEmGramas - 1) / 1_000 + 1;
        return calcularEmCentavos(quilosCobrados);
    }

    protected abstract int calcularEmCentavos(int quilosCobrados);

    public final String modalidade() {
        return modalidade;
    }
}
