package com.library.model.services.rentalservice;

import com.library.model.doa.ILibraryDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.library.model.domain.AvailableItems;
import com.library.model.domain.RentalItem;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author Veeral Patel
*
*/

public class RentalServiceImpl implements IRentalService {


	public boolean rentItem(String catalogNumber, String SQLTable, String email) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException  {
		Connection dbConnection = null;
		boolean QueryStatus = false;


	    try {

            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/sys");
            dbConnection = ds.getConnection();
            
            String sqlString = "UPDATE " + SQLTable + " SET availibility = 1, rentedBy = '" + email + "', returnDate = adddate(current_date , 21) WHERE catalogNumber = '"+catalogNumber+"';";
            
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate(sqlString);
            
            stmt.close();
            dbConnection.close();
            QueryStatus = true;
            
	    } catch (Exception e) {
            e.printStackTrace();
            QueryStatus = false;
        }
	    
		return QueryStatus;
               
	}



}
