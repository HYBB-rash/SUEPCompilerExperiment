import java.util.Scanner;
import java.util.Stack;

public class Demo {

    public static void main(String[] args) {

        Stack<Character> stk = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String tmp;
        while ((tmp = scanner.next()) != null){

            // 初始化
            int idx = 0;
            stk.clear();
            stk.push('#');
            stk.push('E');

            while (idx < tmp.length()){

                // 分三种情况讨论：
                // 1. 栈顶是终结符
                // 2. 栈顶是非终结符
                // 3. 栈顶什么也不是

                // 1. 栈顶是非终结符
                if (Rules.whatType(stk.peek()) == Rules.isNotTerminalChar){

                    // 获取栈顶字符的编号
                    int x = Rules.char2int(stk.peek());
                    if (x == Rules.unknown) {
                        System.out.println("stack exist a invade char");
                        break;
                    }

                    // 获取字符串当前的字符的编号
                    int y = Rules.char2int(tmp.charAt(idx));
                    if (y == Rules.unknown){
                        System.out.println("input exist a invade char");
                        break;
                    }

                    // 出栈
                    stk.pop();

                    // 从矩阵中获取对应的产生式
                    int index = Rules.getMatrixVar(x, y);
                    if (index == Rules.unknown){
                        System.out.println("rules not had this rules!");
                        break;
                    }
                    String rule = Rules.rules[index];

                    // 将产生式倒着压入栈
                    for (int i = rule.length() - 1; i >= 0; i --)
                        stk.push(rule.charAt(i));

                }
                // 栈顶是终结符
                else if (Rules.whatType(stk.peek()) == Rules.isTerminalChar){

                    // 如果栈顶和字符串
                    if (stk.peek() == tmp.charAt(idx)){
                        stk.pop(); idx ++;
                    }else {
                        System.out.println("error");
                        break;
                    }

                }
                // 栈顶是未知符号
                else System.out.println("stack exist a invade char!");
            }
            if (stk.empty()) System.out.println("successful!");
            else System.out.println("error");

        }

    }
}
