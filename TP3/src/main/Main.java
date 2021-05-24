package main;

import utils.Ciudad;
import utils.Mapa;

public class Main {

    public static void main(String[] args) {
        Ciudad pehuajo = new Ciudad(1, "Pehuajo", 3, true, true, 5);
        Ciudad ayacucho = new Ciudad(2, "Ayacucho", 1, false, false, 2);
        Ciudad olavarria = new Ciudad(3, "Olavarria", 9, true, false, 17);
        Ciudad rauch = new Ciudad(4, "Rauch", 1, false, true, 0);
        Ciudad bolivar = new Ciudad(5, "Bolivar", 7, false, false, 4);
        Ciudad tandil = new Ciudad(6, "Tandil", 6, true, true, 5);
        Ciudad azul = new Ciudad(7, "Azul", 4, false, true, 4);
        Ciudad marDelPlata = new Ciudad(8, "Mar del plata", 15, true, false, 12);

        Mapa mapa = new Mapa();
        mapa.addCiudad(pehuajo);
        mapa.addCiudad(ayacucho);
        mapa.addCiudad(olavarria);
        mapa.addCiudad(rauch);
        mapa.addCiudad(bolivar);
        mapa.addCiudad(tandil);
        mapa.addCiudad(azul);
        mapa.addCiudad(marDelPlata);

        mapa.addRuta(azul, bolivar, 100);
        mapa.addRuta(bolivar, olavarria, 140);
        mapa.addRuta(tandil, olavarria, 130);
        mapa.addRuta(bolivar, pehuajo, 70);
        mapa.addRuta(pehuajo, ayacucho, 540);
        mapa.addRuta(ayacucho, tandil, 70);
        mapa.addRuta(ayacucho, rauch, 50);
        mapa.addRuta(rauch, tandil, 60);
        mapa.addRuta(rauch, olavarria, 210);
        mapa.addRuta(tandil, marDelPlata, 200);

        System.out.println(mapa.encontrarCamino(azul, ayacucho, 1) + "\n");
        System.out.println(mapa.encontrarCamino(rauch, marDelPlata, 1) + "\n");
        System.out.println(mapa.encontrarCamino(marDelPlata, pehuajo, 1) + "\n");
        mapa.borrarCiudad(ayacucho);
        mapa.borrarRuta(tandil, rauch);
        System.out.println(mapa.encontrarCamino(marDelPlata, pehuajo, 1) + "\n");

    }
}
