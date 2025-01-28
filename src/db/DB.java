package db;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    
    private static Connection conn = null;
    
    public static Connection getConnection(){
        if(conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException ex) {
                throw new DbException("Erro ao conectar banco de dados: " + ex.getMessage());
            }
        }
        return conn;
    }
    
    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new DbException("Erro ao conectar banco de dados: " + ex.getMessage());
            }
        }
    }
    
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            
            return props;
            
        } catch (IOException e) {
            throw new DbException("Erro ao carregar arquivo: " + e.getMessage());
        }
    }
}
