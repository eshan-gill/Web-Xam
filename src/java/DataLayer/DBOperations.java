/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import java.sql.*;
/**
 *
 * @author eshangill
 */
public abstract class DBOperations {
    protected Connection con;
    public boolean createConnection()
    {
        boolean ret=false;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:WebXamDBDSN");
            ret=true;
        }
        catch(Exception ex)
        {
            ret=false;
        }
        return ret;
    }//Function
    public void closeConnection()
    {
        if(con!=null)
        {
            try
            {
                con.close();
            }
            catch(Exception ex)
            {
                
            }
        }
    }//Function
}
