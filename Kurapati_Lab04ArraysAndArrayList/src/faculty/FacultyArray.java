/*
 * This is a Array implementation of the faculty class
 */
package faculty;

/**
 *Class pertaining array  implementation of Faculty
 * @author rajiv kurapati
 */
public class FacultyArray {
    private Faculty[] facultyArray;
    private int numberOfFaculty;
    private final int MAX = 100;
    /**
     * FacultyArray constructor which sets the maximum list of faculty members
     */
    public FacultyArray(){
        facultyArray = new Faculty[MAX];
        numberOfFaculty =0;
    }
    /**
     * This method adds the faculty to the faculty array at the end of the array taking the faculty object 
     * @param facultyIn The faculty object that is passed from main class
     * @return returns true on successful addition of the faculty
     */
    public boolean addFaculty(Faculty facultyIn){
        
        if(numberOfFaculty < MAX){
           facultyArray[numberOfFaculty] = facultyIn;
           numberOfFaculty++;
           return(true);
        }
        else{
           return(false);
        } 
    }
    /**
     * This method adds the faculty to the faculty list taking the faculty object and the position of insert
     * @param facultyPosition
     * @param faculty
     * @return returns true on successful addition of the member
     */
    public boolean addFaculty(int facultyPosition, Faculty faculty){
       if(numberOfFaculty < MAX && facultyPosition <= numberOfFaculty ){
           
          for(int j=numberOfFaculty;j>=facultyPosition;j--){
              
              facultyArray[j+1] = facultyArray[j];
           }    
           facultyArray[facultyPosition] = faculty;
           numberOfFaculty++;
           return(true);
        }
        else{
           return(false);
        }      
    }
    /**
     * Removes the faculty based on the position passed from the main class
     * @param facultyPosition
     * @return returns true on successful removing of the faculty
     */
    public boolean removeFaculty(int facultyPosition){
        
        if(facultyPosition >=numberOfFaculty || facultyPosition < 0){
            return false;
        }
        else{
            for(int j=facultyPosition;j<numberOfFaculty;j++){
              
              facultyArray[j] = facultyArray[j+1];
           }    
           numberOfFaculty--;
           return(true);  
        }
    }
    /**
     * This methods returns the number of faculty members in the list
     * @return number of faculty members
     */
    public int getNumberOfFaculty(){
     return(numberOfFaculty);   
    }
    /**
     * This method finds the average salary of the total faculty members
     * @return the average of the salary
     */
    public double findAverageSalary(){
         double sum=0.0;
        if(numberOfFaculty<0){
            return(0.0);
        }
        else{         
            for (int i=0;i<numberOfFaculty;i++) {
                sum += facultyArray[i].getSalary(); 
            }
            sum =(sum/numberOfFaculty);
            return(sum);
              
        }
    }
    /**
     * This methods returns the list of Faculty details 
     * @return A string with the Faculty name and salary details
     */
    @Override
    public String toString(){    
        String facList= "";
        for(int i=0;i<numberOfFaculty;i++){
            facList =facList.concat(facultyArray[i].toString());
        }
        return(facList);        
    }
    
}

    