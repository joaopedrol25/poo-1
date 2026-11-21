package revisao;

public final class Produtorio {
    private Produtorio() {
    }

    public static double calcular(int limiteInferior, int limiteSuperior) {
        if (limiteInferior < 1 || limiteSuperior < limiteInferior) {
            throw new IllegalArgumentException("Use limites inteiros com 1 <= inferior <= superior.");
        }

        double produto = 1.0;
        for (long indice = limiteInferior; indice <= limiteSuperior; indice++) {
            double termo = indice + 1.0 / indice;
            produto *= termo;
        }
        return produto;
    }
}
