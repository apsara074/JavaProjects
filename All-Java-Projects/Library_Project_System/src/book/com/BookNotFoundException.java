package book.com;

public class BookNotFoundException extends RuntimeException
{
	public String toString()
	{
		return getClass() + " Given id or author is invalid...";
	}
}
