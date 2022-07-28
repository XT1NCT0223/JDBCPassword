package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dto.Password;
import service.PasswordService;



public class PasswordController {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		boolean flag = true;  
		while (flag) {
		System.out.println("------------HomePage----------------------");
		System.out.println("Press 1 to enter new Password");
		System.out.println("Press 2 to View all Password");
		System.out.println("Press 3 to get Password by AccName");
		System.out.println("Press 4 to Update existing Password");
		System.out.println("Press 5 to delete Password by AccName");
		System.out.println("Press 6 to exit");
		int choice = t.nextInt();
		
			switch (choice) {
			case 1: {
				PasswordService service= new PasswordService();
				Password password = new Password();
				System.out.println("Enter Password id");
				int id = t.nextInt();
				password.setId(id);
				System.out.println("Enter  Account name");
				String name = t.next();
				password.setAccName(name);
				System.out.println("Enter User name");
				String uname = t.next();
				password.setUserName(uname);
				System.out.println("Enter Password");
				String pass = t.next();
				password.setPassword(pass);
				service.savePassword(password);
				System.out.println("user saved sucessfully ");
			
			}

				break;
			case 2: {
				PasswordService service= new PasswordService();
				ResultSet resultSet = service.getPasswords();
				try {
					while (resultSet.next()) {
						int id = resultSet.getInt(1);
						String accName = resultSet.getString(2);
						String userName = resultSet.getString(3);
						String pass = resultSet.getString(4);

						System.out.println("Password id is = " + id);
						System.out.println("Account name is = " + accName);
						System.out.println("User name is = " + userName);
						System.out.println("Password is = " + pass);
						System.out.println("--------------------------------------------");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

				break;
			case 3: {
				PasswordService service= new PasswordService();
				System.out.println("Enter Password id");
				String acc = t.next();
				ResultSet resultSet = service.getPasswordByAccName(acc);
				try {
					if (resultSet.next()) {
						int id = resultSet.getInt(1);
						String accName = resultSet.getString(2);
						String userName = resultSet.getString(3);
						String pass = resultSet.getString(4);

						System.out.println("Password id is = " + id);
						System.out.println("Account name is = " + accName);
						System.out.println("User name is = " + userName);
						System.out.println("Password is = " + pass);
						System.out.println("--------------------------------------------");

				
					} else {
						System.out.println("No account found");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				break;
			case 4: {
				PasswordService service= new PasswordService();
				Password password = new Password();
				System.out.println("Enter Password id");
				int id = t.nextInt();
				password.setId(id);
				System.out.println("Enter  Account name");
				String name = t.next();
				password.setAccName(name);
				System.out.println("Enter User name");
				String uname = t.next();
				password.setUserName(uname);
				System.out.println("Enter Password");
				String pass = t.next();
				password.setPassword(pass);
				service.updatePassword(password);
				System.out.println("password updated sucessfully ");

			}
				break;
			case 5: {
				PasswordService service= new PasswordService();
				System.out.println("Enter Acc  to delete the password");
				String acc = t.next();
				int res = service.deletePassword(acc);
				System.out.println(res + " deleted sucessfully");

			}
				break;
			case 6: {
				flag = false;
				System.out.println("thank you");
			}
				break;
			default: {

			}
			}
		}
	}


}
