public interface Cheese extends Product {
    void setCheeseType(String type); // Встановити тип сиру
    void getCheeseType();           // Отримати тип сиру
}

class CheeseImpl implements Cheese {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private String expirationDate;
    private int quantity;
    private String cheeseType;

    public CheeseImpl(int id, String name, String upc, String manufacturer, double price, String expirationDate, int quantity) {
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
        System.out.println("Сир додано: " + name);
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
        System.out.println("Дані про сир оновлено.");
    }

    @Override
    public void moveToStorage() {
        System.out.println("Сир переміщено на склад.");
    }

    @Override
    public void moveToSalesFloor() {
        System.out.println("Сир переміщено у торговий зал.");
    }

    @Override
    public void payForProduct() {
        System.out.println("Сир оплачено.");
    }

    @Override
    public void writeOffProduct() {
        System.out.println("Сир списано.");
    }

    @Override
    public void setCheeseType(String type) {
        this.cheeseType = type;
    }

    @Override
    public void getCheeseType() {
        System.out.println("Тип сиру: " + cheeseType);
    }
}
