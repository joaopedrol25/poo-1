package revisao;

import java.util.Objects;

public class GerenciadorCifras {
    private final Mensagem[] historico;
    private final Usuario usuario;
    private int quantidade;

    public GerenciadorCifras(int capacidadeMaxima, Usuario usuario) {
        if (capacidadeMaxima < 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior ou igual a zero.");
        }
        this.historico = new Mensagem[capacidadeMaxima];
        this.usuario = Objects.requireNonNull(usuario, "O usuário é obrigatório.");
    }

    public boolean processarMensagem(String texto, int deslocamento) {
        if (quantidade == historico.length) {
            return false;
        }

        Mensagem mensagem = new Mensagem(texto, deslocamento);
        mensagem.cifrarMensagem();
        historico[quantidade] = mensagem;
        quantidade++;
        usuario.registrarMensagemCifrada();
        return true;
    }

    public Mensagem buscarMensagemPorIndice(int indice) {
        if (indice < 0 || indice >= quantidade) {
            return null;
        }
        return historico[indice];
    }

    public int mensagensRestantes() {
        return historico.length - quantidade;
    }
}
