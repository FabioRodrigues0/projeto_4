import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aplicação JavaFX com UI criada por código.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Label do Titulo
        Label label = new Label("Código Secreto");
        label.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Label para o PIN
        Label labelPin = new Label("Pin:");
        labelPin.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TextArea para o texto decodificado
        TextArea txtDecoded = new TextArea();
        txtDecoded.setWrapText(true);

        Button buttonDecode = new Button("Decode");
        buttonDecode.setOnAction(e -> {
            txtDecoded.setText(Cript.decode(txtDecoded.getText()));
        });

        Label labelAuthor = new Label("Nome do autor:");
        TextField txtAuthor = new TextField();

        Button buttonPin = new Button("Get Pin");
        buttonPin.setOnAction(e -> {
            labelPin.setText("Pin: " + Cript.getLockKey(txtAuthor.getText()));
        });

        // Layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.getChildren().addAll(label, buttonDecode, txtDecoded, labelAuthor, txtAuthor, labelPin,
                buttonPin);

        // Cena e janela
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args
     *            argumentos da linha de comandos
     */
    public static void main(String[] args) {
        launch(args);
        // ashdhasdjkashdkjas
    }
}
