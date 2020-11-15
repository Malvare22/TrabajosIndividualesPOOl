import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import java.util.ArrayList;
import mundo.*;
/**
 * Controlador de la interfaz gráfica del programa de gestión de materias universitarias.
 * 
 * @author (Rodrigo Andrés Malaver Suárez - rodrigoandresmasu@ufps.edu.co) 
 * @version 1.0 :)
 */
public class ControllerUniversidad {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMateriasMaximoAlumosPorGrupo;

    @FXML
    private TextField txtMateriasNombre;

    @FXML
    private Button cmdMateriasAgregarMateria;

    @FXML
    private Button cmdMateriasLimpiar;

    @FXML
    private Button cmdInformacion;

    @FXML
    private TableView<Materia> tblMaterias;

    @FXML
    private TableColumn<?, ?> colMateriasMateria;

    @FXML
    private TableColumn<?, ?> colMateriasMaximoAlumnos;

    @FXML
    private TextField txtAlumnosPromedio;

    @FXML
    private Button cmdAlumnosAgregarAlumno;

    @FXML
    private Button cmdAlumnosLimpiar;

    @FXML
    private TextField txtAlumnosCodigo;

    @FXML
    private TextField txtAlumnosNombres;

    @FXML
    private TextField txtAlumnosApellidos;

    @FXML
    private TextField txtAlumnosEdad;

    @FXML
    private TableView<Alumno> tblAlumnos;

    @FXML
    private TableColumn<?, ?> colAlumnosCodigo;

    @FXML
    private TableColumn<?, ?> colAlumnosNombre;

    @FXML
    private TableColumn<?, ?> colAlumnosApellidos;

    @FXML
    private TableColumn<?, ?> colAlumnosEdad;

    @FXML
    private TableColumn<?, ?> colAlumnosPromedio;

    @FXML
    private TextField txtInscripcionesNumeroDeAlumno;

    @FXML
    private ComboBox<String> cmbInscripcionesMateria;

    @FXML
    private Button cmdInscripcionesLimpiar;

    @FXML
    private Button cmdInscripcionesInscribir;

    @FXML
    private TableView<Inscripcion> tblInscripciones;

    @FXML
    private TableColumn<?, ?> colInscripcionesAlumno;

    @FXML
    private TableColumn<?, ?> colInscripcionesMateria;

    @FXML
    private ComboBox<String> cmbGruposMateria;

    @FXML
    private ComboBox<String> cmbGruposGrupo;

    @FXML
    private Button cmdGruposGenerarGrupo;

    @FXML
    private TableView<Alumno> tblGrupos;

    @FXML
    private TableColumn<?, ?> colGruposCodigo;

    @FXML
    private TableColumn<?, ?> colGruposNombres;

    @FXML
    private TableColumn<?, ?> colGruposApellidos;

    private ObservableList<Materia> datosMaterias = FXCollections.observableArrayList();

    private ObservableList<Alumno> datosAlumnos = FXCollections.observableArrayList();

    private ObservableList<Inscripcion> datosInscripciones = FXCollections.observableArrayList();

    private ObservableList<Alumno> datosGrupo = FXCollections.observableArrayList();

    private Universidad universidad;
    private int i;
    @FXML
    void alumnosAgregarAlumno(ActionEvent event) {
        Alert alert = null;
        String aviso = null;
        Alumno a = null;
        try{
            if(universidad.agregarAlumno(txtAlumnosCodigo.getText(), txtAlumnosNombres.getText(), txtAlumnosApellidos.getText(), Integer.parseInt(txtAlumnosEdad.getText()),
                Float.parseFloat(txtAlumnosPromedio .getText()))){
                a = new Alumno(txtAlumnosCodigo.getText(), txtAlumnosNombres.getText(), txtAlumnosApellidos.getText(), Integer.parseInt(txtAlumnosEdad.getText()),
                    Float.parseFloat(txtAlumnosPromedio.getText()));
                datosAlumnos.add(a);      
            }
            else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("¡No se permiten duplicados!");
                alert.setContentText("No se pudo agregar el estudiante debido a que ya se \nencuentra en el sistema :c");
                alert.showAndWait();
            }
            limpiarAlumnos();
            tblAlumnos.setItems(datosAlumnos);
        }
        catch (NumberFormatException e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("¡Datos invalido!");
            alert.setContentText("Llene los datos con informacion valida");
            alert.showAndWait();
        }
        tblAlumnos.refresh();
    }

    @FXML
    void mostrarInformacion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText(null);
        alert.setContentText("Programa de gestión de prematrículas Ver 1.0 \ncreado por Rodrigo Andrés Malaver Suárez");
        alert.showAndWait();
    }

    @FXML
    void alumnosLimpiar(ActionEvent event) {
        limpiarAlumnos();
    }

    @FXML
    void gruposGenerarGrupo(ActionEvent event) {
        Alert alert = null;
        if(cmbGruposMateria.getSelectionModel().getSelectedIndex() < 0){
            return;
        }
        else{
            Materia m = universidad.getMateria(cmbGruposMateria.getSelectionModel().getSelectedIndex()+1);
            if(!m.generarGrupos()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("¡No se puedo generar los grupos!");
                alert.setContentText("Revise la informacion");
                alert.showAndWait();
            }
            Grupo [] g = m.getGrupos();
            cmbGruposGrupo.getItems().clear();
            for(int i=0; i<g.length;i++){
                cmbGruposGrupo.getItems().add("Grupo "  + i);
            }
        }
    }

    @FXML
    void gruposSeleccionarGrupo(ActionEvent event) {
        Materia m = universidad.getMateria(cmbGruposMateria.getSelectionModel().getSelectedIndex()+1);
        datosGrupo.clear();
        if(m==null || cmbGruposGrupo.getSelectionModel().getSelectedIndex()<0) return;
        Grupo g = m.getGrupo(cmbGruposGrupo.getSelectionModel().getSelectedIndex());
        Alumno[] a = g.getAlumnos();
        for(int c=0; c<m.getMaximoDeAlumnosPorGrupo() && a[c]!=null; c++){
            Alumno e = a[c];
            datosGrupo.add(e);
        }
        tblGrupos.setItems(datosGrupo);
        tblGrupos.refresh();
    }

    @FXML
    void gruposSeleccionarMateria(ActionEvent event) {
        if(cmbGruposMateria.getSelectionModel().getSelectedIndex() < 0) return;
        Materia m = universidad.getMateria(cmbGruposMateria.getSelectionModel().getSelectedIndex()+1);;
        Grupo [] g = m.getGrupos();
        cmbGruposGrupo.getItems().clear();
        for(int i=0; i<g.length;i++){
            cmbGruposGrupo.getItems().add("Grupo "  + i);
        }
        if(g.length>0) cmbGruposGrupo.getSelectionModel().select(0);
    }

    @FXML
    void inscripcionesInscribir(ActionEvent event) {
        Alert alert = null;
        try{
            Alumno a = universidad.getAlumno(Integer.parseInt(txtInscripcionesNumeroDeAlumno.getText()));
            Materia m = universidad.getMateria(cmbInscripcionesMateria.getSelectionModel().getSelectedIndex()+1);
            if(m.inscribir(a)){
                Inscripcion n = new Inscripcion(a, m);
                datosInscripciones.add(n);
                tblInscripciones.setItems(datosInscripciones);
            }
            else{
                if(a.tienePromedioCondicional()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("¡No se permite al estudiante!");
                    alert.setContentText("No se pudo inscribir el estudiante debido a que tiene \npromedio condicional :c");
                    alert.showAndWait();
                }
                else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("¡No se permiten duplicados!");
                    alert.setContentText("No se pudo inscribir el estudiante debido a que ya se \nencuentra inscrito en la materia :c");
                    alert.showAndWait();
                }
            }
        }
        catch(Exception e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("¡Datos invalidos!");
            alert.setContentText("Llene los campos con informacion valida");
            alert.showAndWait();
        }
        limpiarInscripciones();
        tblInscripciones.refresh();
    }

    @FXML
    void inscripcionesLimpiar(ActionEvent event) {
        limpiarInscripciones();
    }

    @FXML
    void inscripcionesSeleccionMateria(ActionEvent event) {
        Materia m = universidad.getMateria(cmbInscripcionesMateria.getSelectionModel().getSelectedIndex()+1);
        if (m==null){
            return;
        }
        ArrayList<Inscripcion> inscripciones = m.getInscripciones();
        datosInscripciones.clear();
        for(int c=0; c<inscripciones.size(); c++){
            datosInscripciones.add(inscripciones.get(c));
        }
        tblInscripciones.setItems(datosInscripciones);
        tblInscripciones.refresh();
    }

    @FXML
    void materiasAgregarMateria(ActionEvent event) {
        Alert alert = null;
        String aviso = null;
        Materia m = null;
        try{
            if(universidad.agregarMateria(txtMateriasNombre.getText(), Integer.parseInt(txtMateriasMaximoAlumosPorGrupo.getText()))){
                m = new Materia(txtMateriasNombre.getText(), Integer.parseInt(txtMateriasMaximoAlumosPorGrupo.getText()));
                datosMaterias.add(m);
                i++;
                cmbInscripcionesMateria.getItems().add(i + "-" + m.getNombre());
                cmbGruposMateria.getItems().add(i + "-" + m.getNombre());
            }
            else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("¡No se permiten duplicados!");
                alert.setContentText("No se pudo agregar la materia debido a que ya se encuentra \nen el sistema :c");
                alert.showAndWait();
            }
            tblMaterias.setItems(datosMaterias);
        }
        catch (NumberFormatException e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("¡Datos invalidos!");
            alert.setContentText("Llene los campos con informacion valida");
            alert.showAndWait();
        }
        limpiarMaterias();
        tblMaterias.refresh();
    }

    @FXML
    void materiasLimpiar(ActionEvent event) {
        limpiarMaterias();
    }

    void limpiarMaterias(){
        txtMateriasNombre.setText("");
        txtMateriasMaximoAlumosPorGrupo.setText("");
    }

    void limpiarAlumnos(){
        txtAlumnosCodigo.setText("");
        txtAlumnosNombres.setText("");
        txtAlumnosApellidos.setText("");
        txtAlumnosEdad.setText("");
        txtAlumnosPromedio.setText("");
    }

    void limpiarInscripciones(){
        txtInscripcionesNumeroDeAlumno.setText("");
    }

    @FXML
    void initialize() {
        assert txtMateriasMaximoAlumosPorGrupo != null : "fx:id=\"txtMateriasMaximoAlumosPorGrupo\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtMateriasNombre != null : "fx:id=\"txtMateriasNombre\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdMateriasAgregarMateria != null : "fx:id=\"cmdMateriasAgregarMateria\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdMateriasLimpiar != null : "fx:id=\"cmdMateriasLimpiar\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert tblMaterias != null : "fx:id=\"tblMaterias\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colMateriasMateria != null : "fx:id=\"colMateriasMateria\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colMateriasMaximoAlumnos != null : "fx:id=\"colMateriasMaximoAlumnos\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtAlumnosPromedio != null : "fx:id=\"txtAlumnosPromedio\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdAlumnosAgregarAlumno != null : "fx:id=\"cmdAlumnosAgregarAlumno\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdAlumnosLimpiar != null : "fx:id=\"cmdAlumnosLimpiar\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtAlumnosCodigo != null : "fx:id=\"txtAlumnosCodigo\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtAlumnosNombres != null : "fx:id=\"txtAlumnosNombres\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtAlumnosApellidos != null : "fx:id=\"txtAlumnosApellidos\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtAlumnosEdad != null : "fx:id=\"txtAlumnosEdad\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert tblAlumnos != null : "fx:id=\"tblAlumnos\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colAlumnosCodigo != null : "fx:id=\"colAlumnosCodigo\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colAlumnosNombre != null : "fx:id=\"colAlumnosNombre\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colAlumnosApellidos != null : "fx:id=\"colAlumnosApellidos\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colAlumnosEdad != null : "fx:id=\"colAlumnosEdad\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colAlumnosPromedio != null : "fx:id=\"colAlumnosPromedio\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert txtInscripcionesNumeroDeAlumno != null : "fx:id=\"txtInscripcionesNumeroDeAlumno\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmbInscripcionesMateria != null : "fx:id=\"cmbInscripcionesMateria\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdInscripcionesLimpiar != null : "fx:id=\"cmdInscripcionesLimpiar\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdInscripcionesInscribir != null : "fx:id=\"cmdInscripcionesInscribir\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert tblInscripciones != null : "fx:id=\"tblInscripciones\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colInscripcionesAlumno != null : "fx:id=\"colInscripcionesAlumno\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colInscripcionesMateria != null : "fx:id=\"colInscripcionesMateria\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmbGruposMateria != null : "fx:id=\"cmbGruposMateria\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmbGruposGrupo != null : "fx:id=\"cmbGruposGrupo\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdGruposGenerarGrupo != null : "fx:id=\"cmdGruposGenerarGrupo\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert tblGrupos != null : "fx:id=\"tblGrupos\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colGruposCodigo != null : "fx:id=\"colGruposCodigo\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colGruposNombres != null : "fx:id=\"colGruposNombres\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert colGruposApellidos != null : "fx:id=\"colGruposApellidos\" was not injected: check your FXML file 'Matriculas.fxml'.";
        assert cmdInformacion != null : "fx:id=\"cmdInformacion\" was not injected: check your FXML file 'Matriculas.fxml'.";

        universidad = new Universidad();

        TableColumn colMateriasMateria = new TableColumn("Materia");
        colMateriasMateria.setMinWidth(236);
        colMateriasMateria.setCellValueFactory(
            new PropertyValueFactory<Materia, String>("nombre"));

        TableColumn colMateriasMaximoAlumnos = new TableColumn("Maximo de Alumnos por Grupo");
        colMateriasMaximoAlumnos.setMinWidth(236);
        colMateriasMaximoAlumnos.setCellValueFactory(
            new PropertyValueFactory<Materia, String>("maximoDeAlumnosPorGrupo"));

        tblMaterias.setItems(datosMaterias);
        tblMaterias.getColumns().clear();
        tblMaterias.getColumns().addAll(colMateriasMateria, colMateriasMaximoAlumnos);

        TableColumn colAlumnosCodigo = new TableColumn("Codigo");
        colAlumnosCodigo.setMinWidth(95);
        colAlumnosCodigo.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("codigo"));

        TableColumn colAlumnosNombre = new TableColumn("Nombres");
        colAlumnosNombre.setMinWidth(95);
        colAlumnosNombre.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("nombres"));

        TableColumn colAlumnosApellidos = new TableColumn("Apellidos");
        colAlumnosApellidos.setMinWidth(95);
        colAlumnosApellidos.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("apellidos"));

        TableColumn colAlumnosEdad = new TableColumn("Edad");
        colAlumnosEdad.setMinWidth(95);
        colAlumnosEdad.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("edad"));

        TableColumn colAlumnosPromedio = new TableColumn("Promedio");
        colAlumnosPromedio.setMinWidth(95);
        colAlumnosPromedio.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("promedio"));

        tblAlumnos.setItems(datosAlumnos);
        tblAlumnos.getColumns().clear();
        tblAlumnos.getColumns().addAll(colAlumnosCodigo, colAlumnosNombre, colAlumnosApellidos, colAlumnosEdad, colAlumnosPromedio);

        TableColumn colInscripcionesAlumno = new TableColumn("Alumno");
        colInscripcionesAlumno.setMinWidth(235);
        colInscripcionesAlumno.setCellValueFactory(
            new PropertyValueFactory<Inscripcion, String>("nombresAlumno"));

        TableColumn colInscripcionesMateria = new TableColumn("Materia");
        colInscripcionesMateria.setMinWidth(235);
        colInscripcionesMateria.setCellValueFactory(
            new PropertyValueFactory<Inscripcion, String>("nombreDeLaMateria"));

        tblInscripciones.setItems(datosInscripciones);
        tblInscripciones.getColumns().clear();
        tblInscripciones.getColumns().addAll(colInscripcionesAlumno, colInscripcionesMateria);

        TableColumn colGruposCodigo = new TableColumn("Codigo");
        colGruposCodigo.setMinWidth(157);
        colGruposCodigo.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("codigo"));

        TableColumn colGruposNombres = new TableColumn("Nombres");
        colGruposNombres.setMinWidth(157);
        colGruposNombres.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("nombres"));

        TableColumn colGruposApellidos = new TableColumn("Apellidos");
        colGruposApellidos.setMinWidth(157);
        colGruposApellidos.setCellValueFactory(
            new PropertyValueFactory<Alumno, String>("apellidos"));

        tblGrupos.setItems(datosGrupo);
        tblGrupos.getColumns().clear();
        tblGrupos.getColumns().addAll(colGruposCodigo, colGruposNombres, colGruposApellidos);

    }
}
