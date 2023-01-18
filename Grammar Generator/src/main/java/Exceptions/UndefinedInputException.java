package Exceptions;
/**
 * UndefinedInputException is an exception class that prints the error message
 * @author  nikethaanand-divyadharshini
 */

public class UndefinedInputException extends  Exception{
    /**
     * Error message printed when exception arrises in Json file
     * @param message error message
     */
    public UndefinedInputException(String message) {

        super(message);
    }
}
