package br.com.andromeda.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();


        if (args[0].equals("!" + "testloop-500".toLowerCase())) {
            for (int i = 0; i <= 500; i++) {
                textChannel.sendMessage(i + "° loop...").queue();
            }

        }

        if (args[0].equals("!" + "testloop-1000".toLowerCase())) {
            for (int i = 0; i <= 2000; i++) {
                textChannel.sendMessage(i + "° loop...").queue();
            }

        }
    }
}
