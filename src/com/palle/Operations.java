package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Operations {
	
	public static String url ="jdbc:mysql://localhost:3306/palle";
	public static String username = "root";
	public static String password = "Subhasis@123";
	
	Connection con = null;
	Statement s = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void creating() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			s = con.createStatement();
			
			s.executeUpdate("create table student(sno int primary key auto_increment, "
					+ "sname varchar(20), sub varchar(20), email varchar(30) unique)");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(s != null) {
					s.close();
					}
					if(con != null) {
						con.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	
	public void inserting(String sname,String sub,String email) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
			
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			
			
			ps.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(ps != null) {
					ps.close();
					}
					if(con != null) {
						con.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	
	public void update(int sno, String email,String sub) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);			
			ps = con.prepareStatement("update student set email=?, sub=? where sno =?");
			
			
			ps.setString(1, email);
			ps.setString(2, sub);
			ps.setInt(3, sno);		
			ps.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(ps != null) {
					ps.close();
					}
					if(con != null) {
						con.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	
	
	public void delete(int sno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);			
			ps = con.prepareStatement("delete from student where sno = ?");
			
			
			
			ps.setInt(1, sno);		
			ps.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(ps != null) {
					ps.close();
					}
					if(con != null) {
						con.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	
	
	public void read() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);		
			s = con.createStatement();
			
			rs= s.executeQuery("select * from student");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("**********");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(rs != null) {
					rs.close();
					}
					if(con != null) {
						con.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}	
	}
	
	
	
	public ArrayList<Student> getAllTableData(){
		ArrayList<Student> al = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			rs = s.executeQuery("select * from student");
			
			while(rs.next()) {
				int a = rs.getInt("sno");
				String b = rs.getString("sname");
				String c = rs.getString("sub");
				String d = rs.getString("email");
				
				Student s = new Student(a, b, c, d);
				
				al.add(s);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
