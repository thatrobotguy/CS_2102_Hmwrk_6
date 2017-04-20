import java.util.LinkedList;
import java.util.Scanner;

class ElectionData implements CandidateSet{ // extends Exception{
	private LinkedList<String> ballot = new LinkedList<String>(); // A list of candidates
	private LinkedList<String> votes = new LinkedList<String>();
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

	public void screen() {
		this.printBallot();
		System.out.println("Who do you want to vote for?");
		String candidate = keyboard.next();
		addCandidate(candidate);
		System.out.println("You voted for " + candidate);
	}

	public int countVotes(String forcand) {
		int numvotes = 0;
		for (String s : votes) {
			if (s.equals(forcand))
				numvotes = numvotes+1;
		}
		return numvotes;
	}

	public void addCandidate(String vote) throws CandidateNotFoundException
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