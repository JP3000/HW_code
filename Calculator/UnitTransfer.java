import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 
public class UnitTransfer extends JFrame{
    private final int WIDTH = 400, HEIGHT = 300;//窗口默认的宽度、高度
     
    private JLabel lblInUnit=new JLabel("输入单位");
    private JComboBox cboIn=new JComboBox(new String[]{"", ""});
    private JLabel lblIn=new JLabel("输入数值");
    private JTextField txtIn=new JTextField("10");
     
    private JLabel lblOutUnit=new JLabel("输出单位");
    private JLabel lblResult=new JLabel("显示结果");
    private JLabel txtResult=new JLabel("结果");
    private JComboBox cboOut=new JComboBox(new String[]{"", ""});
     
    private JButton btnTrans = new JButton("转换");
    private JButton btnClear = new JButton("清空");
     
    private JRadioButton rdLeng = new JRadioButton("长度");
    private JRadioButton rdWeig = new JRadioButton("时间");
    private String [] lengthUnit={"米", "分米", "厘米", "毫米"};
    private String [] timeUnit={"天", "时", "分", "秒"};
     
    public UnitTransfer(){
        super("简单的单位转换器 Beta");
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        ButtonGroup group = new ButtonGroup();
        group.add(rdLeng);
        group.add(rdWeig);
        this.getContentPane().add(rdLeng);
        this.getContentPane().add(rdWeig);
        this.getContentPane().add(btnTrans);
        this.getContentPane().add(btnClear);
        this.getContentPane().add(lblIn);
        this.getContentPane().add(txtIn);
        this.getContentPane().add(lblInUnit);
        this.getContentPane().add(cboIn);
 
        this.getContentPane().add(lblResult);
        this.getContentPane().add(txtResult);
        this.getContentPane().add(lblOutUnit);
        this.getContentPane().add(cboOut);
        this.setVisible(true);
        this.doLayout();
        btnTrans.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                doConvert();
            }
        });
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtIn.setText("0");
                txtResult.setText("0");
            }
        });
        rdLeng.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cboIn.setModel(new DefaultComboBoxModel(lengthUnit));
                cboOut.setModel(new DefaultComboBoxModel(lengthUnit));
            }
        });
        rdWeig.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cboIn.setModel(new DefaultComboBoxModel(timeUnit));
                cboOut.setModel(new DefaultComboBoxModel(timeUnit));
            }
        });
        rdLeng.setSelected(true);
        cboIn.setModel(new DefaultComboBoxModel(lengthUnit));
        cboOut.setModel(new DefaultComboBoxModel(timeUnit));
    }
    final int offX=100;
    public void doLayout(){
        super.doLayout();
         
        rdLeng.setBounds(offX, 15, 60, 20);
        rdWeig.setBounds(rdLeng.getX()+rdLeng.getWidth()+5, 15, 60, 20);
         
        lblInUnit.setBounds(offX, rdLeng.getY()+rdLeng.getHeight()+20, 80, 20);
        cboIn.setBounds(lblInUnit.getX()+lblInUnit.getWidth()+5, lblInUnit.getY(), 80, 20);
        lblIn.setBounds(offX, lblInUnit.getY()+lblInUnit.getHeight()+5, 80, 20);
        txtIn.setBounds(lblIn.getX()+lblIn.getWidth()+5, lblIn.getY(), 80, 20);
         
        lblOutUnit.setBounds(offX, lblIn.getY()+lblIn.getHeight()+30, 80, 20);
        cboOut.setBounds(lblOutUnit.getX()+lblOutUnit.getWidth()+5, lblOutUnit.getY(), 80, 20);
        lblResult.setBounds(offX, cboOut.getY()+cboOut.getHeight()+5, 80, 20);
        txtResult.setBounds(lblResult.getX()+lblResult.getWidth()+5, lblResult.getY(), 100, 20);
         
        int w=getWidth ();
        int x=(w-70*2-5)/2;//水平居中
        btnTrans.setBounds(x, lblResult.getY()+lblResult.getHeight()+30, 70, 25);
        btnClear.setBounds(btnTrans.getX()+btnTrans.getWidth()+3, btnTrans.getY(), 70, 25);
    }
    public void doConvert(){
        double v=0;
        try{
            v= Double.parseDouble(txtIn.getText());
        }catch(Exception ex){
            txtIn.setText("0");
            return;
        }
        //"米", "分米", "厘米", "毫米"
        if(rdLeng.isSelected()){
            switch(cboIn.getSelectedIndex()){
                case 0:
                    break;
                case 1:
                    v=v/10;
                    break;
                case 2:
                    v=v/100;
                    break;
                case 3:
                    v=v/1000;
                    break;
                default:
                    return;
            }
            //v 现在是标准单位：米
            switch(cboOut.getSelectedIndex()){
                case 0:
                    break;
                case 1:
                    v=v*10;
                    break;
                case 2:
                    v=v*100;
                    break;
                case 3:
                    v=v*1000;
                    break;
                default:
                    return;
            }
            if(v<0.01){
                txtResult.setText(String.format("%2.8f", v));
            }else{
                txtResult.setText(String.format("%2.2f", v));
            }
        }else{
        //"天", "时", "分", "秒"
            switch(cboIn.getSelectedIndex()){
                case 0:
                    v=v*24;
                    break;
                case 1:
                    break;
                case 2:
                    v=v/60;
                    break;
                case 3:
                    v=v/3600;
                    break;
                default:
                    return;
            }
            //v 现在是标准单位：小时
            switch(cboOut.getSelectedIndex()){
                case 0:
                    v=v/24;
                    break;
                case 1:
                    break;
                case 2:
                    v=v*60;
                    break;
                case 3:
                    v=v*3600;
                    break;
                default:
                    return;
            }
            if(v<0.01){
                txtResult.setText(String.format("%2.8f", v));
            }else{
                txtResult.setText(String.format("%2.8f", v));
            }
        }
    }
     
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable()  {
            public void run()   {
                new UnitTransfer();
            }
        });
    }
}