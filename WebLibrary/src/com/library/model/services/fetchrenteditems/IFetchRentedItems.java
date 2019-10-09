package com.library.model.services.fetchrenteditems;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.library.model.domain.LibraryResultsDTO;
import com.library.model.services.IService;

interface IFetchRentedItems extends IService {
			//This variable is used to get the name of the service, it is referred to in the Service Factory
			public final String NAME = "IFetchRentedItems";
			
			//This method will return the result of a search with a string attached to it
			public List<LibraryResultsDTO> getUserRentedItems (String email) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException;
}
