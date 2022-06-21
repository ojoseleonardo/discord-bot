package br.com.andromeda.commands;

import br.com.andromeda.messages.PingMessage;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class PingCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");


        if (args[0].equals("!" + "ping".toLowerCase())) {
            PingMessage msg = new PingMessage();
            event.getChannel().sendMessageEmbeds(msg.ping(event.getMember())).queue();

        }
    }
}
