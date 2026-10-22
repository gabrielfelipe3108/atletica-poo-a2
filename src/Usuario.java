import java.time.LocalDateTime;
public class Usuario {

    private String nome;
    private int matricula;
    private LocalDateTime bloqueadoAte;//armazena até quando o usuário ficará bloqueado

    public Usuario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.bloqueadoAte = null;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public boolean estaBloqueado() {

        if (bloqueadoAte == null) {
            return false;
        }
        return LocalDateTime.now().isBefore(bloqueadoAte);
    }

    public void aplicarPenalidade(int dias) {

        if (dias <= 0) {
            return;
        }

        LocalDateTime agora = LocalDateTime.now();//obtem a data e hora atual

        if (estaBloqueado()) {
            bloqueadoAte = bloqueadoAte.plusDays(dias);
        } else {
            bloqueadoAte = agora.plusDays(dias);
        }
    }
    public LocalDateTime getBloqueadoAte() {
        return bloqueadoAte;
    }
}
