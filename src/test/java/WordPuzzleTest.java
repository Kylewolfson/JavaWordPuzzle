import org.junit.*;
import static org.junit.Assert.*;

public class WordPuzzleTest {
  @Test
  public void SingleConsonantInReturnsItBack() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("b", testWordPuzzle.runWordPuzzle("b"));
  }
  @Test
  public void SingleVoWelReturnsDash() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("-", testWordPuzzle.runWordPuzzle("a"));
  }
  @Test
  public void OneConsonantAndOneVowelReturnConsonantDash() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("b-", testWordPuzzle.runWordPuzzle("ba"));
  }
  @Test
  public void FullStringReplacement() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("B-l--v- y-- c-n -nd y--'r- h-lfw-y th-r-. Th--d-r- R--s-v-lt", testWordPuzzle.runWordPuzzle("Believe you can and you're halfway there. Theodore Roosevelt"));
  }
}
