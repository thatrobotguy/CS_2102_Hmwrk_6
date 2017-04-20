import java.util.LinkedList;
import java.util.Scanner;

class ElectionData implements CandidateSet{ // extends Exception{
	private LinkedList<String> ballot = new LinkedList<String>(); // A list of candidates
	private LinkedList<String> votes = new LinkedList<String>();  // The votes people cast
	// A list of candidates from the voters
	public Scanner keyboard = new Scanner(System.in); // Keyboard input

	ElectionData() {
		this.ballot.add("Gompei");
		this.ballot.add("Husky");
		this.ballot.add("Andrew");
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
			this.printBallot();
			System.out.println("Who do you want to vote for?");
			String candidate = keyboard.next();
			addCandidate(candidate1, candidate2, candidate3);
			System.out.println("You voted for " + candidate);
		}
		catch (CandidateNotFoundException e)
		{

		}
	}

	public int countVotes(String forcand) {
		int numvotes = 0;
		for (String s : votes) {
			if (s.equals(forcand))
				numvotes = numvotes+1;
		}
		return numvotes;
	}

	public void addCandidate(String vote1, String vote2, String vote3) 
			throws CandidateNotFoundException
	{
		for (Customer cust: customers)
		{
			if (cust.nameMatches(name))
				return cust;
		}
		votes.add(vote);

		throw new (CandidateNotFoundException vote);
	}
}