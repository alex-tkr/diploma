
package ua.nure.order.dao.soap;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _Medicine_QNAME = new QName("http://it.nure.ua/medicine", "Medicine");
    private final static QName _Return_QNAME = new QName("http://it.nure.ua/medicine", "return");

    public ObjectFactory() {
    }

    public Medicine createMedicine() {
        return new Medicine();
    }


    public Medicines createMedicines() {
        return new Medicines();
    }

    public Entity createEntity() {
        return new Entity();
    }


    public Images createImages() {
        return new Images();
    }


    public Image createImage() {
        return new Image();
    }


    public Pharmacist createPharmacist() {
        return new Pharmacist();
    }


    public Description createDescription() {
        return new Description();
    }


    public Descriptions createDescriptions() {
        return new Descriptions();
    }


    @XmlElementDecl(namespace = "http://it.nure.ua/medicine", name = "Medicine")
    public JAXBElement<Medicine> createMedicine(Medicine value) {
        return new JAXBElement<Medicine>(_Medicine_QNAME, Medicine.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/Medicine", name = "return")
    public JAXBElement<Object> createReturn(Object value) {
        return new JAXBElement<Object>(_Return_QNAME, Object.class, null, value);
    }

}
