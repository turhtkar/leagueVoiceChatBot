package com.turhtkar.leaugevoicechatbot.threadManager;

import com.mongodb.client.MongoClient;


public class DbThreadController implements Runnable {
	
	private String flag;

	private MongoClient client;
	
	public DbThreadController(MongoClient client) {
		this.setClient(client);
	}
	public DbThreadController(String flag) {
		this.setFlag(flag);
	}

	public void run() {
//		switch (getFlag()) {
////		case "addUser":
////			UserDAO user = new UserDAO(getClient());
////			user.createUser(Account acc);
////			break;
////		case "deleteUser":
////			
////			break;
////		case "updateUser":
////			
////			break;
//		case "getAllUsers":
//			
//			break;
//		case "updateAllUsers":
//			
//			break;
//
//		default:
//			break;
//		}
	}

	public MongoClient getClient() {
		return client;
	}

	public void setClient(MongoClient client) {
		this.client = client;
	}
	/**
	 * @return the flag
	 */
	private String getFlag() {
		return flag;
	}
	
	/**
	 * @param flag the flag to set
	 */
	private void setFlag(String flag) {
		this.flag = flag;
	}

}
