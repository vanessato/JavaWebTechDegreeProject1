import java.util.Scanner;

public class Prompter {
  
  Jar jar;
  
  public Prompter(Jar jar) {
    this.jar = jar;
  }
  
  public static Jar promptForAdmin(){
    Scanner scanner = new Scanner(System.in);
    String itemName, maxItem;
    
    System.out.println("ADMINISTRATOR SETUP");
    System.out.println("===================");
    System.out.print("What type of item do you want to store in the jar? " );
    itemName = scanner.nextLine();
    
    
    System.out.printf("What is the maximum amount of %s? ", itemName);
    maxItem = scanner.nextLine();
    
    return new Jar(itemName, Integer.parseInt(maxItem));
  }
  
  public boolean promptForGuess() {
    boolean isHit = false;
    Scanner scanner = new Scanner(System.in);
    String guessNumber;
    
    System.out.println("Welcome to the Guessing Game!");
    while (jar.isWon() != 0) {
      System.out.printf("How many %s are in the jar? Pick a number between 1 and %d. ", jar.getItemName(), jar.MAX_ITEM);
      guessNumber = scanner.nextLine();
      
      try {
        isHit = jar.applyGuess(guessNumber);
        if (jar.isWon() < 0) 
          System.out.println("Your guess is too low");
        else if (jar.isWon() > 0)
          System.out.println("Your guess is too high");
      } catch (IllegalArgumentException iae) {
        System.out.printf("%s. Plase try again. %n", iae.getMessage());
      }
    }
    
    return isHit;
  }
  
  public void displayOutcome() {
    if (jar.isWon() == 0) {
      System.out.printf("Congra! You got it in %d attempt%s%n", jar.getNoOfGuess(), (jar.getNoOfGuess() > 1 ? "s": ""));
    }
  }
}


