package snake_and_ladder;

public class Dice {

	int numberOfDice;
	
	public Dice(int number_of_dice)
	{
		this.numberOfDice = number_of_dice;
	}
	
	//generate a method to select a random number based on the range of numbers
	
	int rollDice()
	{
		//Example, if there are two dice, so lower bound will be 2 and upper bound will be 12
		return ((int)(Math.random()*(6*numberOfDice - 1* numberOfDice))) + 1;
	}

	public int getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}
	
	//generate getter and setters
	
}
