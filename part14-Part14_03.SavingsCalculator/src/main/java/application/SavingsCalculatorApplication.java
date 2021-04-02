package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        
        BorderPane borderPane1 = new BorderPane();
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setSnapToTicks(true);
        monthlySavingsSlider.setBlockIncrement(500);
        Label currentMonthlySavings = new Label(String.valueOf(monthlySavingsSlider.getValue()));
        borderPane1.setLeft(new Label("Monthly savings"));
        borderPane1.setCenter(monthlySavingsSlider);
        borderPane1.setRight(currentMonthlySavings);
        borderPane1.setPadding(new Insets(10));
        
        BorderPane borderPane2 = new BorderPane();
        Slider yearlyInterestRateSlider = new Slider(0, 10, 0);
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setShowTickLabels(true);
        Label currentYearlyInterestRate = new Label(String.valueOf(yearlyInterestRateSlider.getValue()));
        borderPane2.setLeft(new Label("Yearly interest rate"));
        borderPane2.setCenter(yearlyInterestRateSlider);
        borderPane2.setRight(currentYearlyInterestRate);
        borderPane2.setPadding(new Insets(10));
        
        vBox.getChildren().addAll(borderPane1, borderPane2);
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        XYChart.Series savingsData = new XYChart.Series();
        XYChart.Series savingsWithInterestData = new XYChart.Series();
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
        lineChart.getData().add(savingsData);
        lineChart.getData().add(savingsWithInterestData);
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        
        monthlySavingsSlider.setOnMouseReleased(event -> {
            String savingsString = ""+monthlySavingsSlider.getValue();
            if(savingsString.length() > 5) {
                savingsString = savingsString.substring(0, 5);
            }
            currentMonthlySavings.setText(savingsString);
            
            updateChart(savingsData, savingsWithInterestData, monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue());

        });
        
        yearlyInterestRateSlider.setOnMouseReleased(event -> {
            String interestString = ""+yearlyInterestRateSlider.getValue();
            if(interestString.length() > 4) {
                interestString = interestString.substring(0, 4);
            }
            currentYearlyInterestRate.setText(interestString);
            updateChart(savingsData, savingsWithInterestData, monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue());
        });
        
        layout.setTop(vBox);
        layout.setCenter(lineChart);
        Scene scene = new Scene(layout, 640, 480);
        window.setTitle("Savings Calculator");
        window.setScene(scene);
        window.show();
    }

    private void updateChart(XYChart.Series savingsData, XYChart.Series savingsWithInterestData, double savingsValue, double interestRateValue) {
            savingsData.getData().clear();
            savingsWithInterestData.getData().clear();
            
            savingsData.getData().add(new XYChart.Data(0, 0));
            savingsWithInterestData.getData().add(new XYChart.Data(0, 0));
            
            double interestValue = 0;
            
            for(int i  = 1; i <= 30; i++) {
                savingsData.getData().add(new XYChart.Data(i, i * 12 * savingsValue));
                interestValue = interestValue + (12 * savingsValue);
                interestValue = interestValue * (1 + interestRateValue/100.0);
                savingsWithInterestData.getData().add(new XYChart.Data(i, interestValue));
            }
    }
}

/*
package application;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class SavingsCalculatorApplication extends Application {
 
    @Override
    public void start(Stage ikkuna) {
        BorderPane display = new BorderPane();
 
        Slider monthlySum = new Slider();
        monthlySum.setMin(25);
        monthlySum.setMax(250);
        monthlySum.setSnapToTicks(true);
        monthlySum.setBlockIncrement(500);
        monthlySum.setShowTickLabels(true);
        monthlySum.setShowTickMarks(true);
 
        Slider interestRate = new Slider();
        interestRate.setMin(0);
        interestRate.setMax(10);
        interestRate.setMinorTickCount(10);
        interestRate.setShowTickLabels(true);
        interestRate.setShowTickMarks(true);
 
        Label savingsText = new Label("25");
        Label interestRateText = new Label("0");
 
        BorderPane monthlySumDisplay = new BorderPane();
        monthlySumDisplay.setLeft(new Label("Monthly savings"));
        monthlySumDisplay.setCenter(monthlySum);
        monthlySumDisplay.setRight(savingsText);
        monthlySumDisplay.setPadding(new Insets(10));
 
        BorderPane interestRateDisplay = new BorderPane();
        interestRateDisplay.setLeft(new Label("Yearly interest rate"));
        interestRateDisplay.setCenter(interestRate);
        interestRateDisplay.setRight(interestRateText);
        interestRateDisplay.setPadding(new Insets(10));
 
        VBox sliderDisplay = new VBox();
        sliderDisplay.getChildren().add(monthlySumDisplay);
        sliderDisplay.getChildren().add(interestRateDisplay);
 
        sliderDisplay.setPadding(new Insets(10));
        sliderDisplay.setSpacing(10);
 
        display.setTop(sliderDisplay);
 
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
 
        LineChart<Number, Number> savingsLineChart = new LineChart<>(xAxis, yAxis);
        savingsLineChart.setAnimated(false);
        savingsLineChart.setLegendVisible(false);
        savingsLineChart.setTitle("Savings calculator");
 
        display.setCenter(savingsLineChart);
 
        XYChart.Series savings = new XYChart.Series();
        XYChart.Series savingsWithInterest = new XYChart.Series();
 
        savingsLineChart.getData().add(savings);
        savingsLineChart.getData().add(savingsWithInterest);
 
        monthlySum.setOnMouseReleased(e -> {
            savingsText.setText("" + monthlySum.getValue());
            updateChart(monthlySum.getValue(), interestRate.getValue(), savings, savingsWithInterest);
        });
 
        interestRate.setOnMouseReleased(e -> {
 
            String interestString = "" + interestRate.getValue();
            if (interestString.length() > 4) {
                interestString = interestString.substring(0, 4);
            }
            interestRateText.setText(interestString);
            updateChart(monthlySum.getValue(), interestRate.getValue(), savings, savingsWithInterest);
        });
 
        Scene view = new Scene(display, 640, 480);
        ikkuna.setScene(view);
        ikkuna.show();
    }
 
    private void updateChart(double monthlySavings, double interestRate, XYChart.Series savings, XYChart.Series savingsWithInterest) {
        savings.getData().clear();
        savingsWithInterest.getData().clear();
 
        savings.getData().add(new XYChart.Data(0, 0));
        savingsWithInterest.getData().add(new XYChart.Data(0, 0));
 
        double previous = 0;
 
        for (int i = 1; i <= 30; i++) {
            savings.getData().add(new XYChart.Data(i, i * monthlySavings * 12));
 
            previous += monthlySavings * 12;
            previous *= (1 + interestRate / 100.0);
 
            savingsWithInterest.getData().add(new XYChart.Data(i, previous));
        }
    }
 
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
        System.out.println("Hello world!");
    }
 
}
*/
