package ru.job4j.collection;

import java.util.Comparator;

public class JobSortByNameAsc implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
