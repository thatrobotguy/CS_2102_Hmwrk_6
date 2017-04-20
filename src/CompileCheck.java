
class CompileCheck {
	public static void main(String [] args) {

		Exception e1 = new UnknownCandidateException("gompei");
		Exception e2 = new CandidateExistsException("gompei");
		Exception e3 = new DuplicateVotesException("gompei"); // If a person tries to vote
		// Twice for the same person. 
		
		ElectionData ED = new ElectionData(); // Add the 3 candidates to the Election

		try {
			ED.addCandidate("a"); // Need to write addCandidate().
		} catch (CandidateExistsException e) {}

		try {
			ED.processVote("a","b","c");
		} catch (UnknownCandidateException e) {
		} catch (DuplicateVotesException e) {}

		String winner1 = ED.findWinnerMostFirstVotes();
		String winner2 = ED.findWinnerMostPoints();

		System.out.println ("Congratulations, your program compiled!");
	}
}
