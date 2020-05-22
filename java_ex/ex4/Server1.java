import java.net.*;
import java.io.*;
public class Server1 implements Runnable
{
    ServerSocket server = null;
    Socket clientSocket;
    boolean flag = true;   //标记是否结束
    Thread c;            //向客户器端发送信息的线程
    BufferedReader sin;
    DataOutputStream sout;
    public static void main(String args[])
    {
        new Server1().ServerStart();
    }
    public void ServerStart()
    {   try
        {   server = new ServerSocket(5678);
            System.out.println("端口号:"+server.getLocalPort());
            while(flag)
            {   clientSocket = server.accept();
                System.out.println("已建立连接!");
                InputStream is = clientSocket.getInputStream();
                sin = new BufferedReader(new InputStreamReader(is));
                OutputStream os = clientSocket.getOutputStream();
                sout = new DataOutputStream(os);
                c = new Thread(this);
                c.start();               //启动线程，向客户器端发送信息
                String aline;
                while((aline=sin.readLine())!=null) //接收客户端的数据
                {    System.out.println(aline);
                     if(aline.equals("bye"))
                     {   flag = false;
                         c.interrupt(); break; //线程中断
}
                }	
                sout.close(); os.close(); sin.close(); is.close(); //关闭流                
                clientSocket.close();	 //关闭Socket连接
                System.exit(0);          //程序运行结束 
            }
         }catch(Exception e) {    System.out.println(e);    }
} 
    public void run()
    {   while(true)
        { try
          { int ch;
            while((ch=System.in.read())!=-1)
            {//从键盘接收字符并向客户端发送
              sout.write((byte)ch);
              if(ch=='\n') sout.flush(); //缓冲区内容向输出流发送
            }
          }
          catch(Exception e)
            {  System.out.println(e);   }
        }
    }
    public void finalize()               //析构方法
    {   try
        {   server.close(); }      //停止ServerSocket服务        
        catch(IOException e)
        {  System.out.println(e); }
    }
}
