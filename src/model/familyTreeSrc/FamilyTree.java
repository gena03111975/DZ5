package model.familyTreeSrc;

import model.person.comparators.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// сделал класс параметризированным и изменил соответственно типы в методах
public class FamilyTree<E extends ItemFamilyTree<E>> implements Serializable, Iterable<E> {
    private long peopleId;
    private List<E> people;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> people) {
        this.people = people;
    }

    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        }
        if (!people.contains(human)) {
            people.add(human);
            human.setId(peopleId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getAllChildren(E person) {
        return person.getChildren();
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : people) {
            if (human.getName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorse(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorse(human1, human2);
        }
        return false;
    }

    public boolean setDivorse(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            E human = getById(humanId);
            return people.remove(human);
        }
        return false;
    }

    public E findPersonByName(String name) {
        for (E person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    private boolean checkId(long id) {
        return id < peopleId && id >= 0;
    }

    public E getById(long id) {
        for (E human : people) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    // SORT 3 METHODS \\
    // Добавил дженерики \\
    public void sortByName() {
        people.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthDate() {
        people.sort(new HumanComparatorByAge<>());
    }

    public void sortByChildrenQuantity() {
        people.sort(new HumanComparatorByChildrenQuantity<E>());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("В дереве ");
        res.append(people.size());
        res.append(" объектов: \n");
        for (E human : people) {
            res.append(human);
            res.append("\n");
        }
        return res.toString();
    }

    // ITERATOR \\
    // Изменил итератор \\
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(people);
    }
}