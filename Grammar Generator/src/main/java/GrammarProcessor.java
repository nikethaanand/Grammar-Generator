import Exceptions.UndefinedInputException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class GrammarProcessor used to process Json File and load random sentences
 * @author nikethaanand-divyadharshini
 */
public class GrammarProcessor {
    /**
     * contentProcessor checks if the attribute is found in grammarInput,if not found exception is thrown. When it is found
     * randomOptionGenerator is used to get a random value for grammarInput value.Redux is used to get the tag from grammarInput
     * While loop and recursion is used until the generated sentence does not have a tag. Incase any tag is not found in the Json
     * file an exception is thrown and exited from the Loop.The replaceVal is returned to UserInput
     *
     * @param attribute attribute is the Tag name that has to be fetched from the Json file
     * @param grammarInput is a hashmap that contains the tag name as key and value as words inside the Json tag
     * @return replaceVal which is the sentence generated using randomOptionGenerator
     * @throws UndefinedInputException when a tag is not found in the Json file
     */
    public String contentProcessor(String attribute, HashMap<String, List<String>> grammarInput) throws UndefinedInputException {
        if (grammarInput.isEmpty()) {
            String exceptionMessage ="Input .json file cannot be Empty";
            throw  new UndefinedInputException(exceptionMessage);
        }

        if (grammarInput.containsKey(attribute)) {
            List<String> values = grammarInput.get(attribute);
            String value = values.get(randomOptionGenerator(values.size()));
            String replaceVal = value;
            Pattern pattern = Pattern.compile("(?<=\\<).+?(?=\\>)");
            Matcher matcher = pattern.matcher(value);
            while (matcher.find()) {
                String group = '<'+matcher.group()+'>';
                replaceVal = replaceVal.replaceAll(group, contentProcessor(matcher.group(), grammarInput));
            }
            return replaceVal;
        } else {
            String exceptionMessage ="The given .json file does not contain <"+attribute+"> tag";
            throw new UndefinedInputException(exceptionMessage);
        }

    }

    /** randomOptionGenerator generated a random int value within the size
     *
     * @param size size of Arraylist given as input
     * @return a number in the range
     */

    public int randomOptionGenerator(int size) {
        Random number = new Random();
        return number.nextInt(size);
    }

    @Override
    public String toString() {
        return "GrammarProcessor{}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
