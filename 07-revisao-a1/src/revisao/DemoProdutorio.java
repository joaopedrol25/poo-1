package revisao;

import java.util.Locale;

public class DemoProdutorio {
    public static void main(String[] args) {
        System.out.printf(Locale.ROOT, "Produto de 1 a 3: %.6f%n", Produtorio.calcular(1, 3));
        System.out.printf(Locale.ROOT, "Produto com um termo (4): %.6f%n", Produtorio.calcular(4, 4));
    }
}
