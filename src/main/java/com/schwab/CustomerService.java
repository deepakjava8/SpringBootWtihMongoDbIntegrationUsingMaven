package com.schwab;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;



public class CustomerService {
	
	public List<Customer> findAll(){
		List<Customer> list=new ArrayList<>();
		try{
		MongoClient client=new MongoClient();
		DB db=client.getDB("schwab");
		DBCollection col=db.getCollection(Customer.Collecton_Name);
		DBCursor dc=col.find();
		while(dc.hasNext()){
			DBObject o=dc.next();
			Customer c=new Customer();
			c.setName((String)o.get("name"));
			c.setAge((String)o.get("age"));
			list.add(c);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public DBObject findObjectId(String id){
		DBObject dbObj=null;
		try{
		MongoClient client=new MongoClient();
		DB db=client.getDB("schwab");
		DBCollection col=db.getCollection(Customer.Collecton_Name);
		
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(id));
	    dbObj = col.findOne(query);
	   // return DBObject dbObj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return  dbObj;
	
	}
	/*public Customer saveCustomer(Customer cust){
		
		try{
		MongoClient client=new MongoClient();
		DB db=client.getDB("schwab");
		System.out.println("connect...");
		DBCollection col=db.getCollection(Customer.Collecton_Name);
		DBObject  o=new BasicDBObject();
		
		col.save(cust);
		System.out.println("saved");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cust;
	}*/
}
