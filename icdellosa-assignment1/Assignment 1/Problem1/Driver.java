package Problem1;

import java.io.File;

/**
 * 
 * @author Frank M. Carrano
 * @version 5.0
 */
public class Driver {
   public static void main(String[] args) {
      // Create a file of correctly spelled words to act as a dictionary
      // UNCOMMENT THE FOLLOWING LINE IF YOU WANT TO GENERATE YOUR OWN DICTIONARY
      // TextFileOperations.createTextFile("dictionary", 10);

      // Create the spell checker
      SpellChecker checker = new SpellChecker();
      checker.setDictionary(new File("dictionary"));


      // Create a file of the words in the document to check
      // UNCOMMENT THE FOLLOWING LINE IF YOU WANT TO GENERATE YOUR OWN DOCUMENT
      // TextFileOperations.createTextFile("document", 5);

      // Check spelling of words in the document file
      checker.checkSpelling(new File("document"));


   }
}

/*
 * Enter 10 lines of data:
 * Line 1: able
 * Line 2: baker
 * Line 3: gamma
 * Line 4: delta
 * Line 5: epsilon
 * Line 6: red
 * Line 7: blue
 * Line 8: green
 * Line 9: yellow
 * Line 10: white
 * Enter 5 lines of data:
 * Line 1: gama
 * Line 2: blue
 * Line 3: dalta
 * Line 4: yullow
 * Line 5: white
 * gama is NOT spelled correctly.
 * blue is spelled correctly.
 * dalta is NOT spelled correctly.
 * yullow is NOT spelled correctly.
 * white is spelled correctly.
 */
