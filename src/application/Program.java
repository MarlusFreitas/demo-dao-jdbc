
package application;

import db.DB;
import model.entities.Department;
import model.entities.Seller;
import java.sql.Connection;
import java.time.LocalDate;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

    public static void main(String[] args) {
        
        Connection conn = DB.getConnection();
              
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("--------1-------");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("");
        
        System.out.println("--------2-------");
        
        DB.closeConnection();
    }
    
}
