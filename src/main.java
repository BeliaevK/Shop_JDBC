import Entities.GoodsStock;
import Utilities.Initialization;
import Utilities.MyResourseBundle;
import Utilities.Serial;
import Utilities.StringReader;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Scala on 20.11.2016.
 */
public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            con = DriverManager.getConnection(MyResourseBundle.getConnection().getString("url"), MyResourseBundle.getConnection().getString("name"), MyResourseBundle.getConnection().getString("password"));
            System.out.println("Соединение установлено");
            Statement st = con.createStatement();
        } catch (Exception e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
                }
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
                StringReader.getInstance().orderRead(shopGoodsStockArray, basketGoodsStockArray);
                Serial.writeFile(basket, basketGoodsStockArray);
            }
        }
    }
}
