package ua.bu;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {


        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i <= 125; i++) {
            integerList.add(i);
        }

        int id = 1;
        int step = 20;


        if (!integerList.isEmpty()) {
            int size = integerList.size();
            if (size < id * step) {
                System.out.println(integerList.subList(integerList.size() / step * step, integerList.size() / step * step + integerList.size() % step).toString());

            } else if (size > (id + 1) * step) {

                System.out.println(integerList.subList(id * step, (id + 1) * step).toString());

            } else {
                System.out.println(integerList.subList(id * step, size).toString());


            }
        }
    }

}
