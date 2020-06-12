public class ex2_2{
    public static void main(String[] args){
        System.out.println(max(20, 5, 22));
        System.out.println(max(10L, 11L, 9L));
        System.out.println(max(20.1f , 20.2f, 20.3f));
        System.out.println(min(20, 5, 22));
        System.out.println(min(10L, 11L, 9L));
        System.out.println(min(20.1f , 20.2f, 20.3f));
    }
    public static int max(int a, int b, int c){
        int max = (a > b) ? a : b;
        max = (max > c) ? max : c;
        return max;
    }
    public static long max(long a, long b, long c){
        long max = (a > b) ? a : b;
        max = (max > c) ? max : c;
        return max;
    }
    public static float max(float a, float b, float c){
        float max = (a > b) ? a : b;
        max = (max > c) ? max : c;
        return max;
    }



    public static int min(int a, int b, int c){
        int min = (a < b) ? a : b;
        min = (min < c) ? min : c;
        return min;
    }
    public static long min(long a, long b, long c){
        long min = (a < b) ? a : b;
        min = (min < c) ? min : c;
        return min;
    }
    public static float min(float a, float b, float c){
        float min = (a < b) ? a : b;
        min = (min < c) ? min : c;
        return min;
    }
}