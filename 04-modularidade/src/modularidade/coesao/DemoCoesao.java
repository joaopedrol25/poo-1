package modularidade.coesao;

public final class DemoCoesao {
    public static void main(String[] args) {
        System.out.println("Antes: emissão, formatação e registro na mesma classe.");
        BilheteriaLegada legada = new BilheteriaLegada("Mostra da Cidade", 2);
        legada.emitir(false);
        legada.emitir(true);

        System.out.println("Depois: três responsabilidades colaboram.");
        Bilheteria bilheteria = new Bilheteria("Mostra da Cidade", 2);
        RegistroIngressos registro = new RegistroIngressos();
        FormatadorIngresso formatador = new FormatadorIngresso();

        registro.registrar(bilheteria.emitir(false));
        registro.registrar(bilheteria.emitir(true));
        for (Ingresso ingresso : registro.registrados()) {
            System.out.println(formatador.formatar(ingresso));
        }
        System.out.println("Lugares restantes: " + bilheteria.lugaresRestantes());
    }
}
