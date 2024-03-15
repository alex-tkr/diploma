
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pharmacist", propOrder = {
    "username",
    "image"
})
public class Pharmacist
    extends Entity
{

    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
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
