public class Aluno extends Usuario { //a classe Aluno herda os atributos e métodos da classe Usuario
private static final int LIMITE_ITENS = 2; //define o limite de itens para alunos

public Aluno(String nome, int matricula) { //recebe o nome e a matrícula do aluno
    super(nome, matricula);
}

public int getLimiteItens() { //retorna o limite de itens permitido para alunos
    return LIMITE_ITENS;
}
}
