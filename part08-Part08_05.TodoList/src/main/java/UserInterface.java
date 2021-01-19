
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrewvijay
 */
public class UserInterface {
    
    private Scanner scanner;
    private TodoList list;

    public UserInterface(TodoList list, Scanner scanner) {
        this.scanner = scanner;
        this.list = list;
    }
    
    public void start() {
        
        while(true) {
            
            System.out.print("Command: ");
            String command = scanner.nextLine();
            
            if(command.equals("stop")) {
                break;
            }
            
            if(command.equals("add")) {
                this.add();
                continue;
            }
            
            if(command.equals("list")) {
                this.list();
                continue;
            }
            
            if(command.equals("remove")) {
                this.remove();
            }
        }
    }
    
    public void remove() {
        System.out.print("Which one is removed? ");
        int index = Integer.valueOf(scanner.nextLine());
        this.list.remove(index);
    }
    
    public void list() {
        this.list.print();
    }
    
    public void add() {
        System.out.print("To add: ");
        String task = scanner.nextLine();
        this.list.add(task);
    }
}
