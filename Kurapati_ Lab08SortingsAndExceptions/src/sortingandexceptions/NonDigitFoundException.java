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
public class NonDigitFoundException extends Exception {

    /**
     *
     */
    public NonDigitFoundException() {
    }

    /**
     *
     * @param string
     */
    public NonDigitFoundException(String string) {
        super(string);
    }

}
