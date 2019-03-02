package com.ecankurban.db.manager.comming;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecankurban.db.manager.model.User;
import com.ecankurban.db.manager.ui.GirisFrame;
import com.ecankurban.db.manager.ui.MainFrame;

public class UserDAO {

	public User getUserForName(String userName) throws SQLException {
		
		ConnectionManager temp= ConnectionManager.getInstance();
		Connection conn=temp.getConnection();
		Statement stmt=conn.createStatement();
		String sql="select id,usrname,paswd from usr where usrname='"+userName+"'";
		System.out.println(sql);
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println(sql);
		User usr=null;
		if(rs.next()) {
			usr=new User();
			usr.setUsername(rs.getString("usrname"));
			usr.setPassword(rs.getString("paswd"));
			usr.setId(rs.getInt("id"));
			}
		
		
		
		return usr;
	}
	
	public List<User> getAllUsers(User usr) throws SQLException{
		List<User> users=new ArrayList<User>();
		
		ConnectionManager temp= ConnectionManager.getInstance();
		Connection conn=temp.getConnection();
		Statement stmt=conn.createStatement();
		String sql="select id,usrname,paswd from usr ";
		System.out.println(sql);
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println(sql);
		
		while(rs.next()) {
			User nusr=new User();
			nusr.setUsername(rs.getString("usrname"));
			nusr.setPassword(rs.getString("paswd"));
			nusr.setId(rs.getInt("id"));
			users.add(nusr);
			}
		
		return users;
	}
}
