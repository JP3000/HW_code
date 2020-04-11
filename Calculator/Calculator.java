import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.regex.*;
public class Calculator extends JFrame implements ActionListener{
	JFrame f=new JFrame("Calculator");

	public JTextField text_show;

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

	
	
	
	public Calculator(){
		text_show=new JTextField("",100);
		
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

        submitButton = new JButton("计算");//计算改成等号( = )

        //bmi主界面
		bmi1.setLayout(new FlowLayout());
		bmi2.setLayout(new FlowLayout());
		bmi3.setLayout(new FlowLayout());
        bmi1.add(whPanel,FlowLayout.LEFT);
        bmi2.add(consolePanel,FlowLayout.LEFT);
        bmi3.add(submitButton,FlowLayout.LEFT);
		
		button_sqrt=new JButton("sqrt");button_mark=new JButton("%");
		button_CE=new JButton("CE");button_C=new JButton("C");
        button_7=new JButton("7");button_8=new JButton("8");
        button_9=new JButton("9");button_divide=new JButton("/");
        button_4=new JButton("4");button_5=new JButton("5");
        button_6=new JButton("6");button_multiply=new JButton("*");
        button_1=new JButton("1");button_2=new JButton("2");
        button_3=new JButton("3");button_minus=new JButton("-");
        button_0=new JButton("0");button_dot=new JButton(".");
        button_equal=new JButton("=");button_plus=new JButton("+");
		
		
        button_sqrt.addActionListener(this);
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
		jpanel1.add(button_sqrt);
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
	    f.setVisible(true);
		
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
                consoleText.setText("你的指数为：" + dformat.format(bmi) + "，你的健康状况为：" + getResult(bmi));
            }

        });

	}
	private String getResult(double bmi) {           //分析BMI值大小
    
        if(bmi < 18.5){
            return "您有点偏瘦哦";
        }else if(bmi>=18.5 && bmi < 24){
            return "您的身材比列很完美哦";
        }else{
            return "您有点偏胖了哦";
        }
    }
	public void actionPerformed(ActionEvent ev){
		double value=0;
	    char operator=0;
	    if(reop)
        {
            text_show.setText("");
            reop = false;
        }
		if(ev.getSource()==button_0){
			String str=text_show.getText();
			if(str.equals(""))
				return;
			text_show.setText(str+'0');
			}
		if(ev.getSource()==button_1){
			String str=text_show.getText();
			text_show.setText(str+'1');
		}
		if(ev.getSource()==button_2){
			String str=text_show.getText();
			text_show.setText(str+'2');
		}
		if(ev.getSource()==button_3){
			String str=text_show.getText();
			text_show.setText(str+'3');
		}
		if(ev.getSource()==button_4){
			String str=text_show.getText();
			text_show.setText(str+'4');
		}
		if(ev.getSource()==button_5){
			String str=text_show.getText();
			text_show.setText(str+'5');
		}
		if(ev.getSource()==button_6){
			String str=text_show.getText();
			text_show.setText(str+'6');
		}
		if(ev.getSource()==button_7){
			String str=text_show.getText();
			text_show.setText(str+'7');
		}
		if(ev.getSource()==button_8){
			String str=text_show.getText();
			text_show.setText(str+'8');
		}
		if(ev.getSource()==button_9){
			String str=text_show.getText();
			text_show.setText(str+'9');
		}
		
		if(ev.getSource()==button_dot){
			String str=text_show.getText();
			text_show.setText(str+'.');
		}
		if(ev.getSource()==button_C){
			text_show.setText("");
			return;
		}
		if(ev.getSource()==button_plus){
			operator='+';
		}
		if(ev.getSource()==button_minus){
			operator='-';
		}
		if(ev.getSource()==button_multiply){
			operator='*';
		}
		if(ev.getSource()==button_divide){
			operator='/';
		}
		if(ev.getSource()==button_equal){
			operator='=';
		}
		if(ev.getSource()==button_mark){
			operator='%';
		}
		if(ev.getSource()==button_sqrt){
			operator='^';
		}
		if(ev.getSource()==button_CE){
			operator='e';
		}
		switch(operator){
		case'e' :
		          String s=text_show.getText();
		          text_show.setText(s.substring(0,s.length()-1));
		          break;
		case'^' :
			      v1=Double.parseDouble(text_show.getText());
			      value=Math.sqrt(v1);text_show.setText(String.valueOf(value));reop = true;
			      break;
		case'%' : 
		          v1=Double.parseDouble(text_show.getText());
                  value=v1/100;text_show.setText(String.valueOf(value));reop = true;
                  break;
		case'+' : 
		          v1=Double.parseDouble(text_show.getText());
		          text_show.setText("");sign='+';break;
		case'-' : 
				  v1=Double.parseDouble(text_show.getText());
                  text_show.setText("");sign='-';break;
		case'*' : 
	              v1=Double.parseDouble(text_show.getText());
	              text_show.setText("");sign='*';break;
	    case'/' : 
			      v1=Double.parseDouble(text_show.getText());
                  text_show.setText("");sign='/';break;
	    case'=' : 
	    	      reop = true;
	    	      v2=Double.parseDouble(text_show.getText());
		          switch(sign){
		          case'+' : 
			          value=v1+v2;break;
			      case'-' : 
			    	  value=v1-v2;break;
			      case'*' : 
			    	  value=v1*v2;break;
		          case'/' : 
		        	  value=v1/v2;break;
		        	  default:value=v1;
		          }
		          String str=String.valueOf(value);
				  text_show.setText(str);
		          break;
                  default:;  
		
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();

	}
}