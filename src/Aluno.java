import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private int id;
    private int ra;
    private String nome;
    private LocalDate Nascimento;

    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return Nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        if (nascimento.isAfter(LocalDate.of(1920, 1, 1))){
            this.Nascimento = nascimento;
        }
    }

    public void setNascimento(String data) {
        LocalDate nascimento= LocalDate.parse(data, dtf);
        setNascimento(nascimento);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", ra=" + ra +
                ", nome='" + nome + '\'' +
                ", Nascimento=" + Nascimento +
                '}';
    }
}
