
package shop.entity;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entity", namespace = "http://it.nure.ua/medicine")
@XmlSeeAlso({
    Medicine.class,
    Image.class,
    Pharmacist.class,
    Description.class
})
public class Entity {

    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "uuid")
    protected String uuid;
    @XmlAttribute(name = "hidden")
    protected Boolean hidden;

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String value) {
        this.uuid = value;
    }

    public boolean isHidden() {
        if (hidden == null) {
            return false;
        } else {
            return hidden;
        }
    }

    public void setHidden(Boolean value) {
        this.hidden = value;
    }

}
