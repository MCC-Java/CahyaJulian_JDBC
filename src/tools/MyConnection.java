/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class MyConnection {

    private Connection connection = null;

    public Connection getConnection() {
        try {
            MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mccoc2");
            dataSource.setUser("root");
            dataSource.setPassword("cahyacahya");
            connection = dataSource.getConnection();
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
