package frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Pogodynka extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        primaryStage.setWidth(450);
        primaryStage.setHeight(360);
        root.setBackground(new Background(new BackgroundImage(new WeatherAppImage("brazilmaplo.jpg"),
                null,
                null,
                null,
                new BackgroundSize(primaryStage.getWidth(), primaryStage.getHeight(), false, false, false, false))));

        Image weatherGirl = new WeatherAppImage("weather-girl.png");
        ImageView imageView = new ImageView(weatherGirl);
        VBox rightPanel = new VBox();
        root.getChildren().addAll(imageView, rightPanel);

        Region emptyRegion = new Region();
        rightPanel.getChildren().add(emptyRegion);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    class WeatherAppImage extends Image {

        WeatherAppImage(String file) {
            super(inputStreamFromFile(file));

        }
    }

        private static InputStream inputStreamFromFile(String fileName) {
            File initialFile = new File("src/main/java/frontend/".concat(fileName));
            try {
                return new FileInputStream(initialFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

    }


