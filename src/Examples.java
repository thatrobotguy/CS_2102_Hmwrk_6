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
			ED.processVote("Jane", "Dan", "Andrew");
		} catch (Exception e) {}
		return (ED);
	}	

	ElectionData Setup5 () {
		ElectionData ED = new ElectionData();
		try {
			ED.addCandidate("Bob");
			ED.addCandidate("Dan");
			ED.addCandidate("Andrew");
			ED.addCandidate("Mary");
			// cast votes	
			ED.processVote("Bob", "Mary", "Andrew");
			ED.processVote("Andrew", "Dan", "Andrew");
			ED.processVote("Bob", "Mary", "Dan");
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
	public void testMostPointsFirstWinnerwith1 () { 
		assertEquals("Jane", Setup4().findWinnerMostPoints());
	}
	// now run a test on a single candidate election
	@Test
	public void testMostPointsFirstWinnerwith1_2 () { 
		assertEquals("Jane", Setup4().findWinnerMostFirstVotes());
	}

	@Test //test is throws unknown before duplicate
	public void testThrowsUnkownBeforeDuplicate () {
		boolean unknown = false;
		try {
			Setup5().processVote("Mary", "Derpface", "Mary");
		} catch (DuplicateVotesException e) {
		} catch (UnknownCandidateException e) {
			unknown = true;
		}
		assertTrue(unknown);
	}

	@Test //test if throws unknown exception
	public void testThrowsUnknownOnly () {
		boolean unknown = false;
		try {
			Setup5().processVote("Mary", "Derpface", "Andrew");
		} catch (DuplicateVotesException e) {
		} catch (UnknownCandidateException e) {
			unknown = true;	
		}
		assertTrue(unknown);
	}

	@Test //checks if duplicate throws exception
	public void testThrowsDuplicateOnly () {
		boolean unknown = false;
		try {
			Setup5().processVote("Mary", "Mary", "Andrew");
		} catch (DuplicateVotesException e) {
			unknown = true;	
		} catch (UnknownCandidateException e) {}
		assertTrue(unknown);
	}

	@Test //tests if add candidate throws exception
	public void testThrowsDuplicateCadidate () {
		boolean unknown = false;
		try {
			Setup5().addCandidate("Mary");
		} catch (CandidateExistsException e) {
			unknown = true;	
		}
		assertTrue(unknown);
	}
}