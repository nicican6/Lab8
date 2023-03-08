package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private ArrayList<City> cityList = new ArrayList<>();

    @Test
    public void testAddCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(1,list.getCount());
    }

    @Test
    void testHasCity() {
        CustomList list = new CustomList(null, cityList);
        assertEquals(0,list.getCount());
        City city = new City("Winnipeg", "Manitoba");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
        City city2 = new City("Markham", "Ontario");
        assertEquals(false, list.hasCity(city2));
    }




}
