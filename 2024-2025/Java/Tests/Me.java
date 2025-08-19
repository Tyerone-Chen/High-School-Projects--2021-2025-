/*
   // Author: Tyerone Chen
   // Init Create Date: 4/3/2025
   // Last Update Date: 4/3/2025
   
   // Class Desc:
      // A class to help save the data around a person, such as their name, age, and status
*/
public class Me {
   // Fields
   String person_name;
   int person_age;
   enum States { NAN, ASLEEP, AWAKE, TIRED, ACTIVE, HUNGRY, HAPPY };
   States person_state;
   private static Me instance; // Singleton Instance
   
   // Default Constructor
      // Sets default value of person_name, person_age, and person_state
   private Me(){
      person_name = "Unknown";
      person_age = 0;
      person_state = States.NAN;  
   }
   
   /*
      Constructor w/Parameters
      @param input_name = String that takes in name
      @param input_age = int that takes in age
      @param input_state = enum States that take in an inputed state value from the enum States  
   */
   private Me(String input_name, int input_age, States input_state){
      this.person_name = input_name;
      this.person_age = input_age;
      this.person_state = input_state;
   }
   
   /* Get instance
      @return if no instance exists, create a new one
      @return a prexistating instance and its values
   */
   public static Me getInstance(){
      if (instance == null){
         instance = new Me();
      }
      return instance;
   }
   /* Get instance
      @return if no instance exists, create a new one with the given parameters
      @return a prexistating instance and its values
   */
   public static Me getInstance(String input_name, int input_age, States input_state){
      if (instance == null){
         instance = new Me(input_name, input_age, input_state);
      }
      return instance;
   }
  
   // Setters
   
   /* Set person name
      @param input_name = String that takes in a given String
   */
   public void setPersonName(String input_name){
      this.person_name = input_name;
   }
   
   /* Set person age
      @param input_name = int that takes in a given int
   */
   public void setPersonAge(int input_age){
      this.person_age = input_age;
   }
   
   /* Set person state
      @param input_name = enum States that takes in a given enum States value
   */
   public void setPersonaState(States input_state){
      this.person_state = input_state;
   }

   // Getters
   
   /* Returns person name
      @return String currently stored at person_name
   */
   public String getPersonName(){
      return person_name;
   }
   
   /* Returns person age
      @return int currently stored at person_age
   */
   public int getPersonAge(){
      return person_age;
   }
   
   /* Returns person state
      @return enum States currently stored at person_state
   */
   public States getPersonState(){
      return person_state;
   }
}
