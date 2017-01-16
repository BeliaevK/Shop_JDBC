package Entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Scala on 20.11.2016.
 */
public class GoodsStock implements Serializable {
    private int id;
    private String name;
    private TypeGoods typeGoods;
    private CategoriesGoods categoriesGoods;
    private int sum;
    private Date date;

    public enum TypeGoods {
        PRODUCTS , CLOTHES , ELECTRONICS
    }

    public enum CategoriesGoods {

        BREAD, MILK, PIZZA,

        SHORTS, TSHIRT, OUTERWEAR,

        TV, CONSOLE
    }

    public GoodsStock(int id, String name, TypeGoods typeGoods, CategoriesGoods categoriesGoods, int sum) {
        this.setId(id);
        this.setName(name);
        this.setTypeGoods(typeGoods);
        this.setCategoriesGoods(categoriesGoods);
        this.setSum(sum);
    }

    public GoodsStock(int id, String name, TypeGoods typeGoods, CategoriesGoods categoriesGoods, int sum, Date date) {
        this.setId(id);
        this.setName(name);
        this.setTypeGoods(typeGoods);
        this.setCategoriesGoods(categoriesGoods);
        this.setSum(sum);
        this.setDate(date);
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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public TypeGoods getTypeGoods() {
        return typeGoods;
    }

    public void setTypeGoods(TypeGoods typeGoods) {
        this.typeGoods = typeGoods;
    }

    public CategoriesGoods getCategoriesGoods() {
        return categoriesGoods;
    }

    public void setCategoriesGoods(CategoriesGoods categoriesGoods) {
        this.categoriesGoods = categoriesGoods;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.id + ", Наименование: " + this.name + ", тип: " + this.typeGoods + ", категория: " + this.categoriesGoods + ", цена: " + this.sum;
    }

}
