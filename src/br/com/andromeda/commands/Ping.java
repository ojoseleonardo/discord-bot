package br.com.andromeda.commands;

import br.com.andromeda.main.*;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class Ping extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].equals("!" + "ping".toLowerCase() )){
            textChannel.sendMessage(Dev.jda.getGatewayPing() + "ms").queue();

        }
    }
}
