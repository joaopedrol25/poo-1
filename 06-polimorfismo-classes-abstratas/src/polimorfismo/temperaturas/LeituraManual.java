package polimorfismo.temperaturas;

public final class LeituraManual implements FonteTemperatura {
    private final double celsius;

    public LeituraManual(double celsius) {
        if (!Double.isFinite(celsius)) {
            throw new IllegalArgumentException("A leitura deve ser um número finito.");
        }
        this.celsius = celsius;
    }

    @Override
    public double temperaturaEmCelsius() {
        return celsius;
    }
}
