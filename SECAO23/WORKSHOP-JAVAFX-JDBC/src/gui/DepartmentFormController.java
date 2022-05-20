package gui;

import java.net.URL;
import java.nio.channels.IllegalSelectorException;
import java.util.ResourceBundle;

import gui.util.Contraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	private Department entity;

	public void setEntity(Department e) {
		this.entity = e;
	}

	@FXML
	private Button btnSave;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private Label txtError;

	@FXML
	public void actionBtnSave() {
		System.out.println("save");
	}

	@FXML
	public void actionBtnCancel() {
		System.out.println("cancel");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
	}

	private void initializeNodes() {
		Contraints.setTextFieldInteger(txtId);
		Contraints.setTextFieldMaxLength(txtName, 30);
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}

}
