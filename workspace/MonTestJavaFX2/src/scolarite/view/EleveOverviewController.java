package scolarite.view;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import scolarite.model.beans.Eleve;
import scolarite.model.dao.Connexion;
import scolarite.model.dao.EleveDAO;

public class EleveOverviewController implements Initializable {
	
	
	//Colonne du tableau
	@FXML
	public TableView<Eleve> tblView;
	
	@FXML
	private TableColumn<Eleve, String> tblNom;
	
	@FXML
	private TableColumn<Eleve, String> tblPrenom;
	
	@FXML
	private TableColumn<Eleve, String> tblNomComplet;
	
	@FXML
	private TableColumn<Eleve, String> tblFrenchDate;
	
	@FXML
	private TableColumn<Eleve, Date> tblDate;
	
	//Labels
	@FXML
	private TextField lblNom;
	
	@FXML
	private TextField lblPrenom;
	
	@FXML
	private DatePicker lblBirthday;
	
	private ObservableList<Eleve> eleves;
	
		
		
	public EleveOverviewController() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		EleveDAO eleveDAO = new EleveDAO(Connexion.getConnexion());
		System.out.println(eleveDAO);
		eleves = FXCollections.observableArrayList();
		eleveDAO.findAll(eleves);
		tblView.setItems(eleves);
		
		tblNom.setCellValueFactory(new PropertyValueFactory<Eleve, String>("nom"));
		tblPrenom.setCellValueFactory(new PropertyValueFactory<Eleve, String>("prenom"));
		tblNomComplet.setCellValueFactory(new PropertyValueFactory<Eleve, String>("nomComplet"));
		tblFrenchDate.setCellValueFactory(new PropertyValueFactory<Eleve, String>("frenchDate"));
		tblDate.setCellValueFactory(new PropertyValueFactory<Eleve, Date>("birthday"));
		
	}
	
	@FXML
	public void addStudent() {
		
		/*
		 * Conversion de la date du datetimePicker (LocalDate) en Date LocalDate ---> Date
		 */
		Date date = java.sql.Date.valueOf(lblBirthday.getValue());
		System.out.println(date);
		EleveDAO eleveDAO = new EleveDAO(Connexion.getConnexion());
		Eleve eleve = new Eleve(lblNom.getText(), lblPrenom.getText(), date);
		int status = eleveDAO.create(eleve);
		eleves.add(eleve);
		System.out.println(status);
	}
	
	@FXML
	public void onSelectedRow () {
		System.out.println("Vous avez selectionné une ligne");
		Eleve selectedEleve = tblView.selectionModelProperty().getValue().getSelectedItem();
		System.out.println(selectedEleve);
		lblNom.setText(selectedEleve.getNom());
		lblPrenom.setText(selectedEleve.getPrenom());
		/**
		 * Conversion de Date to LocalDate
		 */
		LocalDate birth = selectedEleve.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		System.out.println(birth+"  -----LocalDate");
		//lblBirthday.setValue(selectedEleve.getBirthday());
	}
		
	
}
