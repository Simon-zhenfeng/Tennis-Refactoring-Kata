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
        if (getPointsDiff() == 0) {
            return getEvenScore(player1Points);
        }
        if (isReached4Points()) {
            return getEndGameScore();
        }
        return getScoreName(player1Points) + "-" + getScoreName(player2Points);
    }

    private boolean isReached4Points() {
        return player1Points >= 4 || player2Points >= 4;
    }

    private String getEndGameScore() {
        if (getPointsDiff() == 1) {
            return "Advantage " + leadingPlayerName();
        }
        return "Win for " + leadingPlayerName();

    }

    private int getPointsDiff() {
        return Math.abs(player1Points - player2Points);
    }

    private String leadingPlayerName() {
        return player1Points > player2Points ? "player1" : "player2";
    }

    private String getEvenScore(int points) {
        if (points == 0) {
            return "Love-All";
        }
        if (points == 1) {
            return "Fifteen-All";
        }
        if (points == 2) {
            return "Thirty-All";
        }
        return "Deuce";

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
