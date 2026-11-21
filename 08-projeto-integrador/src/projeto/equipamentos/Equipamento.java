package projeto.equipamentos;

import java.util.Objects;

public abstract class Equipamento {
    private final String codigo;
    private final String descricao;
    private final long diariaEmCentavos;

    protected Equipamento(String codigo, String descricao, long diariaEmCentavos) {
        this.codigo = textoObrigatorio(codigo, "Código");
        this.descricao = textoObrigatorio(descricao, "Descrição");
        if (diariaEmCentavos <= 0) {
            throw new IllegalArgumentException("A diária deve ser positiva.");
        }
        this.diariaEmCentavos = diariaEmCentavos;
    }

    public final String codigo() {
        return codigo;
    }

    public final String descricao() {
        return descricao;
    }

    public final long calcularValorEmCentavos(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("Informe ao menos um dia de locação.");
        }
        long taxaFixa = taxaFixaEmCentavos();
        if (taxaFixa < 0) {
            throw new IllegalStateException("A taxa fixa do equipamento deve ser maior ou igual a zero.");
        }
        long valorDasDiarias = Math.multiplyExact(diariaEmCentavos, dias);
        return Math.addExact(valorDasDiarias, taxaFixa);
    }

    /** Retorna a taxa por retirada, em centavos. Zero representa isenção. */
    protected abstract long taxaFixaEmCentavos();

    private static String textoObrigatorio(String valor, String campo) {
        String texto = Objects.requireNonNull(valor, campo).strip();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException(campo + " deve ser preenchido.");
        }
        return texto;
    }
}
