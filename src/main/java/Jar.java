import java.util.Random;

public class Jar {
  private String itemName;
  public final int MAX_ITEM;
  private int answer;
  private int noOfGuess;
  private int currentGuessNumber;
  
  
  public Jar(String itemName, int maxItem) {
    this.itemName = itemName;
    this.MAX_ITEM = maxItem;
    noOfGuess = 0;
    currentGuessNumber = -1;
  }
  
  public String getItemName() {
    return itemName;
  }
  
  public void fill() {
    Random random = new Random();
    do {
      answer = random.nextInt(MAX_ITEM);
      if (MAX_ITEM <= 1) {
        answer = 1;
      }
    } while (answer == 0);
    
  }
  
  public int normalizeGuess(String guessNumber) {
    int normalizedGuessNumber = 0;
    if (guessNumber.length() == 0) {
      throw new IllegalArgumentException("No number found");
    }
    
    try {
      normalizedGuessNumber = Integer.parseInt(guessNumber);
    } catch (Exception e) {
      throw new IllegalArgumentException("A Integer is required");
    }
    
    if (normalizedGuessNumber < 1) {
      throw new IllegalArgumentException("You guess must be higher than 0");
    }
    
    if (normalizedGuessNumber > MAX_ITEM) {
      throw new IllegalArgumentException("Your guess must be less than " + (MAX_ITEM+1));
    }
    
    return normalizedGuessNumber;
  }
  
  public boolean applyGuess(String guessNumber) { 
    
    int normalizedGuessNumber = normalizeGuess(guessNumber);
    
    noOfGuess++;
    currentGuessNumber = normalizedGuessNumber;
    return isWon() == 0;
  
  }
  
  public int getNoOfGuess() {
    return noOfGuess;
  }
  
  // return 0 - won, -1 - guess number is too low, 1 - guess number is too high
  public int isWon() {
    if (answer > currentGuessNumber)
      return -1;
    else if (answer == currentGuessNumber)
      return 0;
    else 
      return 1;
  }
  
  
  
}