import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class TestConvert extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    JTextField text1, text2, text3;
    public TestConvert(){
        super("米码转换器");
        this.setLayout(new GridLayout(3 ,2));
        text1 = new JTextField(10);
        text2 = new JTextField(10);
        text3 = new JTextField(10);
        this.add(new JLabel("单位(M/Y)"));
        this.add(text1);
        this.add(new JLabel("数量(米/码)"));
        this.add(text2);
        this.add(new JLabel("数量(码)"));
        this.add(text3);
        text2.addActionListener(this);
        this.setSize(250, 120);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        new TestConvert();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        double num = 0;
        if(text1.getText().trim().equals("M")){
            try{
                num = Double.parseDouble(text2.getText().trim());
                num *= 0.9144;
                text3.setText(num + "");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "数量错误, 只能使数值");
            }
        }
        else if(text1.getText().trim().equals("Y")){
            try{
                num = Double.parseDouble(text2.getText().trim());
                text3.setText(num + "");
            }
            catch(Exception ex){
                JOptionPane.showConfirmDialog(this, "数量错误, 只能是数值");
            }
        }
        else{
            JOptionPane.showConfirmDialog(this, "单位错误, 只能是M或Y");
        }
    }
}