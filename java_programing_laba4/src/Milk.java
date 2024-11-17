public interface Milk extends Product {
    void setFatPercentage(double percentage); // Встановити вміст жиру
    void getFatPercentage();                // Отримати вміст жиру
}

class MilkImpl implements Milk {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private String expirationDate;
    private int quantity;
    private double fatPercentage;

    public MilkImpl(int id, String name, String upc, String manufacturer, double price, String expirationDate, int quantity) {
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
        System.out.println("Молоко додано: " + name);
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
        System.out.println("Дані про молоко оновлено.");
    }

    @Override
    public void moveToStorage() {
        System.out.println("Молоко переміщено на склад.");
    }

    @Override
    public void moveToSalesFloor() {
        System.out.println("Молоко переміщено у торговий зал.");
    }

    @Override
    public void payForProduct() {
        System.out.println("Молоко оплачено.");
    }

    @Override
    public void writeOffProduct() {
        System.out.println("Молоко списано.");
    }

    @Override
    public void setFatPercentage(double percentage) {
        this.fatPercentage = percentage;
    }

    @Override
    public void getFatPercentage() {
        System.out.printf("Вміст жиру: %.2f%%\n", fatPercentage);
    }
}
