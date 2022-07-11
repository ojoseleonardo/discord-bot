//package me.andromeda.bot.msg;
//
//import me.andromeda.bot.App;
//import net.dv8tion.jda.api.EmbedBuilder;
//import net.dv8tion.jda.api.entities.Member;
//import net.dv8tion.jda.api.entities.MessageEmbed;
//
//
//
//public class PingMessages {
//
//    EmbedBuilder builder = new EmbedBuilder();
//
//    public MessageEmbed ping(Member author){
//        builder.setTitle("✅  PING");
//        builder.setDescription("*" + App.jda.getGatewayPing() + "ms" + "*");
//        builder.setAuthor(author.getUser().getName(),"https://www.google.com/", author.getUser().getAvatarUrl());
//
//        return builder.build();
//    }
//}
