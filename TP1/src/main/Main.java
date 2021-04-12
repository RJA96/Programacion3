package main;

import service.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Service service = new Service();
        List<Integer> list =
                new ArrayList<>();
        System.out.println("test 1, umbral: 10");
        service.testDoble(list, 10);
        System.out.println();
        list = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        System.out.println("test 2, umbral: 10");
        service.testDoble(list, 10);
        System.out.println();

        System.out.println("test 3, umbral: 2");
        service.testDoble(list, 2);
        System.out.println();

        list =
                new ArrayList<>() {
                    {
                        add(3);
                        add(5);
                        add(2);
                        add(7);
                        add(19);
                        add(14);
                        add(28);
                    }
                };
        System.out.println("test 4, umbral: 10");
        service.testDoble(list, 10);
        System.out.println();

        list =
                new ArrayList<>() {
                    {
                        add(3);
                        add(5);
                        add(4);
                        add(2);
                        add(7);
                        add(15);
                        add(14);
                        add(28);
                    }
                };
        System.out.println("test 5, umbral: 15");
        service.testDoble(list, 15);
        System.out.println();

        System.out.println("remover primer elemento");
        service.removeFirstElement(list);
        System.out.println();

        System.out.println("encontrar elemento index 3");
        System.out.println(service.getIndex(list,3));

    }

}
