
import java.util.*;
public class Ex_1 {
    static char a[]=null;
    static int count;
    static int i=1;
    static int p;
    public static void Inputwords() {
        Scanner x=new Scanner(System.in);
        String  k=x.nextLine();
        a=k.toCharArray();
        count=a.length;}
    public void Compareletters(char a[],int count) {
        for(;i<=count;i++) {
            if(a[i-1]=='(')
                System.out.println("("+"1,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]==')')
                System.out.println("("+"2,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='{')
                System.out.println("("+"3,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='}')
                System.out.println("("+"4,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]==';')
                System.out.println("("+"5,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='=')
                System.out.println("("+"6,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='+')
                System.out.println("("+"7,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='*')
                System.out.println("("+"8,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='>')
                System.out.println("("+"9,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='<')
                System.out.println("("+"10,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='‘')
                System.out.println("("+"11,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]=='’')
                System.out.println("("+"12,"+"\""+a[i-1]+"\""+")");
            if(a[i-1]>='0' && a[i-1]<='9') { //加了单引号，判断字符是否为数字
                System.out.printf("("+"20,"+"\"");
                for(p=i-1;a[p]>='0'&& a[p]<='9';p++) {
                    System.out.print(a[p]);
                }//有问题！！！
                System.out.println("\""+")");
                if(p==a.length)
                    break;
                else {i = p; continue;}
            }
            if(i+3<=a.length) {
                if(a[i-1]=='m'&&a[i]=='a'&&a[i+1]=='i'&&a[i+2]=='n') { //只有a[i+3]=' '会出现越界情况
                    if(i+3==a.length)
                    {System.out.println("("+"26,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+"\""+")");
                        break;}
                    else if(a[i+3]==' ') {
                        System.out.println("("+"26,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+"\""+")");
                        i=i+3;//必须要跳转！！！！！
                        continue;
                    }}}
            if(i+2<=a.length) {
                if(a[i-1]=='i'&&a[i]=='n'&&a[i+1]=='t') {
                    if(i+2==a.length)
                    {System.out.println("("+"21,"+"\""+a[i-1]+a[i]+a[i+1]+"\""+")");
                        break;}
                    else if(a[i+2]==' ') {
                        System.out.println("("+"21,"+"\""+a[i-1]+a[i]+a[i+1]+"\""+")");
                        i=i+2;
                        continue;
                    }}}
            if(i+1<=a.length) {
                if(a[i-1]=='i'&&a[i]=='f') {
                    if(i+1==a.length)
                    {System.out.println("("+"22,"+"\""+a[i-1]+a[i]+"\""+")");
                        break;}
                    else if(a[i+1]==' ')
                    {
                        i=i+1;
                        continue;
                    }}}
            if(i+3<=a.length) {
                if(a[i-1]=='t'&&a[i]=='h'&&a[i+1]=='e'&&a[i+2]=='n') {
                    if(i+3==a.length)
                    {System.out.println("("+"23,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+"\""+")");
                        break;}
                    else if(a[i+3]==' '){
                        System.out.println("("+"23,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+"\""+")");
                        i=i+3;
                        continue;
                    }}}
            if(i+3<=a.length) {
                if(a[i-1]=='e'&&a[i]=='l'&&a[i+1]=='s'&&a[i+2]=='e') {
                    if(i+3==a.length)
                    {System.out.println("("+"24,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+"\""+")");
                        break;}
                    else if(a[i+3]==' ') {
                        System.out.println("("+"24,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+"\""+")");
                        i=i+3;//不能i=i+4，因为如果在最后会越界
                        continue;
                    }}}
            if(i+5<=a.length) {
                if(a[i-1]=='r'&& a[i]=='e'&& a[i+1]=='t'&& a[i+2]=='u'&& a[i+3]=='r'&& a[i+4]=='n') {
                    if(i+5==a.length)
                    {System.out.println("("+"25,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+a[i+3]+a[i+4]+"\""+")");
                        break;}
                    else if(a[i+5]==' ') {
                        System.out.println("("+"25,"+"\""+a[i-1]+a[i]+a[i+1]+a[i+2]+a[i+3]+a[i+4]+"\""+")");
                        i=i+5;
                        continue;
                    }}}
            if(a[i-1]>='a'&& a[i-1]<='z'||a[i-1]>='A' && a[i-1]<='Z') {
                System.out.print("("+"0,"+"\"");
                p=i-1;
                for(;p < count &&((a[p]>='0'&& a[p]<='9') || (a[p]>='a'&& a[p]<='z') || (a[p]>='A'&& a[p]<='Z')) ;p++)
                    System.out.print(a[p]);


                System.out.println("\""+")");
                if(p==a.length)//否则会出现越界错误
                    break;
                else {i = p; continue;}
            }
            if(a[i-1]!=' ') {
                System.out.printf("("+"100,"+"\"");
                p=i-1;
                for(;a[p]!=' ';p++)
                    System.out.print(a[p]);
                System.out.println("\""+")");
                if(p==a.length)
                    break;
                else i=p;
            }
        }
    }

    public static void main(String[] args) {
        Ex_1 s=new Ex_1();
        s.Inputwords();
        s.Compareletters(s.a,s.a.length);
    }
}
