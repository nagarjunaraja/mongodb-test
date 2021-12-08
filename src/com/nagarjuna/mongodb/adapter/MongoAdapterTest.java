package com.nagarjuna.mongodb.adapter;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.mongodb.client.MongoDatabase;

public class MongoAdapterTest {
	
	public static void main(String args[]){
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		/*Employee emp = new Employee();
		emp.set_id("101");
		emp.setName("Nagarjuna");
		emp.setDesignation("TL");
		cr.insert(db, "employee", emp);*/
		//Crud.createCollection(db);
		
		//Crud.insert(db, "employee");
		//Crud.update("employee", db);
		
		//cr.delete("employee",db);
		//Boolean b = cr.update(db,"employee",new Employee("NS1272","Siva","Associate"));
		//System.out.println(b);
		ArrayList<Employee> al = cr.readAllRecords("employee", db);
		Employee e = al.get(0);
		System.out.println(e.get_id()+" "+e.getName()+" "+e.getDesignation());
		//cr.delete(db,"employee", "_id", "NS1274");
		cr.close();
	}
	
	@Test
	public void testEmployeeInsert() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}
	
	@Test
	public void testEmployeeUpdate() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}
	
	@Test
	public void testEmployeeDelete() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}
	
	@Test
	public void testEmployeeGet() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}
	
	@Test
	public void testEmployeeGetAll() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}
	
	@Test
	public void testCreationCollection() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}
	
	@Test
	public void testDeleteCollection() {
		MongoAdapter cr = new MongoAdapter();
		MongoDatabase db = cr.Connection();
		Employee emp = new Employee();
		emp.set_id("102");
		emp.setName("Naseer");
		emp.setDesignation("ATL");
		cr.insert(db, "employee", emp);
		assertEquals(true, true);
	}

}
