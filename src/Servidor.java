public class Servidor extends Usuario { //a classe Servidor herda os atributos e métodos da classe Usuario
    private static final int LIMITE_ITENS = 4; //define o limite de itens para servidores

    public Servidor(String nome, int matricula) { //recebe o nome e a matrícula do servidor
        super(nome, matricula);
    }

    public int getLimiteItens() { //retorna o limite de itens permitido para servidores
        return LIMITE_ITENS;
    }
}