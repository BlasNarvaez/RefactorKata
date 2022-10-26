// Added brackets to if and else, for more readability
public class TennisGame1 implements TennisGame {

    //Field naming convention
    private int mScore1 = 0;
    private int mScore2 = 0;

    private String playerName1;

    private String playerName2;
    private static final int MINUS_ONE_POINT = -1;
    private static final int NONE_POINTS = 0;
    private static final int ONE_POINT = 1;
    private static final int TWO_POINTS = 2;
    private static final int THREE_POINTS = 3;
    private static final int FOUR_POINTS = 4;

    public TennisGame1(String playerName1, String playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
    }

    //Player names, not used. Removed constructor to use default
    public void wonPoint(String playerName) {
        // Compare strings with equals
        if (playerName1.equals(playerName)) {
            mScore1++;
        } else if (playerName2.equals(playerName)) {
            mScore2++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getScore() {
        String score = "";
        if (mScore1 == mScore2) {
            score = equalScoreValue();
        } else if (mScore1 >= FOUR_POINTS || mScore2 >= FOUR_POINTS) {
            score = advantageScoreValue();
        } else {
            score = normalScoreValue();
        }
        return score;
    }

    private String normalScoreValue() {
        //Unnecessary loop to append String and tempScore localVariable
        return getScoreByPlayer(mScore1)
                + "-"
                + getScoreByPlayer(mScore2);
    }

    //Do not have complex structure as switch with conditionals or inside a loops, extract to a method
    private String advantageScoreValue() {
        String score;
        int minusResult = mScore1 - mScore2;
        if (minusResult == ONE_POINT) {
            score = "Advantage player1";
        } else if (minusResult == MINUS_ONE_POINT) {
            score = "Advantage player2";
        } else if (minusResult >= TWO_POINTS) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    //Do not have complex structure as switch with conditionals or inside a loops, extract to a method
    private String equalScoreValue() {
        String score;
        switch (mScore1) {
            case NONE_POINTS:
                score = "Love-All";
                break;
            case ONE_POINT:
                score = "Fifteen-All";
                break;
            case TWO_POINTS:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    //Do not have complex structure as switch with conditionals or inside a loops, extract to a method
    private static String getScoreByPlayer(int playerScore) {
        String score = "";
        switch (playerScore) {
            case NONE_POINTS:
                score += "Love";
                break;
            case ONE_POINT:
                score += "Fifteen";
                break;
            case TWO_POINTS:
                score += "Thirty";
                break;
            case THREE_POINTS:
                score += "Forty";
                break;
            //Add default. For example throws exception even if not reachable
            default:
                throw new IndexOutOfBoundsException();
        }
        return score;
    }
}
