package sample;

public class OrderTableObjects {

    //aici sunt variabilele care ajuta la stocarea informatiilor in database
    private String nameOrderTable;
    private String cityOrderTable;
    private String carOrderTable;
    private String carModelOrderTable;
    private int timeOrderTable;
    private int totalPriceOrderTable;

    //constructor cu parametrii
    public OrderTableObjects(String nameOrderTable, String cityOrderTable,
                             String carOrderTable,String carModelOrderTable, int timeOrderTable, int totalPriceOrderTable) {

        this.nameOrderTable = nameOrderTable;
        this.cityOrderTable = cityOrderTable;
        this.carOrderTable = carOrderTable;
        this.carModelOrderTable = carModelOrderTable;
        this.timeOrderTable = timeOrderTable;
        this.totalPriceOrderTable = totalPriceOrderTable;

    }

    public String getCarModelOrderTable() {
        return carModelOrderTable;
    }

    public String getNameOrderTable() {
        return nameOrderTable;
    }

    public String getCityOrderTable() {
        return cityOrderTable;
    }

    public String getCarOrderTable() {
        return carOrderTable;
    }

    public int getTimeOrderTable() {
        return timeOrderTable;
    }

    public int getTotalPriceOrderTable() {
        return totalPriceOrderTable;
    }
}
