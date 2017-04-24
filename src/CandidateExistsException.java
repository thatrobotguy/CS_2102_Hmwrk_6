
public class CandidateExistsException extends Exception {
	//Mary Hatfalvi & Andrew Schueler
	private String existsName;
	// Constructor for exception
	public CandidateExistsException(String name)
	{
		this.existsName = name;
	}
}
