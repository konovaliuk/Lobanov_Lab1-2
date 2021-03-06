package servlet;

import commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {
    private static final String COMMAND = "command";
    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    private ControllerHelper() {
        commands.put("signUp", new SignupCommand());
        commands.put("signIn", new SigninCommand());
        commands.put("signOut", new SignoutCommand());
        commands.put("addFilm", new AddFilmCommand());
        commands.put("removeFilm", new RemoveFilmCommand());
        commands.put("checkAvailableTimeAtHall", new CheckAvailableTimeAtHallCommand());
        commands.put("addSession", new AddSessionCommand());
        commands.put("displaySession", new DisplaySessionsCommand());
        commands.put("updateFilm", new UpdateFilmCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter(COMMAND));
        System.out.println(request.getParameter(COMMAND));
        if (command == null) {
            System.out.println(":(");
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }


}
