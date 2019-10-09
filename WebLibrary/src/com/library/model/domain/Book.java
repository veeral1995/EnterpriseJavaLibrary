package com.library.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * This class is responsible for creating Book which are then stored with each Customer.
 *
 * NOTE: Rearranged the class to fit the conventional order of methods/variables.
 * @author: Veeral Patel
 */

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//the title string is the title for an object within the class Book.
	private String title;
    
	//refers to the DB value for ID, auto-generated
    private Integer id;
    
    private String type;
	
	//the Author string is the Author for an object within the class Book.
	private String Author;
	
	//the releaseYear integer is the year the object of class book was released.
	private int releaseYear;
	
	//the boolean variable availability is the status of availability for an object within the class Book.
	private int availibility;
	
	//the Date variable returnDate is the date the object of Book is due when rented out.
	private Date returnDate;
	
	//the string variable catalogNum is the catalog number for an object within the class Book.
	private String catalogNumber;
	
	//the integer IBSN, is the IBSN number for an object that is of the class Book
	private int IBSN;

    public Book() {
    }
	

/**
* This is the constructor. For every Book object that gets created, this method is called and requires these parameters.
*/
	public Book(String title, String author, int releaseYear, int availibility, Date returnDate, String catalogNumber, int IBSN) {
		super();
		this.title = title.toLowerCase();
		this.type = "Book";
		Author = author;
		this.releaseYear = releaseYear;
		this.IBSN = IBSN;
		this.catalogNumber = catalogNumber;
		this.returnDate = null;
		this.availibility = availibility;
	}

/**
* Validate if the instance variables are valid
* 
* @return boolean - true if instance variables are valid, else false
*/
	public boolean validate () {
		
		if (releaseYear == 0.0) return false;
		if (IBSN == 0.0) return false;
		if (title == null) return false;
		if (Author == null) return false;
		if (returnDate != null) return false;
                if (availibility == 0.0) return true;
                if (catalogNumber == null) return false;
		return true;
	}		

/**
* The getIBSN() function randomly generates an integer that is added for every object of Book that is created.
*/
	public int getIBSN(){
		
		Random randoNum = new Random();
		int num = 1000000000 + randoNum.nextInt(900000000);
		return num;
	}
		
		
/**
* Until the next comments, all these methods are getters and setters. Which mean that they get and set values for
* objects that are within the class.
     * @return 
*/
        public Integer getID(){
            return id;
        }
        
       
	public String getTitle() {
		return title.toLowerCase().trim();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
        public void setID (int id) {
		this.id = id;
	}

	public int getAvailibility() {
		return availibility;
	}

	public void setAvailibility(int availibility) {
		this.availibility = availibility;
        }

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public void setIBSN(int iBSN) {
		IBSN = iBSN;
	}


/**
* This is the equals() method. This method will check if two objects within the class are identical to each other.
* 
*/	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (Author == null) {
			if (other.Author != null)
				return false;
		} else if (!Author.equals(other.Author))
			return false;
		if (IBSN != other.IBSN)
			return false;
		if (availibility != other.availibility)
			return false;
		if (catalogNumber != other.catalogNumber)
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	* This is the hashCode() method. This is mainly used for hashing collections such as a HashMap, which is not used here.
	* 
	*/
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Author == null) ? 0 : Author.hashCode());
			result = prime * result + IBSN;
			result = prime * result + availibility;
			result = prime * result + ((catalogNumber == null) ? 0 : catalogNumber.hashCode());
			result = prime * result + releaseYear;
			result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}	
	
/**
* This is the toString() method. This method turns an Book object into a string that can be read at runtime if invoked.
* 
*/
	@Override
	public String toString() {
		return "Book [title=" + title + ", Author=" + Author + ", releaseYear=" + releaseYear + ", availibility="
				+ availibility + ", returnDate=" + returnDate + ", catalogNumber=" + catalogNumber + ", IBSN=" + IBSN + "]";
	}


public void setType(String string) {
	this.type = string;
}

public String getType() {
	return type;
}

	
	
}