package polimorfismo.sobrescrita;

public class VerificacaoSobrescrita {
    public static void main(String[] args) {
        BoletimDetalhado detalhado = new BoletimDetalhado("Laboratório", 3);
        Boletim geral = detalhado;
        Object objeto = detalhado;

        assert DemoSobrescrita.formatar(geral).equals("Edição geral: Laboratório (3 itens)");
        assert DemoSobrescrita.formatar(detalhado).equals("Edição detalhada: Laboratório (3 itens)");
        assert objeto.toString().equals("Laboratório (3 itens)");
    }
}
