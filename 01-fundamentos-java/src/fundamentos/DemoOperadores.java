package fundamentos;

public class DemoOperadores {
    public static void main(String[] args) {
        System.out.println("2 + 3 * 4 = " + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4 = " + ((2 + 3) * 4));
        System.out.println("7 / 2 = " + (7 / 2));
        System.out.println("7 / 2.0 = " + (7 / 2.0));
        System.out.println("7 % 2 = " + (7 % 2));

        int prefixo = 5;
        int posfixo = 5;
        int valorDoPrefixo = ++prefixo;
        int valorDoPosfixo = posfixo++;
        System.out.printf("Prefixo → expressão: %d, variável: %d%n", valorDoPrefixo, prefixo);
        System.out.printf("Pós-fixo → expressão: %d, variável: %d%n", valorDoPosfixo, posfixo);

        System.out.println("12 é divisível por 3? " + divisivelPor(12, 3));
        System.out.println("12 passa no teste com divisor 0? " + divisivelPor(12, 0));

        String apelidoDigitado = null;
        boolean usarPadrao = apelidoDigitado == null || apelidoDigitado.isBlank();
        System.out.println("Usar apelido padrão? " + usarPadrao);
    }

    static boolean divisivelPor(int numero, int divisor) {
        // Se a primeira condição for falsa, Java não avalia a operação com %.
        return divisor != 0 && numero % divisor == 0;
    }
}
