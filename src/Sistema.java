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

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
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

    public Equipamento buscarEquipamento(int codigo) { //procura equipamento pelo código
    for (Equipamento equipamento : equipamentos) {
        if (equipamento.getCodigo() == codigo) {
            return equipamento;
        }
    }
        return null;
    }
    
    public void registrarEmprestimo(String matricula, int codigo){
        //verifica se o equipamento existe
        Equipamento equipamento = buscarEquipamento(codigo);
        if(equipamento == null){
            System.out.println("Equipamento não encontrado.");
            return;
        }
        if(!equipamento.isDisponivel()){//verifica se o equipamento pode ser emprestado
            System.out.println("Equipamento não disponível para empréstimo.");
            return;
        }
        System.out.println("Equipamento selecionado: " + equipamento.getNome());

        /*
            DEPENDE DO GABRIEL:
            Identificar aluno ou servidor;
            Verificar os limites de em´restimos por tipo de usuário;
            Criar registro na classe Emprestimo;
            Alterar a disponibilidade do equipamento para false;
        */
    }



    public void registrarDevolucao(int codigo) {

    //procura equipamento por código
    Equipamento equipamento = buscarEquipamento(codigo);
    //verifica se o equipamento existe
    if (equipamento == null) {
        System.out.println("Equipamento não encontrado!");
        return;
    }
    //verifica se o equipamento está disponível
    if (equipamento.isDisponivel()) {
        System.out.println("Este equipamento já está disponível!");
        return;
    }
    System.out.println("Equipamento selecionado para devolução: "
            + equipamento.getNome());

    /*
     * DEPENDE DO GABRIEL:
     * 1. Localizar o empréstimo ativo;
     * 2. Registrar a data da devolução;
     * 3. Verificar se houve atraso;
     * 4. Aplicar bloqueio, caso necessário;
     * 5. Fazer vistoria se for uma Bike;
     * 6. Atualizar a disponibilidade do equipamento.
     */
}

    }

    public void listarHistorico(){

    }
}

/*
FUNÇÕES DE USUÁRIOS:
1 cadastraUsuario()
2 listaUsuarios()

FUNÇÕES DE EQUIPAMENTOS:
4 listarDisponiveis() OK
5 registrarEmprestimo() - pedir um emprestimo novo
6 registrarDevolucao() - registra a volta do equipamento para o estoque
7 listarHistorico() - historico contendo todos os empréstimos e marca quem deveolve danificado	
listarEmprestados()	- quais foram emprestados e quem está com o que
*/