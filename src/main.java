import Entities.GoodsStock;
import Utilities.Initialization;
import Utilities.Serial;
import Utilities.StringReader;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Scala on 20.11.2016.
 */
public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("C:\Program Files (x86)\Java\jdk1.8.0_77\lib");
        }
        String basket = "src\\tmp\\basket.txt";
        ArrayList<GoodsStock> shopGoodsStockArray = Initialization.getInstance().initShopGoodsStockArray();
        ArrayList<GoodsStock> basketGoodsStockArray = Serial.readFile(basket);
/*        for (int i = 0; i < shopGoodsStockArray.size(); i++) {
            System.out.println(shopGoodsStockArray.get(i));
        }*/
        while (true) {
            System.out.println("Введите запрос. Пример: \nb - купить товар, r - список товаров,с - добавить " +
                    "товар, u - обновить информацию о товаре, d - удалить товар, i - просмотреть товар.");
            StringReader.getInstance().orderRead(shopGoodsStockArray,basketGoodsStockArray);
            Serial.writeFile(basket, basketGoodsStockArray);
        }
    }
}