import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class TennisGameTest {
	
	private TennisGame Tennis ;
	
	@Before
	public void setUp() throws Exception {
		  this.Tennis = new TennisGame();
	}

	@After
	public void tearDown() throws Exception {
		this.Tennis=null;
	}

	@Test
	public void DebuPartie() {
		assertEquals("love - love",this.Tennis.currentScore());
	}

	@Test
	public void testUnAZero() {
		simule(1,0);
		assertEquals("fifteen - love",this.Tennis.currentScore());
	}
	@Test
	public void testDeuxAZero() {
		simule(2,0);
		assertEquals("thirty - love",this.Tennis.currentScore());
	}

	@Test
	public void testTroisAZero() {
		simule(3,0);
		assertEquals("forty - love",this.Tennis.currentScore());
	}

	@Test
	public void testUnAUn() {
		simule(1,1);
		assertEquals("fifteen - fifteen",this.Tennis.currentScore());
	}

	@Test
	public void testDeuxAUn() {
		simule(2,1);
		assertEquals("thirty - fifteen",this.Tennis.currentScore());
	}
	
	@Test
	public void testDeuxADeux() {
		simule(2,2);
		assertEquals("thirty - thirty",this.Tennis.currentScore());
	}
	
	@Test
	public void testTroisAUn() {
		simule(3,1);
		assertEquals("forty - fifteen",this.Tennis.currentScore());
	}
	
	
	
	@Test
	public void testTroisADeux() {
		simule(3,2);
		assertEquals("forty - thirty",this.Tennis.currentScore());
	}
	
	
	@Test
	public void testDeuce() {
		simule(3,3);
		assertEquals("deuce",this.Tennis.currentScore());
	}
	
	@Test
	public void testPlayer2Advantage() {
		simule(3,4);
	
		assertEquals("advantage for player2",this.Tennis.currentScore());
	}
	@Test
	public void testPlayer1Advantage() {
		simule(4,3);
		
		assertEquals("advantage for player1",this.Tennis.currentScore());
	}
	
	@Test
	public void testPlayer1Win() {
		simule(4,2);
		assertEquals("game for player1",this.Tennis.currentScore());
	}
	
	@Test
	public void testPlayer2Win() {
		simule(2,4);
		assertEquals("game for player2",this.Tennis.currentScore());
	}
	
	
	@Test
	public void testPlayer2WinScore() {
		simule(3,5);
		this.Tennis.player1Scores();
	
		assertEquals("game for player2",this.Tennis.currentScore());
		
	}
	
	@Test
	public void testPlayer2WinScore2() {
		simule(3,5);
		this.Tennis.player2Scores();
	
		assertEquals("game for player2",this.Tennis.currentScore());
		
	}
	
	
	
	@Test
	public void testPlayer1WinScore() {
		simule(5,3);
		this.Tennis.player2Scores();
		
		assertEquals("game for player1",this.Tennis.currentScore());
		
	}
	
	@Test
	public void testPlayer1WinScore2() {
		simule(5,3);
		this.Tennis.player1Scores();
		
		assertEquals("game for player1",this.Tennis.currentScore());
		
	}
	
	private void simule(int score1, int score2) {
		for(int i=1;i<= Math.max(score1, score2);i++) {
			if(i<=score1)
				this.Tennis.player1Scores();
			if(i<=score2)
				this.Tennis.player2Scores();
		}
			
	}

}
