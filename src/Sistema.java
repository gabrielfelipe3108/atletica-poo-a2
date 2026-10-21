import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Equipamento> equipamentos;

    public Sistema() {
        equipamentos = new ArrayList<>();
        //lista fixa de equipamentos disponíveis
        equipamentos.add(new Bola(1, "Bola de futebol"));
        equipamentos.add(new Bola(2, "Bola de basquete"));
        equipamentos.add(new Bola(3, "Bola de vôlei"));

        equipamentos.add(new Bike(4, "Bicicleta 1"));
        equipamentos.add(new Bike(5, "Bicicleta 2"));

        equipamentos.add(new Raquete(6, "Raquete 1"));//gabriel implementar a classe raquete
        equipamentos.add(new Raquete(7, "Raquete 2"));

        equipamentos.add(new Colete(8, "Colete 1 "));
        equipamentos.add(new Colete(9, "Colete 2"));
    }

    public void listarDisponiveis() {//exibe na tela quais equipamentos podem ser feitos empréstimos
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

    public void registrarEmprestimo(){
        System.out.println("Gostaria de realizar qual empréstimo?");
        for(Equipamento equipamento : equipamentos){

        }
    }	

    public void registrarDevolucao(){
        System.out.println("O que será devolvido?");
    }

    public void listarHistorico(){

    }

    public void listarResponsaveis(){

    }

}


/*
FUNÇÕES DE USUÁRIOS:
1 cadastraAluno()
2 cadastraServidor()
3 listaUsuarios()

FUNÇÕES DO MENU:
listarDisponiveis() OK
listarEmprestados()	- quais foram emprestados e quem está com o que
registrarEmprestimo() - pedir um emprestimo novo
registrarDevolucao() - registra a volta do equipamento para o estoque
listarHistorico() - historico contendo todos os empréstimos e marca quem deveolve danificado	
listarResponsaveis() - 
*/