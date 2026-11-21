package projeto.equipamentos;

public final class EquipamentoEletrico extends Equipamento {
    private final long taxaDeManutencaoEmCentavos;

    public EquipamentoEletrico(String codigo, String descricao, long diariaEmCentavos,
            long taxaDeManutencaoEmCentavos) {
        super(codigo, descricao, diariaEmCentavos);
        if (taxaDeManutencaoEmCentavos < 0) {
            throw new IllegalArgumentException("A taxa não pode ser negativa.");
        }
        this.taxaDeManutencaoEmCentavos = taxaDeManutencaoEmCentavos;
    }

    @Override
    protected long taxaFixaEmCentavos() {
        return taxaDeManutencaoEmCentavos;
    }
}
