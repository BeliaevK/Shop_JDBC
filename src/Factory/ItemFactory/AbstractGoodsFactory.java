package Factory.ItemFactory;

import Entities.AbstractGoods;
import Entities.GoodsStock;

/**
 * Created by Scala on 20.11.2016.
 */
public interface AbstractGoodsFactory {

    AbstractGoods createGoods(GoodsStock.CategoriesGoods categoriesGoods);

}
