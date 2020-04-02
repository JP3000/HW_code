import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo8_1 {
    public static void main(String[] args){
        final JFrame frame = new JFrame("JFrameDemo");//创建一个JFrame的实例
        final JButton button = new JButton("Press me");//创建一个JButton的实例
        frame.setBounds(200, 100, 200, 200);
        //将JButton放到JFrame的中央
        //frame.getContentPane().add(button);
        frame.add(button);
        frame.pack();//将JFrame的中央
        frame.setVisible(true);//显示JFrame flase
    }
}