/* Author: Tyerone Chen
   Create Date: 4/7/2025
*/

import java.io.Serializable;

// Extension of OoMe Class
public class OoTyerone extends OoMe implements Serializable {
   // Define a new variable specific to this class
   private String interest;
   
   // Define a Singleton Instance of this class
   private static final OoTyerone instance = new OoTyerone();
   
   /* Default Constructor
      Uses defualt constructor of the super class to set values
      Set custom variable value
   */
   private OoTyerone() {
      super("Tyerone Chen", 17, "Develop Logic");
      this.interest = "Reading Documentation";
   }
   
   /* Instance handeler
      @return - instance of this class
   */
   public static OoTyerone getInstance(){
      return instance;
   }
   
   // Unique Methods
   /* syaPhrase() method 
      Prints out an odd phrase
   */
   private void sayPhrase(){
      System.out.println("Potato, Potato");
   }
   
   /* Rewrite default toString() method
      Defines new custom behavior for this class
   */
   @Override
   public String toString(){
      return super.toString() + "\tInterest: " + interest; 
   }
   
   /* Rewrite defualt youDoYou() method from OoMe
      Defines new custom behavior for this class
   */
   @Override 
   public void youDoYou() {
      System.out.println(name + " can " + talent + " and likes " + interest);
      sayPhrase();
   }
}