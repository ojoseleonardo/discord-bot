package br.com.andromeda.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ClearChannelCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].equals("!" + "clear".toLowerCase())) {
            List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
            textChannel.deleteMessages(messages).queue();

        }

        if (args[0].equals("!" + "clear".toLowerCase() + "-force")) {
            for (int i = 0; i <= Integer.parseInt(args[1]); i++) {
                purgeMessages(textChannel, 100);
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        if (args[0].equals("!" + "clear".toLowerCase() + "-all")) {
            for (int i = 0; i <= 10000; i++) {
                purgeMessages(textChannel, 100);
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

//            textChannel.createCopy().complete();
//            textChannel.delete().queue();


        }



    private void purgeMessages(TextChannel channel, int num) {
        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;
        history.retrievePast(100);

        msgs = history.retrievePast(num).complete();
        channel.deleteMessages(msgs).queue();
    }
}

