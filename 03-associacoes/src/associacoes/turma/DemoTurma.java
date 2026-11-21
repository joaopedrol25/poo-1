package associacoes.turma;

public final class DemoTurma {
    public static void main(String[] args) {
        Turma java = new Turma("POO-01");
        Turma historia = new Turma("HIST-02");
        Aluno davi = new Aluno("2026-01", "Davi");
        java.adicionarAluno(davi);
        java.adicionarAluno(new Aluno("2026-02", "Sara"));
        historia.adicionarAluno(davi);

        System.out.println("Alunos de " + java.codigo());
        for (Aluno aluno : java.alunosMatriculados()) {
            System.out.println(aluno.matricula() + " | " + aluno.nome());
        }
        System.out.println("A segunda turma também contém Davi? " + (historia.alunosMatriculados()[0] == davi));
    }
}
