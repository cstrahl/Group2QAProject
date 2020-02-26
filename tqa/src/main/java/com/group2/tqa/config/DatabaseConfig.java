package com.group2.tqa.config;

import com.group2.tqa.database.CSVDatabase;
import com.group2.tqa.database.NoOpCSVDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class DatabaseConfig {

    public static final File FILE = new File("test.csv");

    @Bean
    public CSVDatabase csvDatabase() {
        return new NoOpCSVDatabase(FILE);
    }

}
