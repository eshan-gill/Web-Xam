/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import Beans.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author eshangill
 */
public class DALUser extends DBOperations {
    public void saveUser(Beans.User obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Users values(?,?,?,?)");
            ps.setString(1,obj.getUserId());
            ps.setString(2,obj.getPassword());
            ps.setString(3,obj.getName());
            ps.setString(4,obj.getUserType());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveUser
    
    public boolean checkUserAvailability(String pUserId)
    {
        boolean ret=false;
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Users Where UserId=?");
            ps.setString(1, pUserId);
            
            ResultSet rs = ps.executeQuery();
            
            ret = rs.next();
            rs.close ();
        }
        catch(Exception ex)
        {
        }
        closeConnection();
        return !ret;
    }//Function checkUserAvailability
    
    public Beans.User authenticateUser(String pUserId, String pPassword, String pType)
    {
        Beans.User obj=new User();
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("select * from Users where UserId=? and Password=? and UserType=?");
            ps.setString(1,pUserId);
            ps.setString(2, pPassword);
            ps.setString(3, pType);
            
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                obj.setSerialNo(rs.getInt("SerialNo"));
                obj.setUserId(rs.getString("UserId").trim());
                obj.setPassword(rs.getString("Password").trim());
                obj.setName(rs.getString("Name").trim());
                obj.setUserType(rs.getString("UserType").trim());
            }
            rs.close();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        return obj;
    }//Function authenticateUser 
    
    public void UpdatePassword(int pRegId, String pNewPwd)
    {
        
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("Update Users set Password=? Where SerialNo=?");
            ps.setString(1, pNewPwd);
            ps.setInt(2, pRegId);
            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();   
    }//Function UpdatePassword
    public ArrayList<Beans.User> getUsers(String pUserType)
    {
        ArrayList<Beans.User> AU = new ArrayList<User>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select SerialNo, UserId, Name from Users where UserType=?");
            ps.setString(1, pUserType);
            ResultSet rs = ps.executeQuery();
            
            Beans.User U=null;
            
            while(rs.next())
            {
                U= new User();
                U.setSerialNo(rs.getInt("SerialNo"));
                U.setUserId(rs.getString("UserId").trim());
                U.setName(rs.getString("Name").trim());
                AU.add(U);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AU;
    }//Function getUsers with UserType
     public void deleteUser(int pSerialNo)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Users where SerialNo=?");
            ps.setInt(1, pSerialNo);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        closeConnection();
        
    }//Function deleteUser
      
}
