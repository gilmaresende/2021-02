package gui;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Contraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Seller;
import model.exception.ValidationException;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	private Seller entity;

	public void setEntity(Seller e) {
		this.entity = e;
	}

	private SellerService service;

	public void setSellerService(SellerService service) {
		this.service = service;
	}

	private List<DataChangeListener> dataChengeListeners = new ArrayList();

	public void subscribeDataChangeListener(DataChangeListener listener) {
		this.dataChengeListeners.add(listener);
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
	private TextField txtEmail;
	@FXML
	private DatePicker txtBrithDate;
	@FXML
	private TextField txtBaseSalary;
	@FXML
	private Label txtErrorName;
	@FXML
	private Label txtErrorEmail;
	@FXML
	private Label txtErrorBirthDate;
	@FXML
	private Label txtErrorBaseSalar;

	@FXML
	public void actionBtnSave(ActionEvent e) {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormData();
			this.service.saveOrUpdate(entity);
			nofifyDataChangeListener();
			Utils.currentStage(e).close();
		} catch (ValidationException ex) {
			setErrosMessages(ex.getErros());
		} catch (DbException ex) {
			Alerts.showAlert("Error saving obkect", null, ex.getMessage(), AlertType.ERROR);
		}
	}

	private void nofifyDataChangeListener() {
		for (DataChangeListener dataChangeListener : dataChengeListeners) {
			dataChangeListener.onDataChanger();
		}

	}

	private Seller getFormData() {
		ValidationException exception = new ValidationException("Validation Error");

		Seller obj = new Seller();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		if (txtName.getText() == null || txtName.getText().trim().equals("")) {
			exception.addErro("name", "Fild can1t be empty.");
		}

		if (exception.getErros().size() > 0) {
			throw exception;
		}
		obj.setName(txtName.getText());

		return obj;
	}

	@FXML
	public void actionBtnCancel(ActionEvent e) {
		Utils.currentStage(e).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
	}

	private void initializeNodes() {
		Contraints.setTextFieldInteger(txtId);
		Contraints.setTextFieldMaxLength(txtName, 70);
		Contraints.setTextFieldDouble(txtBaseSalary);
		Contraints.setTextFieldMaxLength(txtEmail, 60);
		Utils.formatDatePicker(txtBrithDate, "dd/MM/yyyy");
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());
		txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
		Locale.setDefault(Locale.US);
		if (entity.getBirthDate() != null)
			txtBrithDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
	}

	private void setErrosMessages(Map<String, String> erros) {
		Set<String> fiels = erros.keySet();
		if (fiels.contains("name")) {
			txtErrorName.setText(erros.get("name"));
		}
	}
}