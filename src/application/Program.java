
package application;

import db.DB;
import model.entities.Seller;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

    public static void main(String[] args) {
        
        Connection conn = DB.getConnection();
              
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("-------- 1 - findById ------");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("");
        
        System.out.println("-------- 2 - findByDeparment ------");
        Department department = new Department(2, null);
        
        List<Seller> list = sellerDao.findByDeparment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("-------- 3 - findAll ------");
        department = new Department(2, null);
        
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("-------- 4 - Insert ------");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        
        System.out.println("Inseted! New ID: " + newSeller.getId());
        
        DB.closeConnection();
    }
    
}
