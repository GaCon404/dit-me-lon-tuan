package oop;
interface IEmployee{
    public int calculateSalary();
    public String getName();
}
abstract class Employee implements IEmployee{
    private String name;
    private int paymentPerHour;
    public Employee(String name, int paymentPerHour)
    {
        this.name=name;
        this.paymentPerHour=paymentPerHour;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    @Override
     public String getName()
    {
        return name;
    }
    public void setPaymentPerHour(int paymentPerHour)
    {
        this.paymentPerHour=paymentPerHour;
    }
    public int getPaymentPerHour()
    {
        return paymentPerHour;
    }
}
class PartTimeEmployee extends Employee{
    private int workingHours;
    public PartTimeEmployee(String name, int paymentPerHour, int workingHours)
    {
        super(name,paymentPerHour);
        this.workingHours=workingHours;
    }
    @Override
    public int calculateSalary()
    {
        return workingHours*getPaymentPerHour();
    }
}
class FullTimeEmployee extends Employee{
    public FullTimeEmployee(String name, int paymentPerHour)
    {
        super(name,paymentPerHour);
    }
    @Override
    public int calculateSalary()
    {
        return 8*getPaymentPerHour();
    }
}
public class b46 {
    public static void main(String[] args) {
        IEmployee employee1 = new PartTimeEmployee("Trung", 45000, 7);
        System.out.println("Name: " + employee1.getName());
        System.out.println("Salary per day: " + employee1.calculateSalary());

        IEmployee employee2 = new FullTimeEmployee("Linh", 65000);
        System.out.println("Name: " + employee2.getName());
        System.out.println("Salary per day: " + employee2.calculateSalary());
    }
}
