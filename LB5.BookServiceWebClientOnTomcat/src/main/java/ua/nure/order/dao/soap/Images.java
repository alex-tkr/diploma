
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Images", propOrder = {
    "image"
})
public class Images {

    protected List<Image> image;

    public List<Image> getImage() {
        if (image == null) {
            image = new ArrayList<Image>();
        }
        return this.image;
    }

    @Override
    public String toString() {
        return "Images{" +
                "image=" + image +
                '}';
    }
}
