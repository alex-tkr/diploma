
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medicine", propOrder = {
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

    @XmlElement(required = true)
    protected String header;
    @XmlElement(required = true)
    protected String text;
    @XmlElement(required = true)
    protected Images images;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "created_by", required = true)
    protected Pharmacist createdBy;
    @XmlElement(required = true)
    protected Descriptions descriptions;
    @XmlElement(name = "type", required = true)
    protected String type;

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

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    @Override
    public String toString() {
        return "Post{" +
                "header='" + header + '\'' +
                ", text='" + text + '\'' +
                ", images=" + images +
                ", date=" + date +
                ", createdBy=" + createdBy +
                ", descriptions=" + descriptions +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
