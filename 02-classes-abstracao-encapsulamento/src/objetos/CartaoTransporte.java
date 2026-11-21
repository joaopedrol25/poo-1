package objetos;

/** Cartão pré-pago com saldo em centavos e operações que preservam seu estado. */
public final class CartaoTransporte {
    private final String codigo;
    private String apelido;
    private long saldoEmCentavos;

    public CartaoTransporte(String codigo, String apelido) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Informe o código do cartão.");
        }
        validarApelido(apelido);
        this.codigo = codigo;
        this.apelido = apelido;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        validarApelido(apelido);
        this.apelido = apelido;
    }

    public long getSaldoEmCentavos() {
        return saldoEmCentavos;
    }

    public void recarregar(long valorEmCentavos) {
        validarValor(valorEmCentavos);
        saldoEmCentavos = Math.addExact(saldoEmCentavos, valorEmCentavos);
    }

    public boolean pagarPassagem(long tarifaEmCentavos) {
        validarValor(tarifaEmCentavos);
        if (tarifaEmCentavos > saldoEmCentavos) {
            return false;
        }
        saldoEmCentavos -= tarifaEmCentavos;
        return true;
    }

    private static void validarApelido(String apelido) {
        if (apelido == null || apelido.isBlank()) {
            throw new IllegalArgumentException("O apelido precisa ter algum texto.");
        }
    }

    private static void validarValor(long valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            throw new IllegalArgumentException("O valor em centavos precisa ser positivo.");
        }
    }
}
