import Lex.Lex;
import Lex.token;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 算符优先算法，可以根据算法进行语法分析。
 * 最终实现的功能是计算
 */
public class PriorityAlgorithm {

    public static Stack<token> opd = new Stack<>();
    public static Stack<token> opt = new Stack<>();

    public static void rules(token t1, token t2, token t3){
        token t = null;

        if (t1.getIndex() == token.math && t2.getIndex() == token.plus && t3.getIndex() == token.math)
            t = new token(
                    (Integer.parseInt(t1.getData()) + Integer.parseInt(t3.getData())) + "",
                    token.math
            );
        if (t1.getIndex() == token.math && t2.getIndex() == token.times && t3.getIndex() == token.math)
            t = new token(
                    (Integer.parseInt(t1.getData()) * Integer.parseInt(t3.getData())) + "",
                    token.math
            );
        if (t1.getIndex() == token.LEFT_Kuohao && t2.getIndex() == token.math && t3.getIndex() == token.RIGHT_Kuohao)
            t = t2;
        if (t1.getIndex() == token.end && t2.getIndex() == token.math && t3.getIndex() == token.end)
            t = t2;
        if (t != null) opd.push(t);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String tmp;
        while ((tmp = scanner.next()) != null){
            Lex lex = new Lex(tmp);
            List<token> tokens = lex.getAns();
            for (int i = 0; i < tokens.size(); i ++){
                token token = tokens.get(i);
                int type = MatrixUtils.classfy(token);
                if (type == MatrixUtils.num) opd.push(token);
                else if (type == MatrixUtils.opt) {
                    if (opt.empty()) opt.push(token);
                    else {
                        int priority = MatrixUtils.getPriority(opt.peek(), token);
                        if (priority == MatrixUtils.smaller) opt.push(token);
                        else if (priority == MatrixUtils.greater){
                            token token1 = opd.peek(); opd.pop();
                            token token3 = opd.peek(); opd.pop();
                            token token2 = opt.peek(); opt.pop();
                            rules(token1, token2, token3);
                            i --;
                        }else if (priority == MatrixUtils.equal){
                            token token1 = opt.peek(); opt.pop();
                            token token2 = opd.peek(); opd.pop();
                            rules(token1, token2, token);
                        }else throw new Exception("Cannot catch this rule, stop in" + token);
                    }
                }else throw new Exception("Cannot specify this token");
            }
            if (!opd.empty())System.out.println(opd.peek().getData());
            else throw new Exception("No token can be analyze");
            opd.clear();
        }
    }
}
