package LeetCode;

/**
 * Created by shuai on 2017/2/16.
 * 419. Battleships in a Board
 */
public class countBattleshipsSolution {

    public static void main(String []args){
//        char [][]board = {
//                {'X','.','.','X'},
//                {'.','.','.','X'},
//                {'.','.','.','X'}
//        };
//        char [][]board = {{'X','.','X'}};
//        char [][]board = {{'X'},{'.'},{'X'}};
        char [][]board = {};
        int result = countBattleships(board);
        System.out.println("result : "+result);
    }

    public static int countBattleships(char[][] board) {

        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.println("i: "+i+", j: "+j);
//                if(board[i][j] == '.'){
//
//                }else
                if(board[i][j] == 'X'){
                    if(i == board.length - 1 ){
                        if(j == board[i].length - 1){
                            ++count;
                            continue;
                        }
                        if(j + 1 < board[i].length && board[i][j+1] != 'X'){
                            ++count;
                        }

                    }
                    if(j == board[i].length - 1){
                        if(i + 1 < board.length && board[i+1][j] != 'X'){
                            ++count;
                        }
                    }
                    if((j + 1 < board[i].length && board[i][j+1] != 'X')
                            &&(i + 1 < board.length && board[i+1][j] != 'X')){
                        ++count;
                        ++j;
                    }

                }
//                else {
//                    System.out.println("Invalid Input");
//                    return -1;
//                }
            }
        }
        return count;
    }

    public int countBattleships2(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if(board[i][j] == '.') continue;
                if(i + 1 < board.length && board[i+1][j] == 'X')continue;
                if(j + 1 < board[i].length && board[i][j+1] == 'X')continue;
                ++count;
                ++j;
            }
        }
        return count;
    }
}
