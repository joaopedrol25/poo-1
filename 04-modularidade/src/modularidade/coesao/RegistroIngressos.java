package modularidade.coesao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class RegistroIngressos {
    private final List<Ingresso> ingressos = new ArrayList<>();

    public void registrar(Ingresso ingresso) {
        ingressos.add(Objects.requireNonNull(ingresso));
    }

    public List<Ingresso> registrados() {
        return List.copyOf(ingressos);
    }
}
