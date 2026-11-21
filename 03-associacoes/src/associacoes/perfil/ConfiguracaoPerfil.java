package associacoes.perfil;

public final class ConfiguracaoPerfil {
    private boolean recebeLembretes = true;

    ConfiguracaoPerfil() {
    }

    public boolean recebeLembretes() {
        return recebeLembretes;
    }

    public void alterarLembretes(boolean recebeLembretes) {
        this.recebeLembretes = recebeLembretes;
    }
}
