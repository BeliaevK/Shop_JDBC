package Factory.ItemFactory;

import Entities.AbstractGoods;
import Entities.Electronics.Console;
import Entities.Electronics.Tv;
import Entities.GoodsStock;

/**
 * Created by Scala on 21.11.2016.
 */
public class ElectronicsFactory implements AbstractGoodsFactory {
    @Override
    public AbstractGoods createGoods(GoodsStock.CategoriesGoods categoriesGoods) {
        if(GoodsStock.CategoriesGoods.TV.equals(categoriesGoods))
            return new Tv(categoriesGoods);
        else if(GoodsStock.CategoriesGoods.CONSOLE.equals(categoriesGoods))
            return new Console(categoriesGoods);
        else return null;

    }
}
