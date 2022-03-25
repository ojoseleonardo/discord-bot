package br.com.andromeda.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class MemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel textChannel =  event.getGuild().getTextChannelById(956680969514012772L);
        String userName = event.getUser().getAsMention();

        textChannel.sendMessage(userName + " entrou no servidor!").queue();

    }

}
