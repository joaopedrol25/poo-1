package modularidade.acoplamento;

import java.util.Set;

public final class Pesquisador {
    private final Set<Credencial> credenciais;

    public Pesquisador(Set<Credencial> credenciais) {
        this.credenciais = Set.copyOf(credenciais);
    }

    boolean podeOperarEquipamentos() {
        return credenciais.contains(Credencial.OPERACAO_DE_EQUIPAMENTOS);
    }
}
