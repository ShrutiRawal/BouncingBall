import javafx.animation.*;
import javafx.application.*;
import javafx.collections.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.util.*;

public class BouncingBall extends Application {

    public static void main(String[] args) {
        Application.launch(args);                 //launch FX application
    }

    @Override
    public void start(Stage mainWindow) {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 200);

        Polyline sinWave = new Polyline();      //sin wave trace
        sinWave.setStroke(Color.GREY);
        ObservableList<Double> pointList = sinWave.getPoints();  //value for points on sin wave
        for (int x = -170; x <= 170; x++) {
            pointList.add(x + 200.0);
            pointList.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));
        }

        Circle ball = new Circle(10, Color.RED);
        
        Line x1 = new Line(10,100,390,100);
        Line x2 = new Line(390,100,380,110);
        Line x3 = new Line(390,100,380,90);

        Line y1 = new Line(200,10,190,20);
        Line y2 = new Line(200,10,210,20);
        Line y3 = new Line(200,10,200,200);

        Text Xaxis = new Text(380, 70, "X");         //texts for axis and values
        Text Yaxis = new Text(220, 20, "Y");
        Text n3Pi = new Text(50, 115, "-3\u03c0");
        Text n2Pi = new Text(100, 115, "-2\u03c0");
        Text n1Pi = new Text(150, 115, "-\u03c0");
        Text zero = new Text(205, 115, "0");
        Text p1Pi = new Text(350, 115, "3\u03c0");
        Text p2Pi = new Text(300, 115, "2\u03c0");
        Text p3Pi = new Text(250, 115, "\u03c0");
        
        pane.getChildren().addAll(sinWave, ball,    //adding all the elements to the pane
                y1, y2, y3, x1, x2, x3,
                Xaxis, Yaxis, n3Pi, n2Pi, n1Pi,
                p1Pi, p2Pi, p3Pi, zero);

        PathTransition waveTrace = new PathTransition(Duration.millis(3000), sinWave, ball);  //making ball follow our sinWave polyline
        waveTrace.setCycleCount(Timeline.INDEFINITE);
        waveTrace.play();

        mainWindow.setTitle("Bouncing Ball");
        mainWindow.setScene(scene);    //adding scene to mainWindow
        mainWindow.show();

        pane.requestFocus();
    }
}
