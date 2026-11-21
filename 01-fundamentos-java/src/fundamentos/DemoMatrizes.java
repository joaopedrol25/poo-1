package fundamentos;

import java.util.Arrays;

public class DemoMatrizes {
    public static void main(String[] args) {
        int[][] inscritosPorOficina = {
            {10, 12, 14},
            {8, 11},
            {}
        };
        System.out.println("Inscritos por turma: " + Arrays.deepToString(inscritosPorOficina));
        System.out.println("Total por oficina: " + Arrays.toString(somarPorLinha(inscritosPorOficina)));
    }

    static long[] somarPorLinha(int[][] matriz) {
        long[] totais = new long[matriz.length];
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                totais[linha] += matriz[linha][coluna];
            }
        }
        return totais;
    }
}
