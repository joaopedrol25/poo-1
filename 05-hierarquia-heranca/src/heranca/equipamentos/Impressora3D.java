package heranca.equipamentos;

public final class Impressora3D extends Equipamento {
    private int filamentoEmGramas;

    public Impressora3D(String identificacao, int filamentoEmGramas) {
        super(identificacao);
        if (filamentoEmGramas < 0) {
            throw new IllegalArgumentException("A massa do filamento deve ser não negativa.");
        }
        this.filamentoEmGramas = filamentoEmGramas;
    }

    public void imprimirPeca(int gramasNecessarias) {
        exigirLigado();
        if (gramasNecessarias <= 0) {
            throw new IllegalArgumentException("Informe uma massa positiva para a peça.");
        }
        if (gramasNecessarias > filamentoEmGramas) {
            throw new IllegalStateException("Filamento insuficiente.");
        }
        filamentoEmGramas -= gramasNecessarias;
    }

    public int filamentoEmGramas() {
        return filamentoEmGramas;
    }
}
