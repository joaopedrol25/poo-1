package fundamentos;

import java.util.Arrays;

public class DemoVetores {
    public static void main(String[] args) {
        int[] atendimentos = {12, 20, 14, 20, 8};
        System.out.println("Atendimentos: " + Arrays.toString(atendimentos));
        System.out.println("Total: " + somar(atendimentos));

        int indiceDoPico = indiceDoMaior(atendimentos);
        if (indiceDoPico >= 0) {
            System.out.printf("Primeiro pico na posição %d: %d%n", indiceDoPico, atendimentos[indiceDoPico]);
        }

        int[] capacidadeParaTresDias = new int[3];
        capacidadeParaTresDias[0] = 10;
        System.out.println("Dias informados e valores iniciais: " + Arrays.toString(capacidadeParaTresDias));
    }

    static long somar(int[] valores) {
        long soma = 0;
        for (int valor : valores) {
            soma += valor;
        }
        return soma;
    }

    static int indiceDoMaior(int[] valores) {
        if (valores.length == 0) {
            return -1;
        }

        int indiceDoMaior = 0;
        for (int indice = 1; indice < valores.length; indice++) {
            if (valores[indice] > valores[indiceDoMaior]) {
                indiceDoMaior = indice;
            }
        }
        return indiceDoMaior;
    }
}
