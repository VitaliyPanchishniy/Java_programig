public class Main {
    public static void main(String[] args) {
        // додавання олії
        Oil oil = new OilImpl(1, "Соняшникова олія", "123456789012", "ОліяУкраїна", 50.0, "2024-12-31", 100);
        oil.addProduct();
        oil.setOilType("Рафінована");
        oil.getOilType();
        oil.getProductDetails();

        // додавання молока
        Milk milk = new MilkImpl(2, "Молоко", "987654321098", "МолокоУкраїна", 25.0, "2023-12-01", 50);
        milk.addProduct();
        milk.setFatPercentage(3.2);
        milk.getFatPercentage();
        milk.getProductDetails();

        // додавання сиру
        Cheese cheese = new CheeseImpl(3, "Голландський сир", "111222333444", "СирЗавод", 150.0, "2024-01-15", 30);
        cheese.addProduct();
        cheese.setCheeseType("Твердий");
        cheese.getCheeseType();
        cheese.getProductDetails();
    }
}
