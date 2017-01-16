package Entities.Products;

import Entities.AbstractGoods;

/**
 * Created by Scala on 23.11.2016.
 */
public class Pizza extends AbstractGoods {

    public Pizza(Enum categories) {
        super(categories);
        setName("Pizza");
    }
}
