package polimorfismo.sobrescrita;

public class DemoSobrescrita {
    public static void main(String[] args) {
        BoletimDetalhado detalhado = new BoletimDetalhado("Notícias do laboratório", 3);
        Boletim referenciaGeral = detalhado;
        Object referenciaObjeto = detalhado;

        // O compilador seleciona a sobrecarga pelo tipo declarado do argumento.
        System.out.println(formatar(referenciaGeral));
        System.out.println(formatar(detalhado));

        // O objeto real continua sendo detalhado, seja qual for o tipo da referência.
        System.out.println("Object.toString(): " + referenciaObjeto.toString());
    }

    static String formatar(Boletim boletim) {
        return "Edição geral: " + boletim.resumo();
    }

    static String formatar(BoletimDetalhado boletim) {
        return "Edição detalhada: " + boletim.resumo();
    }
}
