
public class CandidateNotFoundException extends Exception{
	String unfoundName;
	
	CandidateNotFoundException(String name)
	{
		this.unfoundName = name;
	}
}
