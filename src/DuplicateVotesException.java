public class DuplicateVotesException extends Exception {
	//Mary Hatfalvi & Andrew Schueler
	private String duplicateName1;
	public DuplicateVotesException(String name1)
	{
		this.duplicateName1 = name1;
	}
}
