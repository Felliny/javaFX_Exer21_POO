import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;


public class TelaAluno extends Application {
    private TextField txtID;
    private TextField txtRA;
    private TextField txtNome;
    private TextField txtNascimento;

    AlunoController controller= new AlunoController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane panel= new GridPane();
        Scene scn= new Scene(panel, 300, 150);

        Label lblID= new Label("ID:");
        txtID= new TextField();

        Label lblRA= new Label("RA:");
        txtRA= new TextField();

        Label lblNome= new Label("Nome:");
        txtNome= new TextField();

        Label lblNascimento= new Label("Nascimento:");
        txtNascimento= new TextField();

        Button btnAdicionar= new Button("Adicionar");
        Button btnPesquisar= new Button("Pesquisar");

        panel.setHgap(10);

        panel.add(lblID, 0, 0 );
        panel.add(txtID, 1, 0);

        panel.add(lblRA, 0, 1);
        panel.add(txtRA, 1, 1);

        panel.add(lblNome, 0, 2);
        panel.add(txtNome, 1, 2);

        panel.add(lblNascimento, 0, 3);
        panel.add(txtNascimento, 1, 3);

        panel.add(btnAdicionar, 0, 4);
        panel.add(btnPesquisar, 1, 4);


        // Eventos -----------------------------------------

        btnAdicionar.setOnMouseClicked(event -> {
            Aluno aluno= new Aluno();
            aluno.setId(Integer.parseInt(txtID.getText()));
            aluno.setRa(Integer.parseInt(txtRA.getText()));
            aluno.setNome(txtNome.getText());
            aluno.setNascimento(txtNascimento.getText());

            controller.Adicionar(aluno);

            txtID.setText("");
            txtRA.setText("");
            txtNome.setText("");
            txtNascimento.setText("");
        });

        btnPesquisar.setOnMouseClicked(event -> {
            Aluno aluno= controller.pesquisar(txtNome.getText());
            if (aluno != null){
                txtID.setText(String.valueOf(aluno.getId()));
                txtRA.setText(String.valueOf(aluno.getRa()));
                txtNome.setText(aluno.getNome());
                txtNascimento.setText(String.valueOf(aluno.getNascimento()));
            } else {
                Alert alert= new Alert(Alert.AlertType.INFORMATION, "Aluno não encontrado!", new ButtonType("Ok"));
                alert.show();
            }
        });

        primaryStage.setScene(scn);
        primaryStage.setTitle("Cadastro Aluno");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
