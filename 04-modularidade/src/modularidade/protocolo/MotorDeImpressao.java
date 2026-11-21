package modularidade.protocolo;

import java.util.ArrayList;
import java.util.List;

// Simula uma impressora que produz o lote em memória.
final class MotorDeImpressao {
    private List<String> lote;

    void abrirLote() {
        if (lote != null) {
            throw new IllegalStateException("Já existe um lote aberto.");
        }
        lote = new ArrayList<>();
    }

    void imprimirEtiqueta(String texto) {
        if (lote == null) {
            throw new IllegalStateException("Abra o lote antes de imprimir.");
        }
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("O texto da etiqueta deve ser preenchido.");
        }
        lote.add("[" + texto.strip() + "]");
    }

    List<String> resultado() {
        if (lote == null) {
            throw new IllegalStateException("Abra o lote antes de consultar o resultado.");
        }
        return List.copyOf(lote);
    }

    void fecharLote() {
        lote = null;
    }
}
