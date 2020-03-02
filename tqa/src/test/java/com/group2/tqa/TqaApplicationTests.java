package com.group2.tqa;

import com.group2.tqa.database.CSVDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Null;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static com.group2.tqa.config.DatabaseConfig.FILE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TqaApplicationTests {

    @Autowired
    private CSVDatabase database;

    // this tests for the first requirement (system can locate, open, and read the .csv file)
    // Addresses R1, R1.1, R1.2
    @Test
    void testCSVFileCanBeOpenedReadAndWrittenTo() {
        // this tests that the file can be located and opened and Read
        assertTrue(FILE.canExecute());
        assertTrue(Files.isReadable(FILE.toPath()));
        assertTrue(Files.isWritable(FILE.toPath()));
    }

    // Addresses R2.2
    @Test
    void testCanGetAndSearchSchools() {
        // search methods with no parameters are for default searches with no user input
        // 	(i.e. user wants to look at ALL schools)
        assertTrue(this.database.searchSchools().size() >= 5);
        assertEquals(1, this.database.searchSchools(new String[]{"Kennesaw"}).size());
        assertEquals(1, this.database.searchSchools(new String[]{"Kennesaw State University"}).size());
        assertTrue(this.database.searchSchools(new String[]{"Georgia"}).size() >= 5);


        assertEquals(null, this.database.searchClasses());
        assertEquals(null, this.database.searchClasses(new String[]{"CS 3305, CS 3502, CS 3503"}));
    }

    // Address R2.3
    @Test
    void testCanGetAndSearchResearch() {
        assertTrue(this.database.searchResearch().size() >= 10);
        assertTrue(this.database.searchResearch(new String[]{"Widdershins"}).isEmpty());
        assertEquals(1, this.database.searchResearch(new String[]{"CCSV Research Project"}).size());
        assertEquals(1, this.database.searchResearch(new String[]{"Jaylim Gilliam"}).size());
//
//		After searching for Kennesaw State University, requesting statistics should return a result list
//		of at least 10 projects. One project should be the CCSV Research Project. It should have the
//		following characteristics:
//			Two universities connected to it (Kennesaw State University and Georgia Highlands College)
//			At least 3 faculty members connected to it
//			“Engineering”, “Computer Science”, and “Architecture” subjects connected to it
//			$2 million dollars in funding is attached to the research project

//		List<String[]> result = this.database.searchResearch(new String[]{"Kennesaw State University"});
//		assertEquals(10, result.size());
//		result.forEach(array -> Arrays.asList(array)
//						.stream()
//						.filter(str -> ((String) str).equals("CCSV Research Project"))
//				.collect(Collectors.toList()));
    }

    // Addresses R2.4
    @Test
    void testCanGetAndSearchClasses() {
        assertFalse(this.database.searchClasses().isEmpty());
		assertFalse(this.database.searchClasses(new String[]{"CS 3305, CS 3502, CS 3503"}).isEmpty());
    }

    // this tests for the third requirement (system can add a research project/course if it doesn't already exist)
    // Addresses R3, R3.1, R3.2
    @Test
    void test3() {

        // tests if a project with a name of 'machine learning' already exists
        assertEquals(true, this.database.exists("Project", "machine learning"));
    }


    // Input space partitioning for CSV file type.
    // Characteristics: File Type
    // Blocks: CSV, null, other (JPG, PNG, etc..)
    @Test
    void testISPFileType() {
        assertNotNull(FILE); // test if file is null or not
        assertTrue(FILE.getName().toLowerCase().contains(".csv")); // tests if file is a csv type or another type
    }

    // Input space partitioning for searching schools input.
    // Characteristics: Type of input array
    // Blocks: null, empty (nothing), String array
    @Test
    void testISPSearchSchools() {
        assertNull(this.database.searchSchools(null)); // null input

        List<String[]> emptySearch = this.database.searchSchools(new String[]{""}); // empty search
        assertNull(emptySearch);

        List<String[]> allSearch = this.database.searchSchools(); // no input parameters - returns all research
        assertTrue(allSearch.size() > 0);

        List<String[]> validSearch = this.database.searchSchools(new String[]{"Kennesaw"}); // valid search
        assertEquals(1, validSearch.size());
    }

    // Input space partitioning for searching schools input.
    // Characteristics: Type of input array
    // Blocks: null, empty array, no input (no parameters), String array
    @Test
    void testISPSearchResearch() {
        assertNull(this.database.searchResearch(null)); // null input

        List<String[]> emptySearch = this.database.searchResearch(new String[]{""}); // empty search
        assertTrue(emptySearch.isEmpty());

        List<String[]> allSearch = this.database.searchResearch(); // no input parameters - returns all research
        assertTrue(allSearch.size() > 0);

        List<String[]> validSearch = this.database.searchResearch(new String[]{"CCSV Research Project"}); // valid search
        assertEquals(1, validSearch.size());
    }

    // Input space partitioning for searching classes input.
    // Characteristics: Type of input array
    // Blocks: null, empty array, no input (no parameters), String array
    @Test
    void testISPSearchClasses() {

        assertNull(this.database.searchClasses(null)); // null input

        List<String[]> emptySearch = this.database.searchClasses(new String[]{""}); // empty search
        assertTrue(emptySearch.isEmpty());

        List<String[]> allSearch = this.database.searchClasses(); // no input parameters - returns all research
        assertTrue(allSearch.size() > 0);

        List<String[]> validSearch = this.database.searchClasses(new String[]{"CS 3305"}); // valid search
        assertEquals(1, validSearch.size());

    }






}
