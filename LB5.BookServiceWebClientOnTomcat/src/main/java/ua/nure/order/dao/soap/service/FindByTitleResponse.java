
package ua.nure.order.dao.soap.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByTitleResponse", propOrder = {
    "_return"
})
public class FindByTitleResponse {

    @XmlElement(name = "return", namespace = "http://it.nure.ua/medicine", nillable = true)
    protected ua.nure.order.dao.soap.Medicines _return;

    public ua.nure.order.dao.soap.Medicines getReturn() {
        return _return;
    }

    public void setReturn(ua.nure.order.dao.soap.Medicines value) {
        this._return = value;
    }

}
