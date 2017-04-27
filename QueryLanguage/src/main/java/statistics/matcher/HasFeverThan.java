package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;
import statistics.matcher.Matcher;

public class HasFeverThan implements Matcher {

    private int value;
    private String fieldName;

    public HasFeverThan(int value, String category) {
        this.value = value;
        this.fieldName = "get" + Character.toUpperCase(category.charAt(0)) + category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer) method.invoke(p);
            return playersValue < value;
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field " + fieldName.substring(3, fieldName.length()).toLowerCase());
        }
    }

}