package associacoes.planetario;

public final class Reserva {
    private final int assento;
    private final Visitante visitante;

    Reserva(int assento, Visitante visitante) {
        this.assento = assento;
        this.visitante = visitante;
    }

    public int assento() {
        return assento;
    }

    public Visitante visitante() {
        return visitante;
    }
}
