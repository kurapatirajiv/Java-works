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
public class IncorrectMonthException extends Exception{
    /**
     * Creates a new instance of IncorrectMonthException without detail message.
     */
    public IncorrectMonthException(){
    /**
     * Constructs an instance of IncorrectMonthException with the specified detail message.
     *  msg - The detail message.
     */      
    }
    public IncorrectMonthException(String msg){
      super(msg);
    }
    
    
    
}
