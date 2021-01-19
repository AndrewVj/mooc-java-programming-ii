
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("");
            System.out.println("First: "+first);
            System.out.println("Second: "+second);
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int value = Integer.valueOf(parts[1]);
            
            if(command.equals("add")) {
                first.add(value);
                continue;
            }
            
            if(command.equals("move")) {
                
                if(first.contains() - value < 0) {
                    value = first.contains();
                }
                first.remove(value);
                second.add(value);
                
                continue;
            }
            
            if(command.equals("remove")) {
                second.remove(value);
            }
        }
    }
}
