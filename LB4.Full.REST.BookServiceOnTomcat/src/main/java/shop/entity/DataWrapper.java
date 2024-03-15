package shop.entity;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataWrapper<T> {

    public DataWrapper() {
    }

    public DataWrapper(T item) {
        this.item = item;
    }

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
    // Constructors, getters, setters...
}
