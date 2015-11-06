package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Controller {
    private String style1URL = getClass().getResource("application.css").toExternalForm();
    private String style2URL = getClass().getResource("application2.css").toExternalForm();

    @FXML
    private BorderPane rootPane;
    @FXML
    private LineChart<Double, Double> chart;
    @FXML
    private Button but1;
    @FXML
    private Button but2;

    @FXML
    private void handleStyleButtonAction(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        ObservableList<String> styleSheets = rootPane.getStylesheets();
        if (clicked == but1) {
            styleSheets.remove(style2URL);
            styleSheets.add(style1URL);
        } else if (clicked == but2) {
            styleSheets.remove(style1URL);
            styleSheets.add(style2URL);
        }
    }

    public void initialize() {
        double startAngle = 0, stopAngle = 360, step = 10;
        chart.getData().add(initSerie(startAngle, stopAngle, step));
    }

    private XYChart.Series<Double, Double> initSerie(double start, double stop, double delta) {
        XYChart.Series<Double, Double> sin = new XYChart.Series<Double, Double>();
        double iRad;
        for (double i = start; i <= stop; i += delta) {
            iRad = i * Math.PI / 180;
            sin.getData().add(new XYChart.Data<Double, Double>(i, 2 * Math.sin(iRad) * Math.cos(iRad)));
        }
        return sin;
    }
}
