package model.person;

import model.familyTreeSrc.ItemFamilyTree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, ItemFamilyTree<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    /**
     * Создание Human.Human с учетом родителей
     *
     * @param name Имя человека
     * @param gender Пол человека
     * @param birthDate Дата рождения
     */
    public Human(String name, Gender gender, LocalDate birthDate) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    public int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Integer getChildrenQuantity() {
        return children.size();
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    // Add
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", Имя: ");
        sb.append(name);
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        if (deathDate != null) {
            sb.append(", Дата смерти: ");
            sb.append(getDeathDate());
        }
        return sb.toString();
    }

    public String getSpouseInfo() {
        String res = "Супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res = "Мать: Unknown";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res = "Отец: Unknown";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("Отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }
}