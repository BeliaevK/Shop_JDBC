package Entities.Electronics;

import Entities.AbstractGoods;

/**
 * Created by Scala on 23.11.2016.
 */
public class Tv extends AbstractGoods    {

        public Tv(Enum categories) {
        super(categories);
        setName("TV");
    }
}
