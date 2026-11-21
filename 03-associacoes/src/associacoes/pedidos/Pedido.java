package associacoes.pedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Pedido {
    public static final int MAXIMO_DE_ITENS = 10;
    public static final int MAXIMO_POR_ITEM = 999;

    private final int numero;
    private final List<ItemPedido> itens = new ArrayList<>();

    public Pedido(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número do pedido deve ser positivo.");
        }
        this.numero = numero;
    }

    public int numero() {
        return numero;
    }

    public boolean adicionarItem(Produto produto, int quantidade) {
        Objects.requireNonNull(produto, "Informe o produto.");
        if (quantidade < 1 || quantidade > MAXIMO_POR_ITEM) {
            throw new IllegalArgumentException("A quantidade deve estar entre 1 e " + MAXIMO_POR_ITEM + ".");
        }
        if (itens.size() == MAXIMO_DE_ITENS) {
            return false;
        }
        itens.add(new ItemPedido(produto, quantidade));
        return true;
    }

    public long totalEmCentavos() {
        long total = 0;
        for (ItemPedido item : itens) {
            total += item.subtotalEmCentavos();
        }
        return total;
    }

    public List<ItemPedido> itens() {
        return List.copyOf(itens);
    }
}
