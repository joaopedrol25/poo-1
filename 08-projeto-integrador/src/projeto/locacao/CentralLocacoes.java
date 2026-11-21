package projeto.locacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import projeto.equipamentos.Equipamento;

public final class CentralLocacoes {
    private final Map<String, Equipamento> acervo = new HashMap<>();
    private final List<Locacao> historico = new ArrayList<>();

    public void cadastrar(Equipamento equipamento) {
        Objects.requireNonNull(equipamento, "Equipamento");
        if (acervo.putIfAbsent(equipamento.codigo(), equipamento) != null) {
            throw new IllegalArgumentException("Já existe um equipamento com esse código.");
        }
    }

    public Locacao abrir(String codigo, Associado associado, LocalDate inicio, int dias) {
        Equipamento equipamento = acervo.get(codigo);
        if (equipamento == null) {
            throw new IllegalArgumentException("Equipamento não cadastrado.");
        }
        for (Locacao locacao : historico) {
            if (locacao.estaAberta() && locacao.equipamento() == equipamento) {
                throw new IllegalStateException("Equipamento já está em locação.");
            }
        }

        Locacao locacao = new Locacao(equipamento, associado, inicio, dias);
        historico.add(locacao);
        return locacao;
    }

    public void devolver(Locacao locacao, LocalDate data) {
        if (!historico.contains(locacao)) {
            throw new IllegalArgumentException("Locação não registrada nesta central.");
        }
        locacao.registrarDevolucao(data);
    }

    public List<Locacao> historico() {
        return List.copyOf(historico);
    }
}
