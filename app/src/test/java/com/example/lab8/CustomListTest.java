package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

    @Test
    void testDelete() {
        CustomList list = new CustomList(null, cityList);
        assertEquals(0, list.getCount());
        City city = new City("Toronto", "Ontario");
        list.addCity(city);
        assertEquals(1, list.getCount());
        assertEquals(true, list.hasCity(city));
        list.delete(city);
        assertEquals(0, list.getCount());
        assertEquals(false, list.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Montreal", "Quebec");
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(city); });
    }

    @Test
    void testCountCities() {
        CustomList list = new CustomList(null, cityList);
        assertEquals(0, list.countCities());
        City city = new City("Ottawa", "Ontario");
        list.addCity(city);
        assertEquals(1, list.countCities());
        City city2 = new City("Kingston", "Ontario");
        list.addCity(city2);
        assertEquals(2, list.countCities());
        list.delete(city2);
        assertEquals(1, list.countCities());
    }


}
