/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import Beans.Job;
import java.sql.*;
import java.util.*;
/**
 *
 * @author eshangill
 */
public class DALJob extends DBOperations {
    public void saveJob(Beans.Job obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Jobs values(?,?)");
            
            ps.setString(1,obj.getJobName());
            ps.setString(2,obj.getDescription());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }
    public boolean checkJobAvailability(String pJobName, int pJobId)
    {
        boolean ret=false;
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Jobs Where JobName=? and JobId<>?");
            ps.setString(1, pJobName);
            ps.setInt(2, pJobId);
            
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
    public ArrayList<Beans.Job> getJobs()
    {
        ArrayList<Beans.Job> AJ = new ArrayList<Job>();
        
        createConnection();
        
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * From Jobs");
            
            Beans.Job J=null;
            
            while(rs.next())
            {
                J= new Job();
                J.setJobId(rs.getInt("JobId")); 
                J.setJobName(rs.getString("JobName").trim());
                J.setDescription(rs.getString("Description").trim());
                
                AJ.add(J);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AJ;
    }//Function
    public int deleteJob(int pJobId)
    {
        int retValue=0;
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Jobs where JobId=?");
            ps.setInt(1, pJobId);

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
    public void updateJob(Beans.Job obj)
    {
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Update Jobs set JobName=?, Description=? where JobId=?");
            
            ps.setString(1, obj.getJobName());
            ps.setString(2, obj.getDescription());
            ps.setInt(3,obj.getJobId());

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
    }//Function
    public Beans.Job getJob(int pJobId)
    {
        Beans.Job J = new Job();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Jobs where JobId=?");
            ps.setInt(1, pJobId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                J.setJobId(rs.getInt("JobId")); 
                J.setJobName(rs.getString("JobName").trim());
                J.setDescription(rs.getString("Description").trim());
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return J;
    }//Function
}
