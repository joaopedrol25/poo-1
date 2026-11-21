package polimorfismo.exercicio;

public final class FretePadrao extends Frete {
    public FretePadrao() {
        super("Padrão");
    }

    @Override
    protected int calcularEmCentavos(int quilosCobrados) {
        return 900 + 150 * quilosCobrados;
    }
}
