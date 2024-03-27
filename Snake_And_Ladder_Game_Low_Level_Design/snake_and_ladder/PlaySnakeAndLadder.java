package snake_and_ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//In this class I will configure everything
//and supply all my inputs

public class PlaySnakeAndLadder {
public static void main(String[] args)
{
	//Configure Dice
	Dice dice = new Dice(1);

	Player player1 = new Player("Prajakta",1);
	Player player2 = new Player("Abhinay",2);
	Player player3 = new Player("Saily",3);
	Player player4 = new Player("Prachi",4);
	
	Queue<Player> queue = new LinkedList<>();
	queue.offer(player1);
	queue.offer(player2);
	queue.offer(player3);
	queue.offer(player4);
	
	
	
	//Configure the Ladders
	
	LadderJumper l1 = new LadderJumper(3, 25);
	LadderJumper l2 = new LadderJumper(6, 45);
	LadderJumper l3 = new LadderJumper(56, 90);
	LadderJumper l4 = new LadderJumper(45, 78);
	LadderJumper l5 = new LadderJumper(26, 67);
	
	List<LadderJumper> lj= new ArrayList<>();
	lj.add(l1);
	lj.add(l2);
	lj.add(l3);
	lj.add(l4);
	lj.add(l5);

	//Configure the Snakes
	SnakeJumper s1 = new SnakeJumper(36, 4);
	SnakeJumper s2 = new SnakeJumper(56, 35);
	SnakeJumper s3 = new SnakeJumper(95, 64);
	SnakeJumper s4 = new SnakeJumper(80, 55);
	
	List<SnakeJumper> sj= new ArrayList<>();
	sj.add(s1);
	sj.add(s2);
	sj.add(s3);
	sj.add(s4);
	
	//Set up the map
	Map<String, Integer> map = new HashMap<>();
	map.put(player1.getPlayerName(), 0);
	map.put(player2.getPlayerName(), 0);
	map.put(player3.getPlayerName(), 0);
	map.put(player4.getPlayerName(), 0);
	
	System.out.println(map);
	
	GameBoard gameboard = new GameBoard(dice, queue, sj, lj, map, 100);
	gameboard.startGame();

	
	
	
}

}
