package associacoes.turma;

import java.util.Arrays;
import java.util.Objects;

public final class Turma {
    public static final int CAPACIDADE = 40;

    private final String codigo;
    private final Aluno[] alunos = new Aluno[CAPACIDADE];
    private int quantidade;

    public Turma(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Informe o código da turma.");
        }
        this.codigo = codigo.strip();
    }

    public String codigo() {
        return codigo;
    }

    public int quantidade() {
        return quantidade;
    }

    public boolean adicionarAluno(Aluno aluno) {
        Objects.requireNonNull(aluno, "Informe o aluno.");
        if (quantidade == alunos.length) {
            return false;
        }
        for (int indice = 0; indice < quantidade; indice++) {
            if (alunos[indice].matricula().equals(aluno.matricula())) {
                return false;
            }
        }

        alunos[quantidade] = aluno;
        quantidade++;
        return true;
    }

    public Aluno[] alunosMatriculados() {
        return Arrays.copyOf(alunos, quantidade);
    }
}
