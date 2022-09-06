package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class User {
	String fName;
	String lName;
	String email;
	String idp;
	String mob;
	String dateOfBirth;
	Date dob;
	
	
	
	public User(String fName, String lName, String email, String idp, String mob, String dob) throws Exception {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.idp = idp;
		this.mob = mob;
		this.dateOfBirth = dob;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(this.dateOfBirth);
		this.dob = new java.sql.Date(date.getTime()); 
		
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdp() {
		return idp;
	}
	public void setIdp(String idp) {
		this.idp = idp;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}
	
	private static String getVowels(String s) {
		String vow="";
		for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e'
                || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                || s.charAt(i) == 'u' || s.charAt(i) == 'A'
                || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                || s.charAt(i) == 'O'
                || s.charAt(i) == 'U') {
                vow+=s.charAt(i);
            }
            else {
                continue;
            }
        }
		
		return vow;
	}
	
	private static String getOdd(String s) {
		String odd = "";
		for(int i=0; i<s.length(); i+=2) {
			odd += s.charAt(i);
		}
		
		return odd;
	}
	
	private static int getSumOfDigits(String s) {
		int phoneSum = 0; 
	    for(int i=0;i<s.length();i++) {
	    	if(Character.isDigit(s.charAt(i)))
	    		phoneSum+=s.charAt(i)-'0';
	    }
	    return phoneSum;
	}
	
	public Login generateCred() {
		String username = this.fName + this.mob.substring(this.mob.length() - 4);
		
		String vowels = User.getVowels(this.idp);
		String oddMob = User.getOdd(this.mob);
		int dobSum = User.getSumOfDigits(this.dateOfBirth);
		int idpSum = User.getSumOfDigits(this.idp);
		
		String password = this.lName.substring(0, 1) + this.fName.substring(this.fName.length() - 1) + oddMob + vowels + (dobSum + idpSum);
		
		return new Login(this.idp, username, password);
		
	}
	
	public int saveToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prescripty", "root", "0000");
			
			String sql = "insert into user values(?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, this.fName);
			stmt.setString(2, this.lName);
			stmt.setString(3, this.email);
			stmt.setString(4, this.idp);
			stmt.setString(5, this.mob);
			stmt.setDate(6, this.dob);
			
			return stmt.executeUpdate();
			
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
		
	}
	
	
	
	
}
