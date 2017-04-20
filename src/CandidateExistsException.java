
public class CandidateExistsException extends Exception {
	
	String existsName;
	
	CandidateExistsException(String name)
	{
		this.existsName = name;
	}
}
