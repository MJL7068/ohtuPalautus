package statistics.matcher;

import statistics.Player;

public class Default implements Matcher {

    @Override
    public boolean matches(Player p) {
        return true;
    }
    
}
