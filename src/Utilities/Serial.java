package Utilities;

import Entities.GoodsStock;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by k.beliaev on 05.12.2016.
 */
public class Serial {

    public static void writeFile(String fileName,ArrayList<GoodsStock> goodsStockArrayList) {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(goodsStockArrayList);
            objectOutputStream.close();
            outputStream.close();
            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            while (inputStream.available() > 0) {
                goodsStockArrayList = (ArrayList<GoodsStock>) objectInputStream.readObject();
               // System.out.println(goodsStockArrayList);
            }
            inputStream.close();
            objectInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<GoodsStock> readFile(String fileName) {
        ArrayList<GoodsStock> goodsStockArrayList = null;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            while (inputStream.available() > 0) {
                goodsStockArrayList = (ArrayList<GoodsStock>) objectInputStream.readObject();
             //   System.out.println(goodsStockArrayList);
            }
            inputStream.close();
            objectInputStream.close();
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(goodsStockArrayList);
            objectOutputStream.close();
            outputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return goodsStockArrayList;
    }
}