/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Beans.Instruction;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class DALInstruction extends DBOperations{
    public void saveInstruction(Beans.Instruction obj)
    {
        createConnection();
        try
        {
            PreparedStatement ps= con.prepareStatement("Insert into Instructions values(?,?)");
            
            ps.setString(1,obj.getInstructionText());
            ps.setInt(2,obj.getTestId());
            
            ps.executeQuery();
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
    }//Function saveInstruction
    public void deleteInstruction(int pInstructionId)
    {
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("Delete From Instructions where InstructionId=?");
            ps.setInt(1, pInstructionId);

            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        
        closeConnection();
        
    }//Function deleteInstruction
    public ArrayList<Beans.Instruction> getInstructions(int TestId)
    {
        ArrayList<Beans.Instruction> AI = new ArrayList<Instruction>();
        
        createConnection();
        
        try
        {
            PreparedStatement ps = con.prepareStatement("select* from Instructions where TestId=?");
            ps.setInt(1, TestId);
            ResultSet rs = ps.executeQuery();
            
            Beans.Instruction I=null;
            
            while(rs.next())
            {
                I= new Instruction();
                I.setInstructionId(rs.getInt("InstructionId")); 
                I.setInstructionText(rs.getString("InstructionText").trim());
                I.setTestId(rs.getInt("TestId"));
                
                AI.add(I);
            }
            
        }
        catch(Exception ex)
        {
            
        }
        closeConnection();
        
        return AI;
    }//Function getInstructions with TestId
}
