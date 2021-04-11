package main;

import service.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Service service = new Service();
        List<Integer> list =
                new ArrayList<Integer>() {
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
        service.testDoble(list, 10);
    }

}
