package com.schwab;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
MongoClient client=new MongoClient();
MongoDatabase db=client.getDatabase("schwab");
}
