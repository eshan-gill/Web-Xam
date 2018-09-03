/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.Option;
import Beans.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALQuestion extends DBOperations {
    public ArrayList<Beans.Question> getQuestions(ArrayList<Beans.TestCategory> TC)
    {
        ArrayList<Beans.Question> AllQuestions= new ArrayList<Question>();
        createConnection();
        for(Beans.TestCategory C:TC)
        {
        try
        {
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select top "+C.getNOQ()+"* from Questions where CategoryId="+C.getCategoryId()+"order by NewId()");
            Question Q=null;
            String s="";
            int QID=0;
            while(rs.next())
            {
                Q= new Question();
                QID= rs.getInt("QuestionId");
                Q.setQuestionId(QID);
                Q.setQuestionText(rs.getString("QuestionText"));
                Q.setCategoryId(rs.getInt("CategoryId"));
                s=s+QID+","; //"3,1,4,"
                AllQuestions.add(Q);
            }//while loop
            rs.close();
            s=s.substring(0,s.length()-1);
            rs=st.executeQuery("select* from Options where QuestionId IN("+s+")");
            Beans.Option opt=null;
            while(rs.next())
            {
                opt=new Option();
                opt.setOptionId(rs.getInt("OptionId"));
                opt.setOptionText(rs.getString("OptionText"));
                opt.setQuestionId(rs.getInt("QuestionId"));
                opt.setIsAnswer(rs.getByte("IsAnswer"));
                
                for(Question obj: AllQuestions)
                {
                    if(obj.getQuestionId()==opt.getQuestionId())
                    {
                        obj.Options.add(opt);
                        break;
                    }
                }//for
            }//while
            rs.close();
        }//try
        catch(Exception ex)
        {
            
        }//catch
        }
        return AllQuestions;
    }//Function getQuestions with category id and noq
    public void saveQuestion(Beans.Question obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Questions values(?,?)");
            
            ps.setString(1, obj.getQuestionText());
            ps.setInt(2,obj.getCategoryId());
            
            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveQuestion
    public Beans.Question getQuestion(String pQ, int pCategoryId)
    {
        Beans.Question Q = new Question();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Questions where QuestionText=? and CategoryId=?");
            ps.setString(1, pQ);
            ps.setInt(2, pCategoryId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                Q.setQuestionId(rs.getInt("QuestionId"));
                Q.setQuestionText(rs.getString("QuestionText").trim());
                Q.setCategoryId(rs.getInt("CategoryId"));
            }
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return Q;
    }//Function getQuestion
    public ArrayList<Beans.Question> getQuestionsWithCategoryId(int CategoryId)
    {
        ArrayList<Beans.Question> AQ = new ArrayList<Question>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select * from Questions where CategoryId=?");
            ps.setInt(1, CategoryId);
            ResultSet rs = ps.executeQuery();
            
            Beans.Question Q=null;
            
            while(rs.next())
            {
                Q= new Question();
                Q.setQuestionId(rs.getInt("QuestionId")); 
                Q.setQuestionText(rs.getString("QuestionText").trim());
                Q.setCategoryId(rs.getInt("CategoryId"));
                
                AQ.add(Q);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AQ;
    }//Function getQuestions with CategoryId
    public void deleteQuestion(int pQuestionId)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Questions where QuestionId=?");
            ps.setInt(1, pQuestionId);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
        
    }//Function deleteQuestion
}
