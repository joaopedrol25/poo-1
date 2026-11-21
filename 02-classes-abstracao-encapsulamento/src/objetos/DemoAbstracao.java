package objetos;

import java.time.LocalDate;

public class DemoAbstracao {
    public static void main(String[] args) {
        BicicletaLocacao bicicletaNoBalcao = new BicicletaLocacao("B-10", 2_500);
        System.out.printf("Balcão (%s), duas diárias: %d centavos%n",
                bicicletaNoBalcao.getCodigo(), bicicletaNoBalcao.calcularValorEmCentavos(2));
        System.out.println("Locação aceita: " + bicicletaNoBalcao.alugar());
        System.out.println("Disponível: " + bicicletaNoBalcao.estaDisponivel());

        BicicletaOficina bicicletaNaOficina = new BicicletaOficina("B-10", LocalDate.of(2026, 5, 1));
        LocalDate hoje = LocalDate.of(2026, 5, 16);
        System.out.printf("Oficina (%s), dias desde a revisão: %d%n",
                bicicletaNaOficina.getCodigo(), bicicletaNaOficina.diasDesdeUltimaRevisao(hoje));
        bicicletaNaOficina.registrarRevisao(hoje);
        System.out.println("Dias após registrar revisão: " + bicicletaNaOficina.diasDesdeUltimaRevisao(hoje));
    }
}
