
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("");
            System.out.println("First: "+first+"/100");
            System.out.println("Second: "+second+"/100");
            System.out.print("> ");
            
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int value = Integer.valueOf(parts[1]);
            
            if(command.equals("add")) {
                
                if(value < 0) {
                    continue;
                }
    
                first = first + value;
                
                if(first > 100) {
                    first = 100;
                }
                continue;
            }
            
            if(command.equals("move")) {
                
                if(value < 0) {
                    continue;
                }
                
                if(first - value < 0) {
                    value = first;
                }
                
                first = first - value;
                second = second + value;
                
                if(second > 100) {
                    second = 100;
                }
                continue;
            }
            
            if(command.equals("remove")) {
                
                if(value < 0) {
                    continue;
                }
                
                second = second - value;
                
                if(second < 0) {
                    second = 0;
                }
            }
        }
    }

}
