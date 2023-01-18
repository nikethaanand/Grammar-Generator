import Exceptions.IncorrectUserInputException;
import Exceptions.UndefinedInputException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Class Main is the Class to be run while compiling
 * @author nikethaanand-divyadharshini
 */
public class Main {
    /**
     * @param args args
     * @throws IncorrectUserInputException when user does not enter a valid input
     * @throws IOException when exception occurs due to Arraylist
     * @throws ParseException when the Json File cannot be parsed
     * @throws UndefinedInputException when the Json file does not contain a tag
     */
    public static void main(String[] args) throws UndefinedInputException, IncorrectUserInputException, IOException, ParseException {
        UserInput processUserInput = new UserInput();
        processUserInput.test();
    }


    @Override
    public String toString() {
        return "Main{}";
    }
}

