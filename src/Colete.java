import java.time.LocalDateTime;

public class Colete extends Equipamento {

    public Colete(int codigo, String nome) {
        super(codigo, nome);//o que foi herdado de Equipamento
    }

    @Override
    public LocalDateTime calcularDataDevolucao(
            LocalDateTime dataRetirada) {

        //duração do emprestimo de 1 dia para a bola
        return dataRetirada.toLocalDate()
                .atTime(23, 59, 59);
    }
}