package test;

//import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import classes.Student;


public class TestStudent extends TestCase{
	Student x = new Student("x","y",123);
	@Test
	public void testCorrectNumber() {

		
		
		//test number
		//test Student number
		assertEquals(x.getNumber(),123);
	}
	
	
	public void testStudentfirstName(){
		
		assertEquals(x.getFirst(),"x");
	}
		
	public void testStudentlastName(){
		
		assertEquals(x.getLast(),"y");	
	
	}
	
	
	
	public void testNegativeStudentNumber()
	{	Student z = new Student("a","b",-123);
		assertEquals(z.getNumber(),"Number cannot be negative.");
	}
	
	
}
