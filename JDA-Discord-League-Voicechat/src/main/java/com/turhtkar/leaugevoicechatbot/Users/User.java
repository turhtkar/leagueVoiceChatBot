package com.turhtkar.leaugevoicechatbot.Users;

import java.util.ArrayList;

import org.bson.Document;

public class User {
	
	private String discordID;
	private String firstName;
	private ArrayList<Document> LeagueAccounts;
	public User(String discordID, String firstName, ArrayList<Document> leagueAccounts) {
		super();
		this.discordID = discordID;
		this.firstName = firstName;
		LeagueAccounts = leagueAccounts;
	}
	public User(String discordID, String firstName) {
		this.discordID = discordID;
		this.firstName = firstName;
	}
	/**
	 * @return the discordID
	 */
	public String getDiscordID() {
		return discordID;
	}
	/**
	 * @param discordID the discordID to set
	 */
	private void setDiscordID(String discordID) {
		this.discordID = discordID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the leagueAccounts
	 */
	private ArrayList<Document> getLeagueAccounts() {
		return LeagueAccounts;
	}
	/**
	 * @param leagueAccounts the leagueAccounts to set
	 */
	private void setLeagueAccounts(ArrayList<Document> leagueAccounts) {
		LeagueAccounts = leagueAccounts;
	}
	
	
	

}
