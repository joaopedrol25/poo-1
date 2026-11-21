package objetos;

import java.util.Arrays;
import java.util.Locale;

public class DemoCopiasDefensivas {
    public static void main(String[] args) {
        int[] origem = {90, 70, 80};
        PainelNotas painel = new PainelNotas(origem);

        origem[0] = 500;
        int[] copia = painel.copiarNotas();
        copia[1] = -10;
        System.out.println("Notas após alterações externas: " + Arrays.toString(painel.copiarNotas()));

        painel.alterarNota(1, 100);
        System.out.println("Notas após alteração autorizada: " + Arrays.toString(painel.copiarNotas()));
        System.out.printf(Locale.ROOT, "Média: %.1f%n", painel.calcularMedia());
    }
}
