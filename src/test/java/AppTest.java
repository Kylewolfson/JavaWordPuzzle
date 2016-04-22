import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Word Puzzle");
  }
  @Test
  public void puzzleCreationTest() {
    goTo("http://localhost:4567/");
    fill("#userString").with("Hello");
    submit(".btn");
    assertThat(pageSource()).contains("H-ll-");
  }
  @Test
  public void GuessTestFailure() {
    goTo("http://localhost:4567/");
    fill("#userString").with("Hello");
    submit(".btn");
    fill("#guessString").with("This is a terrible guess");
    submit("#guess");
    assertThat(pageSource()).contains("Sorry, that is not the correct answer.");
  }
  @Test
  public void GuessSuccess() {
    goTo("http://localhost:4567/");
    fill("#userString").with("Hello");
    submit(".btn");
    fill("#guessString").with("Hello");
    submit("#guess");
    assertThat(pageSource()).contains("Congratulations, you solved the puzzle!");
  }
}
