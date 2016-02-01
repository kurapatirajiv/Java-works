/*
 * Faculty class determining the core attributes and methods of a faculty
 * 
 */
package faculty;

/**
 * Class pertaining faculty attributes and the methods of the same
 * @author rajiv kurapati
 */
public class Faculty {
    private String firstName;
    private String lastName;
    private double salary;
    private static int totalFaculty = 0;
   /**
    * Faculty class constructor to initialize the member of the faculty
    * @param firstName First name of the faculty
    * @param lastName Last name of the faculty
    * @param salary salary of the faculty
    */
    public Faculty(String firstName, String lastName,double salary){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.salary    = salary;
        totalFaculty+=1;
    }
    /**
     * Faculty class constructor to initialize the member of the faculty
     * @param firstName First name of the faculty
     * @param lastName Last name of the faculty
     */
    public Faculty(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName  = lastName;
        salary    = 0.0;
        totalFaculty+=1;
    }
    /**
     * Faculty class no argument constructor , does nothing
     */
    public Faculty()
    {
    }
    /**
     * This method returns the salary of the faculty
     * @return salary of the faculty
     */
    public double getSalary(){
        return salary;
    }
    /**
     * This method sets the salary of the faculty
     * @param salary Salary of the faculty
     */
    public void setSalary(double salary){
        this.salary=salary;  
    }
    /**
     * This method returns the total count of the faculty
     * @return total faculty members
     */
    public int getTotalFaculty(){
        return(totalFaculty);
    }
    /**
     * This methods returns the list of Faculty details 
     * @return A string with the Faculty name and salary details
     */
    @Override
    public String toString(){
        return("Name: " + firstName + " " + lastName + "; " + "Salary: $" + salary + "\n");
    } 
    
}
