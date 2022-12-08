package com.turhtkar.leaugevoicechatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.login.LoginException;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.turhtkar.leaugevoicechatbot.threadManager.DbThreadController;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import com.turhtkar.leaugevoicechatbot.listeners.EventListener;

/**
 * The Class LeaugeVoicechatBot.
 * @author turhtkar
 */
public class LeaugeVoicechatBot {
	
	/** The shard manager. */
	private final ShardManager shardManager;
	
	private final Dotenv config;
	
	/**
	 * Loads enviorment variables and builds the bot shard manager.
	 *
	 * @throws LoginException the login exception
	 */
	public LeaugeVoicechatBot() throws LoginException {
		config = Dotenv.configure().load();
		String token = config.get("TOKEN");
		DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.playing("with your mom"));
		builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_VOICE_STATES,GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_MEMBERS);
		builder.addEventListeners(new EventListener());
		shardManager = builder.build();
		
	}
	
	

	/**
	 * retrieves the bot shard manager
	 *
	 * @return the shard manager instance for the bot.
	 */
	public ShardManager getShardManager() {
		return shardManager;
	}
	



	/**
	 * retrieves the bot config
	 * 
	 * @return the bot config
	 */
	public Dotenv getConfig() {
		return config;
	}


	private static void addUser(MongoClient client, ButtonInteractionEvent event) {
		MongoCollection<Document> users = client.getDatabase("LeaugeVoiceChatDB").getCollection("LeaugeUsers");
		Document account = new Document();
		account.append("PUUID", "1");
		account.append("summonerID", "1");
		account.append("Region", "EUNE");
		account.append("summonerName", "1");
		account.append("tier", "1");
		account.append("rank", "1");
		account.append("ip", "1");
		account.append("mmr", "1");
		ArrayList<Document> LeagueAccounts = new ArrayList<Document>();
		LeagueAccounts.add(0,account);
		Document user = new Document();
		user.append("discordID", "1");
		user.append("firstName", "גיי");
		user.append("leagueAccounts", LeagueAccounts);
		users.insertOne(user);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LeaugeVoicechatBot bot = null;
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		try {
			bot = new LeaugeVoicechatBot();
		} catch (LoginException e) {
			System.out.println("Error: Provided bot token is invalid!");
			e.printStackTrace();
		}
		String MongoDBConnection = bot.getConfig().get("DBCONNECTION");
		try(MongoClient client = MongoClients.create(MongoDBConnection)) {
			DbThreadController usersController = new DbThreadController(client);
			Thread controller = new Thread(usersController);
			controller.start();
			addUser(client, null);
			//different ways to print the databases
			//======================================
//			List<Document> dbDocuments = client.listDatabases().into(new ArrayList<>());
//			dbDocuments.forEach(document -> System.out.println(document.toJson()));
//			System.out.println(dbDocuments);
//			MongoIterable<String> strings = client.listDatabaseNames();
//			MongoCursor<String> cursor = strings.cursor();
//			while (cursor.hasNext()) {
//				System.out.println(cursor.next());
//			}
		}
		
		
		

		
		
	}
}
