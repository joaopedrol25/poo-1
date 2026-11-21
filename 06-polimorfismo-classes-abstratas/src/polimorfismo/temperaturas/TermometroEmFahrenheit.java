package polimorfismo.temperaturas;

public final class TermometroEmFahrenheit implements FonteTemperatura {
    private final double fahrenheit;

    public TermometroEmFahrenheit(double fahrenheit) {
        if (!Double.isFinite(fahrenheit)) {
            throw new IllegalArgumentException("A leitura deve ser um número finito.");
        }
        this.fahrenheit = fahrenheit;
    }

    @Override
    public double temperaturaEmCelsius() {
        return (fahrenheit - 32) * (5.0 / 9.0);
    }
}
