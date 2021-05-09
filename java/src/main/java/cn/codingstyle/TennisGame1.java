package cn.codingstyle;

public class TennisGame1 implements TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Points += 1;
        } else {
            player2Points += 1;
        }
    }

    public String getScore() {
        String result = "";

        if (player1Points == player2Points) {
            switch (player1Points) {
                case 0:
                    result = "Love-All";
                    break;
                case 1:
                    result = "Fifteen-All";
                    break;
                case 2:
                    result = "Thirty-All";
                    break;
                default:
                    result = "Deuce";
                    break;

            }
        } else if (player1Points >= 4 || player2Points >= 4) // end game
        {
            int minusResult = player1Points - player2Points;
            if (minusResult == 1) result = "Advantage player1";
            else if (minusResult == -1) result = "Advantage player2";
            else if (minusResult >= 2) result = "Win for player1";
            else result = "Win for player2";
        } else {
            result = getScoreName(player1Points) + "-" + getScoreName(player2Points);
        }
        return result;
    }

    private String getScoreName(int points) {
        if (points == 0) {
            return "Love";
        }
        if (points == 1) {
            return "Fifteen";
        }
        if (points == 2) {
            return "Thirty";
        }
        if (points == 3) {
            return "Forty";
        }
        return "";
    }
}
