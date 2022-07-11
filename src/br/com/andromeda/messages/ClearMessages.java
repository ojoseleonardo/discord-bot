package br.com.andromeda.messages;

import br.com.andromeda.commands.ClearChannelCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;


public class ClearMessages {

    EmbedBuilder builder = new EmbedBuilder();

    public MessageEmbed clear(Member author){
        ClearChannelCommand clearChannelCommand = new ClearChannelCommand();
        builder.setTitle(":x:  DELETANDO");
        builder.setDescription("*"+ "Você tem certeza? Dependendo do número de mensagens o processo pode demorar!" + "*");
        builder.setAuthor(author.getUser().getName(),"https://www.google.com/", author.getUser().getAvatarUrl());


        return builder.build();
    }


}
