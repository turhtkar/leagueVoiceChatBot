package com.turhtkar.leaugevoicechatbot.Users;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

public class UserDAO implements UserDaoImpl {
	
	private List<User> users;
	private MongoClient client;
	private MongoCollection<Document> DBuserList;

	public UserDAO(MongoClient client) {
		this.setClient(client);
		this.setUsers(new ArrayList<User>());
		this.setDBuserList(client.getDatabase("LeaugeVoiceChatDB").getCollection("LeaugeUsers"));
	
	}
	@Override
	public User getUser() {
		
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		
		
		return null;
	}

	@Override
	public void updateUser(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateAllUsers(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(Account acc) {
		Document account = new Document();
		account.append("PUUID", acc.getPUUID());
		account.append("summonerID", acc.getSummonerID());
		account.append("Region", acc.getRegion());
		account.append("summonerName", acc.getSummonerName());
		account.append("tier", acc.getTier());
		account.append("rank", acc.getRank());
		account.append("ip", acc.getLp());
		account.append("mmr", acc.getMmr());
		ArrayList<Document> LeagueAccounts = new ArrayList<Document>();
		LeagueAccounts.add(account);
		Document user = new Document();
		user.append("discordID", acc.getDiscordID());
		user.append("firstName", acc.getFirstName());
		user.append("leagueAccounts", LeagueAccounts);
		getDBuserList().insertOne(user);
	}
	public MongoClient getClient() {
		return client;
	}
	public void setClient(MongoClient client) {
		this.client = client;
	}
	/**
	 * @return the users
	 */
	private List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	private void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the dBuserList
	 */
	private MongoCollection<Document> getDBuserList() {
		return DBuserList;
	}
	/**
	 * @param dBuserList the dBuserList to set
	 */
	private void setDBuserList(MongoCollection<Document> dBuserList) {
		DBuserList = dBuserList;
	}
	

}
