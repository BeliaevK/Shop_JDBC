package Entities;

import Utilities.IdGenerator;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by k.beliaev on 30.11.2016.
 */
public class OperationDispatcher {

    private static OperationDispatcher instance;

    public static OperationDispatcher getInstance() {
        if (instance == null) {
            instance = new OperationDispatcher();
        }
        return instance;
    }

    public ArrayList<GoodsStock> createRecord(ArrayList<GoodsStock> homeAccountingArrayList) throws IOException {
        ConsoleDispatcher.sendMessage(Messages.MSG_REQUEST_PRODUCT_INFO);
        String[] recordField = ConsoleDispatcher.readLine().split("\\|");
        if (checkOrderFieldsIsCorrect(recordField)) {
            homeAccountingArrayList.add(new GoodsStock(IdGenerator.nextId(), recordField[0],
                    GoodsStock.TypeGoods.valueOf(recordField[1]), GoodsStock.CategoriesGoods.valueOf(recordField[2]),
                    Integer.parseInt(recordField[3])));
        } else {
            System.out.println("Неверный формат записи. Пример: \n Наименование | Тип | Категория | Цена");
        }
        return homeAccountingArrayList;
    }

    public void deleteForIdRecord(ArrayList<GoodsStock> shopArrayList,ArrayList<GoodsStock> basketArrayList) throws IOException {
        System.out.println("Удаление товара: shop - в магазине, basket - из корзины");
        String recordField = ConsoleDispatcher.readLine();
        if (checkStringFieldsIsCorrect(recordField)) {
            System.out.println("Укажите идентификатор для удаления записи");
            try {
                int id = Integer.parseInt(ConsoleDispatcher.readLine());
                switch (recordField) {
                    case "shop":
                        for (int i = 0; i < shopArrayList.size(); i++) {
                            if (id == shopArrayList.get(i).getId()) {
                                ConsoleDispatcher.sendMessage(Messages.MSG_DELETE_FROM_SHOP + shopArrayList.get(i));
                                shopArrayList.remove(i);
                            }
                        }
                        break;
                    case "basket":
                        for (int i = 0; i < basketArrayList.size(); i++) {
                            if (id == basketArrayList.get(i).getId()) {
                                ConsoleDispatcher.sendMessage(Messages.MSG_DELETE_FROM_BASKET + basketArrayList.get(i));
                                shopArrayList.add(basketArrayList.get(i));
                                basketArrayList.remove(i);
                            }
                        }
                        break;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ConsoleDispatcher.sendMessage(Messages.MSG_WRONG_ID);
            }
        }
    }

    public void readRecord(ArrayList<GoodsStock> shopArrayList, ArrayList<GoodsStock> basketArrayList) throws IOException {
        System.out.println("Вывод списка: shop - вывести все товары магазина, basket -  вывести все товары корзины");
        String recordField = ConsoleDispatcher.readLine();
        if (checkStringFieldsIsCorrect(recordField)) {
            switch (recordField) {
                case "shop":
                    shopArrayList.forEach(System.out::println);
                    break;
                case "basket":
                    basketArrayList.forEach(System.out::println);
                    break;
            }
        } else {
            System.out.println("Неверный формат записи. Пример: \n shop - вывести все товары магазина, basket -  вывести все товары корзины");
        }
    }

    public void findAllRecord(ArrayList<GoodsStock> goodsStockArrayList) throws IOException {
        goodsStockArrayList.forEach(System.out::println);
    }

    public void findForIdRecord(ArrayList<GoodsStock> goodsStockArrayList) throws IOException {
        int recordField = Integer.parseInt(ConsoleDispatcher.readLine());
        for (GoodsStock aGoodsStockArrayList : goodsStockArrayList) {
            if (recordField == aGoodsStockArrayList.getId())
                System.out.println(aGoodsStockArrayList);
        }
    }

    private static boolean checkStringFieldsIsCorrect(String recordField) {
        boolean isCorrect = false;
        if (recordField.equals("shop") || recordField.equals("basket")) isCorrect = true;
        return isCorrect;
    }

    private static boolean checkIntFieldsIsCorrect(int recordField) {
        boolean isCorrect = false;
        if (recordField == 0) isCorrect = true;
        return isCorrect;
    }

    private static boolean checkOrderFieldsIsCorrect(String[] recordField) {
        boolean isCorrect = true;
        if (recordField.length < 4 || recordField.length > 4) isCorrect = false;
        return isCorrect;
    }

    public ArrayList<GoodsStock> updateForIdRecord(ArrayList<GoodsStock> goodsStockArrayList) throws IOException {
        System.out.println("Укажите идентификатор для редактирования записи");
        int recordField = Integer.parseInt(ConsoleDispatcher.readLine());
        for (int i = 0; i < goodsStockArrayList.size(); i++) {
            if (recordField == goodsStockArrayList.get(i).getId()) {
                System.out.println("Введите: Наименование | Тип | Категория | Цена");
                String[] updateField = ConsoleDispatcher.readLine().split("\\|");
                if (checkStringUpdateFieldsIsCorrect(updateField)) {
                    goodsStockArrayList.set(i, new GoodsStock(goodsStockArrayList.get(i).getId(), updateField[0], GoodsStock.TypeGoods.valueOf(updateField[1]),
                            GoodsStock.CategoriesGoods.valueOf(updateField[2]), Integer.parseInt(updateField[3])));
                }
            }
        }
        return goodsStockArrayList;
    }

    private static boolean checkStringUpdateFieldsIsCorrect(String[] readLine) {
        boolean isCorrect = false;
        if (!readLine[0].equals("") || !readLine[1].equals("") || !readLine[2].equals("")|| !readLine[3].equals("")) isCorrect = true;
        return isCorrect;
    }

    public void buyGoods(ArrayList<GoodsStock> shopArrayList, ArrayList<GoodsStock> basketArrayList) throws IOException {
        System.out.println("Укажите идентификатор для покупки товара");
        try {
            int id = Integer.parseInt(ConsoleDispatcher.readLine());
            for (int i = 0; i < shopArrayList.size(); i++) {
                if (id == shopArrayList.get(i).getId()) {
                    ConsoleDispatcher.sendMessage(Messages.MSG_BUY_FROM_BASKET + shopArrayList.get(i));
                    basketArrayList.add(shopArrayList.get(i));
                    shopArrayList.remove(i);
                }
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            ConsoleDispatcher.sendMessage(Messages.MSG_WRONG_ID);
        }
    }

    public void viewImage (ArrayList<GoodsStock> shopArrayList, ArrayList<GoodsStock> basketArrayList) throws IOException {
        System.out.println("Просмотр товара: shop - в магазине, basket - из корзины");
        String recordField = ConsoleDispatcher.readLine();
        if (checkStringFieldsIsCorrect(recordField)) {
            System.out.println("Укажите идентификатор записи для просмотра товара");
            try {
                int id = Integer.parseInt(ConsoleDispatcher.readLine());
                switch (recordField) {
                    case "shop":
                        for (int i = 0; i < shopArrayList.size(); i++) {
                            if (id == shopArrayList.get(i).getId()) {
                            new ProcessBuilder("mspaint",  "src\\tmp\\" + shopArrayList.get(i).getId() + ".jpg").start();
                            }
                        }
                        break;
                    case "basket":
                        for (int i = 0; i < basketArrayList.size(); i++) {
                            if (id == basketArrayList.get(i).getId()) {
                            new ProcessBuilder("mspaint", "src\\tmp\\" + basketArrayList.get(i).getId() + ".jpg").start();
                            }
                        }
                        break;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ConsoleDispatcher.sendMessage(Messages.MSG_WRONG_ID);
            }
        }
    }
}
