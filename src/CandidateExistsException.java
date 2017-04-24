
public class CandidateExistsException extends Exception {
	
	private String existsName;
	
	public CandidateExistsException(String name)
	{
		this.existsName = name;
	}
}
