package Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {
	BagInterface<String> correctWords;
	int counter = 0;

	public SpellChecker() {
		correctWords = new Bag<String>(10);
	}

	/**
	 * Initializes the bag correctWords to serve as a dictionary of correctly
	 * spelled words.
	 *
	 * @param correctWordFile A File object that represents a text file
	 *                        of correctly spelled words, one per line.
	 * @return True if the dictionary is initialized, if not returns false.
	 */
	public boolean setDictionary(File correctWordFile) {
		try {
			Scanner scnr = new Scanner(correctWordFile);
			while (scnr.hasNextLine()) {
				correctWords.add(scnr.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	/**
	 * Checks the spelling of words in a given textfile.
	 *
	 * @param wordFile A textfile of words whose spelling is to be checked.
	 */
	public void checkSpelling(File wordFile) {
		try {
			Scanner scnr = new Scanner(wordFile);
			String checkWord = "";
			for (int i = 1; i < 6; ++i) {
				checkWord = scnr.nextLine();
				if (correctWords.contains(checkWord)) {
					// check if input word is contained on dictionary file, if not print not spelled correct
					System.out.println(checkWord + " is spelled correctly.");
				} else {
					System.out.println(checkWord + " is NOT spelled correctly.");
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
