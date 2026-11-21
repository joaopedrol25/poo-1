package modularidade.protocolo;

import java.util.List;

public final class ImpressoraEtiquetas {
    private final MotorDeImpressao motor = new MotorDeImpressao();

    public List<String> imprimir(List<String> textos) {
        if (textos == null || textos.isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos uma etiqueta.");
        }

        motor.abrirLote();
        try {
            for (String texto : textos) {
                motor.imprimirEtiqueta(texto);
            }
            return motor.resultado();
        } finally {
            motor.fecharLote();
        }
    }
}
