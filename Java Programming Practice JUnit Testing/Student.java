
package classes;

import java.util.*;
import java.lang.*;

public class Student extends Person
{
   private static int nextFreeNumber = 0;
   private int number;
   private String firstName;
   private String lastName;
   
   public Student(String first, String last, int number) {
	   super(first,last);
	   		if(number<0)
	   		{
	   			throw new IllegalArgumentException("Number cannot be negative.");
	   		}
	   		else
	   		{
	   		
	   				this.number=number;
	   				this.firstName=first;
	   				this.lastName=last;
	   		}
	};

   public int getNumber() {
	   if(number!=nextFreeNumber)
	   {
		   return number;
	   }
	   else
	   {
		   return -1; }
	   }
	   

   public String getFirst() { 
	   
	   if(this.firstName!=null)
	   {
		   return this.firstName;
	   }
	   else
	   {
		   return null;
	   }
}	   
	   
public String getLast() { 
		   
		   if(this.lastName!=null)
		   {
			   return this.lastName;
		   }
		   else
		   {
			   return null;
		   }		   
// You decide if you need toString() and equals()
}
   	
   // You decide if you need toString() and equals()
}
