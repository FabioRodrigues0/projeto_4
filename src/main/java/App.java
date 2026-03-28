import fabiorodrigues.bricks.components.Button;
import fabiorodrigues.bricks.components.Column;
import fabiorodrigues.bricks.components.Text;
import fabiorodrigues.bricks.components.TextField;
import fabiorodrigues.bricks.core.BricksApplication;
import fabiorodrigues.bricks.core.Component;
import fabiorodrigues.bricks.core.State;
import fabiorodrigues.bricks.style.Modifier;

/**
 * Aplicação JavaFX com UI criada por código.
 */
public class App extends BricksApplication {

    {
        setTitle("Projeto 4");
    }

    private final State<String> texto = state("");
    private final State<String> nomeAutor = state("");
    private final State<String> pin = state("0");

    @Override
    public Component root() {
        Modifier titleStyle = new Modifier().fontSize(28).bold();
        Modifier titleStyle2 = new Modifier().fontSize(16);

        return new Column().padding(20).gap(12).children(
                new Text("Código Secreto").modifier(titleStyle),
                new TextField().label("Notas:").multiline().rows(4).bindTo(texto),
                new Button("Decode").onClick(() -> texto.update(t -> Cript.decode(t))),
                new TextField().label("Nome do Autor:").placeholder("Escreve o nome do autor...")
                        .bindTo(nomeAutor),
                new Button("Get Pin")
                        .onClick(() -> pin.update(p -> Cript.getLockKey(nomeAutor.get()))),
                new Text("Pin: " + pin.get()).modifier(titleStyle2));
    }

    /**
     * @Override public void start(Stage primaryStage) { // Label do Titulo Label
     *           label = new Label("Código Secreto"); label.setStyle("-fx-font-size:
     *           16px; -fx-font-weight: bold;");
     *
     *           // Label para o PIN Label labelPin = new Label("Pin:");
     *           labelPin.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
     *
     *           // TextArea para o texto decodificado TextArea txtDecoded = new
     *           TextArea(); txtDecoded.setWrapText(true);
     *
     *           Button buttonDecode = new Button("Decode");
     *           buttonDecode.setOnAction(e -> {
     *           txtDecoded.setText(Cript.decode(txtDecoded.getText())); });
     *
     *           Label labelAuthor = new Label("Nome do autor:"); TextField
     *           txtAuthor = new TextField();
     *
     *           Button buttonPin = new Button("Get Pin"); buttonPin.setOnAction(e
     *           -> { labelPin.setText("Pin: " +
     *           Cript.getLockKey(txtAuthor.getText())); });
     *
     *           // Layout VBox root = new VBox(20); root.setAlignment(Pos.CENTER);
     *           root.setPadding(new Insets(40)); root.getChildren().addAll(label,
     *           buttonDecode, txtDecoded, labelAuthor, txtAuthor, labelPin,
     *           buttonPin);
     *
     *           // Cena e janela Scene scene = new Scene(root, 400, 300);
     *           primaryStage.setTitle("JavaFX App"); primaryStage.setScene(scene);
     *           primaryStage.show(); }
     */

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args
     *            argumentos da linha de comandos public static void main(String[]
     *            args) { launch(args); // ashdhasdjkashdkjas }
     */
}
