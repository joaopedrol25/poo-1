package associacoes.pedidos;

public final class ItemPedido {
    private final Produto produto;
    private final int quantidade;

    ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto produto() {
        return produto;
    }

    public int quantidade() {
        return quantidade;
    }

    public long subtotalEmCentavos() {
        return (long) produto.precoEmCentavos() * quantidade;
    }
}
