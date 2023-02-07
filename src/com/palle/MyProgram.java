package com.palle;

import java.util.ArrayList;

public class MyProgram {

	public static void main(String[] args) {

		Operations op = new Operations();
		
		//op.creating();
		
//		op.inserting("Clinton", "Agriculture","cl200@gmail.com");
//		op.inserting("Deba", "CSE","montu@gmail.com");
//		op.inserting("Anup", "B.Tech","anup@gmail.com");
		
		//op.update(2, "montu420@gmail.com", "Math");
		
		//op.read();
		
		//op.delete(3);
		
	   ArrayList<Student> al = op.getAllTableData();
	   for(Student i : al) {
		   System.out.println(i.getSno());
		   System.out.println(i.getSname());
		   System.out.println(i.getSub());
		   System.out.println(i.getEmail());
		   System.out.println("******");
	   }

	}

}
