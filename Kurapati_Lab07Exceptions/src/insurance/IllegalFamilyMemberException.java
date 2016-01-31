/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 * IllegalFamilyMemberException class implementation
 *
 * @author Rajiv kurapati
 */
public class IllegalFamilyMemberException extends Exception {

    /**
     * Creates a new instance of IllegalFamilyMemeberException without detail
     * message.
     */
    public IllegalFamilyMemberException() {

    }

    /**
     * Constructs an instance of IllegalFamilyMemeberException with the
     * specified detail message.
     *
     * @param msg The detail message
     */
    public IllegalFamilyMemberException(String msg) {
        super(msg);
    }

}
