package model.writer;

import java.io.Serializable;

// Интерфейс Writer определяет методы для записи и чтения объектов
public interface Writer {
    void save(Serializable serializable);
    Object read();
    void setPath(String path);
}