package polimorfismo.figuras;

public final class Circulo extends Figura {
    private final int raioEmCentimetros;

    public Circulo(String nome, int raioEmCentimetros) {
        super(nome);
        exigirMedidaPositiva(raioEmCentimetros);
        this.raioEmCentimetros = raioEmCentimetros;
    }

    @Override
    public double areaEmCentimetrosQuadrados() {
        return Math.PI * raioEmCentimetros * raioEmCentimetros;
    }
}
