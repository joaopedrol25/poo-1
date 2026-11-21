package modularidade.protocolo;

import java.util.List;

public final class DemoProtocolo {
    public static void main(String[] args) {
        MotorDeImpressao motor = new MotorDeImpressao();
        try {
            motor.imprimirEtiqueta("Arquivo A");
        } catch (IllegalStateException erro) {
            System.out.println("Chamada fora de ordem: " + erro.getMessage());
        }

        ImpressoraEtiquetas impressora = new ImpressoraEtiquetas();
        System.out.println("Lote produzido: " + impressora.imprimir(List.of("Arquivo A", "Arquivo B")));

        try {
            impressora.imprimir(List.of("Falha no segundo item", "  "));
        } catch (IllegalArgumentException erro) {
            System.out.println("Lote descartado: " + erro.getMessage());
        }
        System.out.println("Novo lote: " + impressora.imprimir(List.of("Arquivo C")));
    }
}
