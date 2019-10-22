/**
 * Game of Tic-Tac_Toe
 * game rules:
 * - you have the choice of field 1 - 9
 * ___________
 * 1 | 2 | 3 |
 *____________
 * 4 | 5 | 6 |
 *____________
 * 7 | 8 | 9 |
 * ___________
 *
 * - two figures: X, O
 * choice of game:
 * 1. first player vs second player
 * 2. first player vs computer player:
 *
 * - computer player algorithm created:
 * ____________
 *  1 | 2 | 3 |   -> FIELDS 1 - 9
 * ____________
 *  4 | 5 | 6 |
 * ____________
 *  7 | 8 | 9 |
 * ____________
 *
 * ___________________________
 *  [0][0] | [0][1] | [0][2] |   -> FIELDS 1- 9
 * ___________________________
 *  [1][0] | [1][1] | [1,2]  |
 * ___________________________
 *  [2][0] | [2][1] | [2][2] |
 * ___________________________
 *
 *  8 possibilities to win:
 *
 *      1                  2
 *  ____________  |______________
 *   1 |   |   |  |   | 2  |    |
 *  ____________  |______________
 *   4 |   |   |  |   | 5  |    |
 *  ____________  |______________
 *   7 |   |   |  |   | 8  |    |
 *  ____________  |______________
 *
 *      3                  4
 *   ____________  |______________
 *      |   | 3 |  | 1 | 2 |  3 |
 *   ____________  |______________
 *      |   | 6 |  |   |   |    |
 *   ____________  |______________
 *      |   | 9 |  |   |   |    |
 *   ____________  |______________
 *
 *       5                  6
 *   ____________  |______________
 *      |   |   |  |   |    |    |
 *   ____________  |______________
 *    4 | 5 | 6 |  |   |    |    |
 *   ____________  |______________
 *      |   |   |  | 7 | 8  |  9 |
 *   ____________  |______________
 *
 *       7                  8
 *   ____________  |______________
 *    1 |   |   |  |   |    |  3 |
 *   ____________  |______________
 *      | 5 |   |  |   | 5  |    |
 *   ____________  |______________
 *      |   | 9 |  | 7 |    |    |
 *   ____________  |______________
 *
 *
 *   draw of the given player who is to start the game:
 *
 *   1. First checks two fields to make sure they are in the correct position (8 possibilities)
 *   and check if one of these three fields is empty(for computer player).
 *   2. Checks two fields to make sure they are in the correct position (8 possibilities)
 *   and check if one of these three fields is empty(for normal player).
 *   3. Checks one field to make sure it is in the right position (8 possibilities)
 *   and check that two of these three fields are empty (for computer player);
 *   4. Checks the free field first to make it possible to win -> field 5, fields 1, 3, 7, 9 (for computer player).
 *   5. Checks any empty field (for computer player).
 *   6. returns a field for computer player.
 */
public class TestGameTicTacToe {

    public static void main(String[] args) {

            TicTacToe ticTacToe = new TicTacToe();

            ticTacToe.startGame();


    }
}
