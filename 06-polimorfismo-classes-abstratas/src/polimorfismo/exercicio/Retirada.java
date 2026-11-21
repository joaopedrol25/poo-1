package polimorfismo.exercicio;

public final class Retirada extends Frete {
    public Retirada() {
        super("Retirada");
    }

    @Override
    protected int calcularEmCentavos(int quilosCobrados) {
        return 0;
    }
}
