package br.com.andromeda.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;


public class MemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel textChannel = (TextChannel) event.getGuild().getDefaultChannel();
        String userName = event.getUser().getAsMention();


        textChannel.sendMessage(userName + " entrou no servidor!").queue();

    }

}
