
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entity")
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


    public Boolean isHidden() {
        return hidden;
    }


    public void setHidden(Boolean value) {
        this.hidden = value;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
