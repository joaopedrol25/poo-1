package heranca.equipamentos;

public class Equipamento {
    private final String identificacao;
    private boolean ligado;

    public Equipamento(String identificacao) {
        if (identificacao == null || identificacao.isBlank()) {
            throw new IllegalArgumentException("Informe a identificação do equipamento.");
        }
        this.identificacao = identificacao.strip();
    }

    public final String identificacao() {
        return identificacao;
    }

    public final void ligar() {
        ligado = true;
    }

    public final void desligar() {
        ligado = false;
    }

    public final boolean estaLigado() {
        return ligado;
    }

    protected final void exigirLigado() {
        if (!ligado) {
            throw new IllegalStateException("Ligue o equipamento antes de usá-lo.");
        }
    }
}
