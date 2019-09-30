package com.example.ibrahim.fook;
import java.util.Stack;
public class Fook_Calc_Engine {

     //   System.out.println(evaluate("(55*2%10)+12"));
     //   String a = spaceGenerator("(2342-21312)+5/2*3%2");
     //   System.out.println(evaluate(a));

    //not: yukardaki main kullanım şekli. uygun şekilde kullan.
    public static double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();


        Stack<Double> values = new Stack<Double>();


        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {

            if (tokens[i] == ' ')
                continue;


            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            }


            else if (tokens[i] == '(')
                ops.push(tokens[i]);


            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }


            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/'|| tokens[i] == '%')
            {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));


                ops.push(tokens[i]);
            }
        }


        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));


        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/'|| op1 == '%') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }


    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '%':
                return a % b;
        }
        return 0;
    }

    public static String spaceGenerator(String str)
    {
        int sLength = str.length()-1;
        char[] strDizi=str.toCharArray();
        char[] strDizi2=str.toCharArray();
        for (int i = 0; i <= sLength-1; i++) {

            if (strDizi[i+1]!='0'&&strDizi[i+1]!='1'&&strDizi[i+1]!='2'&&strDizi[i+1]!='3'&&strDizi[i+1]!='4'&&strDizi[i+1]!='5'&&strDizi[i+1]!='6'&&strDizi[i+1]!='7'&&strDizi[i+1]!='8'&&strDizi[i+1]!='9'&&strDizi[i+1]!='.') {
                char[] newStrDizi=new char[strDizi.length+1];
                for (int j = 0; j <= i; j++) {
                    newStrDizi[j]=strDizi[j];
                }
                newStrDizi[i+1]=' ';
                for (int j = i+2; j < strDizi.length+1; j++) {
                    newStrDizi[j]=strDizi[j-1];
                }
                strDizi = newStrDizi;
                i++;
            }
        }
        return new String(strDizi);
    }
}
