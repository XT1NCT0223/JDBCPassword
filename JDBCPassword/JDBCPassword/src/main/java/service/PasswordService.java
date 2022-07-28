package service;

import java.sql.ResultSet;

import dao.PasswordDao;
import dto.Password;

public class PasswordService {
	public void savePassword(Password Password1) {
		PasswordDao dao = new PasswordDao();
		dao.savePassword(Password1);
	}

	public ResultSet getPasswords() {
		PasswordDao dao = new PasswordDao();
		return dao.getPassword();

	}

	public ResultSet getPasswordByAccName(String accName) {
		PasswordDao dao = new PasswordDao();
		return dao.getPasswordByAccName(accName);
	}

	public int deletePassword(String accName) {
		PasswordDao dao = new PasswordDao();
		return dao.deletePassword(accName);

	}

	public int updatePassword(Password Password2) {
		PasswordDao dao = new PasswordDao();
		return dao.updatePassword(Password2);

	}

}
