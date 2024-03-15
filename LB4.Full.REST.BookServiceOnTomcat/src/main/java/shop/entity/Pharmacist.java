
package shop.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pharmacist", namespace = "http://it.nure.ua/medicine", propOrder = {
        "username",
        "image"
})
public class Pharmacist
        extends Entity
{

    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected String username;
    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected Image image;

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image value) {
        this.image = value;
    }

    @Override
    public String toString() {
        return "Pharmacist{" +
                "username='" + username + '\'' +
                ", image=" + image +
                ", id=" + id +
                '}';
    }
}
