public interface Product {
    void addProduct(); // додати товар
    void getProductDetails(); // отримати дані про товар
    void updateProductDetails(String name, String upc, String manufacturer, double price, String expirationDate, int quantity); // змінити дані про товар
    void moveToStorage(); // перемістити товар на склад
    void moveToSalesFloor(); // перемістити товар у торговий зал
    void payForProduct(); // сплатити товар
    void writeOffProduct(); // списати товар
}
