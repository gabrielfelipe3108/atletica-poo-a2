import java.time.LocalDateTime;

public abstract class Equipamento {

    private int codigo;
    private String nome;
    private boolean disponivel;

    public Equipamento(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.disponivel = true; //o estado padrão do eqp é disponível
    }

    // Getters and Setters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract LocalDateTime calcularDataDevolucao(LocalDateTime dataEmprestimo);
    //define que todos os eqp calculam seus prazos de devolução de forma diferente.
}