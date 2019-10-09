package com.library.model.services.loginservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.library.model.domain.LoginBean;

public class LoginServiceImpl implements ILoginService {
	
	public static String email;

	@Override
	public boolean loginUser(LoginBean loginBean) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		
		String email = loginBean.getUsername();
		setEmail(email);
		String password = loginBean.getPassword();
		
		return true;
	}
	
	private void setEmail(String email) {
		LoginServiceImpl.email = email;
	}

	public String getEmail() {
		return LoginServiceImpl.email;
	}
}
