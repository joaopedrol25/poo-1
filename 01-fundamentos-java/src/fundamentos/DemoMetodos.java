package fundamentos;

import java.util.Arrays;

public class DemoMetodos {
    public static void main(String[] args) {
        double lado = 4;
        double largura = 6;
        System.out.println("Área do quadrado: " + area(lado));
        System.out.println("Área do retângulo: " + area(lado, largura));

        int pontuacao = 10;
        int novaPontuacao = somarBonus(pontuacao, 5);
        System.out.printf("Antes: %d. Valor retornado: %d%n", pontuacao, novaPontuacao);

        int[] pontuacoes = {10, 12};
        bonificar(pontuacoes, 0, 5);
        System.out.println("Pontuações após bônus no índice 0: " + Arrays.toString(pontuacoes));
    }

    static double area(double lado) {
        return area(lado, lado);
    }

    static double area(double comprimento, double largura) {
        double produto = comprimento * largura;
        return produto;
    }

    static int somarBonus(int pontuacao, int bonus) {
        return pontuacao + bonus;
    }

    static void bonificar(int[] pontuacoes, int posicao, int bonus) {
        pontuacoes[posicao] = somarBonus(pontuacoes[posicao], bonus);
    }
}
