package com.imageRetrival;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String user = "postgres";
		String password = "Welcome@123";
		String url = "jdbc:postgresql://127.0.0.1/postgres";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
//		String sql = "create table images2(name varchar,img blob)";
//		Statement st = conn.createStatement();
//		st.execute(sql);
		
//		String sql = "insert into images values(?,?)";
//		PreparedStatement stmt = conn.prepareStatement(sql);
//		stmt.setString(1, "eyes");
//		FileInputStream fin=new FileInputStream("D:\\image.jpg");  
//		stmt.setBinaryStream(2,fin,fin.available());  
//		int i=stmt.executeUpdate();
//		System.out.println("Rows affected "+i);
		
		PreparedStatement ps=conn.prepareStatement("select image from images");  
		/*ResultSet rs=ps.executeQuery();  
		if(rs.next()){//now on 1st row  
		
		InputStream b=rs.getBinaryStream(2);//2 means 2nd column data  
		System.out.println(b);
		//byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
		
		byte barr[]=(byte) b.read();
		              
		FileOutputStream fout=new FileOutputStream("d:\\retrieve.jpg");  
		//fout.write(barr);                
		fout.close();  
		}
		*/
		
		FileOutputStream fos = new FileOutputStream("d:\\retrieve.jpg");
		ResultSet rs = ps.executeQuery( );
		        if (rs != null) {
		            while (rs.next()) {

		                byte[] fileBytes = new byte[1024];
		                InputStream is = rs.getBinaryStream("image");
		                while (is.read(fileBytes) > 0) {
		                    fos.write(fileBytes);
		                }

		                // use the stream in some way here
		            }
		            rs.close();
		        }

	}

}
