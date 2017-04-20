
public class DuplicateVotesException extends Exception {

	String duplicateName1;
	//String duplicateName2;
	
	DuplicateVotesException(String name1) // , String name2)
	{
		this.duplicateName1 = name1;
		//this.duplicateName2 = name2;
	}
}
