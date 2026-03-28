import fabiorodrigues.bricks.components.Alert;
import fabiorodrigues.bricks.components.Button;
import fabiorodrigues.bricks.components.Column;
import fabiorodrigues.bricks.components.FilePicker;
import fabiorodrigues.bricks.components.Row;
import fabiorodrigues.bricks.components.Text;
import fabiorodrigues.bricks.components.TextField;
import fabiorodrigues.bricks.core.BricksApplication;
import fabiorodrigues.bricks.core.Component;
import fabiorodrigues.bricks.core.State;
import fabiorodrigues.bricks.style.Modifier;
import java.nio.file.Files;
import javafx.geometry.Pos;

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
    private final State<Boolean> ficheiroCarregado = state(false);
    private final State<Boolean> textoDecodificado = state(false);
    private final State<Boolean> pinPronto = state(false);

    @Override
    public Component root() {
        Modifier titleStyle = new Modifier().fontSize(28).bold().italic();
        Modifier titleStyle2 = new Modifier().fontSize(16);
        Modifier centerStyle = new Modifier().alignment(Pos.CENTER);

        return new Column().padding(20).gap(12).children(
                new Row().modifier(centerStyle)
                        .children(new Text("Código Secreto").modifier(titleStyle)),
                new TextField().label("Nome do Autor:").placeholder("Escreve o nome do autor...")
                        .bindTo(nomeAutor).onChange(v -> {
                            pin.update(p -> "0");
                            pinPronto.update(p -> textoDecodificado.get() && !v.isBlank());
                        }),
                new Button("Get Pin").enabled(pinPronto)
                        .onDisabledClick(() -> Alert.warning("Aviso",
                                !textoDecodificado.get()
                                        ? "Decodifica o texto primeiro antes de obter o pin."
                                        : "Escreve o nome do autor antes de obter o pin."))
                        .onClick(() -> pin.update(p -> Cript.getLockKey(nomeAutor.get()))),
                new Text("Pin: " + pin.get()).modifier(titleStyle2),
                new FilePicker().title("Abrir Ficheiro de Texto").onSelect(file -> {
                    try {
                        String conteudo = Files.readString(file.toPath());
                        texto.update(t -> conteudo);
                        ficheiroCarregado.update(f -> true);
                    } catch (Exception e) {
                        Alert.error("Erro", "Não foi possível ler o ficheiro: " + e.getMessage());
                    }
                }),
                new TextField().label("Texto:").multiline().rows(4).bindTo(texto).onChange(v -> {
                    textoDecodificado.update(f -> false);
                    pinPronto.update(p -> false);
                }),
                new Button("Decode").enabled(ficheiroCarregado).onDisabledClick(
                        () -> Alert.warning("Aviso", "Carrega um ficheiro antes de descodificar."))
                        .onClick(() -> {
                            texto.update(t -> Cript.decode(t));
                            textoDecodificado.update(f -> true);
                            pinPronto.update(p -> !nomeAutor.get().isBlank());
                        }));
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
