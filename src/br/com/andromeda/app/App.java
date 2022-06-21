package br.com.andromeda.app;

import br.com.andromeda.commands.*;
import br.com.andromeda.events.MemberJoinEvent;
import br.com.andromeda.events.MemberLeaveEvent;
import br.com.andromeda.token.Token;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static JDA jda;
    public static Map<Long, String> mapGuildName = new HashMap<>();

    public static void main(String[] args) throws LoginException, InterruptedException {

        jda = JDABuilder.create(Token.getToken(),
                EnumSet.allOf(GatewayIntent.class)).build();

        //comandos
        jda.addEventListener(new ClearChannelCommand());
        jda.addEventListener(new PingCommand());
        jda.addEventListener(new TestCommand());
        jda.addEventListener(new StopBotCommand());

        //eventos
        jda.addEventListener(new MemberJoinEvent());
        jda.addEventListener(new MemberLeaveEvent());






        //Iterando os servidores que o andrômeda está!
        for (Guild guild: jda.awaitReady().getGuilds()) {
            mapGuildName.put(guild.getIdLong(), guild.getName());
        }

    }
}
