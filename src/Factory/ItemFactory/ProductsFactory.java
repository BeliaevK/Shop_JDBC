package Factory.ItemFactory;

import Entities.AbstractGoods;
import Entities.GoodsStock;
import Entities.Products.Bread;
import Entities.Products.Milk;
import Entities.Products.Pizza;

/**
 * Created by Scala on 21.11.2016.
 */
public class ProductsFactory implements AbstractGoodsFactory {

    @Override
    public AbstractGoods createGoods(GoodsStock.CategoriesGoods categoriesGoods) {
        if(GoodsStock.CategoriesGoods.BREAD.equals(categoriesGoods))
            return new Bread(categoriesGoods);
        else if(GoodsStock.CategoriesGoods.MILK.equals(categoriesGoods))
            return new Milk(categoriesGoods);
        else if(GoodsStock.CategoriesGoods.PIZZA.equals(categoriesGoods))
            return new Pizza(categoriesGoods);
        return null;
    }
}
