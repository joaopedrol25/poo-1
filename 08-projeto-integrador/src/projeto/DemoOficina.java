package projeto;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import projeto.equipamentos.EquipamentoEletrico;
import projeto.equipamentos.EquipamentoManual;
import projeto.locacao.Associado;
import projeto.locacao.CentralLocacoes;
import projeto.locacao.Locacao;

public final class DemoOficina {
    public static void main(String[] args) {
        CentralLocacoes central = new CentralLocacoes();
        central.cadastrar(new EquipamentoManual("M1", "Alicate", 500));
        central.cadastrar(new EquipamentoEletrico("E1", "Furadeira", 1500, 300));

        Associado associado = new Associado("Lia");
        LocalDate retirada = LocalDate.of(2026, 6, 10);
        Locacao manual = central.abrir("M1", associado, retirada, 2);
        Locacao eletrica = central.abrir("E1", associado, retirada, 2);

        imprimirResumo(manual);
        imprimirResumo(eletrica);
        central.devolver(eletrica, retirada.plusDays(1));
        System.out.println("Furadeira devolvida: " + !eletrica.estaAberta());
        System.out.println("Locações no histórico: " + central.historico().size());
    }

    private static void imprimirResumo(Locacao locacao) {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String valor = moeda.format(BigDecimal.valueOf(locacao.valorEmCentavos(), 2));
        System.out.printf("%s com %s até %s — %s%n", locacao.associado().nome(),
                locacao.equipamento().descricao(), locacao.devolucaoPrevista(), valor);
    }
}
