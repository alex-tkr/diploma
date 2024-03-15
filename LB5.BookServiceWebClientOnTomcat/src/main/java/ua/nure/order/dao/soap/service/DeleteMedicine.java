
package ua.nure.order.dao.soap.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteMedicine", propOrder = {
    "id"
})
public class DeleteMedicine {

    @XmlElement(namespace = "")
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

}
