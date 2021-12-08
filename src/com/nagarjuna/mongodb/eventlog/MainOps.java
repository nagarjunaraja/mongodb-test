package com.nagarjuna.mongodb.eventlog;

import com.mongodb.client.MongoDatabase;

public class MainOps {
	
	public static void main(String args[]){
		MongoDatabase db = Connect.Connection("demo");
		//Crud.createCollection(db);
		
		//Crud.insert(db, "employee");
		//Crud.update("employee", db);
		//Crud.delete("employee",db);
		Crud.retrieve("employee", db);
		Connect.close();
	}

}
