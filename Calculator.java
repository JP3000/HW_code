import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;
import javax.xml.soap.Text;
public class Calculator extends JFrame{
       Stack<Character> priStack=new Stack<Character>();
       Stack<Double> numStack=new Stack<Double>();
        public  Calculator() {
            Container c=getContentPane();
            Font font = new Font("宋体",Font.BOLD,15); 
            this.setLayout(new GridLayout(4,1));
            JTextField jt=new JTextField("0");
            JTextField jt1=new JTextField("");
            jt.setFont(font);jt1.setFont(font);
            jt1.setHorizontalAlignment(JTextField.RIGHT);
            jt.setHorizontalAlignment(JTextField.RIGHT);
            JButton  data0=new JButton("0");
            JButton  data1=new JButton("1");
            JButton  data2=new JButton("2");
            JButton  data3=new JButton("3");
            JButton  data4=new JButton("4");
            JButton  data5=new JButton("5");
            JButton  data6=new JButton("6");
            JButton  data7=new JButton("7");
            JButton  data8=new JButton("8");
            JButton  data9=new JButton("9");
            JButton  left=new JButton("(");
            JButton  l1=new JButton("1/x");
            JButton  l2=new JButton(" ");
            JButton  l3=new JButton(" ");
            JButton  right=new JButton(")");
            JButton  point=new JButton(".");
            JButton  sqrt1=new JButton("sqrt");
            JButton  mod=new JButton("%");
            JButton  puls=new JButton("+");
            JButton  minus=new JButton("-");
            JButton  equ=new JButton("=");
            JButton  mul=new JButton("*");
            JButton  dvd=new JButton("/");
            JButton  DEC=new JButton("清零");
            JButton  back=new JButton("退格");
            JPanel jp=new JPanel();
            jp.setLayout(new GridLayout(3,5,5,5));
            jp.add(data7);jp.add(data8);
            jp.add(data9);jp.add(puls);jp.add(back);
            jp.add(data4);
            jp.add(data5);jp.add(data6);
            jp.add(minus);jp.add(DEC); jp.add(data1);
            jp.add(data2);jp.add(data3);
            jp.add(mul);jp.add(sqrt1);
            JPanel jpp=new JPanel();
            jpp.setLayout(new GridLayout(2,5,5,5));
            jpp.add(point);jpp.add(equ);jpp.add(data0);
            jpp.add(dvd);jpp.add(mod);
            jpp.add(left);jpp.add(right);
            jpp.add(l1); jpp.add(l2); jpp.add(l3);
            c.add(jt);c.add(jt1);c.add(jp);c.add(jpp);
            this.setSize(400,500);
            this.setTitle("计算器");
            this.setVisible(true);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            sqrt1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0)
                {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                    }else {
                        String str=jt.getText();
                        double t1=Double.parseDouble(str);
                        t1=Math.sqrt(t1);
                        str=String.valueOf(t1);
                        jt1.setText(str);
                    }
                }
                });

            l1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0)
                {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                    }else {
                        String str=jt.getText();
                        double t1=Double.parseDouble(str);
                        t1=1/t1;
                        str=String.valueOf(t1);
                        jt1.setText(str);
                    }
                }
                });
            mod.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"%");
                    }
                }

            });
            data0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"0");
                    }
                }
               });
            data1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("1");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"1");
                    }
                }
               });
            data2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("2");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"2");
                    }
                }
               });
            data3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("3");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"3");
                    }
                }
               });
            data4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("4");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"4");
                    }
                }
               });
            data5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("5");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"5");
                    }
                }
               });
            data6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("6");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"6");
                    }
                }
               });
            data7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("7");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"7");
                    }
                }
               });
            data8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("8");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"8");
                    }
                }
               });
            data9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("9");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"9");
                    }
                }
               });
            point.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText(".");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+".");
                    }
                }
               });
            puls.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("+");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"+");
                    }
                }
               });
            minus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("-");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"-");
                    }
                }
               });
            left.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("(");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"(");
                    }
                }
               });
            right.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText(")");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+")");
                    }
                }
               });
            mul.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("*");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"*");
                    }
                }
               });

            dvd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(jt.getText().equals("0")) {
                        jt.requestFocus();
                        jt.setText("");
                        jt.setText("/");
                    }else {
                        String str=jt.getText();
                        jt.setText(str+"/");
                    }
                }
               });
            //清零
            DEC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    jt.setText("0");
                    jt1.setText("");
                }
            });
            
            equ.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {              
                    String str=jt.getText();
                    str=str+"#";
                    String temp;
                    StringBuffer tempNum = new StringBuffer();     
                    StringBuffer string = new StringBuffer().append(str);  
                    while (string.length() != 0) {      
                        temp = string.substring(0, 1);      
                        string.delete(0, 1);         
                        if (!isNum(temp)) {        
                            if (!"".equals(tempNum.toString())) {       
                                double num =Double.parseDouble(tempNum.toString());      
                                numStack.push(num);  
                                tempNum.delete(0, tempNum.length());      
                            }          
                            while (!compare(temp.charAt(0)) && (!priStack.empty())) {   
                                double a = (double) numStack.pop();      
                                double b = (double) numStack.pop();
                                char ope = priStack.pop();      
                                double result = 0;
                                switch (ope) {      
                                case '+':      
                                    BigDecimal a1=new BigDecimal(Double.toString(a));
                                    BigDecimal b1=new BigDecimal(Double.toString(b));
                                    result =b1.add(a1).doubleValue();      
                                    numStack.push(result);      
                                    break;      
                                case '-': 
                                    BigDecimal a111=new BigDecimal(Double.toString(a));
                                    BigDecimal b111=new BigDecimal(Double.toString(b));
                                    result =b111.subtract(a111).doubleValue();                                 
                                    numStack.push(result);      
                                    break;      
                                case '*':     
                                    BigDecimal a11=new BigDecimal(Double.toString(a));
                                    BigDecimal b11=new BigDecimal(Double.toString(b));
                                    result =b11.multiply(a11).doubleValue();     
                                    numStack.push(result);      
                                    break;      
                                case '/':  
                                    BigDecimal a1111=new BigDecimal(Double.toString(a));
                                    BigDecimal b1111=new BigDecimal(Double.toString(b));
                                    result=b1111.divide(a1111).doubleValue();
                                    numStack.push(result);      
                                    break; 
                                case '%':      
                                    result = b %a;
                                    numStack.push(result);      
                                    break;
                                }      

                            }      
                            if (temp.charAt(0) != '#') {      
                                priStack.push(new Character(temp.charAt(0)));      
                                if (temp.charAt(0) == ')') {  
                                    priStack.pop();      
                                    priStack.pop();      
                                }      
                            }      
                        } else          
                            tempNum = tempNum.append(temp);     
                    }      
                    double t=numStack.pop();
                    jt1.setText(String.valueOf(t));
                }   
                } );
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    String text=jt.getText();
                    int i=text.length();
                    if(i>0) {
                        text=text.substring(0,i-1);
                        if(text.length()==0) jt.setText("0");
                        else jt.setText(text);
                    }
                }
            });

       }
private boolean isNum(String temp) {      
    return temp.matches("[0,1,2,3,4,5,6,7,8,9,.]");      
}       
private boolean compare(char str) {      
    if (priStack.empty()) {        
        return true;      
    }      
    char last = (char) priStack.lastElement();         
    if (last == '(') {      
        return true;      
    }      
    switch (str) {      
    case '#':      
        return false; 
    case '(':        
        return true;      
    case ')':          
        return false;      
    case '*': {        
        if (last == '+' || last == '-')      
            return true;      
        else      
            return false;      
    }      
    case '/': {      
        if (last == '+' || last == '-')      
            return true;      
        else      
            return false;      
    } 
    case '%': {      
        if (last == '+' || last == '-')      
            return true;      
        else      
            return false;      
    }       
    case '+':      
        return false;      
    case '-':      
        return false;      
    }      
    return true;      
}      
  public static void main(String []args) {
      Calculator c=new Calculator();

  }
}