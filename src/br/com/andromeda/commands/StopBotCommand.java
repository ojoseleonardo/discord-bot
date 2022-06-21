package br.com.andromeda.commands;

import br.com.andromeda.app.App;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class StopBotCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equals("!" + "andromeda-stop".toLowerCase())) {
            App.jda.shutdownNow();
        }
    }
}
