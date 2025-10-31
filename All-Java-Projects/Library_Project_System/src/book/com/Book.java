package book.com;

import java.io.Serializable;

public class Book implements Serializable 
{
	private String title;
	private String author;
	private int cost;
	private int nop;
	private int bookid;
	public Book() 
	{
		
	}
	public Book(String title,String author,int cost,int nop,int bookid)
	{
		this.title=title;
		this.author=author;
		this.cost=cost;
		this.nop=nop;
		this.bookid=bookid;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setCost(int cost)
	{
		this.cost=cost;
	}
	public int getCost()
	{
		return cost;
	}
	public void setNOP(int nop)
	{
		this.nop=nop;
	}
	public int getNOP()
	{
		return nop;
	}
	public int getBookId()
	{
		return bookid;
	}
	
	
	@Override
	public String toString() {
		return "\n title : "+getTitle()+"\n"+"Author : "+getAuthor()+"\n"+"Cost : "+getCost()+
				"\n"+"No of pages : "+getNOP()+"\n"+"Book id : "+getBookId();
		
	}
	public void displayBook()
	{
		System.out.println("title:"+getTitle());
		System.out.println("author:"+getAuthor());
		System.out.println("cost:"+getCost());
		System.out.println("nop:"+getNOP());
		System.out.println("bookId:"+getBookId());
		System.out.println("---------------------");
	}

}

