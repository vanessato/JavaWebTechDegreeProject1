public class GuessingGame {
  
  public static void main(String[] args) {
    Jar jar = Prompter.promptForAdmin();
    Prompter prompt = new Prompter(jar);

    jar.fill();
    prompt.promptForGuess();
    prompt.displayOutcome();
    
  }  
}
