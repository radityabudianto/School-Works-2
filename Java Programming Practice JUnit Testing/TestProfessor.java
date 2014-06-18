package test;

import classes.Professor;

//import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class TestProfessor extends TestCase {

	Professor x = new Professor ("asd","zxc","Office");
	@Test
	public void testProfessorConstructor() {
		
		
		assertEquals(x.getOffice(),"Office");
	}
	
	public void testProfessorFirstName() {
		
		assertEquals(x.getFirst(),"asd");
	}

	
	public void testProfessorLastName() {
		
		assertEquals(x.getLast(),"zxzc");
	}



}
