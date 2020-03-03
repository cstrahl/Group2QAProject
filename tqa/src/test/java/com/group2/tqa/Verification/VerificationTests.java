package com.group2.tqa.Verification;

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
class VerificationTests {

    @Autowired
    private CSVDatabase database;

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

        List<School> emptySearch = this.database.searchSchools(new String[]{""}); // empty search
        assertNull(emptySearch);

        List<School> allSearch = this.database.searchSchools(); // no input parameters - returns all research
        assertTrue(allSearch.size() > 0);

        List<School> validSearch = this.database.searchSchools(new String[]{"Kennesaw"}); // valid search
        assertEquals(1, validSearch.size());
    }

    // Input space partitioning for searching schools input.
    // Characteristics: Type of input array
    // Blocks: null, empty array, no input (no parameters), String array
    @Test
    void testISPSearchResearch() {
        assertNull(this.database.searchResearch(null)); // null input

        List<Project> emptySearch = this.database.searchResearch(new String[]{""}); // empty search
        assertTrue(emptySearch.isEmpty());

        List<Project> allSearch = this.database.searchResearch(); // no input parameters - returns all research
        assertTrue(allSearch.size() > 0);

        List<Project> validSearch = this.database.searchResearch(new String[]{"CCSV Research Project"}); // valid search
        assertEquals(1, validSearch.size());
    }

    // Input space partitioning for searching classes input.
    // Characteristics: Type of input array
    // Blocks: null, empty array, no input (no parameters), String array
    @Test
    void testISPSearchClasses() {

        assertNull(this.database.searchClasses(null)); // null input

        List<OfferedClass> emptySearch = this.database.searchClasses(new String[]{""}); // empty search
        assertTrue(emptySearch.isEmpty());

        List<OfferedClass> allSearch = this.database.searchClasses(); // no input parameters - returns all research
        assertTrue(allSearch.size() > 0);

        List<OfferedClass> validSearch = this.database.searchClasses(new String[]{"CS 3305"}); // valid search
        assertEquals(1, validSearch.size());

    }
}