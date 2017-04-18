package ohtu;

public class TennisGame {

    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;

    private static final int FOUR = 4;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1score += 1;
        } else {
            player2score += 1;
        }
    }

    public String getScore() {
        if (player1score == player2score) {
            return resultWhenScoresAreEqual(player1score);
        }

        if (player1score >= FOUR || player2score >= FOUR) {
            return oneScoreIsOverFour();
        }

        return getScoreOtherwise();
    }

    public String resultWhenScoresAreEqual(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public String oneScoreIsOverFour() {
        int resultDifference = player1score - player2score;
        if (resultDifference == 1) {
            return "Advantage player1";
        }
        if (resultDifference == -1) {
            return "Advantage player2";
        }
        if (resultDifference >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    public String getScoreOtherwise() {
        return getScoreString(player1score) + "-" + getScoreString(player2score);
    }

    public String getScoreString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}
