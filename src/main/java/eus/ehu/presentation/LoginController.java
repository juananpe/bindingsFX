package eus.ehu.presentation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private ComboBox<String> roleCombo;
    @FXML
    private Label roleLabel;

    private ObservableList<String> roles;
    private StringProperty selectedRole = new SimpleStringProperty();

    @FXML
    void initialize() {
        // use observable list to populate the combo box
        roles = FXCollections.observableArrayList("Admin", "User", "Guest");
        roleCombo.setItems(roles);

        // bind the roleLabel text property to the selectedRole property
        roleLabel.textProperty().bind(selectedRole);

        // add listener to update selectedRole when combo box value changes
        roleCombo.valueProperty().addListener((obs, oldVal, newVal) -> {
            selectedRole.set("You selected: " + newVal);
        });
    }
}