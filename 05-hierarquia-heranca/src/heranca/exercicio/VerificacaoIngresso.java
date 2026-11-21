package heranca.exercicio;

public class VerificacaoIngresso {
    public static void main(String[] args) {
        Ingresso inteiro = new Ingresso("Mostra de cinema", 2501);
        Ingresso meia = new IngressoEstudantil("Mostra de cinema", 2501, "2026-017");
        Ingresso meiaGratuita = new IngressoEstudantil("Sessão gratuita", 0, "2026-017");
        assert inteiro.precoEmCentavos() == 2501;
        assert meia.precoEmCentavos() == 1251;
        assert meia.resumo().equals("Mostra de cinema — 1251 centavo(s)");
        assert meiaGratuita.precoEmCentavos() == 0;

        try {
            new IngressoEstudantil("Mostra de cinema", 2500, " ");
            throw new AssertionError("Matrícula em branco aceita.");
        } catch (IllegalArgumentException esperado) {
            assert esperado.getMessage().contains("matrícula");
        }
    }
}
