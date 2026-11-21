package modularidade.coesao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Versão deliberadamente monolítica para comparação com Bilheteria.
final class BilheteriaLegada {
    private final String filme;
    private final int capacidade;
    private final List<String> comprovantes = new ArrayList<>();

    BilheteriaLegada(String filme, int capacidade) {
        if (filme == null || filme.isBlank() || capacidade <= 0) {
            throw new IllegalArgumentException("Informe um filme e uma capacidade positiva.");
        }
        this.filme = filme;
        this.capacidade = capacidade;
    }

    void emitir(boolean meiaEntrada) {
        if (comprovantes.size() == capacidade) {
            throw new IllegalStateException("Sessão esgotada.");
        }

        int preco = meiaEntrada ? 1200 : 2400;
        int numero = comprovantes.size() + 1;
        String recibo = String.format(Locale.ROOT, "%s | Ingresso %d | R$ %d,%02d",
                filme, numero, preco / 100, preco % 100);
        comprovantes.add(recibo);
        System.out.println(recibo);
    }
}
