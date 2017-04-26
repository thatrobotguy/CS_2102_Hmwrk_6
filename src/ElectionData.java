import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
//Mary Hatfalvi & Andrew Schueler
class ElectionData { //extends Exception{implements CandidateSet
	private LinkedList<String> ballot = new LinkedList<String>(); // A list of candidates
	// A list of candidates from the voters
	// new votes structure
	private HashMap<String, Integer> firstchoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> secondchoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> thirdchoice = new HashMap<String, Integer>();
	public Scanner keyboard = new Scanner(System.in); // Keyboard input

	public ElectionData() {	}

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
			System.out.println("Enter a Candidate Name");  
			String add = keyboard.nextLine();
			addCandidate(add); 
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
	// takes in a string and add it to the ballot
	public void addCandidate(String candidate) throws CandidateExistsException
	{		// use helper function to check for duplicates
		if (candidateExist(candidate)){ // if there is a duplicate throw exception 
			throw new CandidateExistsException(candidate);
		}
		// else add to ballot and HashMaps
		this.ballot.add(candidate);
		this.firstchoice.put(candidate, 0);
		this.secondchoice.put(candidate, 0);
		this.thirdchoice.put(candidate, 0);
	}

	// takes in 3 string names and adds to vote count
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
		else if (vote1.equals(vote2)) // this is the error if votes are duplicate
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
			// if there are no duplicates and  exist then add votes to their HashMap storage 
			this.firstchoice.put(vote1, this.firstchoice.get(vote1)+1);
			this.secondchoice.put(vote2, this.secondchoice.get(vote2)+1);
			this.thirdchoice.put(vote3, this.thirdchoice.get(vote3)+1);
		}

	}

	// checks if a candidate exists returns true if there is such a candidate
	// else return false
	private boolean candidateExist(String name)
	{	// go through each candidate name in ballot
		for (String cand1 : this.ballot)
		{
			if (cand1.equals(name))
			{
				return true;
			}
		}
		return false;
	}

	// find the winner with the most first votes
	public String findWinnerMostFirstVotes() {
		// define zero holder variables
		long max = this.firstchoice.get(this.ballot.get(0));
		String holder = this.ballot.get(0);
		// go through ballot and check number of first votes
		for (String a : this.ballot)
		{
			if (this.firstchoice.get(a) > max)  
			{
				// if a candidate has more votes than max they become the new winner
				max = this.firstchoice.get(a);
				holder = a;
			}
		}
		// return holder / winner
		return holder;
	}

	public String findWinnerMostPoints() {
		long max = this.firstchoice.get(this.ballot.get(0))*3 + 
				this.secondchoice.get(this.ballot.get(0))*2 + 
				this.thirdchoice.get(this.ballot.get(0));
		// define winner 
		String winner = this.ballot.get(0);
		for (String aCandidate : this.ballot)
		{	// for each candidate in ballot check if the max points is higher
			if (this.firstchoice.get(aCandidate)*3 + this.secondchoice.get(aCandidate)*2 + this.thirdchoice.get(aCandidate) > max)
			{	// if not the new string becomes the max points and winner
				max = this.firstchoice.get(aCandidate)*3 + this.secondchoice.get(aCandidate)*2 + this.thirdchoice.get(aCandidate);
				winner = aCandidate;
			}
		} // return the winner
		return winner;
	}
}