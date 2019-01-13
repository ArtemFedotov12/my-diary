package com.start.diary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>(
                Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
        String joinBuilder = strings.stream().collect(
                Collector.of(
                        StringBuilder::new, // метод_инициализации_аккумулятора
                        (b ,s) -> b.append(s).append(" , "), // метод_обработки_каждого_элемента,
                        (b1, b2) -> b1.append(b2).append(" , "), // метод_соединения_двух_аккумуляторов
                        StringBuilder::toString // метод_последней_обработки_аккумулятора
                )
        );

        System.out.println(joinBuilder);


        Collector<String, List<String>, List<String>> toList = Collector.of(
                ArrayList::new, // метод инициализации аккумулятора
                List::add, // метод обработки каждого элемента
                (l1, l2) -> { l1.addAll(l2); return l1; } // метод соединения двух аккумуляторов при параллельном выполнении
        );
// Используем его для получение списка строк без дубликатов из стрима
        List<String> distinct1 = strings.stream().distinct().collect(toList);
        System.out.println(distinct1);
    }
}
