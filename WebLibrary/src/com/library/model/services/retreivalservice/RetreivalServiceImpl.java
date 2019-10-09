package com.library.model.services.retreivalservice;

import com.library.model.doa.ILibraryDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.LibraryResultsDTO;
import com.library.model.domain.Movie;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;

/**
*
* @author Veeral Patel
*
*This Implementation of the IRetreivalService is used to get data from searches. The user can search for all of the available items, or enter a string to search for a specific item
*/

public class RetreivalServiceImpl implements IRetreivalService {
    

	//This method will return a list of available items in the library that match the search entered by the user
	public List<LibraryResultsDTO> returnSearchResult(String searchString) throws RetreivalException, FileNotFoundException, IOException, ClassNotFoundException {
			List<LibraryResultsDTO> res = new ArrayList<LibraryResultsDTO>();
		    Connection dbConnection = null;
		    int id, availibilityVal, releaseYear, IBSN;
		    String title, author, artist, catalogNumber, availibility;

		    try {

	            Context initContext = new InitialContext();
	            Context envContext  = (Context)initContext.lookup("java:/comp/env");
	            DataSource ds = (DataSource)envContext.lookup("jdbc/sys");
	            dbConnection = ds.getConnection();
	            
	            Statement stmtBook = dbConnection.createStatement();
	            System.out.println("SELECT * FROM sys.book WHERE bookTitle = " +searchString+";");
	            ResultSet resultBooks = stmtBook.executeQuery("SELECT * FROM sys.book WHERE bookTitle = '" +searchString+"';");
	            
	            while (resultBooks.next()) {
	            	LibraryResultsDTO e = new LibraryResultsDTO();
		        	id = resultBooks.getInt("idBook");
		        	e.setID(id);
		        	e.setType("Book");
		        	availibilityVal = resultBooks.getInt("availibility");
		        	if (availibilityVal != 1) {
		        		availibility = "Available";
		        	}
		        	else {
		        		availibility = "Unavailable";
		        	}
		        	e.setAvailability(availibility);
		        	releaseYear = resultBooks.getInt("releaseYear");
		        	IBSN = resultBooks.getInt("IBSN");
		        	title = resultBooks.getString("bookTitle");
		        	e.setTitle(title);
		        	author = resultBooks.getString("bookAuthor");
		        	e.setAuthorArtist(author);
		        	catalogNumber = resultBooks.getString("catalogNumber");
		        	e.setCatalogNumber(catalogNumber);		        	
		        	System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", CatalogNumber: " + catalogNumber);		        	
					res.add(e);
		        }

	            stmtBook.close();
	            
	            Statement stmtCD = dbConnection.createStatement();
	            ResultSet resultCDs = stmtCD.executeQuery("SELECT * FROM sys.cd WHERE cdTitle = '" + searchString + "';");
	            
	            while (resultCDs.next()) {
	            	LibraryResultsDTO e = new LibraryResultsDTO();
		        	id = resultCDs.getInt("idCD");
		        	e.setID(id);
		        	e.setType("CD");
		        	availibilityVal = resultCDs.getInt("availibility");
		        	if (availibilityVal != 1) {
		        		availibility = "Available";
		        	}
		        	else {
		        		availibility = "Unavailable";
		        	}
		        	e.setAvailability(availibility);
		        	releaseYear = resultCDs.getInt("releaseYear");
		        	title = resultCDs.getString("cdTitle");
		        	e.setTitle(title);
		        	artist = resultCDs.getString("cdArtist");
		        	e.setAuthorArtist(artist);
		        	catalogNumber = resultCDs.getString("catalogNumber");
		        	e.setCatalogNumber(catalogNumber);
		        	
		        	System.out.println("ID: " + id + ", Title: " + title + ", Artist: " + artist + ", CatalogNumber: " + catalogNumber);
		        	res.add(e);
		        }
	            
	            stmtCD.close();
	            
	            Statement stmtMovie = dbConnection.createStatement();
	            ResultSet resultMovies = stmtMovie.executeQuery("SELECT * FROM sys.movie WHERE movieTitle = '" + searchString + "';");
	            
	            while (resultMovies.next()) {
	            	LibraryResultsDTO e = new LibraryResultsDTO();
		        	id = resultMovies.getInt("idMovie");
		        	e.setID(id);
		        	e.setType("Movie");
		        	availibilityVal = resultMovies.getInt("availibility");
		        	if (availibilityVal != 1) {
		        		availibility = "Available";
		        	}
		        	else {
		        		availibility = "Unavailable";
		        	}
		        	e.setAvailability(availibility);
		        	e.setAuthorArtist("N/A");
		        	releaseYear = resultMovies.getInt("releaseYear");
		        	title = resultMovies.getString("movieTitle");
		        	e.setTitle(title);
		        	catalogNumber = resultMovies.getString("catalogNumber");
		        	e.setCatalogNumber(catalogNumber);
		        	
		        	System.out.println("ID: " + id + ", Title: " + title + ", CatalogNumber: " + catalogNumber);
		        	res.add(e);
		        }
	            
	            stmtMovie.close();
	            dbConnection.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		    
		    return res;

	    }
	

	//This method will return all of the available items that are in the libary for rental purposes
	@SuppressWarnings("null")
	public List<LibraryResultsDTO> getAllItems () throws RetreivalException, FileNotFoundException, IOException, ClassNotFoundException, AvailibilityException {
		List<LibraryResultsDTO> res = new ArrayList<LibraryResultsDTO>();
	    Connection dbConnection = null;
	    int id, releaseYear, IBSN, availibilityVal;
	    String title, author, artist, catalogNumber, availibility;

	    try {

            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/sys");
            dbConnection = ds.getConnection();
            
            Statement stmtBook = dbConnection.createStatement();
            ResultSet resultBooks = stmtBook.executeQuery("SELECT * FROM sys.book;");
            
            while (resultBooks.next()) {
            	LibraryResultsDTO e = new LibraryResultsDTO();
	        	id = resultBooks.getInt("idBook");
	        	e.setID(id);
	        	e.setType("Book");
	        	availibilityVal = resultBooks.getInt("availibility");
	        	if (availibilityVal != 1) {
	        		availibility = "Available";
	        	}
	        	else {
	        		availibility = "Unavailable";
	        	}
	        	e.setAvailability(availibility);
	        	releaseYear = resultBooks.getInt("releaseYear");
	        	IBSN = resultBooks.getInt("IBSN");
	        	title = resultBooks.getString("bookTitle");
	        	e.setTitle(title);
	        	author = resultBooks.getString("bookAuthor");
	        	e.setAuthorArtist(author);
	        	catalogNumber = resultBooks.getString("catalogNumber");
	        	e.setCatalogNumber(catalogNumber);		        	
	        	System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", CatalogNumber: " + catalogNumber);		        	
				res.add(e);
	        }

            stmtBook.close();
            
            Statement stmtCD = dbConnection.createStatement();
            ResultSet resultCDs = stmtCD.executeQuery("SELECT * FROM sys.cd");
            
            while (resultCDs.next()) {
            	LibraryResultsDTO e = new LibraryResultsDTO();
	        	id = resultCDs.getInt("idCD");
	        	e.setID(id);
	        	e.setType("CD");
	        	availibilityVal = resultCDs.getInt("availibility");
	        	if (availibilityVal != 1) {
	        		availibility = "Available";
	        	}
	        	else {
	        		availibility = "Unavailable";
	        	}
	        	e.setAvailability(availibility);
	        	releaseYear = resultCDs.getInt("releaseYear");
	        	title = resultCDs.getString("cdTitle");
	        	e.setTitle(title);
	        	artist = resultCDs.getString("cdArtist");
	        	e.setAuthorArtist(artist);
	        	catalogNumber = resultCDs.getString("catalogNumber");
	        	e.setCatalogNumber(catalogNumber);
	        	
	        	System.out.println("ID: " + id + ", Title: " + title + ", Artist: " + artist + ", CatalogNumber: " + catalogNumber);
	        	res.add(e);
	        }
            
            stmtCD.close();
            
            Statement stmtMovie = dbConnection.createStatement();
            ResultSet resultMovies = stmtMovie.executeQuery("SELECT * FROM sys.movie");
            
            while (resultMovies.next()) {
            	LibraryResultsDTO e = new LibraryResultsDTO();
	        	id = resultMovies.getInt("idMovie");
	        	e.setID(id);
	        	e.setType("Movie");
	        	availibilityVal = resultMovies.getInt("availibility");
	        	if (availibilityVal != 1) {
	        		availibility = "Available";
	        	}
	        	else {
	        		availibility = "Unavailable";
	        	}
	        	e.setAvailability(availibility);
	        	e.setAuthorArtist("N/A");
	        	releaseYear = resultMovies.getInt("releaseYear");
	        	title = resultMovies.getString("movieTitle");
	        	e.setTitle(title);
	        	catalogNumber = resultMovies.getString("catalogNumber");
	        	e.setCatalogNumber(catalogNumber);
	        	
	        	System.out.println("ID: " + id + ", Title: " + title + ", CatalogNumber: " + catalogNumber);
	        	res.add(e);
	        }
            
            stmtMovie.close();
            dbConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

	    return res;
		
	}


}
