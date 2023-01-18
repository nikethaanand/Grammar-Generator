import Exceptions.IncorrectUserInputException;
import Exceptions.UndefinedInputException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class UserInputTest {

    UserInput user=new UserInput();

    @BeforeEach
    void setup() throws UndefinedInputException, IncorrectUserInputException, IOException, ParseException {
    }

    @Test
    void testToString() {
        UserInput userInputTest = new UserInput();
        Assertions.assertNotEquals(user, userInputTest);
        Assertions.assertEquals(userInputTest.toString(), user.toString());
    }

    @Test
    void testToHashcode(){
        UserInput userInputTest = new UserInput();
        Assertions.assertNotEquals(userInputTest.hashCode(), user.hashCode());
    }

    @Test
    void testEquals(){
        UserInput userInputTest = new UserInput();
        Assertions.assertNotEquals(userInputTest, user);
    }
}