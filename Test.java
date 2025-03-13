import spiski.Spisok;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        // Добавление страниц
        ArrayList<String> lists1 = new ArrayList<String>();
        lists1.add("TUPE");
        lists1.add("DOMA");
        lists1.add("dOLa");
        lists1.add("Makaaks");
        lists1.add("E");
        Spisok hercules = new Spisok();
        hercules.addPage("Biryuk", lists1);
        lists1.remove("TUPE");
        hercules.addPage("Kirill", lists1);
        ArrayList<String> lists2 = new ArrayList<String>();
        hercules.addPage("Geroge", lists2);

        // Вывод списка страниц
        hercules.vyvodSpiska();

        // Вывод слов для поиска по странице
        hercules.vyvodAssoc("Biryuk");

        // Вывод страниц без слов для поиска
        hercules.vyvodNeAssoc();

        //hercules.vyvodMaxAssoc();

        // Страницы с совпадением чётности букв и слов
        hercules.sovpcChyot();

        // Первая страница с самым длинным словом
        hercules.maxDlina();

        // Топ-3 самых посещаемых страниц
        hercules.threePopular();

    }
}