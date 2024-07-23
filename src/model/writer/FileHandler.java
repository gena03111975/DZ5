package model.writer;


import java.io.*;

public class FileHandler implements Writer {
    // Поле для хранения пути к файлу
    private String filePath = "src/model.writer/testFiles/testTree.out";

    // Метод для сохранения объекта в файл
    @Override
    public void save(Serializable serializable) {
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // Записываем объект в файл
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения объекта из файла
    @Override
    public Object read() {
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            // Читаем объект из файла
            Object o = objectInputStream.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Метод для установки пути к файлу
    @Override
    public void setPath(String path) {
        filePath = path;
    }
}