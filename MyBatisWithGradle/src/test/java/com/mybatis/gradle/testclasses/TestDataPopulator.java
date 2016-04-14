package com.mybatis.gradle.testclasses;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis.gradle.util.MyBatisSqlSessionFactory;

public class TestDataPopulator {
    private static Logger logger = LoggerFactory.getLogger(TestDataPopulator.class);

    public static void main(String[] args) {
        initDatabase();
    }

    public static void initDatabase() {
        Connection connection = null;
        Reader reader = null;
        try {
            connection = MyBatisSqlSessionFactory.getConnection();
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            reader = Resources.getResourceAsReader("sql/drop_table.sql");
            scriptRunner.runScript(reader);
            logger.info("drop_table.sql executed successfully");
            reader = Resources.getResourceAsReader("sql/create_table.sql");
            scriptRunner.runScript(reader);
            logger.info("create_table.sql executed successfully");
            reader = Resources.getResourceAsReader("sql/sample_data.sql");
            scriptRunner.runScript(reader);
            logger.info("sample_data.sql executed successfully");
            connection.commit();
            reader.close();
            scriptRunner.closeConnection();

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public static void initDatabase(boolean newdata) {
        Connection connection = null;
        Reader reader = null;
        if (newdata) {
            try {
                connection = MyBatisSqlSessionFactory.getConnection();
                ScriptRunner scriptRunner = new ScriptRunner(connection);
                reader = Resources.getResourceAsReader("sql/drop_table.sql");
                scriptRunner.runScript(reader);
                logger.info("drop_table.sql executed successfully");
                reader = Resources.getResourceAsReader("sql/create_table.sql");
                scriptRunner.runScript(reader);
                logger.info("create_table.sql executed successfully");
                reader = Resources.getResourceAsReader("sql/sample_data.sql");
                scriptRunner.runScript(reader);
                logger.info("sample_data.sql executed successfully");
                connection.commit();
                reader.close();
                scriptRunner.closeConnection();

            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

    }
}
