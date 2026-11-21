package revisao;

public class DemoPrecedencia {
    public static void main(String[] args) {
        int preparados = 4;
        int minimo = 3;
        int lugares = 1;

        boolean entraComPreDecremento = preparados > minimo && --lugares > 0;
        System.out.printf("Pré-decremento: entra=%b, lugares=%d%n", entraComPreDecremento, lugares);

        lugares = 1;
        boolean entraComPosDecremento = preparados > minimo && lugares-- > 0;
        System.out.printf("Pós-decremento: entra=%b, lugares=%d%n", entraComPosDecremento, lugares);

        lugares = 1;
        boolean entraComCurtoCircuito = preparados < minimo && --lugares > 0;
        System.out.printf("Curto-circuito: entra=%b, lugares=%d%n", entraComCurtoCircuito, lugares);
    }
}
