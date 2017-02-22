
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    private static final int score_0 = 0;
    private static final int score_15 = 1;
    private static final int score_30 = 2;
    private static final int score_45 = 3;
    private static final int advance_score = 4;
    
    
    
  
    public TennisGame2() {
     
    }

    public String getScore(){
        String literalScore = "";
        literalScore = actualScore(literalScore); 
        literalScore = tieScore(literalScore);
        literalScore = deuceScore(literalScore);      
        literalScore = advancePlayer1(literalScore);
        literalScore = advancePlayer2(literalScore);
        literalScore = playerWon(literalScore);
      
        return literalScore;
    }

	private String actualScore(String score) {
		String P1scoreResult = "";
        String P2res = "";
        P1scoreResult = scoreToLiteral(player1Points);           
        P2res = scoreToLiteral(player2Points);
        score = P1scoreResult + "-" + P2res;
		return score;
	}

	private String scoreToLiteral(int playerScore) {
		String res = "";
		if (playerScore==score_0)
			res = "Love";
		if (playerScore==score_15)
			res = "Fifteen";
		if (playerScore==score_30)
			res = "Thirty";
		if (playerScore==score_45)
			res = "Forty";
		
		return res;
	}

	private String advancePlayer1(String score) {
		if (player1Points > player2Points && player2Points >= score_45)
        {
            score = "Advantage player1";
        }
		return score;
	}

	private String advancePlayer2(String score) {
		if (player2Points > player1Points && player1Points >= score_45)
        {
            score = "Advantage player2";
        }
		return score;
	}

	private String playerWon(String score) {
		if (player2Points>=advance_score && player1Points>=score_0 && (player2Points-player1Points)>=score_30)
        {
            score = "Win for player2";
        }
		if (player1Points>=advance_score && player2Points>=score_0 && (player1Points-player2Points)>=score_30)
        {
            score = "Win for player1";
        }
		return score;
	}

	private String deuceScore(String score) {
		if (player1Points==player2Points && player1Points>=score_45)
            score = "Deuce";
		return score;
	}

	private String tieScore(String score) {
		if (player1Points == player2Points && player1Points < advance_score)
        {
            if (player1Points==score_0)
                score = "Love";
            if (player1Points==score_15)
                score = "Fifteen";
            if (player1Points==score_30)
                score = "Thirty";
            score += "-All";
        }
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}