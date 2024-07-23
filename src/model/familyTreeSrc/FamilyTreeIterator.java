package model.familyTreeSrc;


import java.util.Iterator;
import java.util.List;

// сделал класс параметризированным и изменил типы в методах \\
public class FamilyTreeIterator<T> implements Iterator<T> {
    private int currentId;
    private List<T> people;

    public FamilyTreeIterator(List<T> people) {
        this.people = people;
    }

    // Метод проверки, есть ли следующий элемент в списке
    @Override
    public boolean hasNext() {
        return currentId < people.size();
    }

    // Метод для получения следующего элемента в списке
    @Override
    public T next() {
        return people.get(currentId++);
    }
}