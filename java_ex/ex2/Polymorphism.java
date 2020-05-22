abstract class Student {
    final static int CourseNo = 3;  
    String name;
	String type;
    int[]  courses;    
    String  courseGrade;    
    public Student(String name)
    {   this.name = name;
        courses = new int[CourseNo];
        courseGrade = "";// 代码1 初始化courseGrade为空串
    }    
    public abstract void calculateGrade();     
	public String getName( )
    { 
        return name;    
    }
	public String getType( )
    {
        return type;//代码2 返回学生类型
    }
	public String getCourseGrade( )
    {
        return courseGrade;
    }
    public int getCourseScore(int courseNumber)
    {
        return courses[courseNumber];
    }    
    public void setName(String name)
    {
        this.name = name;
    }
	public void setType(String type)
    {
        this.type = type;
    }
    public void setCourseScore(int courseNumber, int courseScore)
    {
        courses[courseNumber] = courseScore;// 代码3 按课程索引号设置课程成绩
    }
    //this.courseGrade = string.valueOf(courseScore[courseNumber]);
}
class Undergraduate extends Student {  
     public Undergraduate(String name ) 
	{    super(name);
		 type = "本科生";
    }
    public void calculateGrade() {
        int total = 0;
	     double average = 0;
        for (int i = 0; i < CourseNo; i++) {
            total += courses[i];// 代码4 累加各门课程成绩
        }
        average = total / CourseNo;
        if (average>=80&&average<100) courseGrade = "优秀";
	       else if (average>=70&&average<80) courseGrade = "良好";
	          else if (average>=60&&average<70) courseGrade = "一般";
	              else if (average>=50&&average<60) courseGrade = "及格";
	                  else courseGrade = "不及格";  
	 }
}
class Postgraduate extends Student {  
   public Postgraduate(String name)
   {   super(name);
	   type = "研究生";
   }
   public void calculateGrade()
    {    int total = 0;
        double average = 0;
        for (int i = 0; i < CourseNo; i++) {
           total += courses[i];
        };
       average = total / CourseNo;
	  if (average>=90&&average<100) courseGrade = "优秀";
	     else if (average>=80&&average<90) courseGrade = "良好";
	       else if (average>=70&&average<80) courseGrade = "一般";
	          else if (average>=60&&average<70) courseGrade = "及格";
	              else courseGrade = "不及格";
     }
}
public class Polymorphism {
    public static void main(String[] args) {
     Student[] students = new Student[5];
     students[0] = new Undergraduate("陈建平");
     students[1] = new Undergraduate("鲁向东");
	 students[2] = new Postgraduate("匡晓华");
     students[3] = new Undergraduate("周丽娜");
     students[4] = new Undergraduate("梁欣欣"); // 代码5 创建姓名为梁欣欣的Postgraduate对象students[4] 
	 for (int i=0; i<5 ;i++) {
		 students[i].setCourseScore(0,87);
         students[i].setCourseScore(1,90);
		 students[i].setCourseScore(2,78);
	 }
     for (int i=0; i<5 ;i++) {
		 students[i].calculateGrade();
	 }
     System.out.println("姓名" + "     类型" +"    成绩");
	 System.out.println("-----------------------");
	 for (int i=0; i<5 ;i++) {	 
       System.out.println(students[i].getName( )+"   "
		                +  students[i].getType( )+"  "
		                +  students[i].getCourseGrade( ));
	 }
  }
}
