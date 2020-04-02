import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

import sun.awt.AWTAccessor.ContainerAccessor;
import sun.awt.geom.AreaOp.AddOp;

import javax.swing.border.*;

public class SwingComponentDemo3{
    JFrame frame = new JFrame("通讯录");

    JLabel labelT = new JLabel("在这里输入姓名和E-mail地址",JLabel.LEFT);
    JLabel labelL = new JLabel("姓(L)");
    JLabel labelF = new JLabel("名(F)");
    JLabel labelI = new JLabel("姓名(I)");
    JLabel labelN = new JLabel("昵称(N)");
    JLabel labelM = new JLabel("E-mail地址");

    JComboBox jcbLF;

    JTextField textL = new JTextField("", 10);
    JTextField textF = new JTextField("", 10);
    JTextField textN = new JTextField("", 10);
    JTextField textM = new JTextField("", 30);

    JButton buttonA = new JButton("增加(A)");
    JButton buttonE = new JButton("编辑(E)");
    JButton buttonR = new JButton("删除(R)");
    JButton buttonQ = new JButton("确定");
    JButton buttonC = new JButton("取消");

    JTextArea textAll = new JTextArea(5, 30);
    
    public static void main(String args[]){
        SwingComponentDemo3 testCom = new SwingComponentDemo3();
        testCom.go();
    }

    public void go(){
        JPanel jPane1 = new JPanel();
        JPanel jPane2 = new JPanel();
        JPanel jPane3 = new JPanel();
        JPanel jPane4 = new JPanel();
        JPanel jPane5 = new JPanel();
        JPanel jPane6 = new JPanel();
        JPanel jPane234 = new JPanel();

        JPanel jPanea = new JPanel();
        JPanel jPaneb = new JPanel();
        JPanel jPaneall = new JPanel();

        JPanel jpanea = new JPanel();
        JPanel jpaneb = new JPanel();
        JPanel jpaneall = new JPanel();

        jpanel.setLayout(new BorderLayout());
        jpanel.add(labelT, BorderLayout.WEST);
        Border etched = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder(etched);

        jcbLF = new JComboBox();
        jcbLF.setEditable(true);

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
        jPane6.add(buttonA);
        jPane6.add(buttonE);
        jPane6.add(buttonR);

        jpanea.add(jPane5);
        jpanea.add(jPane6);
        border = BorderFactory.createTitledBorder(etched, "");
        jpanea.setBorder(border);

        jpaneb.setLayout(new FlowLayout(FlowLayout));
        jpaneb.add(buttonQ);
        jpaneb.add(buttonC);

        jPane234.setLayout(new BorderLayout());
        jPane234.add(jPane2, BorderLayout.NORTH);
        jPane234.add(jPane3, BorderLayout.CENTER);
        jPane234.add(jPane4, BorderLayout.SOUTH);
        jPaneall.setLayout(new BoxLayout(jpaneall, BoxLayout.Y_AXIS));
        jPaneall.add(jPane1);
        jPaneall.add(jPane234);
        jPaneall.add(jPanea);
        jPaneall.add(jPaneb);

        Container contpane = frame.getContentPane();
        contpane.setLayout(new FlowLayout());
        contpane.add(jpaneall);
        border = BorderFactory.createTitledBorder(etched, "NameCards");
        jPaneall.setBorder(border);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}