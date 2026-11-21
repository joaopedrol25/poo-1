package associacoes.perfil;

public final class DemoPerfil {
    public static void main(String[] args) {
        Perfil iris = new Perfil("Íris");
        Perfil jose = new Perfil("José");
        iris.configuracao().alterarLembretes(false);

        System.out.println(iris.nome() + " recebe lembretes? " + iris.configuracao().recebeLembretes());
        System.out.println(jose.nome() + " recebe lembretes? " + jose.configuracao().recebeLembretes());
    }
}
