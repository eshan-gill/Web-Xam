/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.Test;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALTest extends DBOperations{
    public void saveTest(Beans.Test obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Tests values(?,?,?,?,?)");
            
            ps.setString(1, obj.getTestDate());
            ps.setInt(2,obj.getDepartmentId());
            ps.setInt(3,obj.getJobId());
            ps.setInt(4,obj.getPassingScore());
            ps.setInt(5,obj.getDuration());
            
            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveTest
    public ArrayList<Beans.Test> getTests()
    {
        ArrayList<Beans.Test> AT = new ArrayList<Test>();
        
        createConnection();
        
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * From Tests");
            
            Beans.Test T=null;
            
            while(rs.next())
            {
                T= new Test();
                T.setTestId(rs.getInt("TestId")); 
                T.setTestDate(rs.getString("TestDate").trim());
                T.setDepartmentId(rs.getInt("DepartmentId"));
                T.setJobId(rs.getInt("JobId"));
                T.setPassingScore(rs.getInt("PassingScore"));
                T.setDuration(rs.getInt("Duration"));
                
                AT.add(T);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AT;
    }//Function getTests
    public void deleteTest(int pTestId)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Tests where TestId=?");
            ps.setInt(1, pTestId);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
        
    }//Function deleteTest
    public void updateTest(Beans.Test obj)
    {
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Update Tests set TestDate=?, DepartmentId=?, JobId=?, PassingScore=?, Duration=? where TestId=?");
            
            ps.setString(1,obj.getTestDate());
            ps.setInt(2, obj.getDepartmentId());
            ps.setInt(3, obj.getJobId());
            ps.setInt(4, obj.getPassingScore());
            ps.setInt(5, obj.getDuration());
            ps.setInt(6,obj.getTestId());

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
    }//Function updateTest
    public Beans.Test getTest(int pTestId)
    {
        Beans.Test T = new Test();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Tests where TestId=?");
            ps.setInt(1, pTestId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                T.setTestId(rs.getInt("TestId")); 
                T.setTestDate(rs.getString("TestDate").trim());
                T.setDepartmentId(rs.getInt("DepartmentId"));
                T.setJobId(rs.getInt("JobId"));
                T.setPassingScore(rs.getInt("PassingScore"));
                T.setDuration(rs.getInt("Duration"));
            }
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return T;
    }//Function getTest
     public ArrayList<Beans.Test> getTests(int DepartmentId)
    {
        ArrayList<Beans.Test> AT = new ArrayList<Test>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select T.TestId, T.TestDate,T.DepartmentId, T.JobId,J.JobName,T.PassingScore, T.Duration from Tests as T, Jobs as J where DepartmentId=? and T.JobId=J.JobId");
            ps.setInt(1, DepartmentId);
            ResultSet rs = ps.executeQuery();
            
            Beans.Test T=null;
            
            while(rs.next())
            {
                T= new Test();
                T.setTestId(rs.getInt("TestId")); 
                T.setTestDate(rs.getString("TestDate").trim());
                T.setDepartmentId(rs.getInt("DepartmentId"));
                T.setJobId(rs.getInt("JobId"));
                T.setJobName(rs.getString("JobName"));
                T.setPassingScore(rs.getInt("PassingScore"));
                T.setDuration(rs.getInt("Duration"));
                
                AT.add(T);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AT;
    }//Function getTests with DepartmentId
     public Beans.Test getFullTestDetails(int pTestId)
    {
        Beans.Test T = new Test();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select T.TestId,T.TestDate,T.DepartmentId,D.DepartmentName,T.JobId,J.JobName,T.PassingScore,T.Duration from Tests as T,Departments as D, Jobs as J  where T.TestId=? and T.DepartmentId=D.DepartmentId and T.JobId=J.JobId");
            ps.setInt(1, pTestId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                T.setTestId(rs.getInt("TestId")); 
                T.setTestDate(rs.getString("TestDate").trim());
                T.setDepartmentId(rs.getInt("DepartmentId"));
                T.setDepartmentName(rs.getString("DepartmentName").trim());
                T.setJobId(rs.getInt("JobId"));
                T.setJobName(rs.getString("JobName").trim());
                T.setPassingScore(rs.getInt("PassingScore"));
                T.setDuration(rs.getInt("Duration"));
            }
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return T;
    }//Function getFullTestDetails for StartTest.jsp
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
