public class Try4{
    public void run(int k)
    {
        int y = 1, i;
        for(i = 1; i <= k; i++){ y = (int)(y * i); }
        System.out.println(k + "!=" + y);        
    }
    public static void main(String args[]) 
    {
        Try4 a = new Try4();
        for(int i = 1; i < 10; i++) {a.run(i);}    
    }
}