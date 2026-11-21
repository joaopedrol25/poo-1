package modularidade.coesao;

import java.util.Locale;

public final class FormatadorIngresso {
    public String formatar(Ingresso ingresso) {
        int preco = ingresso.precoEmCentavos();
        return String.format(Locale.ROOT, "%s | Ingresso %d | R$ %d,%02d",
                ingresso.filme(), ingresso.numero(), preco / 100, preco % 100);
    }
}
