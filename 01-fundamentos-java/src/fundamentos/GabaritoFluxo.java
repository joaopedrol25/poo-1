package fundamentos;

public class GabaritoFluxo {
    public static void main(String[] args) {
        System.out.println("F01 — sessão de 3 horas com desconto: " + calcularLocacao(3, true) + " centavos");
        int[] leituras = {80, 90, 85, 70, 71, 70};
        System.out.println("F02 — maior sequência acima de 80: " + maiorSequenciaAcima(leituras, 80));
    }

    static int calcularLocacao(int horas, boolean estudante) {
        if (horas < 0 || horas > 24) {
            throw new IllegalArgumentException("Informe de 0 a 24 horas.");
        }
        int horasIniciais = Math.min(horas, 2);
        int horasAdicionais = horas - horasIniciais;
        int preco = horasIniciais * 1_050 + horasAdicionais * 475;
        if (estudante) {
            int descontoEmCentavos = preco / 10;
            preco -= descontoEmCentavos;
        }
        return preco;
    }

    static int maiorSequenciaAcima(int[] leituras, int limite) {
        validarPercentual(limite);
        int atual = 0;
        int maior = 0;
        for (int leitura : leituras) {
            validarPercentual(leitura);
            if (leitura > limite) {
                atual++;
                maior = Math.max(maior, atual);
            } else {
                // Uma leitura no limite também encerra a sequência.
                atual = 0;
            }
        }
        return maior;
    }

    private static void validarPercentual(int percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Informe percentuais de 0 a 100.");
        }
    }
}
