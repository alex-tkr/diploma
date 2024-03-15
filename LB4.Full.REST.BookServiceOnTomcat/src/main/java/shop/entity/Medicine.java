
package shop.entity;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medicine", namespace = "http://it.nure.ua/medicine", propOrder = {
        "header",
        "text",
        "images",
        "date",
        "createdBy",
        "descriptions",
        "type"
})
public class Medicine
        extends Entity
{

    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected String header;
    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected String text;
    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected Images images;
    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "created_by", namespace = "http://it.nure.ua/medicine", required = true)
    protected Pharmacist createdBy;
    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected Descriptions descriptions;
    @XmlElement(name = "type", namespace = "http://it.nure.ua/medicine", required = true)
    @XmlSchemaType(name = "string")
    protected Type type;

    public String getHeader() {
        return header;
    }

    public void setHeader(String value) {
        this.header = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images value) {
        this.images = value;
    }

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    public Pharmacist getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Pharmacist value) {
        this.createdBy = value;
    }

    public Descriptions getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Descriptions value) {
        this.descriptions = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type value) {
        this.type = value;
    }

    @Override
    public String toString() {
        return "Post{" +
                "\nheader='" + header + '\'' +
                ", \ntext='" + text + '\'' +
                ", \nimages=" + images +
                ", \ndate=" + date +
                ", \ncreatedBy=" + createdBy +
                ", \ndescriptions=" + descriptions +
                ", \ntype=" + type +
                ", \nid=" + id +
                '}';
    }
}
