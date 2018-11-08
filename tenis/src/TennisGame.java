public class TennisGame {

    private static boolean SameScore;
    private static boolean firstBiggerThan4;
    private static boolean secondBiggerThan4;
    private static boolean player1GetScore;
    private static boolean player2GetScore;
    private static boolean player1GetSoreAgain;
    private static boolean firstLoop;

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore=0;
        SameScore = m_score1 == m_score2;
        if (SameScore)
        {
            switch (m_score1)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else {
            firstBiggerThan4 = m_score1 >= 4;
            secondBiggerThan4 = m_score2 >= 4;
            if (firstBiggerThan4 || secondBiggerThan4)
            {
                int minusResult = m_score1-m_score2;
                player1GetScore = minusResult == 1;
                if (player1GetScore) score ="Advantage player1";
                else {
                    player2GetScore = minusResult == -1;
                    if (player2GetScore) score ="Advantage player2";
                    else {
                        player1GetSoreAgain = minusResult >= 2;
                        if (player1GetSoreAgain) score = "Win for player1";
                        else score ="Win for player2";
                    }
                }
            }
            else
            {
                for (int i=1; i<3; i++)
                {
                    firstLoop = i == 1;
                    if (firstLoop) tempScore = m_score1;
                    else { score+="-"; tempScore = m_score2;}
                    switch(tempScore)
                    {
                        case 0:
                            score+="Love";
                            break;
                        case 1:
                            score+="Fifteen";
                            break;
                        case 2:
                            score+="Thirty";
                            break;
                        case 3:
                            score+="Forty";
                            break;
                    }
                }
            }
        }
        return score;
    }
}
