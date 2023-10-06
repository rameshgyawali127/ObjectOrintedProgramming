import java.util.*;
public class MyDate {
    private int day, month, year;
    // first 0 is working as a indexing & feb should check having leap or not so making condition later. 
    int []daysInMonth = {0, 31,0,31,30,31,30,31,31,30,31,30,31};
    public void formetcheck(int d, int m, int y){
        boolean valid = isValid(d, m, y);
        if (valid){
            day = d;
            month = m;
            year = y;
        }
        else {
            throw new RuntimeException("!!!Invalid input !!!");
        }
    }
    public boolean isValid(int d, int m ,int y){
        setleapyear(y);
        if(d < 1 && d >daysInMonth[month])
            return false;
        if (m < 1 && m > 12)
            return false;
        else
            return true;
    }
    public boolean setleapyear(int year){
        boolean isleapyear;
        if(year % 400 == 0)
            isleapyear = true;
        else if (year % 100 == 0 )
            isleapyear = false;
        else if (year % 4 == 0)
            isleapyear = true;
        else 
            isleapyear = false;


        if(isleapyear)
            daysInMonth[2] = 28;
        else
            daysInMonth[2] = 29;
        return isleapyear;// return statement
    }
    public void addmonth(){
        month++ ;
        if(month > 12){
            month = 1;
            addyear();
        }
        if(day > daysInMonth[month])
            day = daysInMonth[month];

    }
    public void addyear(){
        year++;
        setleapyear(year);
        if(day > daysInMonth[month])
            day = daysInMonth[month];
    }
    public void addday(){
        day ++;
        if(day > daysInMonth[month]){
            day = 1;
            addmonth();
        }
    }
    public String toString(){
        return day + "-" + month + "-" + year;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the day :");
        int d = sc.nextInt();
        System.out.println("Enter the Month :");
        int m = sc.nextInt();
        System.out.println("Enter the Year :");
        int y = sc.nextInt();
        MyDate dav = new MyDate();
        dav.formetcheck(d,m,y);
        System.out.println("Input date is:"+dav.toString());

        dav.addday();
        System.out.println("After added day:" + dav.toString());

        dav.addmonth();
        System.out.println("After added month:" + dav.toString());
        
        dav.addyear();
        System.out.println("After added year: " + dav.toString());
    }
}
