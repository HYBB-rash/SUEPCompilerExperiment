public class Rules {

    public static final int isTerminalChar = 1, isNotTerminalChar = 0, unknown = -1;

    public static final String[] rules = new String[15];

    /**
     * 以下模块定义规则的编号
     */
    public static final int E_TE1 = 1;      // 产生式 E->TE1
    public static final int E1_ATE1 = 2;    // 产生式 E1->ATE1
    public static final int E1_empty = 3;   // 产生式 E1->空
    public static final int T_FT1 = 4;      // 产生式 T->FT1
    public static final int T1_MFT1 = 5;    // 产生式 T1->MFT1
    public static final int T1_empty = 6;   // 产生式 T1->空
    public static final int F_LkhERkh = 7;  // 产生式 F->(E)
    public static final int F_i = 8;        // 产生式 F->i
    public static final int A_Plus = 9;     // 产生式 A->+
    public static final int A_Minus = 10;   // 产生式 A->-
    public static final int M_Times = 11;   // 产生式 M->*
    public static final int M_Div = 12;     // 产生式 M->/

    /**
     * 以下模块定义非终结符的编号
     */
    public static final int E = 0;  // 非终结符 E
    public static final int E1 = 1; // 非终结符 E1
    public static final int T = 2;  // 非终结符 T
    public static final int T1 = 3; // 非终结符 T1
    public static final int F = 4;  // 非终结符 F
    public static final int A = 5;  // 非终结符 A
    public static final int M = 6;  // 非终结符 M

    /**
     * 以下模块定义终结符的编号
     */
    public static final int i = 0;      // 终结符 i
    public static final int plus = 1;   // 终结符 +
    public static final int minus = 2;  // 终结符 -
    public static final int times = 3;  // 终结符 *
    public static final int div = 4;    // 终结符 /
    public static final int Lkh = 5;    // 终结符 (
    public static final int Rkh = 6;    // 终结符 )
    public static final int end = 7;    // 终结符 #

    public static final int[][] matrix = new int[8][9]; // 预测表

    // 静态加载预测表信息
    static {

        // 初始化表
        for (int j = 0; j < 8; j ++)
            for (int k = 0; k < 9; k ++)
                matrix[j][k] = unknown;

        // 按照实验给的预测分析表，将信息存入表中，方便一会调用
        matrix[E][i] = E_TE1;           matrix[E][Lkh] = E_TE1;
        matrix[E1][plus] = E1_ATE1;     matrix[E1][minus] = E1_ATE1;    matrix[E1][Rkh] = E1_empty;     matrix[E1][end] = E1_empty;
        matrix[T][i] = T_FT1;           matrix[T][Lkh] = T_FT1;
        matrix[T1][plus] = T1_empty;    matrix[T1][minus] = T1_empty;   matrix[T1][times] = T1_MFT1;    matrix[T1][div] = T1_MFT1;      matrix[T1][Rkh] = T1_empty;     matrix[T1][end] = T1_empty;
        matrix[F][i] = F_i;             matrix[F][Lkh] = F_LkhERkh;
        matrix[A][plus] = A_Plus;       matrix[A][minus] = A_Minus;
        matrix[M][times] = M_Times;     matrix[M][div] = M_Div;

        // 将规则放入数组中，方便一会调用
        rules[E_TE1] = "Te";
        rules[E1_ATE1] = "ATe";
        rules[E1_empty] = "";
        rules[T_FT1] = "Ft";
        rules[T1_MFT1] = "MFt";
        rules[T1_empty] = "";
        rules[F_LkhERkh] = "(E)";
        rules[F_i] = "i";
        rules[A_Plus] = "+";
        rules[A_Minus] = "-";
        rules[M_Times] = "*";
        rules[M_Div] = "/";
    }

    /**
     * 类型判断控制器
     * @param c 单个字符输入
     * @return 返回一个int类型的数据，分别代表是终结符，是非终结符，什么也不是未知符号
     */
    public static int whatType(char c){
        switch (c){
            case 'i':
            case '+': case '-': case '*': case '/':
            case '(': case ')': case '#':
                return isTerminalChar;
            case 'E': case 'e': case 'T': case 't': case 'F': case 'A': case 'M':
                return isNotTerminalChar;
            default:
                return unknown;
        }
    }

    /**
     * 将输入的字符转化为对应在矩阵里的编号
     * @param c 一个字符
     * @return 返回这个字符在预处理中的标号，如果不存在的话返回unknown值
     */
    public static int char2int(char c){
        switch (c){

            //终结符
            case 'i': return i;
            case '+': return plus;
            case '-': return minus;
            case '*': return times;
            case '/': return div;
            case '(': return Lkh;
            case ')': return Rkh;
            case '#': return end;

            //非终结符
            case 'E': return E;
            case 'e': return E1;
            case 'T': return T;
            case 't': return T1;
            case 'F': return F;
            case 'A': return A;
            case 'M': return M;

            // 未知
            default:
                return unknown;
        }
    }

    /**
     *
     * @param x 矩阵中的非终结符的一列的序号
     * @param y 矩阵中的终结符的一行的序号
     * @return 返回对应在预测表中产生式的编号
     */
    public static int getMatrixVar(int x, int y){
        return matrix[x][y];
    }

}
