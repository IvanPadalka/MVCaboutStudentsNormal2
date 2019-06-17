
interface EmployersSallary{
    double averageMonthlySalary();
}

abstract class EmployerModel implements EmployersSallary{
    protected int id;
    protected double Sallary;
    protected String name;
    public EmployerModel(int Sallary, String name) {
        this.Sallary = Sallary;
        this.name = name;
        this.id=id;
    }
    @Override
    public String toString() {
        return this.name+" "+this.Sallary;
    }
}


class HourlyWageEmployee extends EmployerModel{
    private int hourlyRate;
    HourlyWageEmployee(int id, String name, int hourlyRate){
        super(id, name);
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double averageMonthlySalary() {
        this.Sallary = 20.8*8*hourlyRate;
        return Sallary;
    }
}
class FixedWageEmployee extends EmployerModel{
    FixedWageEmployee(int id, String name,int salary){
        super(id, name);
        this.Sallary = salary;
    }
    @Override
    public double averageMonthlySalary() {
        return Sallary;
    }
}
