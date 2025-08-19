/* Author: Tyerone Chen
   Create Date: 4/7/2025
*/

public abstract class OoMe {
   /* Shared Files
      Protected Files - Only accesible within this class, subclasses, or classes in the same package
   */
   protected String name;
   protected int age;
   protected String talent;
   
   /* Constructor w/ Params
      @param String in_name - Input Name of the Person
      @param int in_age - Input Age of the Person
      @param String in_talent - Input Talent of the Person
   */
   public OoMe(String in_name, int in_age, String in_talent){
      this.name = in_name;
      this.age = in_age;
      this.talent = in_talent;
   }
   
   // Getters and Setters
   
   /* getName() Method
      @return - name of the person
   */
   public String getName(){
      return name;
   }
   
   /* getAge() Method
      @return - age of the person
   */
   public int getAge(){
      return age;
   }
   
   /* getTalent() Method
      @return - talent of the person
   */
   public String getTalent(){
      return talent;
   }
   
   // Overide the orignial toString default object class method of toString();
   // toString() method
   /*
      @return - the Name, Age, and Telent of the Person
   */
   @Override
   public String toString(){
      return "Name: " + name + "\tAge: " + age + "\t  Talent: " + talent;
   }
   
   public abstract void youDoYou();
}