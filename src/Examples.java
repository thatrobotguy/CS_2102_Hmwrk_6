import static org.junit.Assert.*;
import org.junit.Test;
//Mary Hatfalvi & Andrew Schueler
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
		// dont think that needs to be done
	}
	// another method to set up and use for testing
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
	ElectionData Setup3 (){
		ElectionData ED = new ElectionData();
		// put candidates on the ballot
		try {
			ED.addCandidate("Jane");
			ED.addCandidate("Dan");
			ED.addCandidate("Andrew");		
			ED.addCandidate("Mary");
			ED.addCandidate("SwagMan");
			// cast votes	
			ED.processVote("Jane", "Dan", "Andrew");
			ED.processVote("Andrew", "Dan", "Mary");
			ED.processVote("Mary", "Dan", "Andrew");
			ED.processVote("Mary", "Dan", "Jane");
			ED.processVote("SwagMan", "SwagMan", "SwagMan");

		} catch (Exception e) {
			return new ElectionData();	
		}
		return (ED);
	}	

	ElectionData Setup4 (){
		ElectionData ED = new ElectionData();
		// put candidates on the ballot
		try {
			ED.addCandidate("Jane");
			// ED.processVote("Jane", "Dan", "Andrew");
		} catch (Exception e) {
			return new ElectionData();	
		}
		return (ED);
	}	

	ElectionData Setup5 () {
		ElectionData ED = new ElectionData();
		// put candidates on the ballot
		try {
			ED.addCandidate("Jane");
			ED.addCandidate("Dan");
			ED.addCandidate("Andrew");		
			// cast votes	
			ED.processVote("Jane", "Dan", "Andrew");
			ED.processVote("Andrew", "Dan", "Mary");
			ED.processVote("Jane", "Mary", "Dan");

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
	// now run a test on a single candidate election
	@Test
	public void testMostPointsFirstWinnerSwag1 () {
		assertEquals("Jane", Setup4().findWinnerMostPoints());
	}
	// now run a test on a single candidate election
	@Test
	public void testMostPointsFirstWinnerSwag2 () {
		assertEquals("Jane", Setup4().findWinnerMostFirstVotes());
	}


	//	@Test(expected=DuplicateVotesException.class)
	//	public void testMostPointsFirstWinner3 () {
	//		Setup3();
	//	}

	//	@Test
	//	public void testMostPointsWinner1 () { // Setup3
	//		assertTrue(new ElectionData() == Setup3());
	//	}


}
