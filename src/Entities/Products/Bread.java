package Entities.Products;

import Entities.AbstractGoods;

/**
 * Created by Scala on 23.11.2016.
 */
public class Bread extends AbstractGoods {

    public Bread(Enum categories) {
        super(categories);
        setName("Bread");
    }
}
