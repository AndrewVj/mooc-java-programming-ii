
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while(true) {
            String row = scanner.nextLine();
            if(row.equals("end")) {
                break;
            }
            inputs.add(row);
        }
        
        System.out.println("\nPrint the average of the negative numbers or the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        if(choice.contains("n")) {
            double avgOfNegativeNums = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number < 0)
                    .average()
                    .getAsDouble();

            System.out.println("Average of the negative numbers: "+avgOfNegativeNums);
        }
        
        if(choice.equals("p")) {
            double avgOfPositiveNums = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number > 0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Average of the positive numbers: "+avgOfPositiveNums);
        }
        // toteuta ohjelmasi tänne

    }
}
