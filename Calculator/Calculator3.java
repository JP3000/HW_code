import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.regex.*;
import java.util.Stack; 
import java.util.LinkedList;
import java.util.List;
public class Calculator3 extends JFrame implements ActionListener{
    JFrame f=new JFrame("Calculator");
	private JTextField text_show = new JTextField("0");

	//bmi
	private static final long serialVersionUID = 1L;
    private JButton submitButton;
    private JPanel whPanel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JTextField heightText;
    private JTextField weightText;
    private JPanel consolePanel;
    private JLabel consoleLabel;
    private JTextField consoleText;
 
    
    public double weight;
    
    public double height;
    
    public double bmi;
 
    DecimalFormat dformat = new DecimalFormat("#.00");

	public JButton button_sqrt,button_mark,button_CE,button_C,
	                button_7,button_8,button_9,button_divide,
	                button_4,button_5,button_6,button_multiply,
	                button_1,button_2,button_3,button_minus,
	                button_0,button_dot,button_equal,button_plus;
	public JPanel jpanel;
	
	// public int count_H = 0;
	// public int count_equ = 0;
	
    public char sign;
	public double v1;
	public double v2;
	public boolean reop;


    private ArrayList<String> list=new ArrayList<String>();
    private ArrayList<String> his=new ArrayList<String>();//这个链表用来添加每一次得到的最终的结果
    private ArrayList<String> arr = new ArrayList<String>();//把his里的一整串字符分割成单个字符，再连接
    private String[] arrayStr = new String[] {};//储存单次的历史记录
    private String out = "";
    private String output = "";
    private String[] str=new String[10];
    private int begin;

	public Calculator3(){
		JPanel bmi1 = new JPanel();
		JPanel bmi2 = new JPanel();
		JPanel bmi3 = new JPanel();

		JPanel jpanel1 = new JPanel();
		JPanel jpanel2 = new JPanel();
		JPanel jpanel3 = new JPanel();
		JPanel jpanel4 = new JPanel();
		JPanel jpanel5 = new JPanel();
		
		whPanel = new JPanel();
        whPanel.setLayout(new FlowLayout());
        heightLabel = new JLabel("身高（米/m）：");
        weightLabel = new JLabel("体重（千克/kg）：");
        heightText = new JTextField(10);
        heightText.setToolTipText("请输入身高");
        weightText = new JTextField(10);
        weightText.setToolTipText("请输入体重");

        whPanel.add(heightLabel); whPanel.add(heightText);
        whPanel.add(weightLabel); whPanel.add(weightText);
        //结果
        consolePanel = new JPanel();
        consolePanel.setLayout(new FlowLayout());
        consoleLabel = new JLabel("你的身体质量指数为：");
        consoleText = new JTextField(28);
        consoleText.setEditable(false);

        consolePanel.add(consoleLabel); consolePanel.add(consoleText);

        submitButton = new JButton("BMI计算");//计算改成等号( = )

        //bmi主界面
		bmi1.setLayout(new FlowLayout());
		bmi2.setLayout(new FlowLayout());
		bmi3.setLayout(new FlowLayout());
        bmi1.add(whPanel,FlowLayout.LEFT);
        bmi2.add(consolePanel,FlowLayout.LEFT);
        bmi3.add(submitButton,FlowLayout.LEFT);
		
		button_re=new JButton("replay");button_mark=new JButton("%");
		button_CE=new JButton("CE");    button_C=new JButton("C");
        button_7=new JButton("7");      button_8=new JButton("8");
        button_9=new JButton("9");      button_divide=new JButton("÷");
        button_4=new JButton("4");      button_5=new JButton("5");
        button_6=new JButton("6");      button_multiply=new JButton("x");
        button_1=new JButton("1");      button_2=new JButton("2");
        button_3=new JButton("3");      button_minus=new JButton("-");
        button_0=new JButton("0");      button_dot=new JButton(".");
        button_equal=new JButton("=");  button_plus=new JButton("+");
		
		
        button_re.addActionListener(this);
        button_mark.addActionListener(this);
        button_CE.addActionListener(this);
        button_C.addActionListener(this);
        button_7.addActionListener(this);
        button_8.addActionListener(this);
        button_9.addActionListener(this);
        button_divide.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        button_6.addActionListener(this);
        button_multiply.addActionListener(this);
        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_minus.addActionListener(this);
        button_0.addActionListener(this);
        button_dot.addActionListener(this);
        button_equal.addActionListener(this);
        button_plus.addActionListener(this);
		

        
		jpanel1.setLayout(new GridLayout(1, 4));
		jpanel1.add(button_re);
		jpanel1.add(button_mark);
		jpanel1.add(button_CE);
		jpanel1.add(button_C);
		
		jpanel2.setLayout(new GridLayout(1, 4));
		jpanel2.add(button_7);
		jpanel2.add(button_8);
		jpanel2.add(button_9);
		jpanel2.add(button_divide);
		
		jpanel3.setLayout(new GridLayout(1, 4));
		jpanel3.add(button_4);
		jpanel3.add(button_5);
		jpanel3.add(button_6);
		jpanel3.add(button_multiply);
		
		jpanel4.setLayout(new GridLayout(1, 4));
		jpanel4.add(button_1);
		jpanel4.add(button_2);
		jpanel4.add(button_3);
		jpanel4.add(button_minus);
		
		jpanel5.setLayout(new GridLayout(1, 4));
		jpanel5.add(button_0);
		jpanel5.add(button_dot);
		jpanel5.add(button_equal);
		jpanel5.add(button_plus);
		
		Container container = f.getContentPane();
		container.setLayout(new GridLayout(9, 1));
		container.add(text_show);
        text_show.setEditable(false);
        text_show.setHorizontalAlignment(JTextField.RIGHT);
        text_show.setFont(text_show.getFont().deriveFont((float)(30)));

		container.add(bmi1);
		container.add(bmi2);
		container.add(bmi3);

		container.add(jpanel1);
		container.add(jpanel2);
		container.add(jpanel3);
		container.add(jpanel4);
		container.add(jpanel5);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(600,300);
        f.setVisible(true);

        expression = "";

        submitButton.addActionListener(new ActionListener() {       //设置事件监听器

        	public void actionPerformed(ActionEvent e) {            //初始化以及报错
                if( weightText.getText() == null){
                    JOptionPane.showMessageDialog(null, "身高为空，请输入一个正值身高！");
                    return;
                }
                if( heightText.getText() == null){
                    JOptionPane.showMessageDialog(null, "体重为空，请输入一个正值体重！");
                    return; 
                }
                double weight = Double.valueOf(weightText.getText());
                if(weight <= 0 ){
                    JOptionPane.showMessageDialog(null, "体重输入有误，请重新输入！");
                    return;
                }
                double height = Double.valueOf(heightText.getText());
                if(height <= 0 ){
                    JOptionPane.showMessageDialog(null, "身高输入有误，请重新输入！");
                    return;
                }
                double bmi = weight/height/height;
                consoleText.setText("BMI指数：" + dformat.format(bmi) + "，健康状况：" + getResult(bmi));
            }

        });

	}
	private String getResult (double bmi) {           //分析BMI值大小
    
        if(bmi < 18.5){
            return "您偏瘦";
        }else if(bmi>=18.5 && bmi < 24){
            return "您的身材很完美";
        }else{
            return "您偏胖";
        }
    }

    
    public void actionPerformed(ActionEvent ev)
    {
        String action = ev.getActionCommand();
        /**
         * 如果点“=”，计算整个表达式的结果，如果是错误表达式，在文本框输入“Input Error!”
         */
        if(action.equals("="))
        {
            try
            {    
                Function f = new Function();
                double result = f.compute(out);
                cl.text.setText(Double.toString(result));
            } catch(Exception e) {
                cl.text.setText("Input Error!");
            }
        } 
        else if(action.equals("x")) {
            /**
             * 如果点击"×"，先把它转换为"*"
             */
            if(list.isEmpty())
            {
                arr.add("*");
                output += "*";
                out = output;
                text_show.setText(output);
            } else {
                list.add("*");
                output += "*";
                out = output;
                text_show.setText(output);
            }
        } 
        else if(action.equals("÷")) {
            /**
             * 如果点击"÷"，把它转换为"/"
             */
            if(list.isEmpty())
            {
                arr.add("/");
                output += "/";
                out = output;
                text_show.setText(output);
            } else {
                list.add("/");
                output += "/";
                out = output;
                text_show.setText(output);
            }
        } 
        else if(action.equals("CE")){
            /**
             * 如果点击"CE"，删除表达式里最后一个字符，每点一次删一个
             */
            if(list.isEmpty())
            {
                arr.remove(arr.size()-1);
                output = "";
                for(int i = 0; i < arr.size(); i++) output += arr.get(i);
                 out = output;
                 text_show.setText(output);
            } else {
                list.remove(list.size()-1);
                String output = "";
                for(int i = 0; i < list.size(); i++) output+=list.get(i);
                 out = output;
                 text_show.setText(output);
            }
        } 
        else if(action.equals("C")){
            /**
             * 如果点击"AC"，删除list链表，再删除之前先把表达式保留到his的链表里
             */
            his.add(out);
            list.clear();
            output="";
             text_show.setText(output);
        } else if(action.equals("replay")){
            /**
             * 如果点击"Replay"，在文本框里显示上一条表达式
             */
            output=his.get(his.size()-1);
            text_show.setText(output);
            arr.clear();
            //把上一条表达式分割成单个字符的字符数组
            char[] a=output.toCharArray();
            for(int i=0;i<a.length;i++)
            {
                arr.add(String.valueOf(a[i]));
            }
            his.remove(his.size()-1);
        } else {
            /**
             * 其余按钮可以直接加入表达式
             */
            if(list.isEmpty())
            {
                arr.add(action);
                output+= action;
                out=output;
                text_show.setText(output);
            } else {
                list.add(action);
                output+=action;
                out=output;
                text_show.setText(output);
            }
        }
    }
    

	public static void main(String[] args) {
        new Calculator2();
	}
}