package book.com;

public class EmptyException extends RuntimeException 
{
	public String toString()
	{
		 return getClass() + "No Books are added....";
	}
}
