package objetos.solucoes;

public class DemoOrdemManutencao {
    public static void main(String[] args) {
        OrdemManutencao ordem = new OrdemManutencao("OM-08", "Projetor da sala 2");
        System.out.println(ordem.getCodigo() + " — " + ordem.getEquipamento());
        System.out.println("Concluir ordem aberta: " + ordem.concluir("Lâmpada substituída"));
        System.out.println("Iniciar manutenção: " + ordem.iniciar());
        System.out.println("Concluir manutenção: " + ordem.concluir("Lâmpada substituída"));
        System.out.println(ordem.getEstado() + " — " + ordem.getRelatoFinal());
    }
}
