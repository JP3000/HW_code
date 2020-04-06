import java.awt.GridLayout;
import javax.swing.*;

public class Scroll extends JFrame{
    // 定义需要用到的组件
    private JList jList;
    private JComboBox jComboBox;
    private JScrollPane jScrollPane;
    private JLabel jLabel, jLabel2;
    private JPanel jPanel, jPanel2;
    public static void main(String[] args){
        Scroll scroll = new Scroll();
    }
    public Scroll(){
    jPanel = new JPanel();
    jPanel2 = new JPanel();
    jLabel = new JLabel("所在省");
    jLabel2 = new JLabel("所在市");
    String [] province = {"广西", "广东", "湖南"};
    // 下拉框
    jComboBox = new JComboBox(province);
    String [] city = {"南宁", "柳州", "广州","深圳", "长沙"};
    // 列表框
    jList = new JList(city);
    jList.setVisibleRowCount(3);
    // 窗口滚动
    jScrollPane = new JScrollPane(jList);
    this.setLayout(new GridLayout(2, 1));
    jPanel.add(jLabel);
    jPanel.add(jComboBox);
    
    jPanel2.add(jLabel2);
    jPanel2.add(jScrollPane);
    
    this.add(jPanel);
    this.add(jPanel2);
    this.setTitle("Java");
    this.setLocation(500, 250);
    this.setSize(350, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    }
}