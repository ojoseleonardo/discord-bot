package br.com.andromeda.main;

import br.com.andromeda.commands.*;;
import br.com.andromeda.security.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Dev {
    public static JDA jda;
    public static Map<Long, String> mapGuildName = new HashMap<>();

    public static void main(String[] args) throws LoginException, InterruptedException {

        jda = JDABuilder.create(Token.getToken(),
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new Ping());
        jda.addEventListener(new MemberJoin());
        jda.addEventListener(new MemberLeave());
        jda.addEventListener(new ClearChannel());
        jda.addEventListener(new TestCommand());

        //Iterando os servidores que o andrômeda está!
        for (Guild guild: jda.awaitReady().getGuilds()) {
            mapGuildName.put(guild.getIdLong(), guild.getName());
        }

    }
}
