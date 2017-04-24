import java.util.Scanner;

//Mary Hatfalvi & Andrew Schueler
public class Main {
	//public static void main(String[] args) {
	Main(){
		Exception e1 = new UnknownCandidateException("gompei"); // If the candidate doesn't exist
		Exception e2 = new CandidateExistsException("gompei");  // The candidate exists - GOOD
		Exception e3 = new DuplicateVotesException("gompei"); // If a person tries to vote twice for the same person. 

		ElectionData ED = new ElectionData(); // Add the 3 candidates to the Election
		Scanner keyboard = new Scanner(System.in); // Keyboard input
		try {
			System.out.println("Enter a Candidate Name");
			String add = keyboard.nextLine();
			ED.addCandidate(add); // Need to write addCandidate().
		} catch (CandidateExistsException e) {
			System.out.println("Candidate Exists Try Again");
			//
		}

		try {
			ED.processVote("a","b","c");
		} catch (UnknownCandidateException e) {
		} catch (DuplicateVotesException e) {}

		String winner1 = ED.findWinnerMostFirstVotes();
		String winner2 = ED.findWinnerMostPoints();

		System.out.println ("Congratulations, your program compiled!");
	}
	//}

}
