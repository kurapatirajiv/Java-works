/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingandexceptions;

/**
 *
 * @author Rajiv Kurapati
 */
public class IncorrectYearsException extends Exception {

    /**
     *
     */
    public IncorrectYearsException() {
    }

    /**
     *
     * @param string
     */
    public IncorrectYearsException(String string) {
        super(string);
    }

}
