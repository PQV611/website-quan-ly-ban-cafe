package website.code.coffeeShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;

    public Category() {}

    public Category(String groupName, String categoryName, String description) {
        this.groupName = groupName;
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(int cid, String groupName, String categoryName, String description) {
        this.cid = cid;
        this.groupName = groupName;
        this.categoryName = categoryName;
        this.description = description;
    }
}
