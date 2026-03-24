import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aplicação JavaFX com UI criada por código.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar componentes
        Label label = new Label("Hello, JavaFX!");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextArea txt_decoded = new TextArea();

        Button button = new Button("Clica-me!");
        button.setOnAction(e -> txt_decoded.setText(Cript.decode(txt_decoded.getText())));

        // Layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.getChildren().addAll(label, button, txt_decoded);

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
