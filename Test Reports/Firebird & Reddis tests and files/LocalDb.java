package com.reroute.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class LocalDb {
	DateFormat dateFormat = new SimpleDateFormat("mm:ss");
	private Date startRunningTime = null;
	private Date endRunningTime = null;

	private Jedis jedis = null;
	//===============================
	public LocalDb(){
		try{
			jedis = new Jedis("localhost");
			System.out.println("Reddis Connection Successful");
			//System.out.println("Server PING: "+jedis.ping());
			//System.out.println("Server Info: "+jedis.info());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//===============================
	public void enqueue(String pKey, String pVal){
		jedis.sadd(pKey,pVal);
	}

	//===============================
	public void dequeue(String pKey){
		jedis.srem(pKey);
	}
	//===============================
	public Set<String> findKey(String pKey){
		return jedis.keys(pKey);
	}
	//===============================
	public Set<String> getMembers(String pKey){
		return jedis.smembers(pKey);
	}
	//===============================
	public Long size(){
		return jedis.dbSize();
	}
	//===============================
	public void close(){
		jedis.close();
	}
	//===============================
	public void deleteAll(){
		jedis.flushDB();
	}
	public String getSearchRunningTime(){
		long diff = Math.abs(startRunningTime.getTime() - endRunningTime.getTime());
		long diffSeconds = diff / 1000 % 60;
		long diffMilliseconds = diff / 1 % 60;
		return ""+diffMilliseconds;
	}
	/*/===============================
	public static void main(String[] args) {
		LocalDb myLocalDb = new LocalDb();
		Set<String> list = null;
		Set<String> members = null;
		String pKey = "83";
		String pVal = "PANADO";

		String search = "AIR-MUNE";
		String productName = "";

		//myLocalDb.enqueue(pKey, pVal);

		list = myLocalDb.findKey("*");
		//Display all the data
		for (String key : list) {
			System.out.print("Key: "+key+" => ");
			members = myLocalDb.getMembers(key);
			System.out.println(members);
		}

		for (String key : list) {
			members = myLocalDb.getMembers(key);
			for (String val : members) {
				if(val.equals(search)){
					productName = key;
				}
			}
		}

		System.out.print("\n=========\nProduct Name: ");
		if(!productName.equals("")){
			System.out.print(productName);
		}
		else{
			System.out.print("NOT MACTHED!");
		}

		//myLocalDb.deleteAll();
		System.out.println("\n=========\nSize: "+myLocalDb.size()+"\n=========");
		myLocalDb.close();

	}*/

}
