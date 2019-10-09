package com.library.model.domain;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import com.library.model.domain.Book;
import com.library.model.domain.Movie;
import com.library.model.domain.CD;

public class AvailableItems implements Serializable{

	/**
	 * @author Veeral Patel
	 */
	
	//Here we need Serializable to be able to write to the output files
	private static final long serialVersionUID = 1L;
	
	//the allAvailableItems is used to add every object in the library that is available
	ArrayList<Object> allAvailableItems = new ArrayList<Object>();

	//This method is used in order to add a new book. A clause in there checks if the item is available or not
	public void addBook(Book newBook) {
		allAvailableItems.add(newBook);
	}

	//This method is used in order to add a new CD. A clause in there checks if the item is available or not
	public void addCD(CD newCD) {
		allAvailableItems.add(newCD);
	}
	
	//This method is used in order to add a new Movie. A clause in there checks if the item is available or not
	public void addMovie(Movie newMovie) {
			allAvailableItems.add(newMovie);
	}
	
	//This method just returns the allAvailableItems array, with all available items in the library
	public ArrayList<Object> returnAllAvailibleItems() throws FileNotFoundException, IOException, Exception {
		return allAvailableItems;
	}
	
}
