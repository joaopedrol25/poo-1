package associacoes.pedidos;

import java.util.List;

public final class VerificacaoPedido {
    public static void main(String[] args) {
        Produto caneta = new Produto("Caneta", 250);
        Pedido primeiro = new Pedido(1);
        Pedido segundo = new Pedido(2);

        assert primeiro.totalEmCentavos() == 0 : "Um pedido vazio tem total zero.";
        List<ItemPedido> antesDeAdicionar = primeiro.itens();
        primeiro.adicionarItem(caneta, 3);
        segundo.adicionarItem(caneta, 1);

        ItemPedido primeiroItem = primeiro.itens().get(0);
        ItemPedido segundoItem = segundo.itens().get(0);
        assert primeiroItem != segundoItem : "Cada pedido tem seu próprio item.";
        assert primeiroItem.produto() == segundoItem.produto() : "O produto pode ser compartilhado.";
        assert primeiroItem.subtotalEmCentavos() == 750 : "O subtotal multiplica preço por quantidade.";
        assert primeiro.totalEmCentavos() == 750 : "O pedido soma os subtotais.";
        assert antesDeAdicionar.isEmpty() : "A consulta entrega uma cópia da lista naquele momento.";

        for (int numero = 1; numero < Pedido.MAXIMO_DE_ITENS; numero++) {
            boolean adicionou = primeiro.adicionarItem(caneta, 1);
            assert adicionou : "O pedido deve aceitar os itens até o limite.";
        }
        boolean ultrapassou = primeiro.adicionarItem(caneta, 1);
        assert !ultrapassou : "O pedido deve rejeitar o próximo item após o limite.";
        assert primeiro.totalEmCentavos() == 3000 : "A tentativa rejeitada preserva o total.";
    }
}
