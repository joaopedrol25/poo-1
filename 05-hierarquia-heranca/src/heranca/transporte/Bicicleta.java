package heranca.transporte;

public class Bicicleta {
    private int voltasCompletas;

    public final void pedalarUmaVolta() {
        voltasCompletas++;
    }

    public final int voltasCompletas() {
        return voltasCompletas;
    }
}
