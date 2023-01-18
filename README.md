
The entry point of the project is the Main.java file. This file can directly be run. On running this file UserInput.java class is called. This receives input from user. The following gets loaded and asks for user input where the user can enter the choice of grammar they wish to get the sentence.

Loading grammars...
1. insult_grammar
2. students_grammar
3. poem_grammar
4. term_paper_grammar

Which would you like to use? (q to quit)
2
Students seem to show more interest towards their Database Management Systems course Assignment 1.
Would you like another? (y/n)

The correctness of the application is evaluated by giving options and checking the output with loaded grammar json as follows

Incase of 'y', application gets the second random sentence from the same grammar file.
Incase of 'n', the grammar options will be displayed again for the user to choose one.
Incase of 'q' it quits the whole application.

when the option is entered by the user, the students_grammar.json file is called from the grammarTemplates folder.The Json file is loaded as a Jsonobject and then returned as a hashmap in the Jsonparser.java file.This hashmap is then passed to GrammarPorcessor.java file.The contentprocessor method calls the randomOptionGenerator method to get random index value for a tag.This random value returned helps to fetch a random tag and this tag is processed using recursion until there is no tag in the variable returned.

The string (random sentence from the choosen grammar file) is returned to the UserInput.java and then process goes on based on input entered by user.

Incase the user entered an invalid input an IncorrectUserException is thrown.When the json file is processed an the file is empty or if a particular tag is missing an undefinedInputException is thrown.

Own grammar is generated and loaded as students_grammar file.
