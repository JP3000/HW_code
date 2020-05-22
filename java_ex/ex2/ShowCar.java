public class ShowCar{
    public static void main(String[] args){
        Car bentian = new Car("本田", "黑色", 1500, 5);
        System.out.println("品牌: " + bentian.name);
        System.out.println("颜色: " + bentian.color);
        System.out.println("自重: " + bentian.weight + "公斤");
        System.out.println("搭乘的人数: " + bentian.passenger + "人");
    }
}
class Car{
    String name;
    String color;
    double weight;
    int passenger;
    public Car(String name, String color, double weight, int passenger){
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.passenger = passenger;
    }
}