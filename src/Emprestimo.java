import java.time.LocalDateTime;

public class Emprestimo {
    private Usuario usuario; //usuário que fez o empréstimo
    private Equipamento equipamento; //equipamento que foi emprestado
    private LocalDateTime dataEmprestimo; //data do empréstimo
    private LocalDateTime dataDevolucao; //data prevista para a devolução
    private LocalDateTime dataDevolucaoEfetiva; //data real da devolução
    private boolean devolvido; //indica se o equipamento foi devolvido
    private int diasAtraso; //número de dias de atraso na devolução
    private String motivoAtraso; //motivo do atraso na devolução
    private double multa; //valor da multa por atraso
    private boolean bloqueado; //indica se o empréstimo está bloqueado
    private String observacoes; //observações sobre o empréstimo
    private int quantidadeItens; //quantidade de itens emprestados

    public Emprestimo(Usuario usuario, Equipamento equipamento, LocalDateTime dataEmprestimo) {
        this.usuario = usuario;
        this.equipamento = equipamento;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = equipamento.calcularDataDevolucao(dataEmprestimo); //calcula o prazo de devolução conforme o equipamento
        this.dataDevolucaoEfetiva = null; //inicialmente, o equipamento ainda não foi devolvido
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
        return dataDevolucao; //retorna a data prevista para a devolução
    }

    public LocalDateTime getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva; //retorna a data real da devolução
    }

    public void registrarDevolucao() { //registra a devolução do equipamento
        if (!devolvido) { //verifica se o equipamento ainda não foi devolvido
            this.dataDevolucaoEfetiva = LocalDateTime.now(); //registra a data e a hora da devolução
            this.devolvido = true; //marca o equipamento como devolvido
            this.equipamento.setDisponivel(true); //torna o equipamento disponível novamente
        }
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
