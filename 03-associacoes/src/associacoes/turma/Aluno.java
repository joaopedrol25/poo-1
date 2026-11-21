package associacoes.turma;

public final class Aluno {
    private final String matricula;
    private final String nome;

    public Aluno(String matricula, String nome) {
        if (matricula == null || matricula.isBlank() || nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe matrícula e nome do aluno.");
        }
        this.matricula = matricula.strip();
        this.nome = nome.strip();
    }

    public String matricula() {
        return matricula;
    }

    public String nome() {
        return nome;
    }
}
