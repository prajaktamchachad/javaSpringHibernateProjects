package snake_and_ladder;

import java.util.Queue;
import java.util.List;
import java.util.Map;

public class GameBoard {

	//Need to roll the dice at runtime
	private Dice dice;
	
	private Queue<Player> nextTurn;
	
	private List<SnakeJumper> snakes;
	
	private List<LadderJumper> ladders;
	
	Map<String,Integer> playersCurrentPosition;
	
	int boardSize;
	
	public GameBoard(Dice dice,Queue<Player> nextTurn,List<SnakeJumper> snakes,List<LadderJumper> ladders,Map<String,Integer> playersCurrentPosition, int boardSize) {
		this.dice = dice;
		this.nextTurn = nextTurn;
		this.snakes = snakes;
		this.ladders = ladders;
		this.playersCurrentPosition = playersCurrentPosition;
		this.boardSize = boardSize;
	}
	
	public void startGame()
	{
		System.out.println("Started");
		while(nextTurn.size() > 1)
		{
			Player player = nextTurn.poll();
			String playerName = player.getPlayerName();
			
			//Get the current Position of the Player
			int currentPosition = playersCurrentPosition.get(playerName); 
			
			//Player Rolled the dice
			int rollDice = dice.rollDice();
			
			int nextCell = rollDice + currentPosition;
			
			if(nextCell > boardSize)
			{
				//he needs to try again
				nextTurn.offer(player);
			}
			else if(nextCell == boardSize)
			{
				System.out.println("Reached Destination: "+nextCell);
				System.out.println("Congratulations!!! "+player+" Won the Game ");
				break;
			}
			else
			{
				//Check if new cell contains a Ladder
				
				for(LadderJumper ladder: ladders )
				{
					if(ladder.startPoint == nextCell)
					{
						System.out.println(playerName +"Climed a ladder--"+ladder.startPoint+" , "+ladder.endPoint );
						nextCell = ladder.endPoint;
						break;
					}
				}
				
				
				//check if new cell contains a snake
				for(SnakeJumper snake: snakes )
				{
					if(snake.endPoint == nextCell)
					{
						System.out.println(playerName +"Climed a ladder--"+snake.startPoint+" , "+snake.endPoint );
						nextCell = snake.startPoint;
						break;
					}
				}
				
				
				//update the players position on the board
				playersCurrentPosition.put(playerName, nextCell);
				
				
				//Add the player in the Queue for next turn
				nextTurn.offer(player);
			}
			
			
		}
		
	}
}
