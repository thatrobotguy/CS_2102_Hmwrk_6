
public class DuplicateVotesException extends Exception {
	//Mary Hatfalvi & Andrew Schueler
	private String duplicateName1;
	//String duplicateName2;
	
	public DuplicateVotesException(String name1) // , String name2)
	{
		this.duplicateName1 = name1;
		//this.duplicateName2 = name2;
	}
}
