package heranca.transporte;

public final class BicicletaEletrica extends Bicicleta {
    private final Bateria bateria;

    public BicicletaEletrica(int capacidadeDaBateria) {
        bateria = new Bateria(capacidadeDaBateria);
    }

    public boolean pedalarComAuxilio() {
        if (!bateria.consumirUnidade()) {
            return false;
        }
        pedalarUmaVolta();
        return true;
    }

    public void recarregar() {
        bateria.recarregar();
    }

    public int cargaRestante() {
        return bateria.carga();
    }
}
