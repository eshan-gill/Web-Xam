/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.Candidate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALCandidate extends DBOperations{
    public void saveCandidate(Beans.Candidate obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Candidates values(?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getGender());
            ps.setString(3,obj.getDOB());
            ps.setString(4,obj.getFatherName());
            ps.setString(5,obj.getHigherQualification());
            ps.setString(6,obj.getAddress());
            ps.setString(7,obj.getContactNo());
            ps.setString(8,obj.getEmailId());
            ps.setInt(9,obj.getTestId());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveCandidate
    
    public void deleteCandidate(int pCandidateId)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Candidates where CandidateId=?");
            ps.setInt(1, pCandidateId);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
        
    }//Function deleteCandidate
    public ArrayList<Beans.Candidate> getCandidates(int TestId)
    {
        ArrayList<Beans.Candidate> AC = new ArrayList<Candidate>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select* from Candidates where TestId=?");
            ps.setInt(1, TestId);
            ResultSet rs = ps.executeQuery();
            
            Beans.Candidate C=null;
            
            while(rs.next())
            {
                C= new Candidate();
                C.setCandidateId(rs.getInt("CandidateId")); 
                C.setName(rs.getString("Name").trim());
                C.setGender(rs.getString("Gender").trim());
                C.setDOB(rs.getString("DOB").trim());
                C.setFatherName(rs.getString("FatherName").trim());
                C.setHigherQualification(rs.getString("HigherQualification").trim());
                C.setAddress(rs.getString("Address").trim());
                C.setContactNo(rs.getString("ContactNo").trim());
                C.setEmailId(rs.getString("EmailId").trim());
                C.setTestId(rs.getInt("TestId"));
                
                AC.add(C);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AC;
    }//Function getCandidates with TestId
    public void updateCandidate(Beans.Candidate obj)
    {
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Update Candidates set Name=?, Gender=?, DOB=?, FatherName=?, HigherQualification=?, Address=?, ContactNo=?, EmailId=? where CandidateId=?");
            
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getGender());
            ps.setString(3, obj.getDOB());
            ps.setString(4, obj.getFatherName());
            ps.setString(5, obj.getHigherQualification());
            ps.setString(6, obj.getAddress());
            ps.setString(7, obj.getContactNo());
            ps.setString(8, obj.getEmailId());
            ps.setInt(9,obj.getCandidateId());

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
    }//Function//Function updateCandidate
    public Beans.Candidate getCandidate(int pCandidateId)
    {
        Beans.Candidate C = new Candidate();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Candidates where CandidateId=?");
            ps.setInt(1, pCandidateId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                C.setCandidateId(rs.getInt("CandidateId")); 
                C.setName(rs.getString("Name").trim());
                C.setGender(rs.getString("Gender").trim());
                C.setDOB(rs.getString("DOB").trim());
                C.setFatherName(rs.getString("FatherName").trim());
                C.setHigherQualification(rs.getString("HigherQualification").trim());
                C.setAddress(rs.getString("Address").trim());
                C.setContactNo(rs.getString("ContactNo").trim());
                C.setEmailId(rs.getString("EmailId").trim());
                C.setTestId(rs.getInt("TestId"));
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return C;
    }//Function getCandidate
    public boolean verifyCandidate(int pCandidateId)
    {
        boolean ret=false;//does not exist
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Candidates where CandidateId=?");
            ps.setInt(1, pCandidateId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())//data found
            {
                ret=true;
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return ret;
    }//Function verifyCandidate
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
