package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class PartiesApplication extends Application{

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    private static Map<Integer, Double> getYearAndPercent(String[] words, int[] years) {
        Map<Integer, Double> yearAndPercent = new HashMap<>();
        
        for(int i = 1; i < words.length; i++) {
            if(words[i].equals("-")) {
                //yearAndPercent.put(years[i-1], 0.0);
                continue;
            }
            yearAndPercent.put(years[i-1], Double.valueOf(words[i]));
        }
        
        return yearAndPercent;
    }

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of the parties");
        
        Map<String, Map<Integer, Double>> values = getData();
        
        System.out.println(values.toString());
        values.keySet().stream()
                .forEach((party) -> {
                    XYChart.Series data = new XYChart.Series();
                    data.setName(party);
                    
                    values.get(party).entrySet()
                            .stream().forEach((pair) -> {
                                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                            });
                    lineChart.getData().add(data);
                });
        
        
        Scene view = new Scene(lineChart);
        window.setScene(view);
        window.show();
    }
    
    private static Map<String, Map<Integer, Double>> getData() {
        Map<String, Map<Integer, Double>> partiesAndData = new HashMap<>();
        Map<Integer, Double> yearAndPercent = new HashMap<>();
        
        try(Scanner fReader = new Scanner(Paths.get("partiesdata.tsv"))) {
            String firstLine = fReader.nextLine();
            String[] parts = firstLine.split("\t");
            int[] years = new int[parts.length - 1];
            for(int i = 0; i < years.length; i++) {
                years[i] = Integer.valueOf(parts[i+1]);
            }
            
            while(fReader.hasNextLine()) {
                String line = fReader.nextLine();
                String[] words = line.split("\t");
                String partyName = words[0];
                partiesAndData.put(partyName, getYearAndPercent(words, years)); 
                System.out.println(partiesAndData.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return partiesAndData;
    }
    //Slider slider = new Slider();
}
