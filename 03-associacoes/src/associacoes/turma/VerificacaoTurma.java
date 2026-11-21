package associacoes.turma;

public final class VerificacaoTurma {
    public static void main(String[] args) {
        Turma turma = new Turma("POO-01");
        assert turma.quantidade() == 0 : "Uma turma nova começa vazia.";
        assert turma.alunosMatriculados().length == 0 : "O array público inclui apenas posições preenchidas.";

        Aluno primeiro = new Aluno("A1", "Lia");
        boolean matriculou = turma.adicionarAluno(primeiro);
        boolean duplicou = turma.adicionarAluno(new Aluno(" A1 ", "Outra instância"));
        assert matriculou : "A primeira matrícula deveria ser aceita.";
        assert !duplicou : "A turma impede duplicatas pela matrícula.";

        Aluno[] copia = turma.alunosMatriculados();
        copia[0] = null;
        assert turma.alunosMatriculados()[0] == primeiro : "Alterar a cópia preserva o array interno.";

        for (int numero = 2; numero <= Turma.CAPACIDADE; numero++) {
            boolean inseriu = turma.adicionarAluno(new Aluno("A" + numero, "Aluno " + numero));
            assert inseriu : "Todas as vagas deveriam poder ser preenchidas.";
        }
        boolean excedeu = turma.adicionarAluno(new Aluno("A41", "Excedente"));
        assert !excedeu : "O limite da turma é de 40 alunos.";
        assert turma.quantidade() == Turma.CAPACIDADE : "Uma tentativa rejeitada preserva a quantidade.";
    }
}
