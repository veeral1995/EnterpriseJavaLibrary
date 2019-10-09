package com.library.model.services.registrationservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.library.model.services.IService;

interface IRegistrationService extends IService{

	
	//This variable is used to get the name of the service, it is referred to in the Service Factory
	public final String NAME = "IRegistrationService";
	
	//This method will return the result of a search with a string attached to it
	public boolean registerCustomer (String email, String password) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException;
	


}