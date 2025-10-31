package book.com;

public class BookNotUpdatedException  extends RuntimeException
{
	public String toString()
	{
		 return getClass() +"Given Title is invalid..... No book is updated...";
	}
}
