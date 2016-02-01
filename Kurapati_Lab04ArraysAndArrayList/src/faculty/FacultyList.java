/*
 * This is a ArrayList implementation of the faculty class
 */
package faculty;

import java.util.ArrayList;

/**
 * Class pertaining array list implementation of Faculty
 * @author rajiv kurapati
 */
public class FacultyList {
    private ArrayList<Faculty> facultyArrayList;
    /**
     * FacultyList constructor which creates a dummy array list of empty members
     */
    public FacultyList(){
       facultyArrayList = new ArrayList<>();
        
    }
    /**
     * Adds the faculty object to the array list at the end of the list
     * @param faculty
     * @return returns true on successful addition of a faculty
     */
    public boolean addFaculty(Faculty faculty){
        return(facultyArrayList.add(faculty));
    }
    /**
     * Adds the faculty object at the defined position in the list
     * @param facultyPosition the position at which faculty to be added
     * @param faculty faculty object that is added
     * @return returns true on successful addition of a faculty
     */
    public boolean addFaculty(int facultyPosition, Faculty faculty){
        
        if(facultyPosition > facultyArrayList.size() || facultyPosition < 0){
            return false;
        }
        else {
            facultyArrayList.add(facultyPosition, faculty);
            return true;
        }
    }
    /**
     * Removes the faculty at the defined position
     * @param facultyPosition the position of the faculty at which the member should be removed
     * @return returns true when a member is successfully removed
     */
    public boolean removeFaculty(int facultyPosition) {
        
        if(facultyPosition >= facultyArrayList.size() || facultyPosition < 0){
            return false;
        }
        else {
            facultyArrayList.remove(facultyPosition);
            return true;
        }
    } 
    /**
     * lists the number of faculty present in the faculty list
     * @return returns the number of faculty
     */
    public int getNumberOfFaculty(){
        return(facultyArrayList.size());
    }
    /**
     *  Computes the average salary of the faculty
     * @return Returns the average salary of the faculty
     */
    public double findAverageSalary(){
        
        if(facultyArrayList.size()<0){
            return(0.0);
        }
        else{
            double sum=0.0;
            for (Faculty facultyArrayList1 : facultyArrayList) {
                sum += facultyArrayList1.getSalary(); 
            }
            sum =(sum/facultyArrayList.size());
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
        for(int i=0;i<facultyArrayList.size();i++){
            facList =facList.concat(facultyArrayList.get(i).toString());
        }
        return(facList);        
    }
    
        
        
}
