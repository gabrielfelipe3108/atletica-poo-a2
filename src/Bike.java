import java.time.LocalDateTime;
import java.util.Scanner;

public class Bike extends Equipamento {

    public Bike(int codigo, String nome) {
        super(codigo, nome);//o que foi herdado de Equipamento
    }

    @Override
    public LocalDateTime calcularDataDevolucao(
            LocalDateTime dataRetirada) {

        //duração do emprestimo de 7 dias para a bike
        return dataRetirada.toLocalDate()
                .plusDays(7)//permite a devolução da bike em até 7 dias, o horário não é relevante, então o horário da devolução será 23:59:59 do último dia
                .atTime(23, 59, 59);
    }
    public boolean Vistoria(Scanner scanner) {//verifica se a bike está em condições de uso
        System.out.println("Realizando vistoria da bike...");
        System.out.print("Verificando pneus...");
        System.out.println("Pneus em boas condiçoes? [S/N]");
        String pneu = scanner.nextLine();
        System.out.print("Verificando freios...");
        System.out.println("Freios em boas condiçoes? [S/N]");
        String freio = scanner.nextLine();
        System.out.print("Verificando corrente...");
        System.out.println("Corrente em boas condiçoes? [S/N]");
        String corrente = scanner.nextLine();

        if(pneu.equalsIgnoreCase("S") &&
        freio.equalsIgnoreCase("S") &&
        corrente.equalsIgnoreCase("S")) {
            System.out.println("Bike em boas condições de uso!");
            return true;
        } else {
            System.out.println("Bike não está em boas condições de uso!");
            return false;
        }
    }
}