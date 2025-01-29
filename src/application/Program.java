
package application;

import db.DB;
import entities.Department;
import entities.Seller;
import java.sql.Connection;
import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        
        Connection conn = DB.getConnection();
        
        Department dep = new Department(345, "marlus");
        System.out.println(dep);
        Seller sel = new Seller(123, "marlussssss", "marlus@gmail.com", LocalDate.now());
        System.out.println(sel);
        DB.closeConnection();
    }
    
}
