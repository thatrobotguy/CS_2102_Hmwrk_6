import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class ElectionData { //extends Exception{implements CandidateSet
	/*Part 1.1 Edit the starter code to store the number of first, second, and third choice 
	 * votes for each candidate on a ballot. Before reading on, think about what 
	 * data structure(s) you might use for this information. After you've come up 
	 * with your proposal on paper, feel free to look at (and use, or not) 
	 * our suggested data structure. ( three HashMaps: one for the number of 
	 * first-choice votes per candidate, one for the number of second-choice 
	 * votes per candidate, and one for the number of third-choice votes per 
	 * candidate.
	 */
	private LinkedList<String> ballot = new LinkedList<String>(); // A list of candidates
	//private LinkedList<String> votes = new LinkedList<String>();  // The votes people cast
	// A list of candidates from the voters
	// new votes structure
	private HashMap<String, Integer> firstchoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> secondchoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> thirdchoice = new HashMap<String, Integer>();
	public Scanner keyboard = new Scanner(System.in); // Keyboard input

	ElectionData() {
		this.ballot.add("Gompei"); // TODO Do we need to have things in the constructor? Post this to the forum.
		this.ballot.add("Husky");
		this.ballot.add("Andrew");
		firstchoice.put("Gompei", 0);
		firstchoice.put("Husky", 0);
		firstchoice.put("Andrew", 0);
		secondchoice.put("Gompei", 0);
		secondchoice.put("Husky", 0);
		secondchoice.put("Andrew", 0);
		thirdchoice.put("Gompei", 0);
		thirdchoice.put("Husky", 0);
		thirdchoice.put("Andrew", 0);
	}

	public void printBallot() {
		System.out.println("The candidates are ");
		for (String s : ballot) {
			System.out.println(s);
		}
	}

	public void screen()
	{
		try
		{
			System.out.println("Enter a Candidate Name"); // TODO Do we need to choose whether we want to add candidate or 
			// vote for already added candidates? Forum??
			String add = keyboard.nextLine();
			addCandidate(add); // Need to write addCandidate().
			this.printBallot();
			System.out.println("Who do you want to vote for?");
			String candidate1 = keyboard.next();
			String candidate2 = keyboard.next();
			String candidate3 = keyboard.next();
			processVote(candidate1, candidate2, candidate3);
		}
		catch (CandidateExistsException	 e)
		{
			System.out.println("Candidate Exists Try Again");
			screen();
		}
		catch (UnknownCandidateException e){
			System.out.println("Candidate Unknown Try Again");
			screen();
		}
		catch (DuplicateVotesException e){
			System.out.println("No Duplicate Votes Try Again");
			screen();
		}
	}
	/*
	 we need to eventually get rid of this according to hw instructions
	public int countVotes(String forcand) {
		int numvotes = 0;
		for (String s : votes) {
			if (s.equals(forcand))
				numvotes = numvotes+1;
		}
		return numvotes;
	}*/


	public void addCandidate(String candidate) 
			throws CandidateExistsException
	{
		for (String b : this.ballot){
			if (candidate.equals(b)){
				throw new CandidateExistsException(candidate);
			}
		}
		this.ballot.add(candidate);
		firstchoice.put(candidate, 0);
		secondchoice.put(candidate, 0);
		thirdchoice.put(candidate, 0);
	}

	public void processVote(String vote1, String vote2, String vote3) 
			throws UnknownCandidateException, DuplicateVotesException
	{
		if (!candidateExist(vote1)) // This is the error if the votes don't match any candidates.
		{
			throw new UnknownCandidateException(vote1);
		}
		else if (!candidateExist(vote2))
		{
			throw new UnknownCandidateException(vote2);
		}
		else if (!candidateExist(vote3))
		{
			throw new UnknownCandidateException(vote3);
		}
		else if (vote1.equals(vote2))
		{
			throw new DuplicateVotesException(vote2);
		}
		else if (vote1.equals(vote3))
		{
			throw new DuplicateVotesException(vote3);
		}
		else if (vote2.equals(vote3))
		{
			throw new DuplicateVotesException(vote3);
		}
		else {
			firstchoice.put(vote1, firstchoice.get(vote1)+1);
			secondchoice.put(vote2, secondchoice.get(vote2)+1);
			thirdchoice.put(vote3, thirdchoice.get(vote3)+1);
		}

	}

	private boolean candidateExist(String name)
	{
		for (String cand1 : this.ballot)
		{
			if (cand1.equals(name))
			{
				return true;
			}
		}
		return false;
	}

	public String findWinnerMostFirstVotes() {
		long max = firstchoice.get(this.ballot.get(0));
		String holder = this.ballot.get(0);

		for (String a : this.ballot)
		{
			if (firstchoice.get(a) >= max) // TODO Do we have ties???? Forum?? Read assignment.
			{
				max = firstchoice.get(a);
				holder = a;
			}
		}
		return holder;
	}

	public String findWinnerMostPoints() {
		long max = firstchoice.get(this.ballot.get(0)) + 
				secondchoice.get(this.ballot.get(0)) + 
				thirdchoice.get(this.ballot.get(0));
		String holder = this.ballot.get(0);
		for (String aCandidate : this.ballot)
		{
			if (firstchoice.get(aCandidate) + secondchoice.get(aCandidate) + thirdchoice.get(aCandidate) >= max)
			{
				max = firstchoice.get(aCandidate) + secondchoice.get(aCandidate) + thirdchoice.get(aCandidate);
				holder = aCandidate;
			}
		}
		return holder;
	}

	
}
