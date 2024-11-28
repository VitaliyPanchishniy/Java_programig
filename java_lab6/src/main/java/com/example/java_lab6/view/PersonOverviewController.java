package com.example.java_lab6.view;

import com.example.java_lab6.MainApp;
import com.example.java_lab6.model.Person;
import com.example.java_lab6.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label groupCodeLabel;
    @FXML
    private Label birthdayLabel;

    // Нові поля
    @FXML
    private Label addressLabel;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private Label averageScoreLabel;

    // Посилання на головну програму
    private MainApp mainApp;

    public PersonOverviewController() {
    }

    @FXML
    private void initialize() {
        // Ініціалізація таблиці адресатів із двома стовпцями.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        // Очищення додаткової інформації про студента.
        showPersonDetails(null);

        // Слухаємо зміни вибору і при зміні відображаємо додаткову інформацію.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Додавання до таблиці даних із спостережуваного списку
        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            // Заповнюємо позначки інформацією з об'єкта person.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            groupCodeLabel.setText(String.valueOf(person.getGroupCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));

            // Відображення нових полів
            addressLabel.setText(person.getAddress());
            phoneNumberLabel.setText(String.valueOf(person.getPhoneNumber()));
            averageScoreLabel.setText(String.format("%.2f", person.getAverageScore()));
        } else {
            // Якщо Person = null, то очищуємо всі поля.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            groupCodeLabel.setText("");
            birthdayLabel.setText("");

            // Очищення нових полів
            addressLabel.setText("");
            phoneNumberLabel.setText("");
            averageScoreLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // Відображення діалогового вікна підтвердження
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.initOwner(mainApp.getPrimaryStage());
            confirmationAlert.setTitle("Confirm Deletion");
            confirmationAlert.setHeaderText("Are you sure?");
            confirmationAlert.setContentText("Do you really want to delete the selected person?");

            // Очікуємо на відповідь від користувача
            confirmationAlert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    personTable.getItems().remove(selectedIndex);
                }
            });
        } else {
            // Нічого не вибрано
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
}
