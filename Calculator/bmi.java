import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.regex.*;
 

public class bmi extends JFrame{       //  界面设计    
		
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
    public bmi(){  //方法构造窗体        
        
        JFrame frame = new JFrame("bmi");

        setTitle("身高体重指数计算器v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
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
        Container contpane = frame.getContentPane();
        contpane.setLayout(new BorderLayout());
        contpane.add(whPanel,BorderLayout.NORTH);
        contpane.add(consolePanel,BorderLayout.CENTER);
        contpane.add(submitButton,BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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
                // txtBMI.setText(dformat.format(bmi));  //返回BMI
                // txtResult.setText(getResult(bmi));   //返回查询结果
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

    public static void main(String[] args) {  //主函数
        new bmi();
    }
}