public class Matrix {

    private static int matrix[][] = new int[24][18];

    public static final int status_1 = 1;
    public static final int status_2 = 2;
    public static final int status_3 = 3;
    public static final int status_4 = 4;
    public static final int status_5 = 5;
    public static final int status_6 = 6;
    public static final int status_7 = 7;
    public static final int status_8 = 8;
    public static final int status_9 = 9;
    public static final int status_10 = 10;
    public static final int status_11 = 11;
    public static final int status_0 = 0;

    public static final int acc = 88888;
    public static final int err = 99999;

    public static final int rule_1 = 123;
    public static final int rule_2 = 623;
    public static final int rule_3 = 523;
    public static final int rule_4 = 423;
    public static final int rule_5 = 323;
    public static final int rule_6 = 223;

    public static final int I = 1;
    public static final int plus = 2;
    public static final int times = 3;
    public static final int Lkh = 4;
    public static final int Rkh = 5;
    public static final int end = 6;

    public static final int E = 7;
    public static final int T = 8;
    public static final int F = 9;

    static {
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[0].length; j ++)
                matrix[i][j] = err;

        matrix[0][I] = status_5;
        matrix[0][Lkh] = status_4;
        matrix[0][E] = status_1;
        matrix[0][T] = status_2;
        matrix[0][F] = status_3;

        matrix[1][plus] = status_6;
        matrix[1][end] = acc;

        matrix[2][plus] = rule_2;
        matrix[2][times] = status_7;
        matrix[2][Rkh] = rule_2;
        matrix[2][end] = rule_2;

        matrix[3][plus] = rule_4;
        matrix[3][times] = rule_4;
        matrix[3][Rkh] = rule_4;
        matrix[3][end] = rule_4;

        matrix[4][I] = status_5;
        matrix[4][Lkh] = status_4;
        matrix[4][E] = status_8;
        matrix[4][T] = status_2;
        matrix[4][F] = status_3;

        matrix[5][plus] = rule_6;
        matrix[5][times] = rule_6;
        matrix[5][Rkh] = rule_6;
        matrix[5][end] = rule_6;

        matrix[6][I] = status_5;
        matrix[6][Lkh] = status_4;
        matrix[6][T] = status_9;
        matrix[6][F] = status_3;

        matrix[7][I] = status_5;
        matrix[7][Lkh] = status_4;
        matrix[7][F] = status_10;

        matrix[8][plus] = status_6;
        matrix[8][Rkh] = status_11;

        matrix[9][plus] = rule_1;
        matrix[9][times] = status_7;
        matrix[9][Rkh] = rule_1;
        matrix[9][end] = rule_1;

        matrix[10][plus] = rule_3;
        matrix[10][times] = rule_3;
        matrix[10][Rkh] = rule_3;
        matrix[10][end] = rule_3;

        matrix[11][plus] = rule_5;
        matrix[11][times] = rule_5;
        matrix[11][Rkh] = rule_5;
        matrix[11][end] = rule_5;
    }

    public static int controller(char c){
        switch (c){
            case 'i': return I;
            case '+': return plus;
            case '*': return times;
            case '(': return Lkh;
            case ')': return Rkh;
            case '#': return end;
            case 'E': return E;
            case 'T': return T;
            case 'F': return F;
            default: return err;
        }
    }

    public static boolean isTer(char c){
        switch (c){
            case 'i':
            case '+':
            case '*':
            case '(':
            case ')':
            case '#': return true;
            case 'E':
            case 'T':
            case 'F': return false;
        }
        return false;
    }

    public static boolean isStatus(int status){
        switch (status){
            case status_0:
            case status_1:
            case status_2:
            case status_3:
            case status_4:
            case status_5:
            case status_6:
            case status_7:
            case status_8:
            case status_9:
            case status_10:
            case status_11: return true;
            default:return false;
        }
    }

    public static int getMatrix(int status, char c){
        int tran = controller(c);
        if (tran == err) return err;
        return matrix[status][tran];
    }
}


