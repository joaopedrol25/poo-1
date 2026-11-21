package heranca.transporte;

final class Bateria {
    private final int capacidade;
    private int carga;

    Bateria(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A bateria deve ter capacidade positiva.");
        }
        this.capacidade = capacidade;
        recarregar();
    }

    boolean consumirUnidade() {
        if (carga == 0) {
            return false;
        }
        carga--;
        return true;
    }

    void recarregar() {
        carga = capacidade;
    }

    int carga() {
        return carga;
    }
}
