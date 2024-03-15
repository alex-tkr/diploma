
package shop.entity;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Description", namespace = "http://it.nure.ua/medicine", propOrder = {
        "text",
        "date",
        "createdBy"
})
public class Description
        extends Entity
{

    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    protected String text;
    @XmlElement(namespace = "http://it.nure.ua/medicine", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "created_by", namespace = "http://it.nure.ua/medicine", required = true)
    protected Pharmacist createdBy;

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
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

    @Override
    public String toString() {
        return "Description{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", createdBy=" + createdBy +
                ", id=" + id +
                '}';
    }
}
