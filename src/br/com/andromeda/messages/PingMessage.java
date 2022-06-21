package br.com.andromeda.messages;

import  br.com.andromeda.app.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;



public class PingMessage {

    EmbedBuilder builder = new EmbedBuilder();

    public MessageEmbed ping(Member author){
        builder.setTitle("✅  PING");
        builder.setDescription("*" + App.jda.getGatewayPing() + "ms" + "*");
        builder.setAuthor(author.getUser().getName(),"https://www.google.com/", author.getUser().getAvatarUrl());

        return builder.build();
    }
}
