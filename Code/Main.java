import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;									//to create Random Integers
import java.util.Scanner;	
import java.util.concurrent.TimeUnit;						//to measure Runtime

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		int input;
		int input_1;
		int input_2;
		boolean found;
		
		System.out.println("\t\t\t\t\t\t\t" + "Welcome to my Program !");
		System.out.println();
		
		mainMenu();
		
		Scanner scan = new Scanner(System.in);
		
		input = scan.nextInt();
		//scan.close();
		
		if (input == 1)
		{
			Menu_2("Unsorted Array");
			input_1 = scan.nextInt();
			
			if (input_1 == 1)
			{
				String s1 = "\t" + "Adding Customer Data File in Unsorted Array";
				Menu_3(s1);
				
				UnsortedArray<Customer> unsorted_array = new UnsortedArray<Customer>(100);
				
				Scanner s = new Scanner(new File("Book1.txt"));
				
				while( s.hasNext() )							
			    {
					Customer Entry = new Customer();			
					
					Entry.setFirst(s.next());					
					Entry.setSecond(s.next());					
					Entry.setID(s.nextInt());					
					
					unsorted_array.add(Entry);					
			    }
				s.close();										
				
				unsorted_array.Print();
				
				Menu_4a();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = unsorted_array.Contains(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5a(input_2, endTime - startTime, "Unsorted Array"); 
				else
					Menu_6a(endTime - startTime, unsorted_array.Get(input_2).getFirst(), unsorted_array.Get(input_2).getSecond() , "Unsorted Array");
				
			}
			
			else if (input_1 == 2)
			{
				String s1 = "\t" + "Adding Random Generated Numers in Unsorted Array";
				Menu_3(s1);
				
				UnsortedArray<Integer> unsorted_array = new UnsortedArray<Integer>(2000);
				
				Random rand = new Random(10);
				
				for (int i =0; i< 2000; i++)
				{
					int x = rand.nextInt(99999);
					unsorted_array.add(x);
				}
				
				unsorted_array.print();
				
				Menu_4b();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = unsorted_array.contains(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5b(input_2, endTime - startTime, "Unsorted Array");
				else
					Menu_6b(endTime - startTime, "Unsorted Array");
			}
			
			else
				System.out.println("\nInvalid Input !");
			
		}
		
		else if (input == 2)
		{
			Menu_2("Sorted Array");
			input_1 = scan.nextInt();
			
			if (input_1 == 1)
			{
				String s1 = "\t" + "Adding Customer Data File in Sorted Array";
				Menu_3(s1);
				
				UnsortedArray<Customer> unsorted_array = new UnsortedArray<Customer>(100);
				
				Scanner s = new Scanner(new File("Book1.txt"));
				
				while( s.hasNext() )							
			    {
					Customer Entry = new Customer();			
					
					Entry.setFirst(s.next());					
					Entry.setSecond(s.next());					
					Entry.setID(s.nextInt());					
					
					unsorted_array.add(Entry);					
			    }
				s.close();										
				
				SortedArray sorted_array = new SortedArray(unsorted_array);
				
				sorted_array.Print();
				
				Menu_4a();
				input_2 = scan.nextInt();
				sorted_array.Contains(input_2);

				double startTime1 = System.nanoTime();
				found = sorted_array.Contains(input_2);
				double endTime1 = System.nanoTime();
				sorted_array.Size();

				double startTime2 = System.nanoTime();
				found = sorted_array.BinaryContains(input_2);
				double endTime2 = System.nanoTime();
				
				if (!found)
					Menu_5c(input_2, endTime1 - startTime1, endTime2 - startTime2, "Sorted Array");
				else
					Menu_7a(endTime1 - startTime1, endTime2 - startTime2, sorted_array.Get(input_2).getFirst(), sorted_array.Get(input_2).getSecond() , "Sorted Array");
			}
			
			else if (input_1 == 2)
			{
				String s1 = "\t" + "Adding Random Generated Numers in Sorted Array";
				Menu_3(s1);
				
				UnsortedArray<Integer> unsorted_array = new UnsortedArray<Integer>(2000);
				
				Random rand = new Random(10);
				
				for (int i =0; i< 2000; i++)
				{
					int x = rand.nextInt(99999);
					unsorted_array.add(x);
				}
				
				SortedArray<Integer> sorted_array = new SortedArray<Integer>(unsorted_array);
				
				sorted_array.print();
				
				Menu_4b();
				input_2 = scan.nextInt();
//				Runtime.getRuntime().exec("cmd /c start clearCache.bat");
				found = sorted_array.contains(input_2); 
				
				double startTime1 = System.nanoTime();
				found = sorted_array.contains(input_2); 
				double endTime1 = System.nanoTime();
				
				double startTime2 = System.nanoTime();
				found = sorted_array.BinaryContain(input_2);
				double endTime2 = System.nanoTime();
				
				if (!found)
					Menu_5d(input_2, endTime1 - startTime1, endTime2 - startTime2, "Sorted Array");
				
				else
				{
					Menu_7b(endTime1 - startTime1, endTime2 - startTime2, "Sorted Array");
				}
			}
			
			else
				System.out.println("\nInvalid Input !");
			
		}
		
		else if (input == 3)
		{
			Menu_2("Unsorted Linked list");
			input_1 = scan.nextInt();
			
			if (input_1 == 1)
			{
				String s1 = "\t" + "Adding Customer Data File in Unsorted Linked list";
				Menu_3(s1);
				
				UnsortedLinkedlist<Object> unsorted_linked = new UnsortedLinkedlist<Object>();
				
				Scanner s = new Scanner(new File("Book1.txt"));
				
				while( s.hasNext() )							
			    {
					Customer Entry = new Customer();			
					
					Entry.setFirst(s.next());					
					Entry.setSecond(s.next());					
					Entry.setID(s.nextInt());					
					
					unsorted_linked.add(Entry);					
			    }
				s.close();										
				
				unsorted_linked.Print();
				
				Menu_4a();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = unsorted_linked.Contains(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5a(input_2, endTime - startTime, "Unsorted Linked list");
				else
					Menu_6a(endTime - startTime, unsorted_linked.Get(input_2).getFirst(), unsorted_linked.Get(input_2).getSecond() , "Unsorted Linked list");
			}
			
			else if (input_1 == 2)
			{
				String s1 = "\t" + "Adding Random Generated Numers in Unsorted Linked list";
				Menu_3(s1);
				
				UnsortedLinkedlist<Integer> unsorted_linked = new UnsortedLinkedlist<Integer>();
				
				Random rand = new Random(10);
				
				for (int i =0; i< 2000; i++)
				{
					int x = rand.nextInt(99999);
					unsorted_linked.add(x);
				}
				
				unsorted_linked.print();
				
				Menu_4b();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = unsorted_linked.contains(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5b(input_2, endTime - startTime, "Unsorted Linked list");
				else
					Menu_6b(endTime - startTime, "Unsorted Linked list");
			}
			
			else
				System.out.println("\nInvalid Input !");
		}
		
		else if (input == 4)
		{
			Menu_2("Sorted Linked list");
			input_1 = scan.nextInt();
			
			if (input_1 == 1)
			{
				String s1 = "\t" + "Adding Customer Data File in Sorted Linked list";
				Menu_3(s1);
				
				UnsortedLinkedlist<Object> unsorted_linked = new UnsortedLinkedlist<Object>();
				
				Scanner s = new Scanner(new File("Book1.txt"));
				
				while( s.hasNext() )							
			    {
					Customer Entry = new Customer();			
					
					Entry.setFirst(s.next());					
					Entry.setSecond(s.next());					
					Entry.setID(s.nextInt());					
					
					unsorted_linked.add(Entry);					
			    }
				s.close();										
				
				SortedLinkedlist sorted_linked = new SortedLinkedlist(unsorted_linked);
				
				sorted_linked.Print();
				
				Menu_4a();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = sorted_linked.Contains(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5a(input_2, endTime - startTime, "Sorted Linked list");
				else
					Menu_6a(endTime - startTime, sorted_linked.Get(input_2).getFirst(), sorted_linked.Get(input_2).getSecond() , "Sorted Linked list");
			}
			
			else if (input_1 == 2)
			{
				String s1 = "\t" + "Adding Random Generated Numers in Sorted Linked list";
				Menu_3(s1);
				
				UnsortedLinkedlist<Integer> unsorted_linked = new UnsortedLinkedlist<Integer>();
				
				Random rand = new Random(10);
				
				for (int i =0; i< 2000; i++)
				{
					int x = rand.nextInt(99999);
					unsorted_linked.add(x);
				}
				
				SortedLinkedlist<Integer> sorted_linked = new SortedLinkedlist<Integer>(unsorted_linked);
				sorted_linked.print();
				
				Menu_4b();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = sorted_linked.contains(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5b(input_2, endTime - startTime, "Sorted Linked list");
				else
					Menu_6b(endTime - startTime, "Sorted Linked list");
			}
			
			else
				System.out.println("\nInvalid Input !");
		}
		
		else if (input == 5)
		{
			Menu_2("Binary Search Tree");
			input_1 = scan.nextInt();
			
			if (input_1 == 1)
			{
				String s1 = "\t" + "Adding Customer Data File in Binary Search Tree" + "\n\tIn-order Traversal";
				Menu_3(s1);
				
				BinarySearchTree tree = new BinarySearchTree();
				
				Scanner s = new Scanner(new File("Book1.txt"));
				
				while( s.hasNext() )							
			    {
					Customer Entry = new Customer();			
					
					Entry.setFirst(s.next());					
					Entry.setSecond(s.next());					
					Entry.setID(s.nextInt());					
					
					tree.add(Entry);							
			    }
				s.close();	
				
				tree.InOrder();
				System.out.println();
				Menu_4a();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = tree.Search(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5e(input_2, endTime - startTime, "Binary Search Tree");
				else
					Menu_8a(endTime - startTime, tree.Get(input_2).getInfoo().getFirst(), tree.Get(input_2).getInfoo().getSecond() , "Binary Search Tree");
			}
			
			else if (input_1 == 2)
			{
				String s1 = "\t" + "Adding Random Generated Numers in Binary Search Tree" + "\n\tIn-order Traversal";
				Menu_3(s1);
				
				BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
				
				Random rand = new Random(10);
				
				for (int i =0; i< 2000; i++)
				{
					int x = rand.nextInt(99999);
					tree.add(x);
				}
				
				tree.inOrder();
				System.out.println();
				Menu_4b();
				input_2 = scan.nextInt();
				
				double startTime = System.nanoTime();
				found = tree.search(input_2);
				double endTime = System.nanoTime();
				
				if (!found)
					Menu_5e(input_2, endTime - startTime, "Binary Search Tree");
				else
					Menu_8b(endTime - startTime, "Binary Search Tree");
			}
			
			else
				System.out.println("\nInvalid Input !");
		}
		
		else if (input == 6)
		{
			Menu_2("Run All");
			input_1 = scan.nextInt();
			
			if (input_1 == 1)
			{
				String s1 = "Adding Customer Data File in Unsorted Array...";
				String s2 = "\n" + "Adding Customer Data File in Sorted Array...";
				String s3 = "\n" + "Adding Customer Data File in Unsorted Linked list...";
				String s4 = "\n" + "Adding Customer Data File in Sorted Linked list...";
				String s5 = "\n" + "Adding Customer Data File in Binary Search Tree";
				Menu_3(s1+s2+s3+s4+s5);
				
				UnsortedArray<Customer> unsorted_array = new UnsortedArray<Customer>(100);
				UnsortedLinkedlist<Object> unsorted_linked = new UnsortedLinkedlist<Object>();
				BinarySearchTree tree = new BinarySearchTree();
				
				Scanner s = new Scanner(new File("Book1.txt"));
				
				while( s.hasNext() )							
			    {
					Customer Entry = new Customer();			
					
					Entry.setFirst(s.next());					
					Entry.setSecond(s.next());					
					Entry.setID(s.nextInt());					
					
					unsorted_array.add(Entry);					
					unsorted_linked.add(Entry);
					tree.add(Entry);
			    }
				
				unsorted_array.Print();
				SortedArray sorted_array = new SortedArray(unsorted_array);
				SortedLinkedlist sorted_linked = new SortedLinkedlist(unsorted_linked);
				
				Menu_4a();
				input_2 = scan.nextInt();
				unsorted_array.Get(input_2);
				sorted_array.Get(input_2);
				
				double startTime1 = System.nanoTime();
				found = unsorted_array.Contains(input_2);
				double endTime1 = System.nanoTime();
				
				double startTime2 = System.nanoTime();
				found = sorted_array.Contains(input_2);
				double endTime2 = System.nanoTime();
				
				double startTime22 = System.nanoTime();
				found = sorted_array.BinaryContains(input_2);
				double endTime22 = System.nanoTime();
				
				double startTime3 = System.nanoTime();
				found = unsorted_linked.Contains(input_2);
				double endTime3 = System.nanoTime();
				
				double startTime4 = System.nanoTime();
				found = sorted_linked.Contains(input_2);
				double endTime4 = System.nanoTime();
				
				double startTime5 = System.nanoTime();
				found = tree.Search(input_2);
				double endTime5 = System.nanoTime();
				
				if (!found)
				{
					Menu_9c(endTime1 - startTime1, endTime2 - startTime2, endTime22 - startTime22, endTime3 - startTime3, 
					endTime4 - startTime4, endTime5 - startTime5);
				
				}
				else
					Menu_9a(endTime1 - startTime1, endTime2 - startTime2, endTime22 - startTime22, endTime3 - startTime3, 
					endTime4 - startTime4, endTime5 - startTime5, unsorted_array.Get(input_2).getFirst(), unsorted_array.Get(input_2).getSecond());
			}
			
			else if (input_1 == 2)
			{
				String s1 = "Adding Random Generated Numers in Unsorted Array...";
				String s2 = "\n" + "Adding Random Generated Numers in Sorted Array...";
				String s3 = "\n" + "Adding Random Generated Numers in Unsorted Linked list...";
				String s4 = "\n" + "Adding Random Generated Numers in Sorted Linked list...";
				String s5 = "\n" + "Adding Random Generated Numers in Binary Search Tree";
				Menu_3(s1+s2+s3+s4+s5);
				
				UnsortedArray<Integer> unsorted_array = new UnsortedArray<Integer>(2000);
				UnsortedLinkedlist<Integer> unsorted_linked = new UnsortedLinkedlist<Integer>();
				BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
				
				Random rand = new Random(10);
				
				for (int i =0; i< 2000; i++)
				{
					int x = rand.nextInt(99999);
					unsorted_array.add(x);
					unsorted_linked.add(x);
					tree.add(x);
				}
				
				unsorted_array.print();
				SortedArray<Integer> sorted_array = new SortedArray<Integer>(unsorted_array);
				SortedLinkedlist<Integer> sorted_linked = new SortedLinkedlist<Integer>(unsorted_linked);
				
				Menu_4b();
				input_2 = scan.nextInt();
				found = unsorted_array.contains(input_2);
				unsorted_array.get(input_2);
				sorted_array.get(input_2);
				
				double startTime1 = System.nanoTime();
				found = unsorted_array.contains(input_2);
				double endTime1 = System.nanoTime();
				
				double startTime2 = System.nanoTime();
				found = sorted_array.contains(input_2);
				double endTime2 = System.nanoTime();
				
				double startTime22 = System.nanoTime();
				found = sorted_array.BinaryContain(input_2);
				double endTime22 = System.nanoTime();
				
				double startTime3 = System.nanoTime();
				found = unsorted_linked.contains(input_2);
				double endTime3 = System.nanoTime();
				
				double startTime4 = System.nanoTime();
				found = sorted_linked.contains(input_2);
				double endTime4 = System.nanoTime();
				
				double startTime5 = System.nanoTime();
				found = tree.search(input_2);
				double endTime5 = System.nanoTime();
				if (!found)
				{
					Menu_9d(endTime1 - startTime1, endTime2 - startTime2, endTime22 - startTime22, endTime3 - startTime3, 
							endTime4 - startTime4, endTime5 - startTime5);
				}
				else
					Menu_9b(endTime1 - startTime1, endTime2 - startTime2, endTime22 - startTime22, endTime3 - startTime3, 
					endTime4 - startTime4, endTime5 - startTime5);
			}
			
			else
				System.out.println("\nInvalid Input !");	
			
		}
		
		else
			System.out.println("\nInvalid Input !");
	}
	
	
	
	public static void mainMenu()
	{
		String s1 = "1. Unsorted Array" + "\t";
		String s2 = "2. Sorted Array" + "\t\t";
		String s3 = "3. Unsorted Linked list" + "\t\t";
		String s4 = "4. Sorted Linked list" + "\t\t";
		String s5 = "5. Binary Search Tree" + "\t\t";
		String s6 = "6. Run All";
		
		Box(s1 + s2 + s3 + s4 + s5 + s6);
        
		System.out.print("Select Menu Number to Enter Program: ");
	}
	
	public static void Menu_2(String s)
	{
		String s1 = "1. Input Customer Data File" + "\t\t";
		String s2 = "2. Input Random Generated Numers";
		
		System.out.println("\n\t\t\t" + s);
		Box(s1 + s2);
		System.out.print("Select Menu Number to Enter Program: ");
	}
	
	public static void Menu_3(String s)
	{
		System.out.println();
		Box(s);
	}
	
	public static void Menu_4a()
	{
		String s1 = "Enter Customer ID to Search: ";
		System.out.print(s1);
	}
	
	public static void Menu_4b()
	{
		String s1 = "Enter Number to Search: ";
		System.out.print(s1);
	}
	
	public static void Menu_5a(int x, double time, String s)
	{
		time = time/1000000;
		
		System.out.println("\nThe Customer ID " + x + " was NOT FOUND in " + s);
		System.out.println("Time taken for Sequential Search: " + time + " milliseconds");
		
	}
	
	public static void Menu_5b(int x, double time, String s)
	{
		time = time/1000000;
		
		System.out.println("\nThe Number " + x + " was NOT FOUND in " + s); 
		System.out.println("Time taken for Sequential Search: " + time + " milliseconds");
	}
	
	public static void Menu_5c(int x, double time1, double time2, String s)
	{
		time1 = time1/1000000;
		time2 = time2/1000000;
		
		System.out.println("\nThe Customer ID " + x + " was NOT FOUND in " + s);
		System.out.println("Time taken for Sequential Search: " + time1 + " milliseconds");
		System.out.println("Time taken for Binary Search: " + time2 + " milliseconds");	
	}
	
	public static void Menu_5d(int x, double time1, double time2, String s)
	{
		time1 = time1/1000000;
		time2 = time2/1000000;
		
		System.out.println("\nNumber " + x + " was NOT FOUND in " + s);
		System.out.println("Time taken for Sequential Search: " + time1 + " milliseconds");
		System.out.println("Time taken for Binary Search: " + time2 + " milliseconds");	
	}
	
	public static void Menu_5e(int x, double time, String s)
	{
		time = time/1000000;
		
		System.out.println("\nThe Customer ID " + x + " was NOT FOUND in " + s);
		System.out.println("Time taken for Binary Tree Search: " + time + " milliseconds");
		
	}
	
	public static void Menu_6a(double time, String first, String second, String s)
	{
		time = time/1000000;
		
		System.out.println("\nCustomer ID FOUND in " + s);
		System.out.println("Customer Name: " + first + " " + second);
		System.out.println("Time taken for Sequential Search: " + time + " milliseconds"); 
	}
	
	public static void Menu_6b(double time, String s)
	{
		time = time/1000000;
		
		System.out.println("\nNumber FOUND in " + s);
		System.out.println("Time taken for Sequential Search: " + time + " milliseconds"); 
	}
	
	public static void Menu_7a(double time1, double time2, String first, String second, String s)
	{
		time1 = time1/1000000;
		time2 = time2/1000000;
		
		System.out.println("\nCustomer ID FOUND in " + s);
		System.out.println("Customer Name: " + first + " " + second);
		System.out.println("Time taken for Sequential Search: " + time1 + " milliseconds"); 
		System.out.println("Time taken for Binary Search: " + time2 + " milliseconds"); 
	}
	
	public static void Menu_7b(double time1, double time2, String s)
	{
		time1 = time1/1000000;
		time2 = time2/1000000;
		
		System.out.println("\nNumber FOUND in " + s);
		System.out.println("Time taken for Sequential Search: " + time1 + " milliseconds"); 
		System.out.println("Time taken for Binary Search: " + time2 + " milliseconds"); 
	}
	
	public static void Menu_8a(double time, String first, String second, String s)
	{
		time = time/1000000;
		
		System.out.println("\nCustomer ID FOUND in " + s);
		System.out.println("Customer Name: " + first + " " + second);
		System.out.println("Time taken for Binary Tree Search: " + time + " milliseconds"); 
	}
	
	public static void Menu_8b(double time, String s)
	{
		time = time/1000000;
		
		System.out.println("\nNumber FOUND in " + s);
		System.out.println("Time taken for Binary Tree Search: " + time + " milliseconds"); 
	}
	
	public static void Menu_9a(double time1, double time2, double time22 , double time3, double time4, double time5, String first, String second)
	{
		System.out.println("\nCustomer ID FOUND");
		System.out.println("Customer Name: " + first + " " + second);
		System.out.println("Time taken for Sequential Search in Unsorted Array:\t\t" + time1 + " nanoseconds"); 
		System.out.println("Time taken for Sequential Search  in Sorted Array:\t\t" + time2 + " nanoseconds");
		System.out.println("Time taken for Binary Search  in Sorted Array:\t\t\t" + time22 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Unsorted Linked list:\t" + time3 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Sorted Linked list:\t\t" + time4 + " nanoseconds");
		System.out.println("Time taken for Binary Tree Search:\t\t\t\t" + time5 + " nanoseconds"); 
	}
	
	public static void Menu_9b(double time1, double time2, double time22 , double time3, double time4, double time5)
	{
		System.out.println("\nNumber FOUND");
		
		System.out.println("Time taken for Sequential Search in Unsorted Array:\t\t" + time1 + " nanoseconds"); 
		System.out.println("Time taken for Sequential Search  in Sorted Array:\t\t" + time2 + " nanoseconds");
		System.out.println("Time taken for Binary Search  in Sorted Array:\t\t\t" + time22 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Unsorted Linked list:\t" + time3 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Sorted Linked list:\t\t" + time4 + " nanoseconds");
		System.out.println("Time taken for Binary Tree Search:\t\t\t\t" + time5 + " nanoseconds"); 
	}
	
	public static void Menu_9c(double time1, double time2, double time22 , double time3, double time4, double time5)
	{
		System.out.println("\nCustomer ID NOT FOUND");
		System.out.println("Time taken for Sequential Search in Unsorted Array:\t\t" + time1 + " nanoseconds"); 
		System.out.println("Time taken for Sequential Search  in Sorted Array:\t\t" + time2 + " nanoseconds");
		System.out.println("Time taken for Binary Search  in Sorted Array:\t\t\t" + time22 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Unsorted Linked list:\t" + time3 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Sorted Linked list:\t\t" + time4 + " nanoseconds");
		System.out.println("Time taken for Binary Tree Search:\t\t\t\t" + time5 + " nanoseconds"); 
	}
	
	public static void Menu_9d(double time1, double time2, double time22 , double time3, double time4, double time5)
	{
		System.out.println("\nNumber NOT FOUND");
		
		System.out.println("Time taken for Sequential Search in Unsorted Array:\t\t" + time1 + " nanoseconds"); 
		System.out.println("Time taken for Sequential Search  in Sorted Array:\t\t" + time2 + " nanoseconds");
		System.out.println("Time taken for Binary Search  in Sorted Array:\t\t\t" + time22 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Unsorted Linked list:\t" + time3 + " nanoseconds");
		System.out.println("Time taken for Sequential Search in Sorted Linked list:\t\t" + time4 + " nanoseconds");
		System.out.println("Time taken for Binary Tree Search:\t\t\t\t" + time5 + " nanoseconds"); 
	}
	
	public double RunTime()
	{
		double startTime = System.nanoTime();
		
		
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime) / 1000000;
		return timeElapsed;
	}
	
	public static void Box(String s)
    {
        int n = 153;
        for (int i=0; i<n+2; i++)
        {
        	System.out.print("-");
        }
        System.out.println();
        
        System.out.println(s);
        
        for (int i=0; i<n+2; i++)
        {
        	System.out.print("-");
        }
        System.out.println();
    }

}
