import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class SwingComponentDemo3{
    JFrame frame = new JFrame("Address book");

    JLabel labelT = new JLabel("Please input your name and E-mail address",JLabel.LEFT);
    JLabel labelL = new JLabel("Last name(L)");  //标签
    JLabel labelF = new JLabel("First name(F)");
    JLabel labelI = new JLabel("Name(I)");
    JLabel labelN = new JLabel("Nickname(N)");
    JLabel labelM = new JLabel("E-mail address");

    JComboBox jcbLF;                          //组合框,存放姓名

    JTextField textL = new JTextField("", 10);//输入框,单行文本域
    JTextField textF = new JTextField("", 10);
    JTextField textN = new JTextField("", 10);
    JTextField textM = new JTextField("", 30);

    JButton buttonA = new JButton("增加(A)");//功能按钮
    JButton buttonE = new JButton("编辑(E)");
    JButton buttonR = new JButton("删除(R)");
    JButton buttonQ = new JButton("确定");//页面按钮
    JButton buttonC = new JButton("取消");

    JTextArea textAll = new JTextArea(5, 30);//用于显示结果的文本区
    
    public static void main(String args[]){
        SwingComponentDemo3 testCom = new SwingComponentDemo3();
        testCom.go();
    }

    public void go(){
        JPanel jPane1 = new JPanel();//定义面板
        JPanel jPane2 = new JPanel();
        JPanel jPane3 = new JPanel();
        JPanel jPane4 = new JPanel();
        JPanel jPane5 = new JPanel();
        JPanel jPane6 = new JPanel();
        JPanel jPane234 = new JPanel();

        JPanel jPanea = new JPanel();//用来放置上述面板
        JPanel jPaneb = new JPanel();//用来放置页面按钮
        JPanel jPaneall = new JPanel();//放置所有组件

        JPanel jpanea = new JPanel();
        JPanel jpaneb = new JPanel();
        JPanel jpaneall = new JPanel();

        jPane1.setLayout(new BorderLayout());
        jPane1.add(labelT, BorderLayout.WEST);//第一个面板中放主题
        Border etched = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder(etched);

        jcbLF = new JComboBox();//设置组合框
        jcbLF.setEditable(true);//可编辑的

        //第2, 3, 4个面板中放输入框
        jPane2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane3.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane4.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane2.add(labelL); jPane2.add(textL);
        jPane2.add(labelF); jPane2.add(textF);
        jPane3.add(labelI); jPane3.add(jcbLF);
        jPane3.add(labelN); jPane3.add(textN);
        jPane4.add(labelM); jPane4.add(textM);

        JScrollPane jp = new JScrollPane(textAll);
        jPane5.add(jp);
        jPane6.setLayout(new GridLayout(0, 1));
        jPane6.add(buttonA);//面板中放功能按钮
        jPane6.add(buttonE);
        jPane6.add(buttonR);

        jpanea.add(jPane5);//文本区和按钮
        jpanea.add(jPane6);
        border = BorderFactory.createTitledBorder(etched, "");
        jpanea.setBorder(border);//设置边框

        jpaneb.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpaneb.add(buttonQ);//面板中放页面按钮
        jpaneb.add(buttonC);

        jPane234.setLayout(new BorderLayout());
        jPane234.add(jPane2, BorderLayout.NORTH);
        jPane234.add(jPane3, BorderLayout.CENTER);
        jPane234.add(jPane4, BorderLayout.SOUTH);
        jPaneall.setLayout(new BoxLayout(jPaneall, BoxLayout.Y_AXIS));
        jPaneall.add(jPane1);
        jPaneall.add(jPane234);
        jPaneall.add(jPanea);
        jPaneall.add(jPaneb);

        Container contpane = frame.getContentPane();
        contpane.setLayout(new FlowLayout());
        contpane.add(jPaneall);
        border = BorderFactory.createTitledBorder(etched, "NameCards");
        jPaneall.setBorder(border);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}