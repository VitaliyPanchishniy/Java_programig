package com.example.java_lab7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Picture extends Application {
    private GraphicsContext gc;
    private double brushSize = 10.0;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 500);
        gc = canvas.getGraphicsContext2D();
        drawInitialCanvas();

        // ScrollBar для зміни розміру пензля
        Label brushLabel = new Label("Brush Size:");
        ScrollBar brushSizeSelector = new ScrollBar();
        brushSizeSelector.setMin(5);
        brushSizeSelector.setMax(50);
        brushSizeSelector.setValue(brushSize);
        brushSizeSelector.setPrefWidth(200);
        brushSizeSelector.valueProperty().addListener((observable, oldValue, newValue) -> brushSize = newValue.doubleValue());

        // Створення нижньої панелі
        HBox controlPanel = new HBox(10, brushLabel, brushSizeSelector);
        controlPanel.setPadding(new Insets(10));
        controlPanel.setStyle("-fx-background-color: #f0f0f0;");
        controlPanel.setMaxHeight(40);

        // Подія для видалення частини малюнка
        canvas.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                gc.clearRect(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
            }
        });

        // Повернення початкового стану при потрійному натисканні
        canvas.setOnMouseClicked(e -> {
            if (e.getClickCount() == 3) {
                drawInitialCanvas();
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(controlPanel);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Canvas Drawing App");
        stage.setScene(scene);
        stage.show();
    }

    // Малюнок кавуна
    private void drawInitialCanvas() {
        // Фон
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 800, 600);

        // Зовнішня частина кавуна
        gc.setFill(Color.DARKGREEN);
        gc.fillOval(200, 150, 400, 300);

        // Внутрішня частина кавуна
        gc.setFill(Color.RED);
        gc.fillOval(220, 170, 360, 260);

        // Кісточки кавуна
        gc.setFill(Color.BLACK);
        double[][] seeds = {
                {300, 200}, {350, 250}, {400, 220}, {280, 300}, {420, 300},
                {330, 270}, {370, 200}, {390, 270}, {310, 230}, {440, 260}
        };
        for (double[] seed : seeds) {
            gc.fillOval(seed[0], seed[1], 10, 20);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
