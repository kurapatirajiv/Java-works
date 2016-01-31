/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06abstractandinterfaces;

/**
 * Student class implementation 
 * @author S525252
 */
public  class Student extends AbstractStudent implements Employee, Employer {

    private String nameOfInstitution;
    private int hoursWorked;
    private double hourlyRate;
    private int numOfEmployees;
    private int years;
    /**
     * Student class constructor
     * @param nameOfStudent Name of the Student
     * @param annualTuition annual Tuition 
     * @param years Number of years
     * @param nameOfInstitution Name of the Institution
     * @param hoursWorked Number of hours worked
     * @param hourlyRate Hourly Rate
     * @param numOfEmployees Number of Employees
     */
    public Student(String nameOfStudent,double annualTuition,int years,String nameOfInstitution,int hoursWorked,double hourlyRate,int numOfEmployees) {
        super(nameOfStudent, annualTuition);
        this.nameOfInstitution = nameOfInstitution;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.numOfEmployees = numOfEmployees;
        this.years = years;
    }
    /**
     * Method to retrieve the number of Employees
     * @return gets the number of employees
     */
    @Override
    public int getNumOfEmployees() {
        return numOfEmployees;
    }
    /**
     * Method to set the number of Employees
     * @param numOfEmployees number of employees
     */
    @Override
    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }
    /**
     * Method to retrieve the tuition of the student
     * @return gets the tuition fee of the student
     */
    @Override
    public double getTuition(){
        return years * super.getAnnualTuition();
    }
    /**
     * Method to retrieve the weekly salary 
     * @return gets the weekly salary of the employee
     */
    @Override
    public double getWeeklySalary(){
        return hourlyRate * hoursWorked * 7;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return super.toString()+" " +String.format("%4d", years)+" "+String.format("%-20s", nameOfInstitution) +" "+String.format("%4d", hoursWorked) + " " + String.format("%10.2f", hourlyRate) + " " + String.format("%4d", numOfEmployees);
    }

}
