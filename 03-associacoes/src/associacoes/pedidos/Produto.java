package associacoes.pedidos;

public final class Produto {
    private final String nome;
    private final int precoEmCentavos;

    public Produto(String nome, int precoEmCentavos) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome do produto.");
        }
        if (precoEmCentavos < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero.");
        }
        this.nome = nome.strip();
        this.precoEmCentavos = precoEmCentavos;
    }

    public String nome() {
        return nome;
    }

    public int precoEmCentavos() {
        return precoEmCentavos;
    }
}
