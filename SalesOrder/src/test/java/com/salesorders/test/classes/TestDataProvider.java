package com.salesorders.test.classes;

import com.salesorders.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.Reader;
import java.sql.Connection;

public class TestDataProvider {

    
    public static void main(String[] args) {
        initDatabase();
    }

    public static void initDatabase() {
        Connection  connection = null;
        Reader reader = null;
        try {
            connection = MyBatisSqlSessionFactory.getConnection();
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            reader = Resources.getResourceAsReader("sql/drop_table.sql");
            scriptRunner.runScript(reader);
            reader = Resources.getResourceAsReader("sql/create_table.sql");
            scriptRunner.runScript(reader);
            reader = Resources.getResourceAsReader("sql/sample_data.sql");
            scriptRunner.runScript(reader);
            
            connection.close();
            reader.close();
            scriptRunner.closeConnection();
            
        } catch (Exception ex) {
            // TODO: handle exception
        }
        
    }
}
