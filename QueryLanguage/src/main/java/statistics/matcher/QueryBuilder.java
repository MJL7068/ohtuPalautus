package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;
    Matcher and;

    public QueryBuilder() {
        matcher = new And();
        and = new And();
    }

    public Matcher build() {
        return matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(matcher, team);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = and(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFeverThan(int value, String category) {
        this.matcher = and(new HasFeverThan(value, category));
        return this;
    }
    
//    public QueryBuilder oneOf(Matcher... matchers) {
//        
//    }
    
}
