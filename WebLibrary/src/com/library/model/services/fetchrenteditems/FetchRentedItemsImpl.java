package com.library.model.services.fetchrenteditems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.library.model.domain.LibraryResultsDTO;

public class FetchRentedItemsImpl implements IFetchRentedItems{

	@Override
public List<LibraryResultsDTO> getUserRentedItems(String email) {
	Connection dbConnection = null;
    List<LibraryResultsDTO> res = new ArrayList<LibraryResultsDTO>();
    
    try {
    	
    	System.out.println("In FetchRentedItemsImpl.java");
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/sys");
        dbConnection = ds.getConnection();
        
        Statement stmtBook = dbConnection.createStatement();
        ResultSet resultBooks = stmtBook.executeQuery("SELECT * FROM sys.book WHERE rentedBy = '" +email+"';");
        
        
        while (resultBooks.next()) {
        	LibraryResultsDTO e = new LibraryResultsDTO();
        	e.setType("Book");
        	e.setTitle(resultBooks.getString("bookTitle"));
        	e.setAuthorArtist(resultBooks.getString("bookAuthor"));
        	e.setCatalogNumber(resultBooks.getString("catalogNumber"));
        	e.setReturnDate(resultBooks.getDate("returnDate").toString());
        	System.out.println(e.getAvailability() + " + " + e.getTitle() + " + " + e.getReturnDate());
        	res.add(e);
        }

        stmtBook.close();
        
        Statement stmtCD = dbConnection.createStatement();
        ResultSet resultCDs = stmtCD.executeQuery("SELECT * FROM sys.cd WHERE rentedBy = '" +email+"';");
        
        while (resultCDs.next()) {
        	LibraryResultsDTO e = new LibraryResultsDTO();
        	e.setType("CD");
        	e.setTitle(resultCDs.getString("cdTitle"));
        	e.setAuthorArtist(resultCDs.getString("cdArtist"));
        	e.setCatalogNumber(resultCDs.getString("catalogNumber"));
        	e.setReturnDate(resultCDs.getDate("returnDate").toString());
        	res.add(e);
        }
        
        stmtCD.close();
        
        Statement stmtMovie = dbConnection.createStatement();
        ResultSet resultMovies = stmtMovie.executeQuery("SELECT * FROM sys.movie  WHERE rentedBy = '" +email+"';");
        
        while (resultMovies.next()) {
        	LibraryResultsDTO e = new LibraryResultsDTO();
        	e.setType("Movie");
        	e.setTitle(resultMovies.getString("movieTitle"));
        	e.setAuthorArtist("N/A");
        	e.setCatalogNumber(resultMovies.getString("catalogNumber"));
        	e.setReturnDate(resultMovies.getDate("returnDate").toString());
        	res.add(e);
        }
        
        stmtMovie.close();
        dbConnection.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
    
    System.out.println(res.toString());
	return res;
    
	}

}
