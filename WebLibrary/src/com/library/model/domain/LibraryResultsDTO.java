package com.library.model.domain;

public class LibraryResultsDTO {

	private String Title;
	private String returnDate;
	private String Type;
	private int ID;
	private String AuthorArtist;
	private String catalogNumber;
	private String Availability;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthorArtist() {
		return AuthorArtist;
	}
	public void setAuthorArtist(String authorArtist) {
		AuthorArtist = authorArtist;
	}
	public String getCatalogNumber() {
		return catalogNumber;
	}
	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availibility) {
		Availability = availibility;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
