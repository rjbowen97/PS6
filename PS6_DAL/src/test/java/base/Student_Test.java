package base;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import domain.PersonDomainModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Student_Test {
	
	private static PersonDomainModel testPerOne;
	private static PersonDomainModel testPerTwo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		Date birthDate = null;
		try
		{
			birthDate = new SimpleDateFormat("yyyy-mm-dd").parse("1997-04-09");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		Date birthDateTwo = null;
		try
		{
			birthDateTwo = new SimpleDateFormat("yyyy-mm-dd").parse("1999-09-01");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		testPerOne = new PersonDomainModel("Richard",
				"Bowen", "Lancaster", 17603,
				"2632 Standardbred Drive", birthDate);
		
		testPerTwo = new PersonDomainModel("Brendan",
				"Bowen", "Lancaster", 17603,
				"2632 Standardbred Drive", birthDate);
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addPersonMethodTest()
	{
		PersonDomainModel per;
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		
		PersonDAL.addPerson(testPerOne);
		
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		assertNotNull("Didnt find person", per);
		System.out.println(testPerOne.getPersonID() + "located in database");
		
	}
	
	@Test
	public void updatePersonMethodTest()
	{
		PersonDomainModel per;
		String updatedFirstName = "RJ";
		String previousFirstName = testPerOne.getFirstName();
		
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		PersonDAL.addPerson(testPerOne);
		
		testPerOne.setFirstName(updatedFirstName);
		PersonDAL.updatePerson(testPerOne);
		
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		assertTrue("Name change success!", testPerOne.getFirstName() == updatedFirstName);
		assertFalse("Name change failed.", testPerOne.getFirstName() == previousFirstName);
		
	}
	
	@Test
	public void deletePersonMethodTest()
	{
		PersonDomainModel per;
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		PersonDAL.addPerson(testPerOne);
		
		PersonDAL.deletePerson(testPerOne.getPersonID());
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		assertNull("Person now deleted, so database is empty", per);
	}
	
	@Test
	public void getPersonMethodTest()
	{
		//add person one
		PersonDomainModel per;
		ArrayList<PersonDomainModel> personList = new ArrayList<PersonDomainModel>();
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		PersonDAL.addPerson(testPerOne);
		per = PersonDAL.getPerson(testPerOne.getPersonID());
		System.out.println("Found person: " + testPerOne.getPersonID());
		
		//add person two
		PersonDAL.addPerson(testPerTwo);
		
		per = PersonDAL.getPerson(testPerTwo.getPersonID());
		System.out.println("Found person: " + testPerTwo.getPersonID());
		
		personList = PersonDAL.getPersons();
		assertTrue("Size of database should be greater than zero", personList.size() > 0);
		
	}
	


}
