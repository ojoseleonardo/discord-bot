package br.com.andromeda.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MemberLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        List<TextChannel> tc =  event.getGuild().getTextChannelsByName("bem-vindo", true);
        String userName = event.getUser().getAsMention();

        

//        ((TextChannel) tc).sendMessage(userName + " vazou do servidor!").queue();

    }
}
