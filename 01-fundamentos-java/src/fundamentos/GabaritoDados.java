package fundamentos;

import java.util.Arrays;
import java.util.Locale;

public class GabaritoDados {
    public static void main(String[] args) {
        System.out.println("F03 — código normalizado: " + normalizarCodigo("  iFf-230 "));
        int[] agendaCompleta = mesclarOrdenados(new int[] {1, 3, 3}, new int[] {-2, 3, 4});
        System.out.println("F04 — agenda reunida: " + Arrays.toString(agendaCompleta));

        int[][] ocupacao = {{1, 0, 1}, {0, 1}, {1, 0, 0}};
        System.out.println("F05 — índice da bancada menos ocupada: " + indiceMenosOcupado(ocupacao));
    }

    static String normalizarCodigo(String entrada) {
        String codigo = entrada.strip();
        if (codigo.length() != 7 || codigo.charAt(3) != '-') {
            throw formatoInvalido();
        }

        for (int indice = 0; indice < 3; indice++) {
            char caractere = codigo.charAt(indice);
            if (!letraAscii(caractere)) {
                throw formatoInvalido();
            }
        }

        for (int indice = 4; indice < codigo.length(); indice++) {
            char caractere = codigo.charAt(indice);
            if (caractere < '0' || caractere > '9') {
                throw formatoInvalido();
            }
        }
        return codigo.toUpperCase(Locale.ROOT);
    }

    private static boolean letraAscii(char caractere) {
        return (caractere >= 'a' && caractere <= 'z') || (caractere >= 'A' && caractere <= 'Z');
    }

    private static IllegalArgumentException formatoInvalido() {
        return new IllegalArgumentException("Use três letras de A a Z, um hífen e três dígitos.");
    }

    static int[] mesclarOrdenados(int[] primeiros, int[] segundos) {
        int[] resultado = new int[primeiros.length + segundos.length];
        int esquerda = 0;
        int direita = 0;
        int destino = 0;
        while (esquerda < primeiros.length && direita < segundos.length) {
            if (primeiros[esquerda] <= segundos[direita]) {
                resultado[destino] = primeiros[esquerda];
                esquerda++;
            } else {
                resultado[destino] = segundos[direita];
                direita++;
            }
            destino++;
        }

        // O restante de cada entrada já está ordenado.
        while (esquerda < primeiros.length) {
            resultado[destino] = primeiros[esquerda];
            destino++;
            esquerda++;
        }
        while (direita < segundos.length) {
            resultado[destino] = segundos[direita];
            destino++;
            direita++;
        }
        return resultado;
    }

    static int indiceMenosOcupado(int[][] ocupacao) {
        int melhorIndice = -1;
        int menorOcupacao = 0;
        for (int linha = 0; linha < ocupacao.length; linha++) {
            int ocupados = contarOcupados(ocupacao[linha]);
            if (melhorIndice == -1 || ocupados < menorOcupacao) {
                melhorIndice = linha;
                menorOcupacao = ocupados;
            }
        }
        return melhorIndice;
    }

    private static int contarOcupados(int[] horarios) {
        int ocupados = 0;
        for (int horario : horarios) {
            if (horario != 0 && horario != 1) {
                throw new IllegalArgumentException("Registre cada horário como livre (0) ou ocupado (1).");
            }
            ocupados += horario;
        }
        return ocupados;
    }
}
