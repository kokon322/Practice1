package config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "java")
@RequiredArgsConstructor
public class ApplicationConfig {
    private final Environment environment;

    @Bean
    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection("1","2","3");
    };

}
