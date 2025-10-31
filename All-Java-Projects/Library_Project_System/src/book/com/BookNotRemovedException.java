package book.com;

public class BookNotRemovedException extends RuntimeException
{
	public String toString()
	{
		return getClass() + " Given id is invalid.....No book is removed...";		
	}
}