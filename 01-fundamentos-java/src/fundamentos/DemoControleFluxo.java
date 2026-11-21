package fundamentos;

public class DemoControleFluxo {
    public static void main(String[] args) {
        System.out.println("Situação com nota 75: " + classificarNota(75));
        System.out.println("Turno V: " + nomeTurno('V'));
        System.out.println("Soma de 1 a 5: " + somarAte(5));
        System.out.println("Duplicações de 1 até alcançar 10: " + contarDuplicacoes(10));

        int tentativas = 0;
        do {
            tentativas++;
            System.out.println("Tentativa de sincronização " + tentativas);
        } while (tentativas < 3);
    }

    static String classificarNota(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 100.");
        }
        if (nota >= 70) {
            return "aprovado";
        } else if (nota >= 50) {
            return "recuperação";
        } else {
            return "reprovado";
        }
    }

    static String nomeTurno(char turno) {
        return switch (turno) {
            case 'M' -> "manhã";
            case 'V' -> "tarde";
            case 'N' -> "noite";
            default -> "turno inválido";
        };
    }

    static long somarAte(int limite) {
        long soma = 0;
        for (long parcela = 1; parcela <= limite; parcela++) {
            soma += parcela;
        }
        return soma;
    }

    static int contarDuplicacoes(int limite) {
        long capacidade = 1;
        int duplicacoes = 0;
        while (capacidade < limite) {
            capacidade *= 2;
            duplicacoes++;
        }
        return duplicacoes;
    }
}
