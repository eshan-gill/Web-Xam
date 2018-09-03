/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.ConductedTest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author eshangill
 */
public class DALConductedTest extends DBOperations {
    public boolean candidateTestConducted(int pCandidateId)
    {
        boolean ret=false;//Not conducted
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From ConductedTests where CandidateId=?");
            ps.setInt(1, pCandidateId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())//data found
            {
                ret=true;//candidate test conducted
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return ret;
    }//Function candidateTestConducted
     public void saveConductedTest(Beans.ConductedTest obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into ConductedTests values(?,?)");
            
            ps.setInt(1,obj.getTestId());
            ps.setInt(2,obj.getCandidateId());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveConductedTest
    public Beans.ConductedTest getConductedTest(int pCandidateId)
    {
        Beans.ConductedTest CT = new ConductedTest();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From ConductedTests where CandidateId=?");
            ps.setInt(1, pCandidateId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                CT.setConductedTestId(rs.getInt("ConductedTestId")); 
                CT.setTestId(rs.getInt("TestId"));
                CT.setCandidateId(rs.getInt("CandidateId"));
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return CT;
    }//Function getConductedTest
}
