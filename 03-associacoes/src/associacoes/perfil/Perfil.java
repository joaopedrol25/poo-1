package associacoes.perfil;

public final class Perfil {
    private final String nome;
    private final ConfiguracaoPerfil configuracao;

    public Perfil(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome do perfil.");
        }
        this.nome = nome.strip();
        this.configuracao = new ConfiguracaoPerfil();
    }

    public String nome() {
        return nome;
    }

    public ConfiguracaoPerfil configuracao() {
        return configuracao;
    }
}
