/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.TestCategory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALTestCategory extends DBOperations{
    public void saveTestCategory(Beans.TestCategory obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into TestCategories values(?,?,?)");
            
            ps.setInt(1,obj.getTestId());
            ps.setInt(2,obj.getCategoryId());
            ps.setInt(3,obj.getNOQ());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }
    public void deleteTestCategory(int pTestCategoryId)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From TestCategories where SerialNo=?");
            ps.setInt(1, pTestCategoryId);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
        
    }//Function deleteTestCategory
    public ArrayList<Beans.TestCategory> getTestCategories(int TestId)
    {
        ArrayList<Beans.TestCategory> ATC = new ArrayList<TestCategory>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select TC.SerialNo, TC. TestId, TC.CategoryId, C.CategoryName, TC.NOQ from TestCategories as TC, Categories as C where TestId=? and TC.CategoryId=C.CategoryId");
            ps.setInt(1, TestId);
            ResultSet rs = ps.executeQuery();
            
            Beans.TestCategory TC=null;
            
            while(rs.next())
            {
                TC= new TestCategory();
                TC.setSerialNo(rs.getInt("SerialNo")); 
                TC.setTestId(rs.getInt("TestId"));
                TC.setCategoryId(rs.getInt("CategoryId"));
                TC.setCategoryName(rs.getString("CategoryName"));
                TC.setNOQ(rs.getInt("NOQ"));
                
                ATC.add(TC);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return ATC;
    }//Function getTestCategories with TestId
    public boolean isNumeric(String v)
    {
        boolean ret=false;
        try
        {
            int x=Integer.parseInt(v);
            ret=true;
        }
        catch(Exception ex)
        {
            ret=false;
        }
        return ret;
    }//Function isNumeric
}
