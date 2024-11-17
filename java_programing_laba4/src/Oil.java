public interface Oil extends Product {
    void setOilType(String type); // Встановити тип олії
    void getOilType();           // Отримати тип олії
}

class OilImpl implements Oil {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private String expirationDate;
    private int quantity;
    private String oilType;

    public OilImpl(int id, String name, String upc, String manufacturer, double price, String expirationDate, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    @Override
    public void addProduct() {
        System.out.println("Олію додано: " + name);
    }

    @Override
    public void getProductDetails() {
        System.out.printf("ID: %d, Назва: %s, UPC: %s, Виробник: %s, Ціна: %.2f, Термін зберігання: %s, Кількість: %d\n",
                id, name, upc, manufacturer, price, expirationDate, quantity);
    }

    @Override
    public void updateProductDetails(String name, String upc, String manufacturer, double price, String expirationDate, int quantity) {
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        System.out.println("Дані про олію оновлено.");
    }

    @Override
    public void moveToStorage() {
        System.out.println("Олію переміщено на склад.");
    }

    @Override
    public void moveToSalesFloor() {
        System.out.println("Олію переміщено у торговий зал.");
    }

    @Override
    public void payForProduct() {
        System.out.println("Олію оплачено.");
    }

    @Override
    public void writeOffProduct() {
        System.out.println("Олію списано.");
    }

    @Override
    public void setOilType(String type) {
        this.oilType = type;
    }

    @Override
    public void getOilType() {
        System.out.println("Тип олії: " + oilType);
    }
}
