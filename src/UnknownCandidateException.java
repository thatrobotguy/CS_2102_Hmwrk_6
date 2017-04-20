
public class UnknownCandidateException extends Exception{
	String unfoundName;
	
	UnknownCandidateException(String name)
	{
		this.unfoundName = name;
	}
}
