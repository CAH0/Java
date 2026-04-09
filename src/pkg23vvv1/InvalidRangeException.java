/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23vvv1;

/**
 *
 * @author aleksandr
 */
public class InvalidRangeException extends Exception {
    double errVal;
    
    public double getErrVal(){
        return errVal;
    }
    
    public InvalidRangeException(String message, double num){
        super(message);
        errVal = num;
    }
    
    public InvalidRangeException(String message){
        super(message);
    }
}
