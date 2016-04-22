import java.util.ArrayList;
import java.util.Arrays;

public class WordPuzzle {

  public String runWordPuzzle(String inputString) {
    char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};
    String puzzleString = inputString;
    for ( char vowel : vowels ) {
      puzzleString = puzzleString.replace(vowel, '-');
    }
    return puzzleString;
  }

}
