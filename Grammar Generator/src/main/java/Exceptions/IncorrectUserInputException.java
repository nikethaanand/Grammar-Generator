package Exceptions;

/**
 * IncorrectUserInputException is an exception class that prints the error message
 * @author  nikethaanand-divyadharshini
 */
public class IncorrectUserInputException extends Exception{

    /**
     * Error message printed when input entered by user is not valid.
     * @param message error message
     */
    public IncorrectUserInputException(String message) {

        super(message);
    }
}
