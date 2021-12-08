package com.nagarjuna.mongodb.eventlog;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connect {
	
	public static MongoDatabase db= null;
	public static MongoClient mongoClient = null;
	
	public static MongoDatabase Connection(String database){
		
		mongoClient = new MongoClient( "localhost" , 27017 );
		db = mongoClient.getDatabase(database);
		System.out.println("Connected to the "+database+" Database");
		return db;
	}
	
	public static void close(){
		mongoClient.close();
		System.out.println("Connectio Closed");
	}

}
