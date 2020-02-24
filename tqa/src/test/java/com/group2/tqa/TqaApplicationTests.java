package com.group2.tqa;

import com.group2.tqa.database.CSVDatabase;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TqaApplicationTests {

	// this tests for the first requirement (system can locate and open the .csv file)
	@Test
	void test1() throws FileNotFoundException {
		// this tests that the file can be located and opened
		File file = new File("test.csv");
		assertEquals(true, file.canExecute());
	}

	// this tests for the second requirement (system can search/read the .csv file)
	@Test
	void test2(){
		File file = new File("test.csv");
		// tests that the file can be read
		assertEquals(true,Files.isReadable(file.toPath()));

		// create an instance of the CSVDatabase to use its search methods
		CSVDatabase database = new CSVDatabase(file);
		// methods return null by default since there is no code being implemented for milestone 2
		// search methods with no parameters are for default searches with no user input (i.e. user wants to look at ALL schools)
		assertEquals(null, database.searchSchools());
		assertEquals(null, database.searchSchools(new String[] {"KSU, GT, UGA"}));
		assertEquals(null, database.searchResearch());
		assertEquals(null, database.searchResearch(new String[] {"AI, machine learning"}));
		assertEquals(null, database.searchClasses());
		assertEquals(null, database.searchClasses(new String[] {"CS 3305, CS 3502, CS 3503"}));
	}

	// this tests for the third requirement (system can add a research project/course if it doesn't already exist)
	@Test
	void test3(){
		File file = new File("test.csv");
		// tests that data can be written to the file
		assertEquals(true,Files.isWritable(file.toPath()));

		CSVDatabase database = new CSVDatabase(file);
		// tests if a project with a name of 'machine learning' already exists
		assertEquals(true, database.exists("Project", "machine learning"));
	}
}
