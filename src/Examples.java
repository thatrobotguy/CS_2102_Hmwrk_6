import static org.junit.Assert.*;

import org.junit.Test;


public class Examples {

	// method to set up a ballot and cast votes

	ElectionData Setup1 () {

		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");

			// cast votes	
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");

		} catch (Exception e) {}

		return(ED);
		// TODO How do we test to add inputs from keyboard?
	}
	ElectionData Setup2 (){
		ElectionData ED = new ElectionData();
		// put candidates on the ballot
		try {
			ED.addCandidate("Jane");
			ED.addCandidate("Dan");
			ED.addCandidate("Andrew");		
			ED.addCandidate("Mary");
			// cast votes	
			ED.processVote("Jane", "Dan", "Andrew");
			ED.processVote("Andrew", "Dan", "Mary");
			ED.processVote("Mary", "Dan", "Andrew");
			ED.processVote("Mary", "Dan", "Jane");

		} catch (Exception e) {}
		return (ED);
	}
	
	// now run a test on a specific election
	@Test
	public void testMostFirstWinner () {
		assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
	}
	// now run a test on a specific election
	@Test
	public void testMostPointsFirstWinner () {
		assertEquals("gompei", Setup1().findWinnerMostPoints());
	}
	// now run a test on a specific election
	@Test
	public void testMostFirstWinner2 () {
		assertEquals("Mary", Setup2().findWinnerMostFirstVotes());
	}
	// now run a test on a specific election
	@Test
	public void testMostPointsFirstWinner2 () {
		assertEquals("Dan", Setup2().findWinnerMostPoints());
	}
}
