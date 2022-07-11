//package me.andromeda.bot.event;
//
//import net.dv8tion.jda.api.entities.TextChannel;
//import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//import static br.com.andromeda.app.App.jda;
//
//public class MemberLeaveEvent extends ListenerAdapter {
//    @Override
//    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
//        String userName = event.getUser().getAsMention();
//
//        List<TextChannel> channels = jda.getTextChannelsByName("welcome", true);
//        for(TextChannel ch : channels)
//        {
//            ch.sendMessage(userName + " saiu do servidor!").queue();
//        }
//
//    }
//}
