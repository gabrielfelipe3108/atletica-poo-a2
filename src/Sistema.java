import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Sistema {
    private ArrayList<Equipamento> equipamentos;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public Sistema() {
        equipamentos = new ArrayList<>();
        //lista fixa de equipamentos disponíveis
        equipamentos.add(new Bola(1, "Bola de futebol"));
        equipamentos.add(new Bola(2, "Bola de basquete"));
        equipamentos.add(new Bola(3, "Bola de vôlei"));

        equipamentos.add(new Bike(4, "Bicicleta 1"));
        equipamentos.add(new Bike(5, "Bicicleta 2"));

        equipamentos.add(new Raquete(6, "Raquete 1"));
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
    
    public void registrarEmprestimo(Usuario usuario, int codigo){ //cria-se um novo empréstimo no sistema. Verifica se usuário e equipamento existem
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        if(usuario.estaBloqueado()){//verifica se o usuário está bloqueado para emprestimos
            System.out.println("Usuário está bloqueado e não pode realizar empréstimos!");
            System.out.println("Usuário está bloqueado até: " + usuario.getBloqueadoAte());
            return;
        }
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

        //define o limite de emprestimos dependendo do tipo de usuário
        int limiteEmprestimos;
        if (usuario instanceof Aluno) {
            limiteEmprestimos = 2; // Limite de empréstimos para alunos
        } else if (usuario instanceof Servidor) {
            limiteEmprestimos = 4; // Limite de empréstimos para servidores
        } else {
            System.out.println("Tipo de usuário desconhecido.");
            return;
        }

        //conta quantos emprestimos o usuario tem
        int qtdAtivos = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario() == usuario && !emprestimo.isDevolvido()) {
                qtdAtivos++;
            }
        }
        if (qtdAtivos >= limiteEmprestimos) {
            System.out.println("Usuário atingiu o limite de empréstimos ativos!");
            return;
        }

        //registra qunadoo emprestimo é feito
        LocalDateTime dataEmprestimo = LocalDateTime.now();
        Emprestimo emprestimo = new Emprestimo(
            usuario, equipamento, dataEmprestimo);

        //guarda no histórico
        emprestimos.add(emprestimo);

        //coloca o equipamento como indisponível
        equipamento.setDisponivel(false);
        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("Equipamento: " + equipamento.getNome());
        System.out.println("Devolver até: " + emprestimo.getdataLimiteDevolucao());
    }

    
    public void registrarDevolucao(int codigo, Scanner scanner) {
        //procura o equipamento pelo código
        Equipamento equipamento = buscarEquipamento(codigo);
        if (equipamento == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }
        //procura o empréstimo ativo desse equipamento
        Emprestimo ativo = null;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getEquipamento().getCodigo() == codigo
                    && !emprestimo.isDevolvido()) {
                ativo = emprestimo;
                break;
            }
        }
        if (ativo == null) {
            System.out.println("Este equipamento não possui empréstimo ativo!");
            return;
        }
        Usuario usuario = ativo.getUsuario();
        System.out.println("Equipamento: " + equipamento.getNome());
        System.out.println("Responsável: " + usuario.getNome());
        //calcula os dias de atraso
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime prazo = ativo.getdataLimiteDevolucao();
        int diasAtraso = 0;
        if (agora.isAfter(prazo)) {
            diasAtraso = (int) Math.max(1,
                    java.time.temporal.ChronoUnit.DAYS.between(
                        prazo.toLocalDate(),
                        agora.toLocalDate()));
        }

        //a penalidade inicial é igual ao atraso
        int diasPenalidade = diasAtraso;
        //verifica se o equipamento foi devolvido com defeito
        boolean comDefeito = false;
        if (equipamento instanceof Bike) {
            Bike bike = (Bike) equipamento;
            //chama a vistoria criada em Bike.java
            boolean aprovada = bike.Vistoria(scanner);
            comDefeito = !aprovada;
        } else {
            System.out.print("Equipamento com defeito? (S/N): ");
            String resposta = scanner.nextLine().trim();
            while (!resposta.equalsIgnoreCase("S")
                    && !resposta.equalsIgnoreCase("N")) {
                System.out.print("Digite apenas S ou N: ");
                resposta = scanner.nextLine().trim();
            }
            comDefeito = resposta.equalsIgnoreCase("S");
        }

        //penalidade adicional por defeito
        if (comDefeito) {
            diasPenalidade += 2;
            ativo.setObservacoes("Equipamento devolvido com defeito.");
        }
        //registra atraso
        ativo.setDiasAtraso(diasAtraso);
        //termina o empréstimo e registra a data real
        ativo.registrarDevolucao();
        //coloca equipamentos que não estão com defeito de volta p emprestimo
        equipamento.setDisponivel(!comDefeito);
        //põe penalidade ao usuário
        usuario.aplicarPenalidade(diasPenalidade);

        System.out.println("Devolução registrada com sucesso!");
        System.out.println("Dias de atraso: " + diasAtraso);
        System.out.println("Dias de penalidade: " + diasPenalidade);

        if (diasPenalidade > 0) {
            System.out.println("Usuário bloqueado até: "
                    + usuario.getBloqueadoAte());
        }

        if (comDefeito) {
            System.out.println("Equipamento encaminhado para manutenção!");
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