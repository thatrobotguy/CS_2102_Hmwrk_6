
public interface CandidateSet {
	// do we need this? i dont think so unless she says to 
	public void addCandidate(String vote) // Do I need this?
			throws UnknownCandidateException, CandidateExistsException, DuplicateVotesException;
}
