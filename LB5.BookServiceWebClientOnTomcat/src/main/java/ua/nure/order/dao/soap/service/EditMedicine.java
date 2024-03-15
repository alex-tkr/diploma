
package ua.nure.order.dao.soap.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.order.dao.soap.Medicine;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editMedicine", propOrder = {
    "id",
    "medicine"
})
public class EditMedicine {

    @XmlElement(namespace = "")
    protected int id;
    @XmlElement(name = "Medicine", namespace = "http://it.nure.ua/medicine")
    protected Medicine medicine;

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine value) {
        this.medicine = value;
    }

}
