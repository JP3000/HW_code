import java.net.*;
import java.io.*;
public class Client1 implements Runnable
{
    Socket clientSocket;
    boolean flag=true;      //标记是否结束
    Thread c;              //用于向服务器端发送信息
    BufferedReader cin;
    DataOutputStream cout;
    public static void main(String arg[])
    {
        new Client1().ClientStart();
    } 
    public void ClientStart()
    { try
      {  clientSocket=new Socket("localhost",5678); //连本机服务器端
         System.out.println("已建立连接!");
            while(flag)   //获取流对象 
            {   InputStream is = clientSocket.getInputStream();
                cin=new BufferedReader(new InputStreamReader(is));
                OutputStream os = clientSocket.getOutputStream();
                cout = new DataOutputStream(os);
                c = new Thread(this);
                c.start();               //启动线程，向服务器端发送信息
                String aline;
                while((aline=cin.readLine())!=null) //接收服务器端的数据
                {   System.out.println(aline);
                    if(aline.equals("bye"))
                    {   flag = false; c.interrupt();break; }                    
                }	
                cout.close(); os.close(); cin.close(); is.close();
                clientSocket.close();    //关闭Socket连接
                System.exit(0);	 
            }
     }   
     catch(Exception e)    {   System.out.println(e);  }
    } 
    public void run()
    {
      while(true)
      {  try
        {//从键盘接收字符并向服务器端发送
           int ch;
           while((ch=System.in.read())!=-1)
          {
             cout.write((byte)ch);
             if(ch=='\n') cout.flush(); }
                    //缓冲区内容向输出流发送
          }
          catch(Exception e)
          { System.out.println(e);  }
        }
    }
}
