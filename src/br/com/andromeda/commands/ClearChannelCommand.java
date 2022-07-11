package br.com.andromeda.commands;

import br.com.andromeda.messages.ClearMessages;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ClearChannelCommand extends ListenerAdapter {

    String arrayArgs;
    public String getArrayArgs() {
        return arrayArgs;
    }

    public void setArrayArgs(String arrayArgs) {
        this.arrayArgs = arrayArgs;
    }

    // Apagando menssagens de até 2 semanas

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].equals("!" + "clear-old".toLowerCase())) {
            // Apaga menssagens muito antigas, porem demora um pouco para menssagens muito antigas
            ClearMessages clearMessages = new ClearMessages();
            event.getChannel().sendMessageEmbeds(clearMessages.clear(event.getMember())).setActionRow(sendButtons()).queue();
            setArrayArgs(args[1]);
        }

        if (args[0].equals("!" + "clear".toLowerCase())) {
            ClearMessages clearMessages = new ClearMessages();
            event.getChannel().sendMessageEmbeds(clearMessages.clear(event.getMember())).setActionRow(sendButtons()).queue();
            setArrayArgs(args[1]);
        }

        if (args[0].equals("!" + "clear-all".toLowerCase())) {
            textChannel.getIterableHistory().takeAsync(10000000).thenAccept(textChannel::purgeMessages);
        }
    }
    private void purgeMessages(TextChannel channel, int num) {
        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;
        history.retrievePast(100);

        msgs = history.retrievePast(num).complete();
        channel.deleteMessages(msgs).queue();
    }
    private static List<Button> sendButtons(){
        List<Button> buttons = new ArrayList<>();
        buttons.add(Button.success("yesbutton", "Sim, tenho certeza."));
        buttons.add(Button.danger("notbutton", "Cancelar"));
        return buttons;
    }

    public void onButtonClick(ButtonClickEvent event) {
        event.deferEdit().queue();

        switch (event.getComponentId()) {
            case "yesbutton" :
                event.getChannel().getIterableHistory().takeAsync(Integer.parseInt(arrayArgs) + 2).thenAccept(event.getChannel()::purgeMessages);

        }

    }


    }


