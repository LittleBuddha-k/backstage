package com.littlebuddha.backstage;

import com.littlebuddha.backstage.test.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class BackstageApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testDB() {
        System.out.println(dataSource.getClass());
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
