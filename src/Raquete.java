import java.time.LocalDateTime;

public class Raquete extends Equipamento { //a classe Raquete herda os atributos e métodos da classe Equipamento
public Raquete(int codigo, String nome) { //recebe o código e o nome da raquete
    super(codigo, nome);
}

@Override
public LocalDateTime calcularDataDevolucao(LocalDateTime dataEmprestimo) { //calcula a data de devolução da raquete
    return dataEmprestimo.toLocalDate()
            .plusDays(2)
            .atTime(23, 59, 59); //raquetes podem ser devolvidas em até 2 dias
}
}