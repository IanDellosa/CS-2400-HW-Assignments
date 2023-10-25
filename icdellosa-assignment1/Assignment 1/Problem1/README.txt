PROBLEM STATEMENT:
You can use either a set or a bag to create a spell checker. The set or bag serves as a dictionary and contains a collection of correctly spelled words. To see whether a word is spelled correctly, you see whether it is contained in the dictionary. Use this scheme to create a spell checker for the words in an external file. To simplify you task, restrict your dictionary to a manageable size.

WHAT IS PROVIDED:
- A driver class to run the program
- A bag interface (BagInterface.java)
- A sample dictionary file containing correctly spelled words
- A sample document file to test
- A class of static methods that write to and display a text file of user-supplied data (TextFileOperations.java)

WHAT YOU NEED TO DO:
1. Create a ResizableArrayBag class that implements BagInterface. You may use the code provided in class, but I want you to understand the algorithm behind each method of the ADT.
2. Use my provided but incomplete SpellChecker.java and finish the functions. Hint: you can use the Scanner class to read in the files line by line.