package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableObjectValue;

public class Student_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
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
	public void test() {
		
		StringProperty firstNameTest = new SimpleStringProperty();
		firstNameTest.setValue("hi");
		
		StringProperty lastNameTest = new SimpleStringProperty();
		lastNameTest.setValue("hi");
		
		StringProperty addressTest = new SimpleStringProperty();
		addressTest.setValue("hi");
		
		IntegerProperty postalCode = new SimpleIntegerProperty();
		postalCode.setValue(42);
		
		StringProperty cityTest = new SimpleStringProperty();
		cityTest.setValue("hi");
		
		ObjectProperty<LocalDate> dateTest = new SimpleObjectProperty<LocalDate>();
		dateTest.setValue(LocalDate.now());
		
		
		
		
		PersonDomainModel URGE = new PersonDomainModel(firstNameTest, lastNameTest, addressTest, postalCode, cityTest, dateTest);
		
		PersonDAL.addPerson(URGE);
		PersonDAL.getPersons();
		PersonDAL.updatePerson(URGE);
		PersonDAL.deletePerson(URGE.getPersonID());
		PersonDAL.getPerson(URGE.getPersonID());
		PersonDAL.getPerson(null);
		
	}

}
