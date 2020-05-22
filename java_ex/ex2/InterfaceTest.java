import java.util.Scanner;
interface Soundable {
    public void increaseVolume( );
    public void decreaseVolume( );
    public void stopSound( );
    public void playSound( );
}
class Radio implements Soundable {
    public void increaseVolume( ) {
	    System.out.println("增大收音机音量");
    }
        public void decreaseVolume( ) {
        System.out.println("减小收音机音量");
    }
    public void stopSound( ) {
        System.out.println("关闭收音机");
    }
    public void playSound( ) {
        System.out.println("收音机播放广播");
    }
    }
    class Walkman implements Soundable {
    public void increaseVolume( ) {
        System.out.println("增大随声听音量");
    }
    public void decreaseVolume( ) {
        System.out.println("减小随声听音量") ;// 代码1 输出减小随声听音量
    }
    public void stopSound( ) {
        System.out.println("关闭随声听");
    }
    public void playSound( ) {
        System.out.println("随声听发出音乐");
    }
}
class Mobilephone implements Soundable {
    public void increaseVolume( ) {
        System.out.println("增大手机音量");
    }
        public void decreaseVolume( ) {
        System.out.println("减小手机音量");
    }
    public void stopSound( ) {
        System.out.println("关闭手机");
    }
    public void playSound( ) {
        System.out.println("手机发出来电铃声");
    }
}
class People {
   private String name;   private int  age;
   public void listen(Soundable s) {
	     s.playSound( );
   }
}
public class InterfaceTest {
   public static void main(String[] args) {
        int i;
	    People sportsman = new People( );
       Scanner scanner = new Scanner(System.in);
	   Soundable[] soundDevice = new Soundable[3];
       //往声音设备数组中放入能发声的设备
	   soundDevice[0] = new Radio( );
	   soundDevice[1] = new Walkman( );
	   soundDevice[2] = new Mobilephone(); //代码2 创建手机对象并赋值给soundDevice[2]
	   System.out.println("你想听什么? 请输入选择：0-收音机 1-随声听 2-手机");
       i = scanner.nextInt( );
       sportsman.listen(soundDevice[i]); //开始听声音
	   soundDevice[i].increaseVolume( );
	   soundDevice[i].stopSound(); //代码3 调用stopSound( )方法
   }
}
