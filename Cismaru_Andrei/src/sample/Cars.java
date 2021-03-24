package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
//aici se afla toate variabilele care ajuta la implementarea obiectelor "masini"
public class Cars {
    private SimpleStringProperty universalCarName;
    private SimpleStringProperty universalGearBox;
    private SimpleStringProperty universalColor;
    private SimpleStringProperty universalModel;
    private SimpleStringProperty universalCarburant;
    private int universalTiresSize;
    private int universalSpeed;
    private int universalNoSeats;
    private int universalHorsePower;
    private Image photo ;
    private int price;

   public Cars(String universalCarName, String universalGearBox, String universalColor, String universalModel,
               String universalCarburant, int universalTireSize, int universalSpeed, int universalNoSeats, int universalHorsePower, int price){
       this.universalCarName = new SimpleStringProperty(universalCarName);
       this.universalGearBox = new SimpleStringProperty(universalGearBox);
       this.universalColor = new SimpleStringProperty(universalColor);
       this.universalModel = new SimpleStringProperty(universalModel);
       this.universalCarburant = new SimpleStringProperty(universalCarburant);
       this.universalTiresSize = universalTireSize;
       this.universalSpeed = universalSpeed;
       this.universalNoSeats = universalNoSeats;
       this.universalHorsePower = universalHorsePower;
       photo = new Image("/images/dacia_duster.png");
       this.price = price;
   }

    public Cars(String universalCarName, String universalGearBox, String universalColor, String universalModel,
                String universalCarburant, int universalTireSize, int universalSpeed, int universalNoSeats, int universalHorsePower, Image photo, int price){
        this.universalCarName = new SimpleStringProperty(universalCarName);
        this.universalGearBox = new SimpleStringProperty(universalGearBox);
        this.universalColor = new SimpleStringProperty(universalColor);
        this.universalModel = new SimpleStringProperty(universalModel);
        this.universalCarburant = new SimpleStringProperty(universalCarburant);
        this.universalTiresSize = universalTireSize;
        this.universalSpeed = universalSpeed;
        this.universalNoSeats = universalNoSeats;
        this.universalHorsePower = universalHorsePower;
        this.photo = photo;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public int getUniversalHorsePower() {
        return universalHorsePower;
    }

    public void setUniversalHorsePower(int universalHorsePower) {
        this.universalHorsePower = universalHorsePower;
    }

    public String getUniversalCarName() {
        return universalCarName.get();
    }

    public SimpleStringProperty universalCarNameProperty() {
        return universalCarName;
    }

    public void setUniversalCarName(String universalCarName) {
        this.universalCarName.set(universalCarName);
    }

    public String getUniversalGearBox() {
        return universalGearBox.get();
    }

    public SimpleStringProperty universalGearBoxProperty() {
        return universalGearBox;
    }

    public void setUniversalGearBox(String universalGearBox) {
        this.universalGearBox.set(universalGearBox);
    }

    public String getUniversalColor() {
        return universalColor.get();
    }

    public SimpleStringProperty universalColorProperty() {
        return universalColor;
    }

    public void setUniversalColor(String universalColor) {
        this.universalColor.set(universalColor);
    }

    public String getUniversalModel() {
        return universalModel.get();
    }

    public SimpleStringProperty universalModelProperty() {
        return universalModel;
    }

    public void setUniversalModel(String universalModel) {
        this.universalModel.set(universalModel);
    }

    public String getUniversalCarburant() {
        return universalCarburant.get();
    }

    public SimpleStringProperty universalCarburantProperty() {
        return universalCarburant;
    }

    public void setUniversalCarburant(String universalCarburant) {
        this.universalCarburant.set(universalCarburant);
    }

    public int getUniversalTiresSize() {
        return universalTiresSize;
    }

    public void setUniversalTiresSize(int universalTiresSize) {
        this.universalTiresSize = universalTiresSize;
    }

    public int getUniversalSpeed() {
        return universalSpeed;
    }

    public void setUniversalSpeed(int universalSpeed) {
        this.universalSpeed = universalSpeed;
    }

    public int getUniversalNoSeats() {
        return universalNoSeats;
    }

    public void setUniversalNoSeats(int universalNoSeats) {
        this.universalNoSeats = universalNoSeats;
    }
}
