
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Descriptions", propOrder = {
    "description"
})
public class Descriptions {

    protected List<Description> description;

    public List<Description> getDescription() {
        if (description == null) {
            description = new ArrayList<Description>();
        }
        return this.description;
    }

    @Override
    public String toString() {
        return "Descriptions{" +
                "description=" + description +
                '}';
    }
}
