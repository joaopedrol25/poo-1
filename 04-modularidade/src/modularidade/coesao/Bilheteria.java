package modularidade.coesao;

public final class Bilheteria {
    private static final int PRECO_INTEIRA = 2400;

    private final String filme;
    private final int capacidade;
    private int emitidos;

    public Bilheteria(String filme, int capacidade) {
        if (filme == null || filme.isBlank() || capacidade <= 0) {
            throw new IllegalArgumentException("Informe um filme e uma capacidade positiva.");
        }
        this.filme = filme;
        this.capacidade = capacidade;
    }

    public Ingresso emitir(boolean meiaEntrada) {
        if (emitidos == capacidade) {
            throw new IllegalStateException("Sessão esgotada.");
        }

        int preco = meiaEntrada ? PRECO_INTEIRA / 2 : PRECO_INTEIRA;
        emitidos++;
        return new Ingresso(emitidos, filme, preco);
    }

    public int lugaresRestantes() {
        return capacidade - emitidos;
    }
}
