package br.com.andromeda.commands;

import br.com.andromeda.messages.PingMessages;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class PingCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");


        if (args[0].equals("!" + "ping".toLowerCase())) {
            PingMessages msg = new PingMessages();
            event.getChannel().sendMessageEmbeds(msg.ping(event.getMember())).queue();

        }
    }
}
