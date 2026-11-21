package associacoes.planetario;

public final class DemoPlanetario {
    public static void main(String[] args) {
        Sessao sessao = new Sessao("Céu de inverno", 3);
        Visitante iris = new Visitante("V1", "Íris");
        Visitante rui = new Visitante("V2", "Rui");

        System.out.println(sessao.titulo());
        System.out.println("Íris reservou o assento 2? " + sessao.reservar(2, iris));
        System.out.println("Rui reservou o mesmo assento? " + sessao.reservar(2, rui));
        System.out.println("Íris cancelou o assento 2? " + sessao.cancelar(2, iris));
        System.out.println("Rui reservou após o cancelamento? " + sessao.reservar(2, rui));
        System.out.println("Vagas livres " + sessao.vagasDisponiveis());
    }
}
