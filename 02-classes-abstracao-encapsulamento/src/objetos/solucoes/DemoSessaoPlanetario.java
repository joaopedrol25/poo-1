package objetos.solucoes;

import java.time.LocalDateTime;

public class DemoSessaoPlanetario {
    public static void main(String[] args) {
        SessaoPlanetario sessao = new SessaoPlanetario("Céu de inverno",
                LocalDateTime.of(2026, 6, 13, 15, 0), 12);

        System.out.println(sessao.getTitulo() + " — " + sessao.getInicio());
        System.out.println("Reserva de 8: " + sessao.reservar(8));
        System.out.println("Reserva de 5: " + sessao.reservar(5));
        System.out.println("Cancelamento de 3: " + sessao.cancelarReserva(3));
        System.out.println("Lugares disponíveis: " + sessao.lugaresDisponiveis());
    }
}
