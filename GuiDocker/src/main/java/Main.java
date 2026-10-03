import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class Main extends Application {

    private tempController temp = new tempController();

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
        stage.setTitle("Temperature Converter");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(15));

        originalDegreeField = new TextField();
        convertedDegreeField = new TextField();
        originalTypeComboBox = new ComboBox<>(FXCollections.observableArrayList(oldTypes));
        convertedTypeComboBox = new ComboBox<>(FXCollections.observableArrayList(types));

        Button calcButton = new Button("Calculate & Save");
        resultLabel = new Label();

        form.add(new Label("Temperature Unit:"), 0, 0);
        form.add(originalTypeComboBox, 1, 0);
        form.add(new Label("Temperature degree:"), 0, 1);
        form.add(originalDegreeField, 1, 1);
        form.add(new Label("Conversion Unit:"), 0, 2);
        form.add(convertedTypeComboBox, 1, 2);
        form.add(calcButton, 1, 3);
        form.add(resultLabel, 1, 4);

        tableView = buildTableView();
        loadRecords();

        calcButton.setOnAction(e -> handleCalculateAndSave());

        VBox root = new VBox(15, form, new Label("Saved Records:"), tableView);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_LEFT);

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


    private void handleCalculateAndSave() {
        try {
            double originalDegree = Double.parseDouble(originalDegreeField.getText());
            double convertedDegree = 0;
            String originalSelectedType = originalTypeComboBox.getValue();
            String convertedSelectedType = convertedTypeComboBox.getValue();

            if (originalSelectedType == null || convertedSelectedType == null) {
                showError("Please select degree");
                return;
            }

            double answ = temp.convert(convertedSelectedType, originalSelectedType, originalDegree);
            convertedDegree = answ;

            resultLabel.setText(String.format("Temp: %.2f", convertedDegree));
            loadRecords();
            originalDegreeField.clear();
            convertedDegreeField.clear();

        } catch (NumberFormatException ex) {
            showError("Temperature degree must be numeric.");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        } catch (SQLException ex) {
            showError("Database error: " + ex.getMessage());
        }
    }

    private TableView<String> buildTableView() {
        TableView<String> table = new TableView<>();

        TableColumn<String, String> recordColumn = new TableColumn<>("Saved Records");
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

    public static void main(String[] args) {
        launch(args);
    }
}