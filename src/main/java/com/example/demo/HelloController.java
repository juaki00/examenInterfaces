package com.example.demo;

import com.example.demo.model.Cliente;
import com.example.demo.model.Coche;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField textMatricula;
    @FXML
    private ComboBox<String> comboModelo;
    @FXML
    private ComboBox<String> comboCliente;
    @FXML
    private DatePicker dateEntrada;
    @FXML
    private DatePicker dateSalida;
    @FXML
    private Label labelCosteTotal;
    @FXML
    private Button btnAniadir;
    @FXML
    private Button btnSalir;
    @FXML
    private TableView<Coche> tablaCoches;
    @FXML
    private TableColumn<Coche,String> cMatricula;
    @FXML
    private TableColumn<Coche,String> cModelo;
    @FXML
    private TableColumn<Coche,String> cEntrada;
    @FXML
    private TableColumn<Coche,String> cSalida;
    @FXML
    private TableColumn<Coche,String> cCliente;
    @FXML
    private TableColumn<Coche,String> cTarifa;
    @FXML
    private TableColumn<Coche,String> cCoste;
    @FXML
    private ToggleGroup tarifa;
    @FXML
    private Label labelInfo;
    @FXML
    private RadioButton Standard;
    @FXML
    private RadioButton Oferta;
    @FXML
    private RadioButton Larga_Duracion;

    @FXML
    public void aniadir( ) {
        Alert alert = new Alert( Alert.AlertType.WARNING );
        if(textMatricula.getText().isEmpty()){
            alert.setContentText( "El campo matricula no puede estar vacio" );
            alert.show();
        }
        else if(tarifa.getSelectedToggle()==null){
            alert.setContentText( "debe seleccionar una tarifa" );
            alert.show();
        }
        else if(dateEntrada.getValue()==null){
            alert.setContentText( "debe seleccionar una fecha de entrada" );
            alert.show();
        }
        else if(dateSalida.getValue()==null){
            alert.setContentText( "debe seleccionar una fecha de salida" );
            alert.show();
        }
        else{


            Cliente cliente = new Cliente();
            Coche coche = new Coche(textMatricula.getText(), comboModelo.getValue(), cliente, tarifa.selectedToggleProperty().getName() , dateEntrada.getValue() , dateSalida.getValue());
            cliente.setNombre( comboCliente.getValue() );
            ObservableList<Coche> observableCoches= FXCollections.observableArrayList();
            observableCoches.add( coche );
            tablaCoches.setItems( observableCoches );
            textMatricula.setText( "" );
            dateEntrada.setValue( null );
            dateSalida.setValue( null );

        }
    }
    @FXML
    public void salir( ActionEvent e) {
        Node source = (Node) e.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();
    }

    @Override
    public void initialize( URL url , ResourceBundle resourceBundle ) {
        ObservableList<String> modelos = FXCollections.observableArrayList();
        modelos.add("Peugeot");
        modelos.add("Seat");
        modelos.add("Mercedes");
        comboModelo.setItems( modelos );
        comboModelo.getSelectionModel().selectFirst();

        ObservableList<String> clientes = FXCollections.observableArrayList();
        clientes.add("Juan");
        clientes.add("Pedro");
        clientes.add("Pablo");
        comboCliente.setItems( clientes );
        comboCliente.getSelectionModel().selectFirst();

        cMatricula.setCellValueFactory( (fila) -> {
            String matricula = fila.getValue().getMatricula();
            return new SimpleStringProperty( matricula);
        });

        cModelo.setCellValueFactory( (fila) -> {
            String modelo = fila.getValue().getModelo();
            return new SimpleStringProperty( modelo);
        });

        cEntrada.setCellValueFactory( (fila) -> {
            LocalDate entrada = fila.getValue().getFechaEntrada();
            return new SimpleStringProperty( entrada.toString());
        });

        cSalida.setCellValueFactory( (fila) -> {
            LocalDate salida = fila.getValue().getFechaSalida();
            return new SimpleStringProperty( salida.toString());
        });

        cCliente.setCellValueFactory( (fila) -> {
            String cliente = fila.getValue().getCliente().getNombre();
            return new SimpleStringProperty( cliente);
        });

        cTarifa.setCellValueFactory( (fila) -> {
            String tarifa = fila.getValue().getTipoTarifa();
            return new SimpleStringProperty( tarifa);
        });

        cCoste.setCellValueFactory( (fila) -> {
            Double coste = fila.getValue().getCosteTotal();
            return new SimpleStringProperty( coste.toString());
        });
    }

    @FXML
    public void info( Event event ) {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setContentText( "Joaquín Romero Sánchez, 2º DAM" );
        alert.show();
    }
}

