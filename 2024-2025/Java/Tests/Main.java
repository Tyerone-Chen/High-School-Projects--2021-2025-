public class Main{
   public static void main(String[] args){
      // Generate a instance with a constructor that has a parameters
      Me john_doe = Me.getInstance("John Doe", 25, Me.States.ACTIVE);
      // Check all values are proper to the parameters
      System.out.println("Name: " + john_doe.getPersonName());
      System.out.println("Age: " + john_doe.getPersonAge());
      System.out.println("State: " + john_doe.getPersonState());
      
      // Grabs the already intitated Me instance
      Me tyerone_chen = Me.getInstance();
      // Checks to make sure the values are still the same
      System.out.println("Name: " + tyerone_chen.getPersonName());
      System.out.println("Age: " + tyerone_chen.getPersonAge());
      System.out.println("State: " + tyerone_chen.getPersonState());
      
      // Check to make sure the set method works
      tyerone_chen.setPersonName("Tyerone Chen");
      System.out.println("Name: " + tyerone_chen.getPersonName());
   }
}