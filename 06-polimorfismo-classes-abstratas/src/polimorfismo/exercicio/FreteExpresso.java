package polimorfismo.exercicio;

public final class FreteExpresso extends Frete {
    public FreteExpresso() {
        super("Expresso");
    }

    @Override
    protected int calcularEmCentavos(int quilosCobrados) {
        return 1700 + 280 * quilosCobrados;
    }
}
