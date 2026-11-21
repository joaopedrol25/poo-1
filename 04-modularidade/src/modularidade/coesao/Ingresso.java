package modularidade.coesao;

public final class Ingresso {
    private final int numero;
    private final String filme;
    private final int precoEmCentavos;

    Ingresso(int numero, String filme, int precoEmCentavos) {
        this.numero = numero;
        this.filme = filme;
        this.precoEmCentavos = precoEmCentavos;
    }

    public int numero() {
        return numero;
    }

    public String filme() {
        return filme;
    }

    public int precoEmCentavos() {
        return precoEmCentavos;
    }
}
