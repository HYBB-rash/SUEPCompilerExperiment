package Lex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lex {

    private Map<String, Integer> matrix;
    private List<token> ans;
    private StringBuffer temp;
    private String text;

    public List<token> getAns() {
        return ans;
    }

    public void setAns(List<token> ans) {
        this.ans = ans;
    }

    private void addToken(int arg){
        token t = new token(temp.toString(), arg);
        ans.add(t);
        temp.delete(0, temp.length());
    }

    private static boolean isEng(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <='9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isMath(char c){
        return (c >= '0' && c <='9');
    }
    
    private static boolean isGap(char c) {
        return c == ' ' || c == '\n' || c == '\t';
    }

    private static boolean isSign(char c){
        if (c == '(') return true;
        if (c == ')') return true;
        if (c == '{') return true;
        if (c == '}') return true;
        if (c == '=') return true;
        if (c == ';') return true;
        if (c == '+') return true;
        if (c == '*') return true;
        if (c == '>') return true;
        if (c == '<') return true;
        if (c == ',') return true;
        if (c == '\'') return true;
        return c == '#';
    }

    private int status_name(int index){
        if (index >= text.length()) return index;
        char c = text.charAt(index);
        if (!isEng(c)){
            addToken(token.NAME);
            return index;
        }
        temp.append(c);
        index = status_name(index + 1);
        return index;
    }

    private int status_num(int index){
        if (index >= text.length()) return index;
        char c = text.charAt(index);
        if (!isMath(c)){
            addToken(token.math);
            return index;
        }
        temp.append(c);
        return status_num(index + 1);
    }

    private int status_main(int index){
        char c = text.charAt(index);
        if (!isEng(c)) {
            addToken(token.MAIN);
            return index;
        }
        return status_name(index);
    }

    private int status_mai(int index){
        char c = text.charAt(index);
        if (c == 'n'){
            temp.append(c);
            index = status_main(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_ma(int index){
        char c = text.charAt(index);
        if (c == 'i'){
            temp.append(c);
            index = status_mai(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_m(int index){
        char c = text.charAt(index);
        if (c == 'a'){
            temp.append(c);
            index = status_ma(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_return(int index){
        char c = text.charAt(index);
        if (!isEng(c)){
            addToken(token.RETURN);
            return index;
        }
        return status_name(index);
    }

    private int status_retur(int index){
        char c = text.charAt(index);
        if (c == 'n'){
            temp.append(c);
            index = status_return(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_retu(int index){
        char c = text.charAt(index);
        if (c == 'r'){
            temp.append(c);
            index = status_retur(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_ret(int index){
        char c = text.charAt(index);
        if (c == 'u'){
            temp.append(c);
            index = status_retu(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_re(int index){
        char c = text.charAt(index);
        if (c == 't'){
            temp.append(c);
            index = status_ret(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_r(int index){
        char c = text.charAt(index);
        if (c == 'e'){
            temp.append(c);
            index = status_re(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_int(int index){
        char c = text.charAt(index);
        if (!isEng(c)){
            addToken(token.INT);
            return index;
        }
        return status_name(index);
    }

    private int status_in(int index){
        char c = text.charAt(index);
        if (c == 't'){
            temp.append(c);
            index = status_int(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_if(int index){
        char c = text.charAt(index);
        if (!isEng(c)){
            addToken(token.IF);
            return index;
        }
        return status_name(index);
    }

    private int status_i(int index){
        char c = text.charAt(index);
        if (c == 'n'){
            temp.append(c);
            index = status_in(index + 1);
        }else if (c == 't'){
            temp.append(c);
            index = status_if(index + 1);
        }
        else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_else(int index){
        char c = text.charAt(index);
        if (!isEng(c)){
            addToken(token.ELSE);
            return index;
        }
        return status_name(index);
    }

    private int status_els(int index){
        char c = text.charAt(index);
        if (c == 'e'){
            temp.append(c);
            index = status_else(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_el(int index){
        char c = text.charAt(index);
        if (c == 's'){
            temp.append(c);
            index = status_els(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_e(int index){
        char c = text.charAt(index);
        if (c == 'l'){
            temp.append(c);
            index = status_el(index + 1);
        }else if (isEng(c)) index = status_name(index);
        return index;
    }

    private int status_then(int index){
        char c = text.charAt(index);
        if (isEng(c)){
            addToken(token.THEN);
            return index;
        }
        return status_name(index);
    }

    private int status_the(int index){
        char c = text.charAt(index);
        if (c == 'n'){
            temp.append(c);
            index = status_then(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_th(int index){
        char c = text.charAt(index);
        if (c == 'e'){
            temp.append(c);
            index = status_the(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_t(int index){
        char c = text.charAt(index);
        if (c == 'h'){
            temp.append(c);
            index = status_th(index + 1);
        }else if (isEng(c)) index = status_name(index);
        else {
            temp.deleteCharAt(temp.length() - 1);
            index = status_name(index - 1);
        }
        return index;
    }

    private int status_sign(int index, char c, int arg){
        temp.append(c);
        addToken(arg);
        return index;
    }

    private int status_any_else(int index){
        char c = text.charAt(index);
        temp.append(c);
        addToken(token.ANY_ELSE);
        return index + 1;
    }

    public Lex(String text){
        ans = new ArrayList<>();
        temp = new StringBuffer();
        this.text = text;
        int index = 0;
        while (index < text.length()){

            char c = text.charAt(index);
            switch (c){
                case '(':
                    index = status_sign(index + 1, c, token.LEFT_Kuohao);
                    break;
                case ')':
                    index = status_sign(index + 1, c, token.RIGHT_Kuohao);
                    break;
                case '{':
                    index = status_sign(index + 1, c, token.UP_LEFT_Kuohao);
                    break;
                case '}':
                    index = status_sign(index + 1, c, token.UP_RIGHT_Kuohao);
                    break;
                case ';':
                    index = status_sign(index + 1, c, token.Fenhao);
                    break;
                case '=':
                    index = status_sign(index + 1, c, token.equal);
                    break;
                case '+':
                    index = status_sign(index + 1, c, token.plus);
                    break;
                case '*':
                    index = status_sign(index + 1, c, token.times);
                    break;
                case '>':
                    index = status_sign(index + 1, c, token.large);
                    break;
                case '<':
                    index = status_sign(index + 1, c, token.small);
                    break;
                case ',':
                    index = status_sign(index + 1, c, token.douhao);
                    break;
                case '\'':
                    index = status_sign(index + 1, c, token.SINGLE_Yinghao);
                    break;
                case '#':
                    index = status_sign(index + 1, c, token.end);
                    break;
                case 'm':
                    temp.append(c);
                    index = status_m(index + 1);
                    break;
                case 'r':
                    temp.append(c);
                    index = status_r(index + 1);
                    break;
                case 'i':
                    temp.append(c);
                    index = status_i(index + 1);
                    break;
                case 'e':
                    temp.append(c);
                    index = status_e(index + 1);
                    break;
                case 't':
                    temp.append(c);
                    index = status_t(index + 1);
                    break;
                case 'a': case 'b': case 'c':
                case 'h': case 'd': case 'f':
                case 'g': case 'j': case 'k':
                case 'l': case 'n': case 'o':
                case 'p': case 'q': case 's':
                case 'u': case 'v': case 'w':
                case 'x': case 'y': case 'z':
                case 'A': case 'B': case 'C':
                case 'D': case 'E': case 'F':
                case 'G': case 'H': case 'I':
                case 'J': case 'K': case 'L':
                case 'M': case 'N': case 'O':
                case 'Q': case 'P': case 'R':
                case 'S': case 'T': case 'U':
                case 'V': case 'W': case 'X':
                case 'Y': case 'Z':
                    temp.append(c);
                    index = status_name(index + 1);
                    break;
                case '1': case '2': case '3':
                case '4': case '5': case '6':
                case '7': case '8': case '9':
                case '0':
                    temp.append(c);
                    index = status_num(index + 1);
                    break;
                case '\n': case ' ': case '\t':
                    index ++;
                    break;
                default:
                    index = status_any_else(index);

            }
        }
    }

    public Lex() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static void main(String[] args) throws IOException {
//        Lex lex = new Lex("#inclu%de <ios%tream> \n" +
//                "using namespace std;\n" +
//                "int 2333m&ain(){\n" +
//                "int a = 1;\n" +
//                "int b = 2;\n" +
//                "return a + b;\n" +
//                "}");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(".\\ex1\\test\\xthrow.cpp"));
        String temp = bufferedReader.readLine();
        while (temp != null){
            System.out.println(temp);
            Lex lex = new Lex(temp);
            List<token> ans = lex.getAns();
            for (token t : ans) System.out.println(t);
            temp = bufferedReader.readLine();
        }

    }
}
