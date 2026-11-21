package revisao;

import java.util.Objects;

public class Mensagem {
    private final char[] textoOriginal;
    private final char[] textoCifrado;
    private final int deslocamento;
    private boolean cifrada;

    public Mensagem(String textoOriginal, int deslocamento) {
        this.textoOriginal = Objects.requireNonNull(textoOriginal, "O texto é obrigatório.").toCharArray();
        this.textoCifrado = new char[this.textoOriginal.length];
        this.deslocamento = deslocamento;
    }

    public char cifrarCaractere(char caractere) {
        if (caractere >= 'a' && caractere <= 'z') {
            return deslocarNoIntervalo(caractere, 'a', 'z');
        }
        if (caractere >= 'A' && caractere <= 'Z') {
            return deslocarNoIntervalo(caractere, 'A', 'Z');
        }
        return caractere;
    }

    private char deslocarNoIntervalo(char caractere, char inicio, char fim) {
        long destino = (long) caractere + deslocamento;
        if (destino < inicio || destino > fim) {
            throw new IllegalArgumentException("O deslocamento precisa manter a letra no intervalo original.");
        }
        return (char) destino;
    }

    public void cifrarMensagem() {
        for (int indice = 0; indice < textoOriginal.length; indice++) {
            textoCifrado[indice] = cifrarCaractere(textoOriginal[indice]);
        }
        cifrada = true;
    }

    public char[] obterTextoCifrado() {
        if (!cifrada) {
            throw new IllegalStateException("Cifre a mensagem antes de consultar o resultado.");
        }
        return textoCifrado.clone();
    }
}
