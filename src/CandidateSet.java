
public interface CandidateSet {
	
	public void addCandidate(String vote) // Do I need this?
			throws UnknownCandidateException, CandidateExistsException, DuplicateVotesException;
}
