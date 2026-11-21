package fundamentos;

import java.util.Locale;

public class DemoEstrutura {
    public static void main(String[] args) {
        final int CAPACIDADE = 24;
        String atividade = args.length > 0 ? args[0] : "Oficina de Java";
        int inscritos = 18;
        int vagasLivres = CAPACIDADE - inscritos;
        boolean haVagas = vagasLivres > 0;
        char turma = 'A';

        // Converter antes de dividir evita que a divisão descarte a parte fracionária.
        double ocupacao = (double) inscritos / CAPACIDADE;
        int percentualTruncado = (int) (ocupacao * 100);

        Locale portugues = Locale.forLanguageTag("pt-BR");
        System.out.printf("%s — turma %c%n", atividade, turma);
        System.out.printf("Vagas livres: %d. Inscrições abertas: %b%n", vagasLivres, haVagas);
        System.out.printf(portugues, "Ocupação: %.1f%%%n", ocupacao * 100);
        System.out.println("Percentual inteiro: " + percentualTruncado);
    }
}
