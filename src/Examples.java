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

	}

	// now run a test on a specific election
	@Test
	public void testMostFirstWinner () {
		assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
	}

}
