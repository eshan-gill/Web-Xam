/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import Beans.Department;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author eshangill
 */
public class DALDepartment extends DBOperations {
    public void saveDepartment(Beans.Department obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Departments values(?,?,?,?,?,?)");
            ps.setString(1,obj.getDepartmentName());
            ps.setString(2,obj.getAddress());
            ps.setString(3,obj.getCity());
            ps.setString(4,obj.getContactNo());
            ps.setString(5,obj.getEmailId());
            ps.setString(6,obj.getContactPerson());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }
    public boolean checkDeptAvailability(String pDeptName, int pDeptId)
    {
        boolean ret=false;
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Departments Where DepartmentName=? and DepartmentId<>?");
            ps.setString(1, pDeptName);
            ps.setInt(2,pDeptId);
            
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
    public ArrayList<Beans.Department> getDepartments()
    {
        ArrayList<Beans.Department> AD = new ArrayList<Department>();
        
        createConnection();
        
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * From Departments");
            
            Beans.Department D=null;
            
            while(rs.next())
            {
                D = new Department();
                D.setDepartmentId(rs.getInt("DepartmentId")); 
                D.setDepartmentName(rs.getString("DepartmentName").trim());
                D.setAddress(rs.getString("Address").trim());
                D.setCity(rs.getString("City").trim());
                D.setContactNo(rs.getString("ContactNo").trim());
                D.setEmailId(rs.getString("EmailId").trim());
                D.setContactPerson(rs.getString("ContactPerson").trim());
                
                AD.add(D);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AD;
    }//Function
    
    public int deleteDepartment(int pDepartmentId)
    {
        int retValue=0;
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Departments where DepartmentId=?");
            ps.setInt(1, pDepartmentId);

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
    public void updateDepartment(Beans.Department obj)
    {
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Update Departments set DepartmentName=?, Address=?, City=?, ContactNo=?, EmailId=?, ContactPerson=? where DepartmentId=?");
            
            ps.setString(1, obj.getDepartmentName());
            ps.setString(2, obj.getAddress());
            ps.setString(3, obj.getCity());
            ps.setString(4, obj.getContactNo());
            ps.setString(5, obj.getEmailId());
            ps.setString(6, obj.getContactPerson());
            ps.setInt(7,obj.getDepartmentId());

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
    }//Function
    public Beans.Department getDepartment(int pDepartmentId)
    {
        Beans.Department D = new Department();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Departments where DepartmentId=?");
            ps.setInt(1, pDepartmentId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                D.setDepartmentId(rs.getInt("DepartmentId")); 
                D.setDepartmentName(rs.getString("DepartmentName").trim());
                D.setAddress(rs.getString("Address").trim());
                D.setCity(rs.getString("City").trim());
                D.setContactNo(rs.getString("ContactNo").trim());
                D.setEmailId(rs.getString("EmailId").trim());
                D.setContactPerson(rs.getString("ContactPerson").trim());
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return D;
    }//Function
}
