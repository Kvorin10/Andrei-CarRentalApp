package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Marketplace implements Initializable {

    @FXML
    private Label universalCarNameLabel;
    @FXML
    private Label universalCarSpeedLabel;
    @FXML
    private Label universalCarGearBoxLabel;
    @FXML
    private Label universalCarModelLabel;
    @FXML
    private Label universalCarCarburantLabel;
    @FXML
    private Label universalCarTireSizeLabel;
    @FXML
    private Label universalCarSeatsLabel;
    @FXML
    private Label universalCarColorLabel;
    @FXML
    private Label universalCarHorsePowerLabel;
    @FXML
    private ImageView universalImage;
    @FXML
    private Label universalCarPriceLabel;

    @FXML
    private Label totalPriceLabel;
    @FXML
    private Label returnDayLabel;
    @FXML
    private Button checkThePriceButton;
    @FXML
    private TextField timeRentTextField;

    private int variableForStoringTheTotalPrice;
    private int variableForStoringTheTime;
    private int variableForStoringTheLabelPrice;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField cityTextField;
    @FXML
    private Button rentNowBotton;
    @FXML
    private Label comandMessageLabel;

    //butoanele din marketplace
    @FXML
    private Button goToMarketplaceButton;
    @FXML
    private Button cadillacPage;
    @FXML
    private Button dodgePage;
    @FXML
    private Button fordCrewPage;
    @FXML
    private Button fordFiestaPage;
    @FXML
    private Button fordEdgePage;
    @FXML
    private Button fordExplorerPage;
    @FXML
    private Button fordFusionPage;
    @FXML
    private Button fordMustangPage;


    public void rentButton(ActionEvent event)throws IOException{
        insertRecords();
        comandMessageLabel.setText("Your order was received!");
    }

    //metoda asta face conexiunea cu database-ul
    public Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_gui_project","root","Laurentiu10");
            return conn;
        }catch (Exception ex){
            System.out.println("Error "+ ex.getMessage());
            return null;
        }
    }

    //metoda asta nu face nimic , dar o voi folosi pentru a afisa valorile din database intr-un table view
    public ObservableList<OrderTableObjects> getCarsList(){
        ObservableList<OrderTableObjects> carsList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM orders";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            OrderTableObjects orders ;
            while(rs.next()){
                orders = new OrderTableObjects(rs.getString("Name"), rs.getString("City"),rs.getString("Car"),rs.getString("Model"),rs.getInt("Time"),rs.getInt("Total Price"));
                carsList.add(orders);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return carsList;
    }

    public void insertRecords(){
        String query = "INSERT INTO orders VALUES ('" + nameTextField.getText() + "','" + cityTextField.getText() + "','" + universalCarNameLabel.getText() + "','" + universalCarModelLabel.getText()+ "'," + returnDayLabel.getText() + "," + totalPriceLabel.getText() + ")" ;
        executeQuery(query);
        //metoda asta insereaza in database textul din label-uri
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //metoda acesta calculeza pretul masinii in functie de nr de zile pe care il trece user-ul in text field
    public void checkTheTotalPriceButtonAction(ActionEvent event){
        variableForStoringTheTime = Integer.parseInt(timeRentTextField.getText());
        variableForStoringTheLabelPrice = Integer.parseInt(universalCarPriceLabel.getText());
        variableForStoringTheTotalPrice = variableForStoringTheLabelPrice * variableForStoringTheTime;
        totalPriceLabel.setText(Integer.toString(variableForStoringTheTotalPrice ));
        returnDayLabel.setText(timeRentTextField.getText());
    }

    //************************************************************************
    public void toyotaPage(ActionEvent event) throws IOException {
        //atribuim obiectului toyota o noua instanta a clasei Cars
        Cars toyota = new Cars("Toyota", "Manual","White","Aygo","Gas", 14, 200,4, 72, new Image("/images/toyota.png"), 90);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load(); //incarca fisierul xml
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(toyota);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); // node este o superclasa abstracta a elementelor grafice
        window.setScene(carsViewScene); //seteaza scena
        window.show(); //arata stage-ul

    }

    public void cadillacPage(ActionEvent event) throws IOException {
        Cars cadillac = new Cars("Cadillac", "Automatic","Black","Escalade","Diesel", 16, 350,5, 640, new Image("/images/cadillac_escalade.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(cadillac);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void dodgePage(ActionEvent event) throws IOException {
        Cars dodge = new Cars("Dodge", "Automatic","Red","Charger","Diesel", 15, 245,4, 300, new Image("/images/dodge_charger.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(dodge);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordEdgepage(ActionEvent event) throws IOException {
        Cars ford_edge = new Cars("Ford", "Automatic","Brown","Edge","Diesel", 16, 300,5, 350, new Image("/images/ford_edge.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(ford_edge);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordExplorerPage(ActionEvent event) throws IOException {
        Cars ford_explorer = new Cars("Ford", "Automatic","Black","Explorer","Electric", 15, 350,5, 460, new Image("/images/ford_explorer.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(ford_explorer);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordFusionPage(ActionEvent event) throws IOException {

        Cars ford_fusion = new Cars("Ford", "Manual","White","Fusion","Gas", 14, 230,4, 150, new Image("/images/ford_fusion.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(ford_fusion);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordCrewpage(ActionEvent event) throws IOException {
        Cars ford_crew = new Cars("Ford", "Automatic","Brown","Crew","Diesel", 16, 300,5, 250, new Image("/images/ford_crew.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(ford_crew);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordMustangpage(ActionEvent event) throws IOException {
        Cars ford_mustang = new Cars("Ford", "Automatic","Black","Mustang","Diesel", 15, 350,4, 450, new Image("/images/ford_mustang.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(ford_mustang);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordFiestaPage(ActionEvent event) throws IOException {
        Cars ford_fiesta = new Cars("Ford", "Manual","Brown","Fiesta","Gas", 14, 250,5, 200, new Image("/images/ford_fiesta.png"),40);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(ford_fiesta);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void opelAstraPage(ActionEvent event) throws IOException {
        Cars opelAstra = new Cars("Opel", "Manual","White","Astra","Diesel", 14, 240,5, 150, new Image("/images/opel_astra.png"),100);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(opelAstra);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void opelCorsaPage(ActionEvent event) throws IOException {
        Cars opelCorsa = new Cars("Opel", "Manual","Blue","Corsa","Diesel", 15, 230,5, 190, new Image("/images/opel_corsa.png"),100);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(opelCorsa);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void daciaDusterPage(ActionEvent event) throws IOException {
        Cars dacia = new Cars("Dacia", "Automatic", "White", "Duster", "Diesel", 16, 300, 5, 450, new Image("/images/dacia_duster.png"),150);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(dacia);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();

    }

    public void fordEcosportPage(ActionEvent event)throws IOException{
        Cars fordEcosport = new Cars("Ford", "Automatic","White","Ecosport","Electric", 16, 300,5, 450,new Image("/images/ford_ecosport.png"),200);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(fordEcosport);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();
    }

    public void opelInsigniaPage(ActionEvent event)throws IOException{
        Cars opelInsignia = new Cars("Opel", "Manual","White","Insignia","Gas", 14, 250,5, 150 ,new Image("/images/opel_insignia.png"),90);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(opelInsignia);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();
    }

    public void opelVivaroPage(ActionEvent event)throws IOException{
        Cars opelVivaro = new Cars("Opel", "Manual","Blue","Vivaro","Gas", 16, 250,3, 150 ,new Image("/images/opel_vivaro.png"),80);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(opelVivaro);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();
    }

    public void renaulTraficPage(ActionEvent event)throws IOException{
        Cars renaultTrafic = new Cars("Renault", "Manual","White","Trafic","Gas", 16, 230,2, 150 ,new Image("/images/renaul_trafic.png"),80);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("toyota.fxml"));
        Parent carsViewParent = loader.load();
        Scene carsViewScene = new Scene(carsViewParent);
        Marketplace controller = loader.getController();
        controller.setData(renaultTrafic);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(carsViewScene);
        window.show();
    }

    //**************************************************************************

    public void setData(Cars masina)throws IOException{
        universalCarNameLabel.setText(masina.getUniversalCarName());
        universalCarSpeedLabel.setText(Integer.toString(masina.getUniversalSpeed()));
        universalCarGearBoxLabel.setText(masina.getUniversalGearBox());
        universalCarCarburantLabel.setText(masina.getUniversalCarburant());
        universalCarModelLabel.setText(masina.getUniversalModel());
        universalCarColorLabel.setText(masina.getUniversalColor());
        universalCarHorsePowerLabel.setText(Integer.toString(masina.getUniversalHorsePower()));
        universalCarTireSizeLabel.setText(Integer.toString(masina.getUniversalTiresSize()));
        universalCarSeatsLabel.setText(Integer.toString(masina.getUniversalNoSeats()));
        universalImage.setImage(masina.getPhoto());
        universalCarPriceLabel.setText(Integer.toString(masina.getPrice()));
    }

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("marketplace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void goToSpeciaOffers(ActionEvent event)throws IOException{

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("speciaOffers.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //linia acesta preia informatiile despre stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void goToTerms(ActionEvent event)throws IOException{

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("termsFX.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
