## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`

#### Выполнил: `Хамуев Владимир Николаевич`

#### Вариант: `27`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

- Условия задачи

> Система поиска
- Краткое описание
Разработать программу для реализации системы поиска страниц по ключевым словам.
Каждая страница содержит название, массив слов-ассоциаций и счётчик посещений.
Реализовать функции добавления страниц, выполнения поиска, анализа данных и сор-
тировки страниц по заданным критериям.
- Описание функционала
1. Вывод списка страниц
Отображает список всех страниц в формате: «название - количество посещений».

2. Добавление страницы
Добавляет страницу с указанным названием и массивом слов-ассоциаций. Коли-
чество слов-ассоциаций должно быть фиксированным.

3. Вывод слов для поиска по странице
Выводит массив слов-ассоциаций для страницы с указанным названием. Количе-
ство посещений страницы увеличивается.

4. Вывод страниц без слов для поиска
Отображает список страниц, у которых нет слов-ассоциаций для поиска. Увели-
чивает количество посещений для этих страниц.

5. Страницы с максимальным количеством слов-ассоциаций
Выводит список страниц с максимальным количеством слов-ассоциаций в поряд-
ке их добавления. Увеличивает количество посещений для каждой страницы в
списке.

6. Страницы с совпадением чётности букв и слов
Проверяет, есть ли в списке страницы, у которых количество букв в каждом слове-
ассоциации совпадает по чётности с общим количеством слов. Увеличивает коли-
чество посещений для таких страниц.

7. Первая страница с самым длинным словом
Находит и выводит первую страницу, содержащую самое длинное слово среди всех
слов-ассоциаций, и это слово.

8. Поиск самой подходящей страницы
По переданному массиву слов находит и возвращает страницу, которая больше
всего подходит. Подходящей считается страница с максимальным количеством
совпадений слов. Увеличивает количество посещений для найденной страницы.

9. Топ-3 самых посещаемых страниц
Выводит три самые посещаемые страницы. Если у нескольких страниц одинаковое
количество посещений, выводятся первые по порядку добавления. Увеличивает
количество посещений для этих страниц.

10. Поиск наименее подходящих страниц
По переданному массиву слов находит страницы, которые наименее соответствуют
массиву. Наименьшее соответствие определяется количеством слов, которые есть
в одном массиве, но отсутствуют в другом. Возвращает список таких страниц.

Данную задачу можно разделить на 5 подзадач: 
1. Добавление страницы с указанным названием и массивом слов-ассоциаций
2. Сортировка столбцов массива по поставленному критерию
3. Нахождение медианы массива
4. Нахождение количества уникальных элементов массива, с дальнейшим выводом гистограммы их распределения
5. Нормализация элементов массива (их приведение к диапазону от 0 до 1)

- Пусть `E = очередной элемент массива`, тогда для 1 подзадачи нужно рассмотреть 2 случая:
  1. `E >= 0`
  2. `E < 0` (отрицание 1 случая)
- Для 2 подзадачи нужно рассмотреть 3 случая:
  1. Массив отсортирован
  2. Массив не отсортирован, средние арифметические у столбцов разные (отрицание 1 случая)
  3. Массив не отсортирован, средние арифметические у столбцов одинаковые, дисперсия разная (отрицание 1 случая)
- Для 3 подзадачи нужно рассмотреть 2 случая:
  1. Длина массива нечётная
  2. Длина массива чётная
- Для 5 подзадачи нужно рассмотреть 2 случая:
  1. Длина массива больше 1
  2. Длина массива равна 1 (отрицание 1 случая)

Всего надо рассмотреть `3 * 2 * 2 * 2 = 24` случаев.

### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать 2 числа, являющимися размерами массива, то есть целыми положительными числами; помимо этого, программа будет считывать элементы этого массива, при этом в условии сказано, что получаемые числа относятся к дробям, то есть к вещественным числам.

|           | Тип                       | min значение | max значение   |
|-----------|---------------------------|--------------|----------------|
| N (Число) | Целое положительное число | 1            | 10<sup>9</sup> |
| M (Число) | Целое положительное число | 1            | 10<sup>9</sup> |
| X (Число) | Вещественное число        | -1.7*10^308  | +1.7*10^308    |

#### Данные на выход

Программа должна вывести:
- Медиану всех элементов массива
- Гистограмму распределения элементов массива
- Нормализованный массив

Т.к. программа должна вывести медиану элементов массива, являющихся дробями, то есть вещественными силами, то и медиана должна быть вещественным числом.

|         | Тип                | min значение | max значение   |
|---------|--------------------|--------------|----------------|
| Число 1 | Вещественное число | -1.7*10^308  | +1.7*10^308    |


Т.к. программа должна вывести гистограмму распределения элементов массива, то на выход мы получим несколько строк.

|        | Тип    | значение   | значение   |
|--------|--------|------------|------------|
| Строка | Строка | "E #"      | "E "+"#"   |

Т.к. программа должна вывести нормализованный массив, то на выход мы получим строку, содержащую все элементы нормализованного массива.

|        | Тип    | значение   | значение                |
|--------|--------|------------|-------------------------|
| Строка | Строка | "0"        | "Массив размером N × M" |

### 3. Выбор структуры данных

Программа получает 2 натуральных числа, не превышающих 10<sup>9</sup>. Поэтому для их хранения
можно выделить 2 переменных (`n`, `m`) типа `int`.
Также программа получает N × M вещественных чисел, не превышающих по модулю +1.7*10^308. Поэтому для их хранения можно выделить 1 двумерный массив типа `double`.

|             | название переменной     | Тип (в Java)       | 
|-------------|---------====------------|--------------------|
| N (Строка)  | `n`                     | `String`           |
| M (Массив)  | `lists`                 | `ArrayList<String>`|

Для вывода результатов не обязательно их хранить в отдельных переменных.

|            | название переменной | Тип (в Java) | 
|------------|---------------------|--------------|
| Строка     | `s1`                | `String`     |

### 4. Алгоритм

1. **Ввод данных:**  
   Программа считывает 2 целых числа, обозначенных как `n` и `m`.
   Затем программой считываются элементы массива размером N × M, обозначенного `a`.

2. **Вычисление среднего арифметического и дисперсии в столбце:**  
   Программа последовательно вычисляет среднее арифметическое значение и дисперсию элементов в столбце массива `a`.

3. **Сортировка массива:**
   Программа сортирует массив `a` пузырьком так, чтобы он был отсортирован по возрастанию среднего арифметиечского значения или по дисперсии элементов в столбце.

4. **Вывод результата:**  
   На экран выводится значение медианы.

5. **Нахождение количества уникальных элементов массива:**  
   Программа создаёт массив, содержащий уникальные элементы массива `a`, одновременно с этим вычисляя количество этих элементов в массиве `a`.

5. **Вывод гистограммы:**  
   На экран выводится гистограмма распределения элементов массива.

6. **Нормализация элементов массива:**
   Программа построчно изменяет элементы массива `a` приводя их к диапазону от 0 до 1.

7. **Вывод нормализованного массива:**  
   На экран выводится изменённый массив.


### 5. Программа

```markdown
    ```java
        package spiski;

import java.util.*;

public class Spisok{

    private final Map<String, Page> pages = new HashMap<>();

    // Конструктор списка
    public Spisok() {
    }


    // Добавление страницы
    public void addPage(String pagename, List<String> pageassoc){
        Page p = pages.putIfAbsent(pagename, new Page(pagename));
        if(p==null){
            p=pages.get(pagename);
            for(String association : pageassoc){
                p.addassoc(association);
            }
        }
    }
    public void addassoc(String gassoc){
        for (Page page : pages.values()) {
            page.addassoc(gassoc);
        }
    }

    // Вывод списка страниц
    public void vyvodSpiska(){
        for(Page page2 : pages.values()){
            page2.vyvodSpiska();
        }
    }

    // Вывод слов для поиска по странице
    public void vyvodAssoc(String hname){
        pages.get(hname).vyvodAssoc();
    }


    // Вывод страниц без слов для поиска
    public void vyvodNeAssoc(){
        for(Page page1 : pages.values()){
            page1.vyvodNeAssoc();
        }
    }

    //Страницы с максимальным количеством слов-ассоциаций
    public void vyvodMaxAssoc(){
        Page page3 = new Page("barankin");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        System.out.println(page3.vychislsize());
        int maxpower = -1;
        int yer=1;
    }

    // Страницы с совпадением чётности букв и слов
    public void sovpcChyot(){
        for(Page page4 : pages.values()){
            page4.sovpChyot();
        }
    }

    // Страницы с максимальным количеством слов-ассоциаций
    public void maxDlina(){
        int mmax = -2147483648;
        String s1="GERAALD";
        Set<String> key=pages.keySet();
        String s2="";
        Map<String, Page> pages1 = new HashMap<>();
        if(pages.size()>1){
            for(Page page5 : pages.values()){
                if(mmax<page5.maxDlina().length()){
                    mmax=page5.maxDlina().length();
                    s1=page5.maxDlina();
                }
            }
        }
        Page page7 = new Page("");
        for(Page page6 : pages.values()){
            pages1.put(s2, page6);
            if (pages1.containsValue(page6.assocContains(s1)) && !(pages1.containsValue(null))){
                page7=page6;
                break;
            }
        }
        System.out.println(page7.assocContains(s1)+" "+s1);
    }

    public void threePopular(){
        int mmax1=-2147483648;
        int mmax2=-2147483648;
        int mmax3=-2147483648;
        Page page7 = new Page("");
        Page page8 = new Page("");
        Page page9 = new Page("");
        for(Page page10 : pages.values()){
            if(mmax1<page10.countret()){
                mmax1=page10.countret();
                page7 = page10;
            }
            if(mmax2<page10.countret() && mmax2<mmax1){
                mmax2=page10.countret();
                page8 = page10;
            }
            if(mmax3<page10.countret() && mmax3<mmax2 && mmax3 <mmax1){
                mmax3=page10.countret();
                page9 = page10;
            }
        }
    }
}



package spiski;
import java.util.*;
import java.util.List;

class Page {
    private final String name;
    private final List<String> assocs = new ArrayList<>();
    private int count=0;

    // Конструктор страницы
    public Page(String name) {
        this.name = name;
    }

    // Добавление слова-ассоциации на страницу
    public void addassoc(String hassoc){
        assocs.add(hassoc);
    }

    // Вывод списка страниц
    public void vyvodSpiska(){
        System.out.print(name+" - "+count);
        System.out.println();
    }

    // Вывод слов для поиска по странице
    public void vyvodAssoc(){
        for(int i=0;i<assocs.size();i++){
            System.out.println(assocs.get(i));
        }
        count+=1;
    }

    // Вывод страниц без слов для поиска
    public void vyvodNeAssoc(){
        if(assocs.isEmpty()){
            System.out.println(name+" ");
        }
        count+=1;
    }

    public int vychislsize(){
        return assocs.size();
    }

    // Страницы с совпадением чётности букв и слов
    public void sovpChyot(){
        boolean sovp = true;
        for (int i=0; i<assocs.size(); i++){
            if(assocs.size()%2!=0 && assocs.get(i).length()%2==0){
                sovp=false;
            }
            else if(assocs.size()%2==0 && assocs.get(i).length()%2!=0){
                sovp=false;
            }
        }
        if (sovp){
            count+=1;
        }
    }

    // Страницы с максимальным количеством слов-ассоциаций
    public String maxDlina(){
        String s ="";
        int mmax = -1;
        for(int i=0; i<assocs.size(); i++){
            if(mmax<assocs.get(i).length()){
                mmax = assocs.get(i).length();
                s=assocs.get(i);
            }
        }
        return s;
    }

    public List<String> assocContains(String s1){
        List<String> ar = new ArrayList<>();
        if(assocs.contains(s1)){
            ar=assocs;
        }
        return ar;
    }

    public void countplus(){
        count++;
    }

    public int countret(){
        return count;
    }
}


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
    ```
```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на "Длина массива нечётная":

    - **Input**:
        ```
        3 3 1 2 3 4 5 6 7 8 9
        ```

    - **Output**:
        ```
        5
        ```

2. Тест на "Длина массива чётная":

    - **Input**:
        ```
        3 2 -4 -4 -4 -4 0 0
        ```

    - **Output**:
        ```
        -4.0
        ```

3. Тест на "Длина массива больше 1":

    - **Input**:
        ```
        3 2 -4 -4 -4 -4 0 0
        ```

    - **Output**:
        ```
        0.0 0.125 0.25 0.375 0.5 0.625 0.75 0.875 1.0 
        ```

4. Тест на "Длина массива равна 1":

   - **Input**:
       ```
       1 1 1
       ```

   - **Output**:
       ```
       1
       ```
  
7. Тест на ограничение задачи:

    - **Input**:
        ```
        1 1 1000000000
        ```

    - **Output**:
        ```
        1
        ```
