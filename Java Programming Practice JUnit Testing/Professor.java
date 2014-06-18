package classes;


public class Professor extends Person
{
   private String office;
   private String firstName;
   private String lastName;
   
   public Professor(String firstName, String lastName, String office) {
	  super(firstName, lastName);
	  this.office=office;
	  this.firstName=firstName;
	  this.lastName=lastName;
	   
   };
   
   public void setOffice(String office) { 
	   
	   office=this.office;
	  // System.out.println("The office is in"+office);
	   
   }
   public String getOffice() { 
	   
	   if(office!=null)
	   {
		   return office;
	   }
	   else
	   {
		   return null;
	   }
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
}

