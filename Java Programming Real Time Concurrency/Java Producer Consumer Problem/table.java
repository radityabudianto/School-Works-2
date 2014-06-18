/************************************

Raditya Budianto
100836539
Assignment 2

*************************************/

public class Table {
	static boolean empty=true;// table is empty
	static Object Ingredients1, Ingredients2;
	
	public Table(){
		
	}
	
	
	//Agent put 2 Ingredients on table
	public synchronized void put(Object x, Object y)
	{
		try{	
			while(!empty)
			{
				wait();
			}
		}catch(InterruptedException e){}
		Ingredients1=x;
		Ingredients2=y;
		//this.Ingredients2=y.toString();
		empty=false;
		notifyAll();
		System.out.println("Ingredients on Table "+'"'+Ingredients1.toString()+'"'+ " and " +'"'+Ingredients2+'"');
	}

	//
	public synchronized int get()
	{
		try{	
			while(empty)
			{
				wait();
			}
	}catch(InterruptedException e){}

		
		
	//The chef that is not choosen by the sandwich take all the ingredients from table
	if((Ingredients1=="PeanutButter" && Ingredients2=="Jam")||(Ingredients2=="PeanutButter" && Ingredients1=="Jam"))
	{	
		empty=true;
		notifyAll();
		System.out.println("case1");
		return 1;//bread is not choosen
	}
	
	
	
	if((Ingredients1=="PeanutButter" && Ingredients2=="Bread")||(Ingredients2=="PeanutButter" && Ingredients1=="Bread"))
	{	
		empty=true;
		notifyAll();
		System.out.println("case2");
		return 2;//Jam is not choosen
	}
	
	
	else
	{	
		empty=true;
		notifyAll();
		System.out.println("case3");
		return 3;//PeanutButter is not choosen
	}

	}//end get

	public static void main(String[] args)
	{
		new Thread(new Agent()).start();
		new Thread(new Jam()).start();
		new Thread(new Bread()).start();
		new Thread(new PeanutButter()).start();
	}
	

	
}