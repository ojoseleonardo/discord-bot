package br.com.andromeda.events;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

import static br.com.andromeda.app.App.jda;


public class MemberJoinEvent extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String userName = event.getUser().getAsMention();

        List<TextChannel> channels = jda.getTextChannelsByName("welcome", true);
        for(TextChannel ch : channels)
        {
           ch.sendMessage(userName + " entrou no servidor!").queue();
        }

    }

}
