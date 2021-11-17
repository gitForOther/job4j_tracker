package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenJobSortByNameAsc() {
        List<Job> actual = new ArrayList<>();
        Job one = new Job("Помыть руки", 1);
        Job two = new Job("Пообедать", 1);
        Job three = new Job("Вымыть посуду", 2);
        actual.add(one);
        actual.add(two);
        actual.add(three);
        actual.sort(new JobSortByNameAsc());
        List<Job> expected = new ArrayList<>();
        expected.add(three);
        expected.add(one);
        expected.add(two);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void whenJobSortByNameDecs() {
        List<Job> actual = new ArrayList<>();
        Job one = new Job("Помыть руки", 1);
        Job two = new Job("Пообедать", 1);
        Job three = new Job("Вымыть посуду", 2);
        actual.add(one);
        actual.add(two);
        actual.add(three);
        actual.sort(new JobSortByNameDesc());
        List<Job> expected = new ArrayList<>();
        expected.add(two);
        expected.add(one);
        expected.add(three);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void whenJobSortByPriorityDecs() {
        List<Job> actual = new ArrayList<>();
        Job one = new Job("Помыть руки", 1);
        Job two = new Job("Пообедать", 2);
        Job three = new Job("Вымыть посуду", 3);
        actual.add(one);
        actual.add(two);
        actual.add(three);
        actual.sort(new JobSortByPriorityDesc());
        List<Job> expected = new ArrayList<>();
        expected.add(three);
        expected.add(two);
        expected.add(one);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void whenJobSortByPriorityAcs() {
        List<Job> actual = new ArrayList<>();
        Job one = new Job("Помыть руки", 1);
        Job two = new Job("Пообедать", 2);
        Job three = new Job("Вымыть посуду", 3);
        actual.add(one);
        actual.add(two);
        actual.add(three);
        actual.sort(new JobSortByPriorityAsc());
        List<Job> expected = new ArrayList<>();
        expected.add(one);
        expected.add(two);
        expected.add(three);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void whenJobSortByPriorityAcsAndNameAsc() {
        List<Job> actual = new ArrayList<>();
        Job one = new Job("Помыть руки", 1);
        Job two = new Job("Пообедать", 2);
        Job three = new Job("Вымыть посуду", 2);
        actual.add(one);
        actual.add(two);
        actual.add(three);
        actual.sort(new JobSortByPriorityAsc().thenComparing(new JobSortByNameAsc()));
        List<Job> expected = new ArrayList<>();
        expected.add(one);
        expected.add(three);
        expected.add(two);
        Assert.assertEquals(actual, expected);
    }
}