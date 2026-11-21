package objetos;

import java.util.Objects;

/** Painel de notas inteiras entre 0 e 100. */
public final class PainelNotas {
    private final int[] notas;

    public PainelNotas(int[] notasIniciais) {
        Objects.requireNonNull(notasIniciais, "Informe as notas iniciais.");
        if (notasIniciais.length == 0) {
            throw new IllegalArgumentException("O painel precisa de pelo menos uma nota.");
        }

        int[] copia = notasIniciais.clone();
        for (int nota : copia) {
            validarNota(nota);
        }
        this.notas = copia;
    }

    public void alterarNota(int indice, int nota) {
        Objects.checkIndex(indice, notas.length);
        validarNota(nota);
        notas[indice] = nota;
    }

    public int[] copiarNotas() {
        return notas.clone();
    }

    public double calcularMedia() {
        long soma = 0;
        for (int nota : notas) {
            soma += nota;
        }
        return (double) soma / notas.length;
    }

    private static void validarNota(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("A nota deve ficar entre 0 e 100.");
        }
    }
}
