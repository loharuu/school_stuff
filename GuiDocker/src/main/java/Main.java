import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private tempController temp = new tempController();
    private RadioButton r_en = new RadioButton();private RadioButton r_fi= new RadioButton();private RadioButton r_sv= new RadioButton();private RadioButton r_ja= new RadioButton();
    private final languageToggle langToggle = new languageToggle(Locale.ENGLISH);
    private TextField originalDegreeField;
    private TextField convertedDegreeField;
    private ComboBox<String> originalTypeComboBox;
    private ComboBox<String> convertedTypeComboBox;
    private Label resultLabel;
    private TableView<String> tableView;
    String[] oldTypes = { "celsius", "fahrenheit", "kelvin"};
    String[] types = { "celsius", "fahrenheit"};

    @Override
    public void start(Stage stage) {
        ToggleGroup tg = new ToggleGroup();
        r_en.setToggleGroup(tg);
        r_fi.setToggleGroup(tg);
        r_ja.setToggleGroup(tg);
        r_sv.setToggleGroup(tg);
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton rb = (RadioButton)tg.getSelectedToggle();
                if(rb == r_en){
                    langToggle.setLocale(Locale.ENGLISH);
                    createVision(stage);
                } else if (rb == r_fi){
                    langToggle.setLocale(languageToggle.FINNISH);
                    createVision(stage);
                } else if (rb == r_ja) {
                    langToggle.setLocale(languageToggle.JAPANESE);
                    createVision(stage);
                }else if (rb == r_sv){
                    langToggle.setLocale(languageToggle.SWEDISH);
                    createVision(stage);
                } else {
                    System.out.println("ohno");
                }
            }
        });
        createVision(stage);
    }

    private void handleCalculateAndSave() {
        try {
            double originalDegree = Double.parseDouble(originalDegreeField.getText());
            double convertedDegree = 0;
            String originalSelectedType = originalTypeComboBox.getValue();
            String convertedSelectedType = convertedTypeComboBox.getValue();

            if (originalSelectedType == null || convertedSelectedType == null) {
                showError(langToggle.getString("errDeg"));
                return;
            }

            double answ = temp.convert(convertedSelectedType, originalSelectedType, originalDegree);
            convertedDegree = answ;

            resultLabel.setText(String.format(langToggle.getString("result"), convertedDegree));
            loadRecords();
            originalDegreeField.clear();
            convertedDegreeField.clear();

        } catch (NumberFormatException ex) {
            showError(langToggle.getString("errNum"));
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        } catch (SQLException ex) {
            showError(langToggle.getString("errDB")+ ex.getMessage());
        }
    }

    private TableView<String> buildTableView() {
        TableView<String> table = new TableView<>();

        TableColumn<String, String> recordColumn = new TableColumn<>(langToggle.getString("savedR"));
        recordColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));
        table.getColumns().add(recordColumn);

        return table;
    }

    private void loadRecords() {
        List<String> records = tempController.getHistory();
        tableView.getItems().setAll(records);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    public static class languageToggle {
        private Locale locale;
        public static final Locale FINNISH = new Locale("fi", "FI");
        public static final Locale SWEDISH = new Locale("sv", "SE");
        public static final Locale JAPANESE = new Locale("ja", "JP");
        private ResourceBundle translations;
        private final String bundleBasename = "Translations";

        public languageToggle(Locale initLocale){
            setLocale(initLocale);
        }
        public void setLocale(Locale newLocale){
            this.locale = newLocale;
            this.translations = ResourceBundle.getBundle(bundleBasename, locale);
        }
        public String getString(String key){
            return translations.getString(key);
        }
    }
    private void createVision(Stage stage){
        System.out.println(langToggle.getString("title"));
        stage.setTitle(langToggle.getString("title"));
        GridPane laung = new GridPane();
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(15));

        originalDegreeField = new TextField();
        convertedDegreeField = new TextField();
        originalTypeComboBox = new ComboBox<>(FXCollections.observableArrayList(oldTypes));
        convertedTypeComboBox = new ComboBox<>(FXCollections.observableArrayList(types));

        Button calcButton = new Button(langToggle.getString("calcSave"));

        resultLabel = new Label();

        laung.add(new Label(langToggle.getString("en")), 1, 0);
        laung.add(new Label(langToggle.getString("fin")), 2, 0);
        laung.add(new Label(langToggle.getString("jp")), 3, 0);
        laung.add(new Label(langToggle.getString("sw")), 4, 0);

        laung.add(new Label(langToggle.getString("language")), 0, 1);
        laung.add(r_en,1, 1);
        laung.add(r_fi,2, 1);
        laung.add(r_ja,3, 1);
        laung.add(r_sv,4, 1);

        form.add(new Label(langToggle.getString("tempUnit")), 0, 2);
        form.add(originalTypeComboBox, 1, 2);
        form.add(new Label(langToggle.getString("tempDeg")), 0, 3);
        form.add(originalDegreeField, 1, 3);
        form.add(new Label(langToggle.getString("tempCon")), 0, 4);
        form.add(convertedTypeComboBox, 1, 4);
        form.add(calcButton, 1, 5);
        form.add(resultLabel, 1, 6);

        tableView = buildTableView();
        loadRecords();

        calcButton.setOnAction(e -> handleCalculateAndSave());

        VBox root = new VBox(15, form, laung, new Label(langToggle.getString("saved")), tableView);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_LEFT);

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
