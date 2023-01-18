import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/** Class JsonParser loads Json file
 * @author nikethaanand-divyadharshini
 */
public class JsonParser {


    private JSONObject grammar;

    /**
     * load function fetches the Json file from the path entered by user and returns the file as a Jsonobject
     * @param filePath grammar file to be loaded
     * @return Jsonobject which contains Json file as a Json object
     * @throws IOException when exception occurs due to Arraylist
     * @throws ParseException when the Json File cannot be parsed
     */
    public JSONObject load(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath))
        {
            grammar = (JSONObject) jsonParser.parse(reader);
            List<String> keys = new ArrayList<>(grammar.keySet());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return grammar;

    }

    /**
     * grammarParse removes few tags from the Jsonobject and loads other values in a Hashmap and is returned
     * @param jsonContent jsonContent contains the Json file as an object
     * @return hashmap which contains key as the tag and vallue as values inside the tag
     */
    public HashMap<String, List<String>> grammarParse(JSONObject jsonContent) {
        jsonContent.remove("grammarTitle");
        jsonContent.remove("grammarDesc");
        HashMap<String, List<String>> grammarMap = new HashMap();

        List<String> keys = new ArrayList<>(jsonContent.keySet());
        for (String definition : keys) {
            JSONArray production = (JSONArray) grammar.get(definition);
            grammarMap.put(definition.toLowerCase(), production);
        }
            return grammarMap;
        }
    }

