package Factory.ItemFactory;

import Entities.AbstractGoods;
import Entities.Clothes.Outerwear;
import Entities.Clothes.Shorts;
import Entities.Clothes.Tshirt;
import Entities.GoodsStock;

/**
 * Created by Scala on 21.11.2016.
 */
public class ClothesFactory implements AbstractGoodsFactory {

    @Override
    public AbstractGoods createGoods(GoodsStock.CategoriesGoods categoriesGoods) {
        if(GoodsStock.CategoriesGoods.SHORTS.equals(categoriesGoods))
            return new Shorts(categoriesGoods);
        else if(GoodsStock.CategoriesGoods.TSHIRT.equals(categoriesGoods))
            return new Tshirt(categoriesGoods);
        else if(GoodsStock.CategoriesGoods.OUTERWEAR.equals(categoriesGoods))
            return new Outerwear(categoriesGoods);
        else return null;
    }
}
