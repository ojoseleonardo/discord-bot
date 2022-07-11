package me.andromeda.bot;


import me.andromeda.bot.token.Token;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class App {

    private App() throws LoginException {
        new JDABuilder().setToken(Token.getToken())
                .setActivity(Activity.playing("Andrômeda"))
                .addEventListeners(new Listener()).build();
    }

    public static void main(String[] args) throws LoginException {
        new App();
//        // Comandos do Andrômeda
//        jda.addEventListener(new ClearChannelCommand());
//        jda.addEventListener(new PingCommand());
//        jda.addEventListener(new TestCommand());
//        jda.addEventListener(new StopBotCommand());
//
//        // Monitoramento de Eventos
//        jda.addEventListener(new MemberJoinEvent());
//        jda.addEventListener(new MemberLeaveEvent());

    }
}
