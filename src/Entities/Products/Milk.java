package Entities.Products;

import Entities.AbstractGoods;

/**
 * Created by Scala on 23.11.2016.
 */
public class Milk extends AbstractGoods {

    public Milk(Enum categories) {
        super(categories);
        setName("Milk");
    }
}
