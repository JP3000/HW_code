import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class UnitConvert{
    JFrame frame = new JFrame("Unit Conver");
    
    JLabel labelT1 = new JLabel(" to ");
    JLabel labelT2 = new JLabel(" to ");

    JComboBox jcbTRAN1;//
    JComboBox jcbTRAN2;//

    JTextField textU1 = new JTextField("", 10);
    JTextField textU2 = new JTextField("", 10);


    public static void main(String args[]){
        UnitConvert convert = new UnitConvert();
        convert.go();
    }

    public void go(){
        JPanel jPane1 = new JPanel();
        JPanel jPane2 = new JPanel();
        JPanel jPaneU = new JPanel();
        String [] unitA = {"重量", "速度", "温度"};
        String [] unitB = {"重量", "速度", "温度"};
        //Border etched = BorderFactory.createEtchedBorder();
        //Border border = BorderFactory.createTitledBorder(etched);

        jcbTRAN1 = new JComboBox(unitA);
        jcbTRAN1.setEditable(true);
        jcbTRAN2 = new JComboBox(unitB);
        jcbTRAN2.setEditable(true);

        jPane1.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPane1.add(jcbTRAN1); jPane1.add(labelT1); jPane1.add(jcbTRAN2);
        jPane2.add(textU1); jPane2.add(labelT2); jPane2.add(textU2);

        jPaneU.setLayout(new BoxLayout(jPaneU, BoxLayout.Y_AXIS));
        jPaneU.add(jPane1);
        jPaneU.add(jPane2);

        Container contpane = frame.getContentPane();
        contpane.setLayout(new FlowLayout());
        contpane.add(jPaneU);
        //border = BorderFactory.createTitledBorder(etched, "UnitConvert");
        //jPane1.setBorder(border);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }
}