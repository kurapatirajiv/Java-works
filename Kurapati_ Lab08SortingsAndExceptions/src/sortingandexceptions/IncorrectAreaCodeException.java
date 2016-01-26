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
public class IncorrectAreaCodeException extends Exception {

    /**
     *
     */
    public IncorrectAreaCodeException() {
    }

    /**
     *
     * @param string
     */
    public IncorrectAreaCodeException(String string) {
        super(string);
    }

}
