import java.time.LocalDateTime;
public class Emprestimo {
    private Usuario usuario; //usuário que fez o empréstimo
    private Equipamento equipamento; //equipamento que foi emprestado
    private LocalDateTime dataEmprestimo; //data do empréstimo
    private LocalDateTime dataDevolucao; //data da devolução
    private boolean devolvido; //indica se o equipamento foi devolvido
    private int diasAtraso; //número de dias de atraso na devolução
    private String motivoAtraso; //motivo do atraso na devolução
    private double multa; //valor da multa por atraso
    private boolean bloqueado; //indica se o usuário está bloqueado
    private String observacoes; //observações sobre o empréstimo
    private int quantidadeItens; //quantidade de itens emprestados

    public Emprestimo(Usuario usuario, Equipamento equipamento, LocalDateTime dataEmprestimo) {
        this.usuario = usuario;
        this.equipamento = equipamento;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = equipamento.calcularDataDevolucao(dataEmprestimo);
        this.devolvido = false;
        this.diasAtraso = 0;
        this.motivoAtraso = "";
        this.multa = 0.0;
        this.bloqueado = false;
        this.observacoes = "";
        this.quantidadeItens = 1; //inicialmente, apenas um item é emprestado
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }
    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }
    public boolean isDevolvido() {
        return devolvido;
    }
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
    public int getDiasAtraso() {
        return diasAtraso;
    }
    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }
    public String getMotivoAtraso() {
        return motivoAtraso;
    }
    public void setMotivoAtraso(String motivoAtraso) {
        this.motivoAtraso = motivoAtraso;
    }
    public double getMulta() {
        return multa;
    }
    public void setMulta(double multa) {
        this.multa = multa;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public int getQuantidadeItens() {
        return quantidadeItens;
    }
    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }
}
