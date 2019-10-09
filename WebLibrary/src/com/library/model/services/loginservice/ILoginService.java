package com.library.model.services.loginservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.library.model.domain.LoginBean;
import com.library.model.services.IService;

interface ILoginService extends IService {
	
	   //This variable is used to get the name of the service, it is referred to in the Service Factory
		public final String NAME = "ILoginService";

		boolean loginUser(LoginBean loginBean)
				throws SQLException, FileNotFoundException, IOException, ClassNotFoundException;

}
