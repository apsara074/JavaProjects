package book.com;

import java.util.ArrayList;
import java.util.Iterator;

public class Library
{
    private Book b;
    private ArrayList<Book> book=new ArrayList<Book>();
    
    //addBook
    public void addBook(Book b)
    {
    	book.add(b);
    	System.out.println(b.getTitle()+" book is added");
    }
    
    //showBook
    public void showBook()
    {
    	if(book.isEmpty())
    	{
    	   throw new EmptyException();
    	}
    	else
    	{
    		for(Book b:book)
    		{
    		  b.displayBook();
    		}
    	}
    }
    
    //searchBookById
    public void searchBookById(int id)
    {
    	boolean isFound=false;
    	if(book.isEmpty())
    		throw new BookNotFoundException();
    	else 
    	{
    		for(Book b:book)
    		{
    			if(b.getBookId()==id)
    			{
    				System.out.println("Book is found");
    				isFound=true;
    			}
    		}
    	}
    	if(isFound==false)
    	{
    		throw new BookNotFoundException();
    	}
    }
    
    //searchBookByAuthor
   
    public void searchBookByAuthor(String author)
    {
    	boolean isFound=false;
    	if(book.isEmpty())
    	{
    		throw new EmptyException();
    	}
    	else 
    	{
    		for(Book b:book)
    		{
    			if(b.getAuthor().equalsIgnoreCase(author))
    			{
    				System.out.println("Book is found");
    				isFound=true;
    			}
    		}
    	}
    	if(isFound==false)
    	{
    		throw new BookNotFoundException();
    	}
    }
    
    //updateBookCost
    public void updateBookCostByTitle(String title,int newCost)
    {
    	boolean isUpdated=false;
    	if(book.isEmpty())
    		throw new EmptyException();
    	else
    	{
    		for(Book b:book)
    		{
    			if(b.getTitle().equalsIgnoreCase(title))
    			{
    				b.setCost(newCost);
    				System.out.println("Book cost is updated");
    				isUpdated=true;
    			}
    		}
    	}
    	if(isUpdated==false)
    		throw new BookNotUpdatedException();
    }
    
    //removeBookById
    public void removeBookById(int id)
    {
    	boolean isRemoved=false;
    	if(book.isEmpty())
    		throw new EmptyException();
    	else
    	{
    		Iterator<Book> itr=book.iterator();
    		while(itr.hasNext())
    		{
    			Book b=itr.next();
    			if(b.getBookId()==id)
    			{
    				itr.remove();
    				System.out.println("Book is removed");
    				isRemoved=true;
    			}
    		}
    	}
    	if(isRemoved==false)
    	{
    		throw new BookNotRemovedException();
    	}
    }
}