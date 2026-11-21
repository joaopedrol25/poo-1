package associacoes.pedidos;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class DemoPedido {
    public static void main(String[] args) {
        Produto caneta = new Produto("Caneta", 250);
        Produto caderno = new Produto("Caderno", 1350);
        Pedido pedido = new Pedido(12);
        pedido.adicionarItem(caneta, 3);
        pedido.adicionarItem(caderno, 2);

        NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        System.out.println("Pedido " + pedido.numero());
        for (ItemPedido item : pedido.itens()) {
            String subtotal = moeda.format(BigDecimal.valueOf(item.subtotalEmCentavos(), 2));
            System.out.println(item.quantidade() + " × " + item.produto().nome() + " | " + subtotal);
        }
        System.out.println("Total " + moeda.format(BigDecimal.valueOf(pedido.totalEmCentavos(), 2)));
    }
}
