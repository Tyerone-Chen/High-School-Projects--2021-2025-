import java.io.*;
import java.util.ArrayList;

/**
   OoMeRead Class - Responsible for reading the employees.dat file written by OoMeWrite
   Prints each value held in employees.dat

   Date: 4/8/25
   Authors: Tyerone C. & Jake R. 
 */

public class OoMeReader {
   /* 
   */
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            ArrayList<OoMe> loadedPeople = (ArrayList<OoMe>) in.readObject();

            for (OoMe person : loadedPeople) {
                System.out.println(person);
            }

        } catch (IOException | ClassNotFoundException err) {
            err.printStackTrace();
        }
    }
}
