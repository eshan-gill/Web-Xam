/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.Option;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALOption extends DBOperations{
    public void saveOption(Beans.Option obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Options values(?,?,?)");
            
            ps.setString(1, obj.getOptionText());
            ps.setInt(2,obj.getQuestionId());
            ps.setByte(3,obj.getIsAnswer());
            
            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveOption
    public Beans.Option getOption(String pOptionText, int pQuestionId)
    {
        Beans.Option Q = new Option();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Select * From Options where OptionText=? and QuestionId=?");
            ps.setString(1, pOptionText);
            ps.setInt(2, pQuestionId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                Q.setOptionId(rs.getInt("OptionId"));
                Q.setOptionText(rs.getString("OptionText").trim());
                Q.setQuestionId(rs.getInt("QuestionId"));
                Q.setIsAnswer(rs.getByte("IsAnswer"));
            }
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return Q;
    }//Function getOption
    public ArrayList<Beans.Option> getOptionsWithQuestionId(int QuestionId)
    {
        ArrayList<Beans.Option> AQ = new ArrayList<Option>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select * from Options where QuestionId=?");
            ps.setInt(1, QuestionId);
            ResultSet rs = ps.executeQuery();
            
            Beans.Option Q=null;
            
            while(rs.next())
            {
                Q= new Option();
                Q.setOptionId(rs.getInt("OptionId"));
                Q.setOptionText(rs.getString("OptionText").trim());
                Q.setQuestionId(rs.getInt("QuestionId"));
                Q.setIsAnswer(rs.getByte("IsAnswer"));
                
                AQ.add(Q);
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AQ;
    }//Function getOptions with QuestionId
    public void deleteOption(int pQuestionId)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Options where QuestionId=?");
            ps.setInt(1, pQuestionId);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
        
    }//Function deleteOption
}
