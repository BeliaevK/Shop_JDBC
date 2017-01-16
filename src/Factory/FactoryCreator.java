package Factory;

import Entities.GoodsStock;
import Factory.ItemFactory.AbstractGoodsFactory;
import Factory.ItemFactory.ClothesFactory;
import Factory.ItemFactory.ElectronicsFactory;
import Factory.ItemFactory.ProductsFactory;

/**
 * Created by Scala on 20.11.2016.
 */
public class FactoryCreator {

    private AbstractGoodsFactory clothesFactory = new ClothesFactory();
    private AbstractGoodsFactory productsFactory = new ProductsFactory();
    private AbstractGoodsFactory electronicsFactory = new ElectronicsFactory();

    public AbstractGoodsFactory getFactory(GoodsStock.TypeGoods typeGoods) {
        if(GoodsStock.TypeGoods.PRODUCTS.equals(typeGoods))
            return productsFactory;
        else if(GoodsStock.TypeGoods.CLOTHES.equals(typeGoods))
            return clothesFactory;
        else if(GoodsStock.TypeGoods.ELECTRONICS.equals(typeGoods))
            return electronicsFactory;
        return null;
    }
}
