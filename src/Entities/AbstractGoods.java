package Entities;

import Utilities.IdGenerator;

/**
 * Created by Scala on 21.11.2016.
 */
public abstract class AbstractGoods {
    private int id;
    private String name;
    private Enum categories;



    public AbstractGoods(Enum categories) {
        setId(IdGenerator.nextId());
        this.setCategories(categories);
    }

    public void toUse() {
        System.out.println("I'm a " + getName() + " and I'm very useful.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getCategories() {
        return categories;
    }

    public void setCategories(Enum categories) {
        this.categories = categories;
    }
}
