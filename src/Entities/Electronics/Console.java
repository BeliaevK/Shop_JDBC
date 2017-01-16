package Entities.Electronics;

import Entities.AbstractGoods;

/**
 * Created by Scala on 23.11.2016.
 */
public class Console extends AbstractGoods {

    public Console(Enum categories) {
        super(categories);
        setName("Console");
    }
}
