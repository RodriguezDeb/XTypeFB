package com.example.xtypee;

public class ListData {
    String name;
    String tamano, garage, habitaciones, precio, desc, bano;
    int img;

    public ListData(String name, String tamano, String bano, String garage, String habitaciones, String precio, String desc, int img) {
        this.name = name;
        this.tamano = tamano;
        this.garage = garage;
        this.bano = bano;
        this.habitaciones = habitaciones;
        this.precio = precio;
        this.desc = desc;
        this.img = img;
    }
}
