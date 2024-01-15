import java.io.*;
import java.util.*;

public class SudoRecursion
{
  public static void main (String [] args) throws IOException
  { 
    //Initialize file read and write objects
    File input = new File ("data.txt");
    PrintWriter output = new PrintWriter(new FileWriter ("output.txt"));
    
    //Initialize array with caveman wordbank
    String words [] = {"ook", "ookook", "oog", "ooga", "ug", "mook", "mookmook", "oogam", "oogum", "ugug"};
    
    //Initialize objects
    Scanner inFile = new Scanner(input);
    String line;
    
    //while loop to read each line of input docement
    while(inFile.hasNextLine())
    {
      line = inFile.nextLine();
      
      //call recursive method and print out number of combinations
      output.println(cavemanCount(line, words));
    }
    output.close();
  }
  
  public static int cavemanCount(String phrase, String[] wordBank) 
  {
    //Base case. When string has caveman words removed and is empty, it is a possibility.
    if (phrase.isEmpty()) 
      return 1;
    else 
    {
      //Loop to run array of word bank. If string contains a word in the array, recursively call method with the phrase subtracted by that word. 
      int count = 0;
      for (String w: wordBank) 
      {
        if (phrase.startsWith(w)) 
          count = count + cavemanCount(phrase.replaceFirst(w,""), wordBank);
      }
      //return the count of possibilities, all steming from the recurcive calls.
      return count;
    }
  }
}