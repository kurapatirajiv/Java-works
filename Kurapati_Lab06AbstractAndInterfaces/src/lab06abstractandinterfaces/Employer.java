/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06abstractandinterfaces;

/**
 * Employer interface definition
 * @author S525252
 */
public interface Employer {
    /**
     * An abstract method to get the number of employees
     * @return returns the number of employees
     */
    public abstract int getNumOfEmployees();
    /**
     * Sets the number of employees
     * @param number the number of employees
     */
    public abstract void setNumOfEmployees(int number);
}
