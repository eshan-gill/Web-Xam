/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import Beans.Category;
import java.sql.*;
import java.util.*;
/**
 *
 * @author eshangill
 */
public class DALCategory extends DBOperations{
    public void saveCategory(Beans.Category obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Categories values(?,?)");
           
            ps.setString(1,obj.getCategoryName());
            ps.setString(2,obj.getDescription());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }
    public boolean checkCategoryAvailability(String pCategoryName, int pCategoryId)
    {
        boolean ret=false;
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Categories Where CategoryName=? and CategoryId<>?");
            ps.setString(1, pCategoryName);
            ps.setInt(2,pCategoryId);
            
            ResultSet rs = ps.executeQuery();
            
            ret = rs.next();
            rs.close ();
        }
        catch(Exception ex)
        {
        }
        closeConnection();
        return !ret;
    }//Function
    public ArrayList<Beans.Category> getCategories()
    {
        ArrayList<Beans.Category> AC = new ArrayList<Category>();
        
        createConnection();
        
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * From Categories");
            
            Beans.Category C=null;
            
            while(rs.next())
            {
                C = new Category();
                C.setCategoryId(rs.getInt("CategoryId")); 
                C.setCategoryName(rs.getString("CategoryName").trim());
                C.setDescription(rs.getString("Description").trim());
                
                AC.add(C);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AC;
    }//Function
    public int deleteCategory(int pCategoryId)
    {
        int retValue=0;
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Categories where CategoryId=?");
            ps.setInt(1, pCategoryId);

            ps.executeUpdate();
            retValue=1;
        }
        catch(Exception ex)
        {
            retValue=-1;
            if(ex.getMessage().indexOf("The DELETE statement conflicted with the REFERENCE constraint")>=0)
            {
                retValue=-2;
            }
            System.out.println(ex.getMessage());
            
        }
        
        closeConnection();
        return retValue;
    }//Function
    public void updateCategory(Beans.Category obj)
    {
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Update Categories set CategoryName=?, Description=? where CategoryId=?");
            
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getDescription());
            ps.setInt(3,obj.getCategoryId());

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
    }//Function
    public Beans.Category getCategory(int pCategoryId)
    {
        Beans.Category C = new Category();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Categories where CategoryId=?");
            ps.setInt(1, pCategoryId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                C.setCategoryId(rs.getInt("CategoryId")); 
                C.setCategoryName(rs.getString("CategoryName").trim());
                C.setDescription(rs.getString("Description").trim());
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return C;
    }//Function
}
