public class Usuario {
    private String nome;//atributo
    private int id;//atributo

    public Usuario(String nome, int id) {
        this.nome = nome;//o this.nome representa o atributo da classe e recebe o valor do parâmetro nome
        this.id = id; //o this.id representa o atributo da classe e recebe o valor do parâmetro id
    }

    public String getNome() {//método getter que retorna o nome do usuário
        return nome;
    }

    public int getId() {//método getter que retorna o ID do usuário
        return id;
    }
}