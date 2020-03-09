package org.geekbang.time.pattern.composite.usage;

public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return this.salary;
    }

}
