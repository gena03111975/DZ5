package model.person.comparators;

import model.familyTreeSrc.ItemFamilyTree;

import java.util.Comparator;

// сделал класс параметризированным и изменил тип в compare \\
public class HumanComparatorByChildrenQuantity<T extends ItemFamilyTree<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getChildrenQuantity().compareTo(o2.getChildrenQuantity());
    }
}