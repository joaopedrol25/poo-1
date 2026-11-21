package objetos;

/** Modelo de uma bicicleta para um balcão de locações. */
public final class BicicletaLocacao {
    private final String codigo;
    private final int diariaEmCentavos;
    private boolean alugada;

    public BicicletaLocacao(String codigo, int diariaEmCentavos) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Informe o código da bicicleta.");
        }
        if (diariaEmCentavos <= 0) {
            throw new IllegalArgumentException("A diária precisa ser positiva.");
        }
        this.codigo = codigo;
        this.diariaEmCentavos = diariaEmCentavos;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean estaDisponivel() {
        return !alugada;
    }

    public long calcularValorEmCentavos(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("A locação deve durar pelo menos um dia.");
        }
        return (long) diariaEmCentavos * dias;
    }

    public boolean alugar() {
        if (alugada) {
            return false;
        }
        alugada = true;
        return true;
    }

    public boolean devolver() {
        if (!alugada) {
            return false;
        }
        alugada = false;
        return true;
    }
}
