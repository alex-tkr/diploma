
package ua.nure.order.dao.soap.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.order.dao.soap.Medicine;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMedicineResponse", propOrder = {
    "_return"
})
public class GetMedicineResponse {

    @XmlElement(name = "return", namespace = "http://it.nure.ua/medicine", nillable = true)
    protected Medicine _return;

    public Medicine getReturn() {
        return _return;
    }

    public void setReturn(Medicine value) {
        this._return = value;
    }

}
