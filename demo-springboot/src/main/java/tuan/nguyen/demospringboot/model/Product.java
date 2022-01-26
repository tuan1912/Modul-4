package tuan.nguyen.demospringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data//lombok tự taoj getter, setter, contructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tu tăng trong MySQL= auto_increment, con auto thi có thể tăng trong java hoặc cơ sở dữu liệu
    private long id;
    private String name;
    private String img;
    private double price;
    @ManyToOne
    private Category category;
}

