
package shop.entity;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListWrapper<T> {
    @XmlElementWrapper(name = "items")
    @XmlAnyElement(lax = true)
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
// Constructors, getters, setters...
}
