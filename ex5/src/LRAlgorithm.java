import java.util.Scanner;
import java.util.Stack;

public class LRAlgorithm {

    static Stack<Integer> statusStack;
    static Stack<Character> analyzeStack;

    public static void E_EPT(){
        analyzeStack.pop();
        analyzeStack.pop();
        analyzeStack.pop();
        statusStack.pop();
        statusStack.pop();
        statusStack.pop();
        Integer status = statusStack.peek();
        statusStack.push(Matrix.getMatrix(status, 'E'));
        analyzeStack.push('E');
    }

    public static void E_T(){
        analyzeStack.pop();
        statusStack.pop();
        Integer status = statusStack.peek();
        statusStack.push(Matrix.getMatrix(status, 'E'));
        analyzeStack.push('E');
    }

    public static void T_TTF(){
        analyzeStack.pop();
        analyzeStack.pop();
        analyzeStack.pop();
        statusStack.pop();
        statusStack.pop();
        statusStack.pop();
        Integer status = statusStack.peek();
        statusStack.push(Matrix.getMatrix(status, 'T'));
        analyzeStack.push('T');
    }

    public static void T_F(){
        analyzeStack.pop();
        statusStack.pop();
        Integer status = statusStack.peek();
        statusStack.push(Matrix.getMatrix(status, 'T'));
        analyzeStack.push('T');
    }

    public static void F_LER(){
        analyzeStack.pop();
        analyzeStack.pop();
        analyzeStack.pop();
        statusStack.pop();
        statusStack.pop();
        statusStack.pop();
        Integer status = statusStack.peek();
        statusStack.push(Matrix.getMatrix(status, 'F'));
        analyzeStack.push('F');
    }

    public static void F_I(){
        analyzeStack.pop();
        statusStack.pop();
        Integer status = statusStack.peek();
        statusStack.push(Matrix.getMatrix(status, 'F'));
        analyzeStack.push('F');
    }

    public static void main(String[] args) {
        statusStack = new Stack<>();
        analyzeStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String tmp;
        while ((tmp = scanner.nextLine()) != null){
            System.out.println(tmp);
            analyzeStack.push('#');
            statusStack.push(0);
            int idx = 0;
            while (idx < tmp.length()){
//                System.out.println(idx);
                char c = tmp.charAt(idx);
                Integer status = statusStack.peek();
                int direct = Matrix.getMatrix(status, c);
                if (direct == Matrix.err){
                    System.err.println("error");
                    break;
                }
                if (direct == Matrix.acc){
                    if (idx != tmp.length() - 1)
                        System.err.println("error 1");
                    else
                        System.out.println("success!");
                    break;
                }
                if (Matrix.isStatus(direct)){
                    analyzeStack.push(c);
                    statusStack.push(direct);
                    idx ++;
                }else {
                    switch (direct){
                        case Matrix.rule_1:E_EPT(); break;
                        case Matrix.rule_2: E_T(); break;
                        case Matrix.rule_3:T_TTF(); break;
                        case Matrix.rule_4: T_F(); break;
                        case Matrix.rule_5: F_LER(); break;
                        case Matrix.rule_6:F_I();break;
                    }
                }
            }
            analyzeStack.clear();
            statusStack.clear();
        }
    }
}
