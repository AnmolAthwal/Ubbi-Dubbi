import java.util.Scanner;

/**
 * English to Ubbi Dubbi
 * 
 * @author Anmol
 */
public class Main {

  /**
   * The method thathhh is executed when you hit the run button.
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Create a scanner for input
    Scanner input = new Scanner(System.in);

    // Grab the string from the user
    System.out.println("Please enter a string");
    String sentence = input.nextLine();

    // Split the string around the space
    String[] words = sentence.split(" ");

    // Changes the entire text to lowercase 
    for (int r = 0; r < words.length; r++) {
      words[r] = words[r].toLowerCase();
    }

    // Go through each word in the array
    for (int i = 0; i < words.length; i++) {
      
      // go through each letter of the current word
      String currentWord = words[i];
      for (int j = 0; j < currentWord.length(); j++) {
          // look for a vowel
          if (currentWord.charAt(j) == 'a' || 
          currentWord.charAt(j) == 'e' || 
          currentWord.charAt(j) == 'i' || 
          currentWord.charAt(j) == 'o' || 
          currentWord.charAt(j) == 'u') {
            // if the first letter is an vowel, just add ub before the word.
            if (j == 0) {
              words[i] = "ub" + words[i];
            } else {
            // Split the word around the vowel
            String front = currentWord.substring(0, j);
            String back;
            if (words[i] == currentWord) {
              back = currentWord.substring(j);
            } else {
              back = words[i].substring(j + 2);
            }
            
            // re-assemble the words
            String lastPart = words[i].substring(0, j + 2);
            // Check if there was an vowel before this vowel.
            if (currentWord.charAt(j - 1) != currentWord.charAt(j)) {
              if (currentWord.charAt(j -1) == 'a' ||
              currentWord.charAt(j -1) == 'e' ||
              currentWord.charAt(j -1) == 'e' ||
              currentWord.charAt(j -1) == 'i' ||
              currentWord.charAt(j -1) == 'o' ||
              currentWord.charAt(j -1) == 'u') {
              } else {
                if (words[i] == currentWord) {
                  // It can use the original word parts since we made no adjustments yet.
                  words[i] = front + "ub" + back;
                } else {
                  // Uses parts from the changed word from the last for loop cycle and build on top of that
                  words[i] = lastPart + "ub" + back;
                }
              }
              }
            }
          }
        }
      }
    // prints out all the words
    for (int i = 0; i < words.length; i++) {
      System.out.print(words[i] + " ");
    }
    // finish the line off
    System.out.println();
  }
}