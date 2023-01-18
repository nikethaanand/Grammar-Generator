import static org.junit.jupiter.api.Assertions.*;

import Exceptions.UndefinedInputException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;

class GrammarProcessorTest {

  private GrammarProcessor grammarTest;
  private JsonParser jsonParseTest;
  private HashMap<String, List<String>> grammarMapTest;

  @BeforeEach
  void setUp(){
    grammarTest = new GrammarProcessor();
    jsonParseTest = new JsonParser();

  }


  @Test
  void contentProcessorTest() throws IOException, ParseException, UndefinedInputException {
    JSONObject grammar = jsonParseTest.load("./grammarTemplates/poem_grammar.json");
    HashMap<String, List<String>> grammarMap = jsonParseTest.grammarParse(grammar);
    Assertions.assertThrows(UndefinedInputException.class, () -> grammarTest.contentProcessor("abc", grammarMap));
    //System.out.println(grammarTest.contentProcessor("start", grammarMap));
    Assertions.assertNotEquals(grammarTest.contentProcessor("start", grammarMap), grammarTest.contentProcessor("adverb", grammarMap));
  }

  @Test
  void numberGenerator() {

    Assertions.assertEquals(0, grammarTest.randomOptionGenerator(1));
    Assertions.assertNotEquals(grammarTest.randomOptionGenerator(10), 20);
  }


  @Test
  void testToString() {
    GrammarProcessor grammarStringObject = new GrammarProcessor();
    Assertions.assertEquals(grammarStringObject.toString(), grammarTest.toString());
  }


  @Test
  void testHashCode() {
    GrammarProcessor grammarHashObject = new GrammarProcessor();
    Assertions.assertNotEquals(grammarHashObject.hashCode(), grammarTest.hashCode());
  }

  @Test
  void testEquals() {
    GrammarProcessor grammarEqualsObject = new GrammarProcessor();
    Assertions.assertNotEquals(grammarEqualsObject, grammarTest);
  }
}