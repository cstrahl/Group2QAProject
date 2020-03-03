package com.group2.tqa.Functionality;

import com.group2.tqa.database.CSVDatabase;
import com.group2.tqa.entities.OfferedClass;
import com.group2.tqa.entities.Project;
import com.group2.tqa.entities.School;
import com.group2.tqa.entities.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.group2.tqa.config.DatabaseConfig.FILE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FunctionalTests {

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

        List<Project> result = this.database.searchResearch(new String[]{"Kennesaw State University"});
        assertTrue(result.size() >= 10);
        List<Project> filteredResults = result.stream().filter(project -> project.getName().equals("CCSV Research Project")).collect(Collectors.toList());
        assertEquals(1, filteredResults.size());

        Project project = filteredResults.get(0);
        assertEquals(2, project.getSchools().size());
        assertTrue(project.getFaculty().size() >= 3);
        assertEquals(2000000.00, project.getFunding());

        Stream<Tag> stream = project.getSubjects().stream();
        assertTrue(stream.anyMatch(tag -> tag.getName().equals("Engineering")));
        assertTrue(stream.anyMatch(tag -> tag.getName().equals("Computer Science")));
        assertTrue(stream.anyMatch(tag -> tag.getName().equals("Architecture")));
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
}
