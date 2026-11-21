package polimorfismo.sobrescrita;

public final class BoletimDetalhado extends Boletim {
    private final int numeroDeItens;

    public BoletimDetalhado(String titulo, int numeroDeItens) {
        super(titulo);
        if (numeroDeItens < 0) {
            throw new IllegalArgumentException("A quantidade de itens deve ser não negativa.");
        }
        this.numeroDeItens = numeroDeItens;
    }

    @Override
    public String resumo() {
        return "%s (%d itens)".formatted(super.resumo(), numeroDeItens);
    }
}
