package com.leetcode;

/**
 * // [999]车的可用捕获量
 * //在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B
 * //” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * //
 * // 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜
 * //色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * //
 * // 返回车能够在一次移动中捕获到的卒的数量。
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //
 * // 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",
 * //".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",
 * //".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".",
 * //"."],[".",".",".",".",".",".",".","."]]
 * //输出：3
 * //解释：
 * //在本例中，车能够捕获所有的卒。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //
 * // 输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".",
 * //"p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B",
 * //"p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".",
 * //"."],[".",".",".",".",".",".",".","."]]
 * //输出：0
 * //解释：
 * //象阻止了车捕获任何卒。
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //
 * // 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",
 * //".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",
 * //".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".",
 * //"."],[".",".",".",".",".",".",".","."]]
 * //输出：3
 * //解释：
 * //车可以捕获位置 b5，d6 和 f5 的卒。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // board.length == board[i].length == 8
 * // board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 * // 只有一个格子上存在 board[i][j] == 'R'
 * //
 * // Related Topics 数组
 *
 * @date 2020/3/26 8:58
 */
public class D20200326N999 {
    public int numRookCaptures(char[][] board) {
        // 1.找到车的位置
        // 2.模拟移动上下左右

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int k = 0; k < 4; k++) {
                        int  x = i, y = j;
                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                                break;
                            }
                            if (board[x][y] == 'p') {
                                res++;
                                break;
                            }
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }
}