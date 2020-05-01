package datastore;
/*
This class sole purpose is to create a UUID in order for you to manually enter it 
in the JFrame for the car entry 
@author Taylor Headen
Last updated 5/1/2020
*/
import java.util.UUID;

public class RandomUUIDGenerator{
    public static void main(String[] args) {
        
        // Creating a random UUID for the VIN 
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        System.out.println("Random UUID String = " + randomUUIDString);
      
    
    }
}