
public class UnknownCandidateException extends Exception{
	private String unfoundName;
	
	public UnknownCandidateException(String name)
	{
		this.unfoundName = name;
	}
}
