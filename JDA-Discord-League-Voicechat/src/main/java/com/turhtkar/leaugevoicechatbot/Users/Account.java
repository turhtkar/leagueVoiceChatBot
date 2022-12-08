package com.turhtkar.leaugevoicechatbot.Users;

import java.util.ArrayList;

import org.bson.Document;

public class Account extends User {

	public Account(String discordID, String firstName, ArrayList<Document> leagueAccounts) {
		super(discordID, firstName, leagueAccounts);
		// TODO Auto-generated constructor stub
	}
	public Account(String discordID, String firstName, String summonerName) {
		super(discordID, firstName);
		this.summonerName = summonerName;
	}
	public Account(String discordID, String firstName, ArrayList<Document> leagueAccounts, String pUUID,
			String summonerID, String region, String summonerName, String tier, String rank, String lp, String mmr) {
		super(discordID, firstName, leagueAccounts);
		PUUID = pUUID;
		this.summonerID = summonerID;
		Region = region;
		this.summonerName = summonerName;
		this.tier = tier;
		this.rank = rank;
		this.lp = lp;
		this.mmr = mmr;
	}
	private String PUUID;
	private String summonerID;
	private String Region;
	private String summonerName;
	private String tier;
	private String rank;
	private String lp;
	private String mmr;
	/**
	 * @return the pUUID
	 */
	public String getPUUID() {
		return PUUID;
	}
	/**
	 * @param pUUID the pUUID to set
	 */
	private void setPUUID(String pUUID) {
		PUUID = pUUID;
	}
	/**
	 * @return the summonerID
	 */
	public String getSummonerID() {
		return summonerID;
	}
	/**
	 * @param summonerID the summonerID to set
	 */
	private void setSummonerID(String summonerID) {
		this.summonerID = summonerID;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return Region;
	}
	/**
	 * @param region the region to set
	 */
	private void setRegion(String region) {
		Region = region;
	}
	/**
	 * @return the summonerName
	 */
	public String getSummonerName() {
		return summonerName;
	}
	/**
	 * @param summonerName the summonerName to set
	 */
	private void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	/**
	 * @return the tier
	 */
	public String getTier() {
		return tier;
	}
	/**
	 * @param tier the tier to set
	 */
	private void setTier(String tier) {
		this.tier = tier;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	private void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the lp
	 */
	public String getLp() {
		return lp;
	}
	/**
	 * @param ip the lp to set
	 */
	private void setLp(String lp) {
		this.lp = lp;
	}
	/**
	 * @return the mmr
	 */
	public String getMmr() {
		return mmr;
	}
	/**
	 * @param mmr the mmr to set
	 */
	private void setMmr(String mmr) {
		this.mmr = mmr;
	}
}
