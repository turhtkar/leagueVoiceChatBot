package com.turhtkar.leaugevoicechatbot.listeners;

import java.util.Optional;

import com.mongodb.internal.async.ErrorHandlingResultCallback;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateAppliedTagsEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateFlagsEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateTypeEvent;
import net.dv8tion.jda.api.events.channel.update.ChannelUpdateUserLimitEvent;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateRulesChannelEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceRequestToSpeakEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceStreamEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceVideoEvent;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.ApplicationUpdatePrivilegesEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

public class EventListener extends ListenerAdapter {

	@Override
	public void onButtonInteraction(ButtonInteractionEvent event) {
		if(event.getComponentId().equals("SignIn")) {
			TextInput name = TextInput.create("firstName", "First Name", TextInputStyle.SHORT)
					.setPlaceholder("Enter your first name or your nickname")
					.setMinLength(1)
					.setRequired(true)
					.setValue("Wongi The Gay")
					.build();
			
			TextInput SummonerName = TextInput.create("SummonerName","Summoner Name", TextInputStyle.SHORT)
					.setPlaceholder("Enter your summonerName")
					.setMinLength(1)
					.setMaxLength(100)
					.setRequired(true)
					.setValue("Omerm123")
					.build();
			
			Modal modal = Modal.create("signIn", "Sign your League Account")
					.addActionRows(ActionRow.of(name), ActionRow.of(SummonerName))
					.build();
			event.replyModal(modal).queue();
			event.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("hello")).queue();
		}
		
	}

	@Override
	public void onModalInteraction(ModalInteractionEvent event) {
		if(event.getModalId().equals("signIn")) {
			System.out.println(event.getValues());
			String name = event.getValue("firstName").getAsString();
            String SummonerName = event.getValue("SummonerName").getAsString();
            
//            Optional<Member> memberOptional = event.getGuild().getMembersByName(name, true).stream().findFirst();
//            if (memberOptional.isPresent()) {
//                //Reply to the user with the name and message
//                event.reply("Sup, " + memberOptional.get().getAsMention() + "! " + SummonerName).queue();
//            }else{
//                //Reply to the user with the name and message
//                event.reply("Sup, " + name + "! " + SummonerName).queue();
//            }
            event.reply("Sup, " + name + "! " +"we signed in your leauge account "+ SummonerName).queue();
		}
		
	}

	@Override
	public void onUserActivityStart(UserActivityStartEvent event) {
		// TODO Auto-generated method stub
		super.onUserActivityStart(event);
	}

	@Override
	public void onUserActivityEnd(UserActivityEndEvent event) {
		// TODO Auto-generated method stub
		super.onUserActivityEnd(event);
	}

	@Override
	public void onChannelCreate(ChannelCreateEvent event) {
		// TODO Auto-generated method stub
		super.onChannelCreate(event);
	}

	@Override
	public void onChannelDelete(ChannelDeleteEvent event) {
		// TODO Auto-generated method stub
		super.onChannelDelete(event);
	}

	@Override
	public void onChannelUpdateName(ChannelUpdateNameEvent event) {
		// TODO Auto-generated method stub
		super.onChannelUpdateName(event);
	}

	@Override
	public void onChannelUpdateFlags(ChannelUpdateFlagsEvent event) {
		// TODO Auto-generated method stub
		super.onChannelUpdateFlags(event);
	}

	@Override
	public void onChannelUpdateType(ChannelUpdateTypeEvent event) {
		// TODO Auto-generated method stub
		super.onChannelUpdateType(event);
	}

	@Override
	public void onChannelUpdateUserLimit(ChannelUpdateUserLimitEvent event) {
		// TODO Auto-generated method stub
		super.onChannelUpdateUserLimit(event);
	}

	@Override
	public void onChannelUpdateAppliedTags(ChannelUpdateAppliedTagsEvent event) {
		// TODO Auto-generated method stub
		super.onChannelUpdateAppliedTags(event);
	}

	@Override
	public void onGuildReady(GuildReadyEvent event) {
		// TODO Auto-generated method stub
		super.onGuildReady(event);
	}

	@Override
	public void onGuildUpdateRulesChannel(GuildUpdateRulesChannelEvent event) {
		// TODO Auto-generated method stub
		super.onGuildUpdateRulesChannel(event);
	}

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		EmbedBuilder msg = new EmbedBuilder();
		Button button1 = Button.success("SignIn", "Sign in");
		event.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage("hello").setActionRow(button1)).queue();
	}

	@Override
	public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
		// TODO Auto-generated method stub
		super.onGuildVoiceUpdate(event);
	}

	@Override
	public void onGuildVoiceStream(GuildVoiceStreamEvent event) {
		// TODO Auto-generated method stub
		super.onGuildVoiceStream(event);
	}

	@Override
	public void onGuildVoiceVideo(GuildVoiceVideoEvent event) {
		// TODO Auto-generated method stub
		super.onGuildVoiceVideo(event);
	}

	@Override
	public void onGuildVoiceRequestToSpeak(GuildVoiceRequestToSpeakEvent event) {
		// TODO Auto-generated method stub
		super.onGuildVoiceRequestToSpeak(event);
	}

	@Override
	public void onApplicationUpdatePrivileges(ApplicationUpdatePrivilegesEvent event) {
		// TODO Auto-generated method stub
		super.onApplicationUpdatePrivileges(event);
	}

	@Override
	public void onGenericInteractionCreate(GenericInteractionCreateEvent event) {
		// TODO Auto-generated method stub
		super.onGenericInteractionCreate(event);
	}

	@Override
	public void onGenericChannelUpdate(GenericChannelUpdateEvent<?> event) {
		// TODO Auto-generated method stub
		super.onGenericChannelUpdate(event);
	}

	@Override
	public void onMessageUpdate(MessageUpdateEvent event) {
		// TODO Auto-generated method stub
		super.onMessageUpdate(event);
	}

	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		event.getReaction();
		super.onMessageReactionAdd(event);
	}

	@Override
	public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
		// TODO Auto-generated method stub
		super.onMessageReactionRemove(event);
	}
	
	
}
