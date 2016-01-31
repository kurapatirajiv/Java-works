/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 *
 * @author Rajiv kurapati
 */
public class Person {

    private double age;
    private String firstName;
    private String gender;
    private String lastName;

    /**
     * Implement the Parameterized constructor to initialize all the above
     * variables.
     *
     * @param age age
     * @param firstName firstName
     * @param lastName lastName
     * @param gender gender
     */
    public Person(double age, String firstName, String lastName, String gender) {
        this.age = age;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
    }

    /**
     * gets the age
     *
     * @return age
     */
    public double getAge() {
        return age;
    }

    /**
     * gets the first name
     *
     * @return first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * gets the gender of the person
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * gets the last name of the person
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the age of the person
     *
     * @param age age of the person
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * sets the first name of the person
     *
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * sets the gender of the person
     *
     * @param gender gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * sets the last name of the person
     *
     * @param lastName lastname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * All the private variable are separated by one space. Print the String
     * values left justified by 10 spaces and print the floating point values
     * right justified by 3 spaces with two number decimal values.
     * @return A string representation of details of the person.
     */
    @Override
    public String toString() {
        return String.format("%-10s", firstName) + " " + String.format("%-10s", lastName) + " " + String.format("%-10s", gender) + " " + String.format("%.2f", age);
    }

}
