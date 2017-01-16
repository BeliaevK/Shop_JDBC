package Utilities;

import Entities.ConsoleDispatcher;
import Entities.GoodsStock;
import Entities.OperationDispatcher;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Scala on 20.11.2016.
 */
public class StringReader {
    private static StringReader instance;

    public static StringReader getInstance() {
        if (instance == null) {
            instance = new StringReader();
        }
        return instance;
    }

    public static void orderRead(ArrayList<GoodsStock> shopArrayList,ArrayList<GoodsStock> basketArrayList) throws IOException {
        String readLine = ConsoleDispatcher.readLine();
        if (checkOrderFieldsIsCorrect(readLine)) {
            switch (readLine) {
                case "b":
                    OperationDispatcher.getInstance().buyGoods(shopArrayList,basketArrayList);
                    break;
                case "c":
                    OperationDispatcher.getInstance().createRecord(shopArrayList);
                    break;
                case "r":
                    OperationDispatcher.getInstance().readRecord(shopArrayList,basketArrayList);
                    break;
                case "u":
                    OperationDispatcher.getInstance().updateForIdRecord(shopArrayList);
                    break;
                case "d":
                    OperationDispatcher.getInstance().deleteForIdRecord(shopArrayList,basketArrayList);
                    break;
                case "i":
                    OperationDispatcher.getInstance().viewImage(shopArrayList,basketArrayList);
                    break;
            }
        } else {
            System.out.println("Неверный запрос. Пример: \n b - купить товар, r - просмотреть список товаров,с - добавить товар u - " +
                    "обновить информацию о товаре, d - удалить товар, i - просмотреть товар.");
        }
    }

    private static boolean checkOrderFieldsIsCorrect(String readLine) {
        boolean isCorrect = false;
        if (readLine.equals("c") || readLine.equals("b")|| readLine.equals("r") || readLine.equals("u") || readLine.equals("d") || readLine.equals("i")) isCorrect = true;
        return isCorrect;
    }
}
