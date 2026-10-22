import java.time.LocalDateTime;
public class Raquete extends Equipamento {
    public Raquete(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public LocalDateTime calcularDataDevolucao(LocalDateTime dataEmprestimo) {
        return dataEmprestimo.plusDays(2)
        .atTime(23, 59, 59); //Raquetes podem ser devolvidas em até 2 dias
    }
}