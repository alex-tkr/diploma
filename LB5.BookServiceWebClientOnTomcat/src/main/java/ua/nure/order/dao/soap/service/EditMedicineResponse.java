
package ua.nure.order.dao.soap.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editMedicineResponse", propOrder = {
    "_return"
})
public class EditMedicineResponse {

    @XmlElement(name = "return", namespace = "http://it.nure.ua/medicine", required = true, nillable = true)
    protected Object _return;

    public Object getReturn() {
        return _return;
    }

    public void setReturn(Object value) {
        this._return = value;
    }

}
