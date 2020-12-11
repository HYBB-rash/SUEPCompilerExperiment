import Lex.token;

/**
 * 算符优先算法的表工具类，用于为算法优先度信息
 */
public class MatrixUtils {
    public MatrixUtils() {
    }

    public static final int E = 2;

    /**
     * 以下模块定义终结符的编号
     */
    public static final int i = 0;      // 终结符 i
    public static final int plus = 1;   // 终结符 +
    public static final int times = 3;  // 终结符 *
    public static final int Lkh = 5;    // 终结符 (
    public static final int Rkh = 6;    // 终结符 )
    public static final int end = 7;    // 终结符 #



    public static final int[][] matrix = new int[9][9]; // 预测表

    public static final int greater = 1;
    public static final int equal = 0;
    public static final int smaller = -1;

    public static final int opt = 10;
    public static final int num = 11;
    public static final int error = 0x7fffffff;

    static {

        matrix[plus][plus] = greater;
        matrix[plus][times] = smaller;
        matrix[plus][Lkh] = smaller;
        matrix[plus][Rkh] = greater;
        matrix[plus][i] = smaller;
        matrix[plus][end] = greater;

        matrix[times][plus] = greater;
        matrix[times][times] = greater;
        matrix[times][Lkh] = smaller;
        matrix[times][Rkh] = greater;
        matrix[times][i] = smaller;
        matrix[times][end] = greater;

        matrix[Lkh][plus] = smaller;
        matrix[Lkh][times] = smaller;
        matrix[Lkh][Lkh] = smaller;
        matrix[Lkh][Rkh] = equal;
        matrix[Lkh][i] = smaller;
        matrix[Lkh][end] = error;

        matrix[Rkh][plus] = greater;
        matrix[Rkh][times] = greater;
        matrix[Rkh][Lkh] = error;
        matrix[Rkh][Rkh] = greater;
        matrix[Rkh][i] = error;
        matrix[Rkh][end] = greater;

        matrix[i][plus] = greater;
        matrix[i][times] = greater;
        matrix[i][Lkh] = error;
        matrix[i][Rkh] = greater;
        matrix[i][i] = error;
        matrix[i][end] = greater;

        matrix[end][plus] = smaller;
        matrix[end][times] = smaller;
        matrix[end][Lkh] = smaller;
        matrix[end][Rkh] = error;
        matrix[end][i] = smaller;
        matrix[end][end] = equal;
    }

    public static int tController(token opt){
        switch (opt.getIndex()){
            case token.math: return i;
            case token.NAME: return E;
            case token.plus: return plus;
            case token.times: return times;
            case token.LEFT_Kuohao: return Lkh;
            case token.RIGHT_Kuohao: return Rkh;
            case token.end: return end;
            default: return error;
        }
    }

    public static int classfy(token o){
        int t = tController(o);
        switch (t){
            case i: return num;
            case plus: case times: case Lkh: case Rkh: case end: return opt;
            default: return error;
        }
    }

    public static int getPriority(token opt1, token opt2){
        int xIdx = tController(opt1);
        int yIdx = tController(opt2);
        return matrix[xIdx][yIdx];
    }

}
