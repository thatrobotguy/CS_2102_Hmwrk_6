
public class UnknownCandidateException extends Exception{
	//Mary Hatfalvi & Andrew Schueler
	private String unfoundName;
	// Constructor for exception
	public UnknownCandidateException(String name)
	{
		this.unfoundName = name;
	}
}
