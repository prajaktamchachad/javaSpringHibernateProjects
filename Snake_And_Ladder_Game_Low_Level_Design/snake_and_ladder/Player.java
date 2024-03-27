package snake_and_ladder;


public class Player {

	private String playerName;
	private int playerId;
	
	//Purpose of Id: how many games the player played, win/lose etc
	//for this we need a id
	//We can also capture email Id, phone number etc
	
	
	
	//constructor
	public Player(String player_name, int player_id)
	{
		this.playerName = player_name;
		this.playerId = player_id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
	
	
}
