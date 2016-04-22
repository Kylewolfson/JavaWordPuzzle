import java.util.ArrayList;
import java.util.Arrays;

public class WordPuzzle {

  public static String runWordPuzzle(String inputString) {
    char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};
    String puzzleString = inputString;
    for ( char vowel : vowels ) {
      puzzleString = puzzleString.replace(vowel, '-');
    }
    return puzzleString;
  }

  public static String runWordPuzzleWithHint(String inputString) {
    char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};
    String puzzleString = inputString;
    Integer firstVowelIndex = null;
    char firstVowelLetter = 'a';
    for ( char vowel : vowels ) {
      puzzleString = puzzleString.replace(vowel, '-');
    }
    for ( char vowel : vowels ) {
      firstVowelIndex = inputString.indexOf(vowel);
      firstVowelLetter = vowel;
      if (firstVowelIndex >= 0) {
        break;
      }
    }
    if (firstVowelIndex != -1){
      puzzleString = puzzleString.substring(0,firstVowelIndex)+firstVowelLetter+puzzleString.substring(firstVowelIndex+1);
    } else {puzzleString = puzzleString;}
    return puzzleString;
  }

}
