package modularidade.acoplamento;

import java.util.Objects;

public final class ReservaLaboratorio {
    private final Pesquisador responsavel;

    public ReservaLaboratorio(Pesquisador responsavel) {
        this.responsavel = Objects.requireNonNull(responsavel);
    }

    public boolean autorizaEntrada() {
        return responsavel.podeOperarEquipamentos();
    }
}
