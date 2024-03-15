
package shop.entity;

import jakarta.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Medicines createMedicines() {
        return new Medicines();
    }

    public Medicine createMedicine() {
        return new Medicine();
    }

    public Entity createEntity() {
        return new Entity();
    }

    public Image createImage() {
        return new Image();
    }

    public Pharmacist createPharmacist() {
        return new Pharmacist();
    }

    public Images createImages() {
        return new Images();
    }

    public Description createDescription() {
        return new Description();
    }

    public Descriptions createDescriptions() {
        return new Descriptions();
    }

}
