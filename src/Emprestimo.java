import java.time.LocalDateTime;

public class Emprestimo {
    private Usuario usuario;
    private Equipamento equipamento;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataLimiteDevolucao;
    private LocalDateTime dataDevolucaoEfetiva;
    private boolean devolvido;
    private int diasAtraso;
    private String motivoAtraso;
    private double multa;
    private String observacoes;

    public Emprestimo(Usuario usuario, Equipamento equipamento, LocalDateTime dataEmprestimo) {
        this.usuario = usuario;
        this.equipamento = equipamento;
        this.dataEmprestimo = dataEmprestimo;
        this.dataLimiteDevolucao = equipamento.dataLimiteDevolucao(dataEmprestimo);
        this.dataDevolucaoEfetiva = null;
        this.devolvido = false;
        this.diasAtraso = 0;
        this.motivoAtraso = "";
        this.multa = 0.0;
        this.observacoes = "";
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

    public LocalDateTime getDataLimiteDevolucao() {
        return dataLimiteDevolucao;
    }

    public LocalDateTime getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void registrarDevolucao() {
        if (!devolvido) {
            this.dataDevolucaoEfetiva = LocalDateTime.now();
            this.devolvido = true;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}