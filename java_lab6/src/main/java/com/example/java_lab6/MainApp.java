package com.example.java_lab6;

import com.example.java_lab6.view.PersonOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.java_lab6.model.Person;
import javafx.stage.Modality;
import com.example.java_lab6.view.PersonEditDialogController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        // Як зразок додаємо деякі дані
        personData.add(new Person("Петро", "П'яточкін"));
        personData.add(new Person("Іван", "Зайців"));
        personData.add(new Person("Катерина", "Васильченка"));
        personData.add(new Person("Ольга", "Жук"));
        personData.add(new Person("Людміла", "Алексєєва"));
        personData.add(new Person("Даніл", "Кац"));
        personData.add(new Person("Євген", "Васнецов"));
        personData.add(new Person("Дмитро", "Жуликів"));
        personData.add(new Person("Мрат", "Алібов"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Lab6");

        initRootLayout();
        showPersonOverview();
    }


    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/java_lab6/RootLayout.fxml"));
        try {
            rootLayout = fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading RootLayout.fxml", e);
        }
    }

    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/java_lab6/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = fxmlLoader.load();
            rootLayout.setCenter(personOverview);
            PersonOverviewController controller=fxmlLoader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading PersonOverview.fxml", e);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showPersonEditDialog(Person person) {
        try{
            FXMLLoader loader=new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/com/example/java_lab6/PersonEditDialog.fxml"));
            AnchorPane page= (AnchorPane)loader.load();
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene=new Scene(page);
            dialogStage.setScene(scene);
            PersonEditDialogController controller=loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        }catch(IOException e) {e.printStackTrace(); return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
