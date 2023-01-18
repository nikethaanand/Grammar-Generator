import Exceptions.IncorrectUserInputException;
import Exceptions.UndefinedInputException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;
import java.io.File;

/**
 * Class UserInput processes the input entered by user
 * @author nikethaanand-divyadharshini
 */
public class UserInput {
  private static final String grammarFolder = "/grammarTemplates";

  /**
   * Test Method is method that is called from the Main class, it loads all the Json files located in the grammarTemplates
   * folder by default. Displays the files and gets input from User via scanner class.When a valid input is entered by
   * the user the do while by default gets executed once.A sentence is printed and again asked if the user wants to continue.
   * If a user does not enter a valid input a IncorrectUserInputException exception is thrown
   *
   * @throws IncorrectUserInputException when user does not enter a valid input
   * @throws IOException when exception occurs due to Arraylist
   * @throws ParseException when the Json File cannot be parsed
   * @throws UndefinedInputException when the Json file does not contain a tag
   */
  public void test() throws IncorrectUserInputException, IOException, ParseException, UndefinedInputException  {
    String grammarName;
    List<String> filenameList = new ArrayList<>();
    Map<Integer, String> filenameMap=new HashMap<>();

    File filePath = new File((new File("").getAbsolutePath()+(grammarFolder)));
    File[] fileListArray = filePath.listFiles();
    for(int i=1;i<fileListArray.length;i++)
    {
      String fileName = fileListArray[i].getName();
      if (fileListArray[i].getName().endsWith(".json"))
      {
        filenameList.add(fileName.replaceAll(".json", ""));
        filenameMap.put(i,fileListArray[i].getPath());
      }
    }
    System.out.println(System.getProperty("user.dir"));
    int ct=0;
    while(ct!=1)
    {
      System.out.println("Loading grammars...");
      for(int i=0;i<filenameList.size();i++)
      {
        System.out.println(i+1+". "+filenameList.get(i));
      }
      System.out.println("Which would you like to use? (q to quit)");
      Scanner sc = new Scanner(System.in);
      grammarName=sc.nextLine();
      if(grammarName.equalsIgnoreCase("q"))
      {
        ct=1;
        System.exit(0);
      }
      else if (grammarName.matches("[0-9]+")) {
        String userOption;
        do {
          int temp = Integer.parseInt(grammarName);
          String filetoPass = filenameMap.get(temp);
          JsonParser obj = new JsonParser();
          JSONObject jsontemp = obj.load(filetoPass);
          HashMap<String, List<String>> grammarMap = new HashMap();
          grammarMap = obj.grammarParse(jsontemp);
          GrammarProcessor gram = new GrammarProcessor();
          try {
            System.out.println(gram.contentProcessor("start", grammarMap));
          }
          catch (UndefinedInputException e)
          {
            e.printStackTrace();
          }
          System.out.println("Would you like another? (y/n)");
          userOption = sc.nextLine();
        }
        while (userOption.equalsIgnoreCase("y"));
      }
      else {
        String s="Enter a valid file number to process";
        throw new IncorrectUserInputException(s);
      }
    }
  }

  @Override
  public String toString() {
    return "UserInput{}";
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
