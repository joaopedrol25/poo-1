package polimorfismo.figuras;

public final class Retangulo extends Figura {
    private final int larguraEmCentimetros;
    private final int alturaEmCentimetros;

    public Retangulo(String nome, int larguraEmCentimetros, int alturaEmCentimetros) {
        super(nome);
        exigirMedidaPositiva(larguraEmCentimetros);
        exigirMedidaPositiva(alturaEmCentimetros);
        this.larguraEmCentimetros = larguraEmCentimetros;
        this.alturaEmCentimetros = alturaEmCentimetros;
    }

    @Override
    public double areaEmCentimetrosQuadrados() {
        return (double) larguraEmCentimetros * alturaEmCentimetros;
    }
}
