package br.com.andromeda.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;


public class ClearChannel extends ListenerAdapter  {




    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].equals("!" + "clean".toLowerCase()) ) {
//            textChannel.createCopy().queue();
//            textChannel.delete().queue();
            LinkedList<Message> msgs;
//            for (int i = 0; i <= 1000 ; i++) {
                msgs = (LinkedList<Message>) textChannel.getHistory().retrievePast(100).complete();
                textChannel.deleteMessages(msgs).queue();
//            }


//            purgeMessages(textChannel, 	100);
        }
    }
}
//    private void purgeMessages(TextChannel channel, int num) {
//        MessageHistory history = new MessageHistory(channel);
//        List<Message> msgs;
//
//            msgs = history.retrievePast(num).complete();
//            channel.deleteMessages(msgs).queue();
//        }
//    }

