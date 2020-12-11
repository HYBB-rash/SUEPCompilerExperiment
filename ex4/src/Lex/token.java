package Lex;

public class token {

    private String data;
    private int index;
    public static final int NAME = 0;
    public static final int LEFT_Kuohao = 1;
    public static final int RIGHT_Kuohao = 2;
    public static final int UP_LEFT_Kuohao = 3;
    public static final int UP_RIGHT_Kuohao = 4;
    public static final int Fenhao = 5;
    public static final int equal = 6;
    public static final int plus = 7;
    public static final int times = 8;
    public static final int large = 9;
    public static final int small = 10;
    public static final int douhao = 11;
    public static final int SINGLE_Yinghao = 12;
    public static final int math = 20;
    public static final int MAIN = 26;
    public static final int INT = 21;
    public static final int IF = 22;
    public static final int THEN = 23;
    public static final int ELSE = 24;
    public static final int RETURN = 25;
    public static final int end = 26;
    public static final int ANY_ELSE = 100;

    @Override
    public String toString() {
        return "token{" +
                "data='" + data + '\'' +
                ", index=" + index +
                '}';
    }


    public token(String date, int index) {
        this.data = date;
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public static int getOrg(char c){
        switch (c){
            case '(':return RIGHT_Kuohao;
            case ')':return LEFT_Kuohao;
            case '{':return UP_LEFT_Kuohao;
            case '}':return UP_RIGHT_Kuohao;
            case ';':return Fenhao;
            case '=':return equal;
            case '+':return plus;
            case '*':return times;
            case '>':return large;
            case '<':return small;
            case ',':return douhao;
            case '\'': return SINGLE_Yinghao;
            case '#': return end;
            default: return -1;
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
