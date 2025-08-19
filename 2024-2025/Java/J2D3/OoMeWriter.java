import java.io.*;
import java.util.ArrayList;

/**
 * The OoMeWriter class is responsible for managing a list of OoMe employees
 * and writing this list to a file.
 * 
 * <p>This class provides methods to add employees to the list and to write
 * the list to a file using serialization.</p>
 * 
 * 
 * Date: 4-3-25
 * Author: Ben V.
 */
public class OoMeWriter {

    private ArrayList<OoMe> employees = new ArrayList<>();

    /**
     * Adds an OoMe employee to the list.
     * 
     * @param employee the OoMe employee to be added
     */
    public void add(OoMe employee){
        employees.add(employee);
    }

    /**
     * Writes the list of employees to a file named "employees.dat".
     * The list is serialized using an ObjectOutputStream.
     */
    public void writeToFile(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.dat"))){
            out.writeObject(employees);
            System.out.println("Employees saved to file");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}