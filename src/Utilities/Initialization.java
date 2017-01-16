package Utilities;

import Entities.GoodsStock;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;

/**
 * Created by Scala on 20.11.2016.
 */
public class Initialization {
    private static Initialization instance;

    public static Initialization getInstance() {
        if (instance == null) {
            instance = new Initialization();
        }
        return instance;
    }

    public static ArrayList<GoodsStock> initShopGoodsStockArray() {
        ArrayList<GoodsStock> shopGoodsStockArray = new ArrayList<>();
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Батон 'Нарезной'" , GoodsStock.TypeGoods.PRODUCTS, GoodsStock.CategoriesGoods.BREAD,20));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Молоко 'Простоквашино'" , GoodsStock.TypeGoods.PRODUCTS, GoodsStock.CategoriesGoods.MILK,30));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Куртка 'Бейн'" , GoodsStock.TypeGoods.CLOTHES, GoodsStock.CategoriesGoods.OUTERWEAR,5500));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Nintendo" , GoodsStock.TypeGoods.ELECTRONICS, GoodsStock.CategoriesGoods.CONSOLE, 3600));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Sony PlayStation 4" , GoodsStock.TypeGoods.ELECTRONICS, GoodsStock.CategoriesGoods.CONSOLE, 30000));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Пицца 'Ristorante'" , GoodsStock.TypeGoods.PRODUCTS, GoodsStock.CategoriesGoods.PIZZA,500));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Футболка 'Avengers'" , GoodsStock.TypeGoods.CLOTHES, GoodsStock.CategoriesGoods.TSHIRT,400));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Шорты 'Nike'" , GoodsStock.TypeGoods.CLOTHES, GoodsStock.CategoriesGoods.SHORTS,1250));
        shopGoodsStockArray.add(new GoodsStock(IdGenerator.nextId(), "Телевизор 'Sony'" , GoodsStock.TypeGoods.CLOTHES, GoodsStock.CategoriesGoods.TV,1250));
        return shopGoodsStockArray;
    }

    public static ArrayList<GoodsStock> initBasketGoodsStockArray() {
        ArrayList<GoodsStock> basketGoodsStockArray = new ArrayList<>();
        return basketGoodsStockArray;
    }

    public static void readFile(ArrayList<GoodsStock> shopGoodsStockArray,ArrayList<GoodsStock> basketGoodsStockArray) throws IOException {
        FileReader shopRead = new FileReader("shop.txt");
        FileReader basketRead = new FileReader("basket.txt");
        shopRead.read(CharBuffer.wrap(String.valueOf(shopGoodsStockArray)));
        shopRead.close();
        basketRead.read(CharBuffer.wrap(String.valueOf(shopGoodsStockArray)));
        basketRead.close();
    }
    public static void writeFile(ArrayList<GoodsStock> shopGoodsStockArray,ArrayList<GoodsStock> basketGoodsStockArray) throws IOException {
        FileWriter shopWrite = new FileWriter("shop.txt");
       FileWriter basketWrite = new FileWriter("basket.txt");
        shopWrite.write(String.valueOf(shopGoodsStockArray));
        shopWrite.close();
       basketWrite.write(String.valueOf(shopGoodsStockArray));
        basketWrite.close();
    }
}
