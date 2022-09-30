public class Employee {
    private final String name;
    private final float salary;
    private final int workHours;
    private final int hireYear;

    public Employee(String name, float salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public float tax() {
        if (this.salary < 1000) return 0;
        return this.salary * (103f / 100f) - this.salary;
    }

    public float bonus() {
        if (this.workHours > 40) return (this.workHours - 40) * 30;
        return 0;
    }

    public float raiseSalary() {
        if (2021 - this.hireYear < 10) return (this.salary + this.tax() + this.bonus()) * (105f / 100f);
        if (2021 - this.hireYear < 20) return (this.salary + this.tax() + this.bonus()) * (110f / 100f);
        return (this.salary + this.tax() + this.bonus()) * (115f / 100f);
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s\n"
                        + "Salary: %f\n"
                        + "Bonus: %f\n"
                        + "Tax: %f\n"
                        + "Raised Salary: %f",
                this.name, this.salary, this.bonus(), this.tax(), this.raiseSalary());
    }
}