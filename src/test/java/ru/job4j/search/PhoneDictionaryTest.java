package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("tr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}