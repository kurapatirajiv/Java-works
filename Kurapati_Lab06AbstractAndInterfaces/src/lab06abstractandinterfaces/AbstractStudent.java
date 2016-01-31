package lab06abstractandinterfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Abstract student class 
 * @author S525252
 */
public abstract class AbstractStudent {

    private String nameOfStudent;
    private double annualTuition;

    /**
     *
     * @param nameOfStudent
     * @param annualTuition
     */
    public AbstractStudent(String nameOfStudent, double annualTuition) {
        this.nameOfStudent = nameOfStudent;
        this.annualTuition = annualTuition;
    }

    /**
     * Method to get the annual tuition fee
     * @return annual tuition fee
     */
    public double getAnnualTuition() {
        return annualTuition;
    }

    /**
     * Method to get the tuition fee
     * @return returns the tuition fee
     */
    public abstract double getTuition();
    /**
     * Method to print the name of the student and the annual tuition fee of the student
     * @return Returns name and annual tuition fee of the student
     */
    @Override
    public String toString() {
        return String.format("%-20s", nameOfStudent) + String.format("%10.2f", annualTuition);
    }

}
