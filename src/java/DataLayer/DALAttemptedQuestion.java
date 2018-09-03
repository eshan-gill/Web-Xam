/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.AttemptedQuestion;
import Beans.QOAttemptedQuestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALAttemptedQuestion extends DBOperations{
    public void saveAttemptedQuestion(Beans.AttemptedQuestion obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into AttemptedQuestions values(?,?,?)");
            
            ps.setInt(1,obj.getQuestionId());
            ps.setInt(2,obj.getOptionId());
            ps.setInt(3,obj.getConductedTestId());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveAttemptedQuestion
    public ArrayList<Beans.AttemptedQuestion> getAttemptedQuestions(int ConductedTestId)
    {
        ArrayList<Beans.AttemptedQuestion> AAQ = new ArrayList<AttemptedQuestion>();
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("select* from AttemptedQuestions where ConductedTestId=?");
            ps.setInt(1, ConductedTestId);
            ResultSet rs = ps.executeQuery();
            
            Beans.AttemptedQuestion AQ=null;
            
            while(rs.next())
            {
                AQ= new AttemptedQuestion();
                AQ.setAQId(rs.getInt("AQId")); 
                AQ.setQuestionId(rs.getInt("QuestionId")); 
                AQ.setOptionId(rs.getInt("OptionId")); 
                AQ.setConductedTestId(rs.getInt("ConductedTestId")); 
                
                AAQ.add(AQ);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AAQ;
    }//Function getAttemptedQuestions with ConductedTestId
    public ArrayList<Beans.QOAttemptedQuestion> getQOAttemptedQuestions(int ConductedTestId)
    {
        ArrayList<Beans.QOAttemptedQuestion> AAQ = new ArrayList<QOAttemptedQuestion>();
        createConnection();
        try
        {
            PreparedStatement ps = con.prepareStatement("select Q.QuestionText,O.OptionText from Questions as Q, Options as O, AttemptedQuestions as AQ where AQ.QuestionId=Q.QuestionId and AQ.OptionId= O.OptionId and AQ.ConductedTestId=?");
            ps.setInt(1, ConductedTestId);
            ResultSet rs = ps.executeQuery();
            
            Beans.QOAttemptedQuestion AQ=null;
            
            while(rs.next())
            {
                AQ= new QOAttemptedQuestion();
                AQ.setQText(rs.getString("QuestionText").trim());
                AQ.setOText(rs.getString("OptionText").trim());
                
                AAQ.add(AQ);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AAQ;
    }//Function getQOAttemptedQuestions with ConductedTestId
}
