package prototype;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author Taylor
 */
public abstract class Prototype {
    
      
  public static void read() {
     try {
      File myObj = new File("C:\\Users\\Taylor\\Documents\\NetBeansProjects\\CppApplication_1\\The5UselessAlarmsYouSnoozeInTheMorning\\src\\prototype\\prototype.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      }
      }
   
public static void write() throws IOException{
Scanner input = new Scanner(System.in);
        
     FileWriter myWriter  = new FileWriter("C:\\Users\\Taylor\\Documents\\NetBeansProjects\\CppApplication_1\\The5UselessAlarmsYouSnoozeInTheMorning\\src\\prototype\\prototype.txt");

     System.out.print("Write something to file: ");
    String s = input.next();
    
myWriter.write(s);

    

           
      myWriter.close();
      System.out.println("Successfully wrote to the file."); }
    public static void main(String[] args) throws IOException {
        
        
  write();
        System.out.println("File contents :");
        read();
     
    }
}
