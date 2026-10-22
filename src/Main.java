import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema(); //cria um único objeto do sistema

        int opcao;

        do {
            //exibe as opções do menu
            System.out.println("\n===== SISTEMA DE EMPRESTIMOS =====");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Listar usuarios");
            System.out.println("3 - Listar equipamentos disponiveis");
            System.out.println("4 - Registrar emprestimo");
            System.out.println("5 - Registrar devolucao");
            System.out.println("6 - Listar historico");
            System.out.println("7 - Listar equipamentos emprestados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            //executa a opção escolhida
            switch (opcao) {
                case 1:
                System.out.print("Nome do usuario: ");
                String nome = scanner.nextLine();

                System.out.print("Matricula: ");
                int matricula = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Tipo (1 - Aluno / 2 - Servidor): ");
                int tipo = scanner.nextInt();
                scanner.nextLine();

                Usuario usuario = null;

                if (tipo == 1) {
                    usuario = new Aluno(nome, matricula);
                } else if (tipo == 2) {
                    usuario = new Servidor(nome, matricula);
                } else {
                    System.out.println("Tipo invalido!");
                }

                    if (usuario != null) {
                    sistema.cadastrarUsuario(usuario);
                }
                    break;

                case 2:
                    sistema.listarUsuarios();
                    break;

                case 3:
                    sistema.listarDisponiveis(); //lista os equipamentos disponíveis
                    break;

                
                case 4:
                System.out.print("Matricula do usuario: ");
                int matriculaBusca = scanner.nextInt();
                scanner.nextLine();

                Usuario usuarioBusca = sistema.buscarUsuario(matriculaBusca);

                if (usuarioBusca == null) {     
                System.out.println("Usuario nao encontrado!");
                break;
    }

                System.out.print("Codigo do equipamento: ");
                int codigoEmprestimo = scanner.nextInt();
                scanner.nextLine();
                sistema.registrarEmprestimo(usuarioBusca, codigoEmprestimo);
                break;


                case 5:
                    //solicita o codigo do equipamento devolvido
                    System.out.print("Codigo do equipamento: ");
                    int codigoDevolucao = scanner.nextInt();
                    scanner.nextLine();

                    sistema.registrarDevolucao(codigoDevolucao, scanner);
                    break;

                case 6:
                    sistema.listarHistorico(); //exibe o histórico de empréstimos
                    break;

                case 7:
                    //lista os equipamentos emprestados e seus responsaveis
                    sistema.listarEmprestados();
                    break;

                case 0:
                    sistema.sair();
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0); //repete o menu até o usuario escolher sair

        scanner.close(); //fecha o scanner
    }
}