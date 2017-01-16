package Utilities;

import Entities.AbstractGoods;
import Entities.GoodsStock;
import Factory.FactoryCreator;
import Factory.ItemFactory.AbstractGoodsFactory;

/**
 * Created by Scala on 23.11.2016.
 */
public class Shop {

    private FactoryCreator factoryCreator;


    public Shop (FactoryCreator factoryCreator) {
        this.setFactoryCreator(factoryCreator);
    }

    private AbstractGoodsFactory factory;
    public AbstractGoods payGoods(GoodsStock.TypeGoods typeGoods, GoodsStock.CategoriesGoods categoriesGoods) {
        factory = getFactoryCreator().getFactory(typeGoods);

        return factory.createGoods(categoriesGoods);
    }

    public FactoryCreator getFactoryCreator() {
        return factoryCreator;
    }

    public void setFactoryCreator(FactoryCreator factoryCreator) {
        this.factoryCreator = factoryCreator;
    }
}
