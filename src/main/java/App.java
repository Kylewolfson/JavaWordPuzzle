import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/puzzlePage", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String inputString = request.queryParams("userString");
      String puzzleString = WordPuzzle.runWordPuzzle(inputString);
      model.put("puzzleString", puzzleString);
      model.put("inputString", inputString);
      model.put("template", "templates/puzzlePage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/puzzlePageWithHint", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String inputString = request.queryParams("inputString");
      String puzzleString = WordPuzzle.runWordPuzzleWithHint(inputString);
      model.put("puzzleString", puzzleString);
      model.put("inputString", inputString);
      model.put("template", "templates/puzzlePageWithHint.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/guess", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String inputString = request.queryParams("inputString");
      String guessString = request.queryParams("guessString");
      String guessCorrect;
      if (inputString.equals(guessString)) {
        guessCorrect = "Congratulations, you solved the puzzle!";
      } else {
        guessCorrect = "Sorry, that is not the correct answer.";
      }
      model.put("guessCorrect", guessCorrect);
      model.put("template", "templates/guess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
