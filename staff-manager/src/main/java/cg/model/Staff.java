package cg.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 6, max = 12, message = "Từ 6 đến 12 ký tự")
    private String name;

    @Min(value = 18, message = "Tuổi phải trên 18")
    @Max(value = 100, message = "Tuổi phải dưới 100")
    private int age;

    // Tạo default
    @NumberFormat(pattern = "10,000" + "USD")
    private double salary;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(String code, String name, int age, double salary, Branch branch) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
