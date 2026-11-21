package polimorfismo.figuras;

import java.util.Locale;

public abstract class Figura {
    private final String nome;

    protected Figura(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome da figura.");
        }
        this.nome = nome.strip();
    }

    public abstract double areaEmCentimetrosQuadrados();

    public final String etiqueta() {
        return String.format(Locale.ROOT, "%s: %.2f cm²", nome, areaEmCentimetrosQuadrados());
    }

    protected static void exigirMedidaPositiva(int medidaEmCentimetros) {
        if (medidaEmCentimetros <= 0) {
            throw new IllegalArgumentException("A medida em centímetros deve ser positiva.");
        }
    }
}
