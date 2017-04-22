import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class ElectionData { // gvgvgvgvfextends Exception{implements CandidateSet
	/*Part 1.1 Edit the starter code to store the number of first, second, and third choice 
	 * votes for each candidate on a ballot. Before reading on, think about what 
	 * data structure(s) you might use for this information. After you've come up 
	 * with your proposal on paper, feel free to look at (and use, or not) 
	 * our suggested data structure. ( three HashMaps: one for the number of 
	 * first-choice votes per candidate, one for the number of second-choice 
	 * votes per candidate, and one for the number of third-choice votes per 
	 * candidate.
	 * 
	 */
	private LinkedList<String> ballot = new LinkedList<String>(); // A list of candidates
	private LinkedList<String> votes = new LinkedList<String>();  // The votes people cast
	// A list of candidates from the voters
	// new votes structure
	private HashMap<String, Integer> firstchoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> secondchoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> thirdchoice = new HashMap<String, Integer>();
	public Scanner keyboard = new Scanner(System.in); // Keyboard input

	ElectionData() {
		this.ballot.add("Gompei");
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
	//	try
	//	{
			this.printBallot();
			System.out.println("Who do you want to vote for?");
			String candidate = keyboard.next();
			//addCandidate(candidate1, candidate2, candidate3);
			System.out.println("You voted for " + candidate);
		//}
		//catch (CandidateExistsException	 e)
		//{

		//}
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
			throws CandidateExistsException //UnknownCandidateException, DuplicateVotesException,
			//DuplicateVotesException
	{
		// This code below is if there weren't any errors
		//		if (vote1 != vote2 && vote1 != vote3 && vote2 != vote3)
		//		{
		//		votes.add(vote);
		//		}
		// this should add a candidate that is not already in the list
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
		// TODO Auto-generated method stub
		int totalCandidates = this.ballot.size(), i = 0;
		LinkedList<Integer> counterList = new LinkedList<Integer>();
		// This list holds an integer for each candidate.
		// Increment the respective counter each time they get a vote.

		// Fill the list with integers of 0 in for each candidate.
		for (i = 0; i < totalCandidates; i++)
		{
			counterList.add(0); // Each candidate gets 0 votes.
		}
		
		// reset counter
		i = 0;
		
		// This fills with a dummy variable so that this function compiles.
		String winner = this.ballot.get(i);
		
		// Filler variable for total first votes for each candidate.
		int totalVotes = 0, comp = countFirstVotes(this.ballot.get(i));

		for (i = 1; i < totalCandidates; i++) // since comp starts with the first candidate anyways, start with 1.
		{
			// counterList.set(i) = countFirstVotes(this.ballot.get(i));
			totalVotes = countFirstVotes(this.ballot.get(i)); // Get the total first votes for that candidate.
			
			if (totalVotes >= comp) // Do we need to handle ties?
			{
				winner = this.ballot.get(i);
			}
			// Mary do you see what I am trying to do? 
			//#######################################
			// i think i got it
			counterList.set(i, totalVotes);// = totalVotes; // This is supposed to set the element in the list to totalVotes.
		}
		return winner;
	}

	// This function helps the findWinnerMostFirstVotes() function counting first votes.
	private int countFirstVotes(String name) // , int ballotnum) // ballotnum is the number that associates the candidate 
	// in the list of candidates
	{
		int result = 0, i = 0;
		for (i = 0; i < this.votes.size(); i = i + 3)
			// (String runTotal: this.votes)
			// (i = ballotnum; i < this.votes.size(); i = i + 3)
		{
			if (this.ballot.get(i).equals(name))
			{
				result++;
			}
		}
		return result;
	}

	public String findWinnerMostPoints() {
		// TODO Auto-generated method stub
		int totalCandidates = this.ballot.size();
		return null;
	}
}
