/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Rajiv Kurapati
 */
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
        //1. Create an object named 'familyHealth' of the FamilyHealthInsurance
        //class and pass the int argument value as 4.
        FamilyHealthInsurance familyHealth = new FamilyHealthInsurance(4);
        //2. Declare and initialize a Scanner object named 'scanner' to read
        //from the file Person.txt 

        Scanner scanner = new Scanner(new File("Person.txt"));

        //3. Declare double variable to stores age, String variable to stores
        //first Name, String variable to stores last name, String variable to 
        //store gender.
        double age;
        String firstName, lastName, gender;

        //4. while Person.txt has more data {
        //  Read in the data, and store them to the respective variables.
        //  Create an object named 'person' of the Person class  
        //  and pass the read values as parameters.
        //  Print the 'person' object
        //  Pass the 'person' object as parameter for familyHealth.addPerson()
        //  For example: familyHealth.addPerson();
        //  Note: Write the above statement using try and catch block. Mention 
        //  the appropriate exception in catch block and print the exception.
        //  }
        System.out.println("toString method of Person class:");
        while (scanner.hasNext()) {

            age = scanner.nextInt();
            firstName = scanner.next();
            lastName = scanner.next();
            gender = scanner.next();
            Person person = new Person(age, firstName, lastName, gender);
            System.out.println(person.toString());
            try {
                familyHealth.addPerson(person);
            } catch (IllegalFamilyMemberException ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.println("*************************************************");

        //5. Print the "Monthly installment in Family health insurance class: $"
        //using 'familyHealth' object.
        // Note: Limit the output of calcMonthlyInstallment() to 2 decimal
        //points.
        System.out.println("Testing the calcMontlyInstallment() of "
                + "FamilyHealthInsurance:");

        System.out.println("Monthly installment in Family health insurance class: $"
                + String.format("%.2f", familyHealth.calcMontlyInstallment()));

        //6. Print the "Yearly installment in Family health insurance class: $"
        //  using 'familyHealth' object
        // Note: Limit the output of calcYearlyInstallment() to 2 decimal points.
        System.out.println("\nTesting the calcYearlyInstallment() "
                + "of FamilyHealthInsurance :");
        System.out.println("Yearly installment in Family health insurance class: $"
                + String.format("%.2f", familyHealth.calcYearlyInstallment()));
        //7. Print the "Life insurance in Family health insurance class: $" 
        //  using 'familyHealth' object
        //      For example: familyHealth.calcLifeInsurance(42);
        //  Note: Write the above statement using try and catch block. Mention 
        //  the appropriate exception in catch block and print the exception.
        //  Note: Limit the output of calcLifeInsurance() to 2 decimal points.
        System.out.println("\nTesting the calcLifeInsurance() "
                + "of FamilyHealthInsurance:");

        try {
            System.out.println("Life insurance in Family health insurance class: $"
                    + String.format("%.2f", familyHealth.calcLifeInsurance(42)));
        } catch (IncorrectMonthException ex) {
            System.out.println(ex.getMessage());
        }

        //8. Print the "Exemption in life insurance in Family health insurance class: $"
        //  using the 'familyHealth' object
        //      For example: familyHealth.calcExemption(40));
        //  Note: Write the above statement using try and catch block. Mention 
        //  the appropriate exception in catch block and print the exception.
        //  Note: Limit the output of calcExemption() to 2 decimal points.
        System.out.println("\nTesting the calcExemption() of "
                + "FamilyHealthInsurance:");
        try {
            System.out.println("Exemption amount in life insurance in Family health Insurance: $"
                    + String.format("%.2f", familyHealth.calcExemption(40)));
        } catch (IncorrectMonthException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*********************************************");
        //9. Print the "toString method of FamilyHealthInsurance:"

        System.out.println("\ntoString method of FamilyHealthInsurance:");
        System.out.println(familyHealth);
        System.out.println("*********************************************");

        // Create an object named 'person1' of the Person class and pass parameter
        //  6.0, "Calton", "James", "Male"
        //
        Person person1 = new Person(6.0, "Calton", "James", "Male");
        //Polymorphic substitution
        //10.Create an Health object reference 'health' and refer it to 
        // an object of type PersonalHealthInsurance and pass 'person1' as parameter.
        //Late Binding Polymorphism

        Health health = new PersonalHealthInsurance(person1);

        //11. Print the "Monthly installment in Personal health insurance class: $"
        // using the 'health' object reference.
        // Note: Limit the output of calcMontlyInstallment() to 2 decimal points.
        System.out.println("\nTesting the calcMontlyInstallment() "
                + "of PersonalHealthInsurance:");
        System.out.println("Monthly installment in Personal health insurance class: $"
                + String.format("%.2f", health.calcMontlyInstallment()));
        //12. Print the "Yearly installment in Personal health insurance class: $"
        // using the 'health' object reference.
        // Note: Limit the output of calcYearlyInstallment() to 2 decimal points.
        System.out.println("\nTesting the calcYearlyInstallment() of "
                + "PersonalHealthInsurance:");
        System.out.println("Yearly installment in Personal health insurance class: $"
                + String.format("%.2f", health.calcYearlyInstallment()));
        //13. Print the "Life insurance in Personal health insurance class: $" 
        // using the 'health' object
        // For example: health.calcLifeInsurance(42);
        // Note: Write the above code using try and catch block. Mention 
        // the appropriate exception in catch block and print the exception.
        // Note: Limit the output of calcLifeInsurance() to 2 decimal points.
        System.out.println("\nTesting the calcLifeInsurance() "
                + "of PersonalHealthInsurance:");
        try {
            System.out.println("Life insurance in Personal health insurance with Exemption: $"
                    + String.format("%.2f", health.calcLifeInsurance(42)));
        } catch (IncorrectMonthException ex) {
            System.out.println(ex.getMessage());
        }
        //14. Print the "Exemption in life insurance in Personal health insurance class: $"
        // using 'health' object
        // For example: health.calcExemption(40));
        // Note: Write the above code using try and catch block. Mention 
        //  the appropriate exception in catch block and print the exception.
        // Note: Limit the output of calcExemption() to 2 decimal points.
        System.out.println("\nTesting the calcExemption() of "
                + "PersonalHealthInsurance:");
        try {
            System.out.println("Exemption amount in life insurance in Personal health insurance: $"
                    + String.format("%.2f", health.calcExemption(40)));
        } catch (IncorrectMonthException ex) {
            System.out.println(ex.getMessage());
        }
        // Casting Objects
        //15. Create an FamilyHealthInsurance object 'familyCasting' and 
        // refer it to an object type of JointFamilyInsurance and pass the 
        // int argument as 3.

        FamilyHealthInsurance familyCasting = new JointFamilyInsurance(3);

        //16. Create an JointFamilyInsurance object 'jointCasting' and
        // refer it to 'familyCasting' object and cast it.
        JointFamilyInsurance jointCasting = (JointFamilyInsurance) familyCasting;

        //17. Create an FamilyHealthInsurance object variable 'familyCasting2' and
        // refer it to an object type of NuclearFamilyInsurance and pass the 
        // int argument as 3.
        FamilyHealthInsurance familyCasting2 = new NuclearFamilyInsurance(3);

        //18. Create an NuclearFamilyInsurance object 'nuclearCasting'
        // and refer it to 'familyCasting2' object and cast it.
        NuclearFamilyInsurance nuclearCasting = (NuclearFamilyInsurance) familyCasting2;

        //19. Create an PersonalHealthInsurance object 'personalInsurance' and pass
        // the 'person1' object as parameter.
        PersonalHealthInsurance personalInsurance = new PersonalHealthInsurance(person1);
        // Print the "toString method of PersonalHealthInsurance:"
        System.out.println("*********************************************");
        System.out.println("\ntoString method of PersonalHealthInsurance:");

        System.out.println(personalInsurance.toString());

        //20 .Uncomment the below code.You can observe exceptions on the console. 
        // Explain each exception in the comment after the statement where the 
        // exception occurs with your own words.
        try {
            familyHealth.addPerson(person1);
            // We recieve a ArrayIndexOutOfBoundsException as we have max length of the array as 4 which is
            // already occupied adding a new element gives us the array out of bound exception which means the 
            // arrray cannot accomidate any new value 
            // So, addPerson method shall throw a IllegalFamilyMemberException exception. we catch an exception and display the error message "IllegalFamilyMemberException : The Persons count in the list is exceeding the size of the array"
            // and continue with the program 

        } catch (IllegalFamilyMemberException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            familyHealth.calcLifeInsurance(-10);
        } catch (IncorrectMonthException ex) {
            System.out.println(ex.getMessage());
            // Since the passed total months count -10 is a invalid number the method calcLifeInsurance() throws an IncorrectMonthException. This exception 
            //is caught and a error message is displayed "IncorrectMonthException : The Total months are less than Zero" and continue with the program
        }
        try {
            health.calcExemption(-20);
            // Since the passed total months count -20 is a invalid number the method calcExemption() throws an IncorrectMonthException from the class PersonalHealthInsurance. This exception 
            //is caught and a error message is displayed "IncorrectMonthException : The Total months are less than Zero" and continue with the program
        } catch (IncorrectMonthException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
