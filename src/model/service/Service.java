package model.service;

import model.builder.HumanBuilder;
import model.familyTreeSrc.FamilyTree;
import model.person.Gender;
import model.person.Human;

import java.time.LocalDate;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;

    public Service() {
        humanBuilder = new HumanBuilder();
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        Human human = humanBuilder.build(name, gender, dateOfBirth);
        familyTree.addHuman(human);
    }

    public void setMother(int idChild, int idMother) {
        Human mother = familyTree.getById(idMother);
        Human child = familyTree.getById(idChild);
        child.setMother(mother);
    }

    public void setFather(int idChild, int idFather) {
        Human father = familyTree.getById(idFather);
        Human child = familyTree.getById(idChild);
        child.setMother(father);
    }

    public void addChildToParent(int idParent, int idChild) {
        Human parent = familyTree.getById(idParent);
        Human child = familyTree.getById(idChild);
        parent.addChild(child);
    }

    public void setDateOfDeath(int idHuman, LocalDate dateOfDeath) {
        Human human = familyTree.getById(idHuman);
        human.setDeathDate(dateOfDeath);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByBirthDate();
    }

    public void sortByChildrenQuantity() {
        familyTree.sortByChildrenQuantity();
    }

    public void setWedding(long humanId1, long humanId2) {
        familyTree.setWedding(humanId1, humanId2);
    }

    public String getHumansListInfo() {
        String result = "Информация о древе:\n";
        return result + familyTree.getInfo();
    }

    public Human getHumanById(long idHuman) {
        return familyTree.getById(idHuman);
    }

    public String getAge(long idHuman) {
        return Integer.toString(familyTree.getById(idHuman).getAge());
    }
}