
package shop.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image", namespace = "http://it.nure.ua/medicine", propOrder = {
    "imageUrl",
    "imageContent"
})
public class Image
    extends Entity
{

    @XmlElement(name = "image_url", namespace = "http://it.nure.ua/medicine")
    protected String imageUrl;
    @XmlElement(name = "image_content", namespace = "http://it.nure.ua/medicine")
    protected String imageContent;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    public String getImageContent() {
        return imageContent;
    }


    public void setImageContent(String value) {
        this.imageContent = value;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageUrl='" + imageUrl + '\'' +
                ", imageContent='" + imageContent + '\'' +
                ", id=" + id +
                '}';
    }
}
