/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.Report;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALReport extends DBOperations{
    public ArrayList<Beans.Report> getAppearedCandidates(int TestId)
    {
        ArrayList<Beans.Report> AR = new ArrayList<Report>();
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select C.CandidateId, C.Name, C.Gender, C.DOB, C.FatherName, C.EmailId, C.ContactNo,(select count(*) from AttemptedQuestions as AQ, ConductedTests as CT where \n" +
"AQ.ConductedTestId=CT.ConductedTestId and C.CandidateId=CT.CandidateId) as Attempted,(select count(*) from AttemptedQuestions as AQ, Questions as Q, Options as O, \n" +
"ConductedTests as CT where AQ.QuestionId=Q.QuestionId and AQ.OptionId=O.OptionId and O.IsAnswer=1 and AQ.ConductedTestId= CT.ConductedTestId and \n" +
"CT.CandidateId= C.CandidateId) as [Correct],(select count(*) from AttemptedQuestions as AQ, Questions as Q, Options as O, ConductedTests as CT where \n" +
"AQ.QuestionId=Q.QuestionId and AQ.OptionId=O.OptionId and O.IsAnswer=0 and AQ.ConductedTestId= CT.ConductedTestId and CT.CandidateId= C.CandidateId) \n" +
"as [Incorrect],(select count(*)*4 from AttemptedQuestions as [AQ], Options as [O] where AQ.ConductedTestId=CT.ConductedTestId and \n" +
"AQ.OptionId= O.OptionId and O.IsAnswer=1) - (select count(*) from AttemptedQuestions as [AQ],Options as [O] where AQ.ConductedTestId=CT.ConductedTestId and \n" +
"AQ.OptionId= O.OptionId and O.IsAnswer=0) as Score from Candidates as [C],ConductedTests as [CT], Tests as [T] where C.CandidateId=CT.CandidateId and CT.TestId=? \n" +
"and CT.TestId=T.TestId order by [Score] desc");
            ps.setInt(1, TestId);
            ResultSet rs = ps.executeQuery();
            
            Beans.Report R=null;
            
            while(rs.next())
            {
                R= new Report();
                R.setCandidateId(rs.getInt("CandidateId"));
                R.setName(rs.getString("Name").trim());
                R.setGender(rs.getString("Gender").trim());
                R.setDOB(rs.getString("DOB").trim());
                R.setFatherName(rs.getString("FatherName").trim());
                R.setEmailId(rs.getString("EmailId").trim());
                R.setContactNo(rs.getString("ContactNo").trim());
                R.setAttempted(rs.getInt("Attempted"));
                R.setCorrect(rs.getInt("Correct"));
                R.setIncorrect(rs.getInt("Incorrect"));
                R.setScore(rs.getInt("Score"));
                
                AR.add(R);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AR;
    }//Function getAppearedCandidates with TestId
    public ArrayList<Beans.Report> getPassedCandidates(int TestId)
    {
        ArrayList<Beans.Report> AR = new ArrayList<Report>();
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select C.CandidateId, C.Name, C.Gender, C.DOB, C.FatherName, C.EmailId, C.ContactNo,(select count(*) from AttemptedQuestions as AQ, ConductedTests as CT where \n" +
"AQ.ConductedTestId=CT.ConductedTestId and C.CandidateId=CT.CandidateId) as Attempted,(select count(*) from AttemptedQuestions as AQ, Questions as Q, Options as O, \n" +
"ConductedTests as CT where AQ.QuestionId=Q.QuestionId and AQ.OptionId=O.OptionId and O.IsAnswer=1 and AQ.ConductedTestId= CT.ConductedTestId and \n" +
"CT.CandidateId= C.CandidateId) as [Correct],(select count(*) from AttemptedQuestions as AQ, Questions as Q, Options as O, ConductedTests as CT where \n" +
"AQ.QuestionId=Q.QuestionId and AQ.OptionId=O.OptionId and O.IsAnswer=0 and AQ.ConductedTestId= CT.ConductedTestId and CT.CandidateId= C.CandidateId) as \n" +
"[Incorrect],(select count(*)*4 from AttemptedQuestions as [AQ], Options as [O] where AQ.ConductedTestId=CT.ConductedTestId and \n" +
"AQ.OptionId= O.OptionId and O.IsAnswer=1) - (select count(*) from AttemptedQuestions as [AQ],Options as [O] where AQ.ConductedTestId=CT.ConductedTestId and \n" +
"AQ.OptionId= O.OptionId and O.IsAnswer=0) as Score from Candidates as C ,ConductedTests as [CT], Tests as [T] where C.CandidateId=CT.CandidateId and CT.TestId=? \n" +
"and CT.TestId=T.TestId and (select count(*)*4 from AttemptedQuestions as [AQ], Options as [O] where AQ.ConductedTestId=CT.ConductedTestId and \n" +
"AQ.OptionId= O.OptionId and O.IsAnswer=1)- (select count(*) from AttemptedQuestions as [AQ],Options as [O] where AQ.ConductedTestId=CT.ConductedTestId and \n" +
"AQ.OptionId= O.OptionId and O.IsAnswer=0)>= T.PassingScore order by [Score] desc");
            ps.setInt(1, TestId);
            
            ResultSet rs = ps.executeQuery();
            
            Beans.Report R=null;
            
            while(rs.next())
            {
                R= new Report();
                R.setCandidateId(rs.getInt("CandidateId"));
                R.setName(rs.getString("Name").trim());
                R.setGender(rs.getString("Gender").trim());
                R.setDOB(rs.getString("DOB").trim());
                R.setFatherName(rs.getString("FatherName").trim());
                R.setEmailId(rs.getString("EmailId").trim());
                R.setContactNo(rs.getString("ContactNo").trim());
                R.setAttempted(rs.getInt("Attempted"));
                R.setCorrect(rs.getInt("Correct"));
                R.setIncorrect(rs.getInt("Incorrect"));
                R.setScore(rs.getInt("Score"));
                
                AR.add(R);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AR;
    }//Function getPassedCandidates with TestId
    
}
