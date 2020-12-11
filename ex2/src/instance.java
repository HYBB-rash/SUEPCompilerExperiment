import Imp.api;

import java.util.Scanner;

public class instance implements api {

    private int index = 0;
    private String text;
    private boolean sign;

    public String getText() {
        return text;
    }

    public boolean isSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public void setText(String text) {
        this.index = 0;
        this.text = text;
        this.sign = false;
    }

    public instance(String text) {
        this.text = text;
        this.index = 0;
        this.sign = false;
    }

    public instance() {
        this.index = 0;
        this.sign = false;
    }

    public void finish(){
        if (currentChar() == '#'){
            System.out.println("结束");
            sign = true;
        }
    }

    public void findError(){
//        System.out.println(currentChar());
        sign = true;
//        System.out.println(index);
        System.out.println("error!");
    }

    public char currentChar(){
        if (index >= text.length()) {
            sign = true;
            throw new NullPointerException("index out bound");
        }
        return text.charAt(index);
    }

    @Override
    public void next() {
        index ++;       // 指针后移
    }

    @Override
    public void P() {
        if (!sign){     // 只有标志位没关上才继续运行
            if (currentChar() == 'b'){              // 检测当前的字符是否为b
                next();                             // 指针后移
                S();                                // 执行规则S算法
                if (currentChar() == 'e') next();   // 如果当前字符是e，指针后移下一个
                else findError();                   // 否则报错
            }
            else findError();
        }
        finish();       // 检测是否结束
    }

    @Override
    public void S() {
        if (!sign){
            A();        // 执行规则A算法
            S1();       // 执行规则S1算法
        }
    }

    @Override
    public void S1() {
        if (!sign){
            if (currentChar() == 'i') S();      // 如果当前的字符为i，执行S规则方法
            else if (currentChar() == 'e') ;    // 如果当前的字符为e，即在follow集合中，匹配空串
            else findError();                   // 否则报错
        }
    }

    @Override
    public void A() {
        if (!sign){
            if (currentChar() == 'i'){                  // 检测终结符
                next();                                 // 下一个字符
                if (currentChar() == '='){              // 终结符如果为=
                    next();                             // 下一个终结符
                    E();                                // 执行E规则方法
                    if (currentChar() == ';') next();   // 如果终结符为; 下一个字符
                    else findError();                   // 否则报错
                }
                else findError();                       // 终结符不是=，报错
            }
            else findError();                           // 终结符不是i，报错
        }
    }

    @Override
    public void E() {
        if (!sign){
            T();                                        // 执行T规则方法
            E1();                                       // 执行E1规则方法
        }
    }

    @Override
    public void E1() {
        if (!sign){
            if (currentChar() == '+' || currentChar() == '-') {         // 如果终结符是+或者-
                next();                                                 // 指针后移
                T();                                                    // 执行T规则方法
                E1();                                                   // 执行E1规则方法
            }
            else if (currentChar() == ';' || currentChar() == ')') ;    // 判定是否是follow集合的终结符
            else findError();                                           // 既不属于first，也不属于follow，则报错
        }
    }

    @Override
    public void T() {
        if (!sign){
            F();        // 执行F规则方法
            T1();       // 执行
        }
    }

    /**
     * 后面两个方法同理，直接模拟即可
     */
    @Override
    public void T1() {
        if (!sign){
            if (currentChar() == '*' || currentChar() == '/'){
                next();
                F();
                T1();
            }
            else if (currentChar() == ';'
                    || currentChar() == '-'
                    || currentChar() == '+'
                    || currentChar() == ')');
            else findError();
        }

    }

    @Override
    public void F() {
        if (!sign){
            if (currentChar() == '('){
                next();
                E();
                if (currentChar() == ')') next();
                else findError();
            }
            else if (currentChar() == 'i') next();
            else findError();
        }
    }

    public static void main(String[] args) {
        instance analyse = new instance();
        Scanner scanner = new Scanner(System.in);
        String tmp;
        while ((tmp = scanner.nextLine()) != null){
            analyse.setText(tmp);
            analyse.P();
            if (analyse.isSign() && analyse.currentChar() != '#') System.out.println("fail");
            else System.out.println("success");

        }

    }
}
