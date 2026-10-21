import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Equipamento> equipamentos;

    public Sistema() {
        equipamentos = new ArrayList<>();
        //lista de equipamentos disponíveis
        equipamentos.add(new Bola(1, "Bola de futsal"));
        equipamentos.add(new Bola(2, "Bola de basquete"));
        equipamentos.add(new Bola(3, "Bola de vôlei"));

        equipamentos.add(new Bike(4, "Bicicleta 1"));
        equipamentos.add(new Bike(5, "Bicicleta 2"));

        equipamentos.add(new Raquete(6, "Raquete 1"));//gabriel implementar a classe raquete
        equipamentos.add(new Raquete(7, "Raquete 2"));

        equipamentos.add(new Colete(8, "Colete 1 "));
        equipamentos.add(new Colete(9, "Colete 2"));
    }

    public void listarEquipamentos() {
        System.out.println("Equipamentos disponíveis para empréstimo:");
        boolean encontrou = false;
        for (Equipamento equipamento : equipamentos) {
            if (equipamento.isDisponivel()) {
                System.out.println("Código: " + equipamento.getCodigo() + ", Nome: " + equipamento.getNome());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum equipamento disponível no momento.");
        }
    }
}

/*
listarEmprestados()	OK
registrarEmprestimo()	
registrarDevolucao()	
listarHistorico()	
listarResponsaveis()	
listarDefeitos()
*/