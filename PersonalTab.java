import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class PersonalTab{
    JFrame frame = new JFrame("Address book");

    JLabel labelT = new JLabel("Please input your personal information",JLabel.LEFT);
    JLabel labelM = new JLabel("Mobilb phone(M)");  //标签
    JLabel labelS = new JLabel("Sex(S)");
    JLabel labelP = new JLabel("Pager(P)");
    JLabel labelB = new JLabel("Brithday(B)");
    JLabel labelQ = new JLabel("QQ");
    JLabel labelI = new JLabel("Interest(I)");
    JLabel labelC = new JLabel("ICQ");
    JLabel labelH = new JLabel("Homepage(H)");

    JComboBox jcbSEX;                          //组合框,存放性别
    JComboBox jcbBRI;                          //组合框,存放生日

    JTextField textM = new JTextField("", 10);//输入框,单行文本域
    JTextField textS = new JTextField("", 10);
    JTextField textP = new JTextField("", 10);
    JTextField textQ = new JTextField("", 10);
    JTextField textI = new JTextField("", 10);
    JTextField textC = new JTextField("", 10);
    JTextField textH = new JTextField("", 30);

    // JButton buttonA = new JButton("Add(A)");//功能按钮
    // JButton buttonE = new JButton("Edit(E)");
    // JButton buttonR = new JButton("Return(R)");
    JButton buttonQ = new JButton("Ok");//页面按钮
    JButton buttonC = new JButton("Cancel");

    //JTextArea textAll = new JTextArea(5, 30);//用于显示结果的文本区

    public static void main(String args[]){
        PersonalTab testCom = new PersonalTab();
        testCom.go();
    }

    public void go(){
        JPanel jPane1 = new JPanel();//定义面板
        JPanel jPane2 = new JPanel();
        JPanel jPane3 = new JPanel();
        JPanel jPaneF = new JPanel();
        JPanel jPane5 = new JPanel();
        JPanel jPane6 = new JPanel();
        JPanel jPaneA = new JPanel();
        JPanel jPaneR = new JPanel();

        //JPanel jPanea = new JPanel();//用来放置上述面板
        JPanel jPaneb = new JPanel();//用来放置页面按钮
        JPanel jPaneall = new JPanel();//放置所有组件

        jPane1.setLayout(new BorderLayout());
        jPane1.add(labelT, BorderLayout.WEST);//第一个面板中放主题
        Border etched = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder(etched);

        jcbSEX = new JComboBox();//设置组合框
        jcbSEX.setEditable(true);//可编辑的
        jcbBRI = new JComboBox();//设置组合框
        jcbBRI.setEditable(true);//可编辑的

        //第2, 3, 4个面板中放输入框


        jPane2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane3.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPaneF.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane5.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextArea jta = new JTextArea(2, 10);
        JScrollPane jsp = new JScrollPane(jta);
        //jsp.setBounds(13, 10, 10, 20);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        jPane2.add(labelM); jPane2.add(textM);
        jPane2.add(labelS); jPane2.add(jcbSEX);

        jPane3.add(labelP); jPane3.add(textP);
        jPane3.add(labelB); jPane3.add(jcbBRI);

        jPaneF.setLayout(new GridLayout(1, 2));
        //jPaneF.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPaneF.add(labelQ); jPaneF.add(textQ);
        jPaneF.add(labelI); jPaneF.add(jsp);
        
        jPaneR.add(labelC); jPaneR.add(textC);

        //jPaneR.add(labelI); jPaneR.add(jsp);

        //jPane5.setLayout(new FlowLayout(FlowLayout.LEFT));
        //jPane5.setLayout(new GridLayout(1, 0));
        //jPane5.add(jPaneF); jPane5.add(jPaneR);

        jPane6.add(labelH); jPane6.add(textH);

        // JScrollPane jp = new JScrollPane(textAll);
        // jPane5.add(jp);
        // jPane6.setLayout(new GridLayout(0, 1));
        // jPane6.add(buttonA);//面板中放功能按钮
        // jPane6.add(buttonE);
        // jPane6.add(buttonR);

        // jPanea.add(jPane5);//文本区和按钮
        //jPanea.add(jPane6);
        //border = BorderFactory.createTitledBorder(etched, "");
        //jPanea.setBorder(border);//设置边框

        jPaneb.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPaneb.add(buttonQ);//面板中放页面按钮
        jPaneb.add(buttonC);

        // jPaneA.setLayout(new BorderLayout());
        // jPaneA.add(jPane2, BorderLayout.NORTH);
        // jPaneA.add(jPane3, BorderLayout.CENTER);
        // jPaneA.add(jPaneF, BorderLayout.CENTER);
        // jPaneA.add(jPane5, BorderLayout.SOUTH);

        jPaneA.setLayout(new GridLayout(5, 1));
        jPaneA.add(jPane2);
        jPaneA.add(jPane3);
        jPaneA.add(jPaneF);
        jPaneA.add(jPaneR);
        //jPaneA.add(jPane5);
        jPaneA.add(jPane6);

        jPaneall.setLayout(new BoxLayout(jPaneall, BoxLayout.Y_AXIS));
        jPaneall.add(jPane1);
        jPaneall.add(jPaneA);
        jPaneall.add(jPaneb);

        Container contpane = frame.getContentPane();
        contpane.setLayout(new FlowLayout());
        contpane.add(jPaneall);
        //contpane.add(jPaneA);
        border = BorderFactory.createTitledBorder(etched, "InformationCard");
        jPaneall.setBorder(border);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}