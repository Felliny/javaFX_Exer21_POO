import java.util.ArrayList;
import java.util.List;

public class AlunoController {

    List<Aluno> list= new ArrayList<>();

    public Aluno pesquisar(String nome){
        for (Aluno a : list){
            if (a.getNome().equals(nome)){
                return a;
            }
        }
        return null;
    }

    public void Adicionar(Aluno aluno){
        if (aluno != null){
            list.add(aluno);
            System.out.println("Tamanho da Lista: " + list.size());
        }
    }
}
