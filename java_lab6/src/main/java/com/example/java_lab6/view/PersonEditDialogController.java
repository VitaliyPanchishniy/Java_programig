package com.example.java_lab6.view;

import com.example.java_lab6.model.Person;
import com.example.java_lab6.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField groupCodeField;
    @FXML
    private TextField birthdayField;
    private Stage dialogStage;
    private Person person;
    private boolean okClicked=false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {this.dialogStage=dialogStage;
    }

    public void setPerson(Person person) {
        this.person=person;
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        groupCodeField.setText(String.valueOf(person.getGroupCode()));
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if(isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setGroupCode(Integer.parseInt(groupCodeField.getText()));
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            okClicked=true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage="";
        if(firstNameField.getText() ==null||firstNameField.getText().length() ==0) { errorMessage+="No valid first name!\n";
        }
        if(lastNameField.getText() ==null||lastNameField.getText().length() ==0)
        { errorMessage+="No valid last name!\n";
        }
        if(groupCodeField.getText() ==null||groupCodeField.getText().length() ==0) { errorMessage+="No valid postal code!\n";
        }else{
// намагаємося перетворити номер групи на int.
            try{
                Integer.parseInt(groupCodeField.getText());
            }catch(NumberFormatException e) {
                errorMessage+="No valid group code (must be an integer)!\n";
            }
        }
        if(birthdayField.getText() ==null||birthdayField.getText().length() ==0)
        { errorMessage+="No valid birthday!\n";
        }else{
            if(!DateUtil.validDate(birthdayField.getText())) {
                errorMessage+="No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }
        if(errorMessage.length() ==0) {
            return true;
        }else{
// Показуємо повідомлення про помилку.
            Alert alert=new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}
