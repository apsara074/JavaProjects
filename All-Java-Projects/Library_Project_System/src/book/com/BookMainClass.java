package book.com;

import java.util.Scanner;

public class BookMainClass
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		boolean start=true;
		Library l=new Library();
		while(start)
		{
			System.out.println("Enter your choice....\n 1.AddBook \n 2.showBook \n 3.SerachBookById \n 4.SearchBookByAuthor \n 5.UpdateBookBytitle \n 6.RemoveBookById \n 7.Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter book title");
				String title=sc.next();
				System.out.println("Enter Author name");
				String author=sc.next();
				System.out.println("Enter the cost");
				int cost=sc.nextInt();
				System.out.println("Enter the book id");
				int id=sc.nextInt();
				System.out.println("Enter the no of pages");
				int noOfPages=sc.nextInt();
				l.addBook(new Book(title,author,cost,id,noOfPages));
			}
			break;
			case 2:
			{
				l.showBook();
			}
			break;
			case 3:
			{
				System.out.println("Enter the book id");
				while(true)
				{
					try
					{
						int id=sc.nextInt();
						l.searchBookById(id);
						break;
					}
					catch(EmptyException e)
					{
						System.out.println("Enter valid book id");
					}
				}
			}
			break;
			case 4:
			{
				System.out.println("Enter Author name");
				while(true)
				{
					try
					{
						String author=sc.next();
						l.searchBookByAuthor(author);
						break;
					}
					catch(BookNotFoundException e)
					{
						System.out.println("Enter valid author name");
					}
				}
			}
			break;
			case 5:
			{
				System.out.println("Enter the book title");
				String title=sc.next();
				System.out.println("Enter the new cost");
				
				
				while(true)
				{
					try {
						
						int newcost=sc.nextInt();
						l.updateBookCostByTitle(title, newcost);
						break;
					}
					catch(BookNotUpdatedException e)
					{
						System.out.println("enter valid book title,cost");
					}
					
				}
			}
			break;
			case 6:
			{
				System.out.println("Enter the book id");
				while(true)
				{
					try
					{
						int id=sc.nextInt();
						l.removeBookById(id);
						break;
					}
					catch(BookNotRemovedException e)
					{
						System.out.println("Enter valid book id");
					}
				}
			}
			break;
			case 7:
			{
				start=false;
				System.out.println("Thank you....");
			}
			break;
			default:System.out.println("Invalid choice");
			}
		}
	}
}
