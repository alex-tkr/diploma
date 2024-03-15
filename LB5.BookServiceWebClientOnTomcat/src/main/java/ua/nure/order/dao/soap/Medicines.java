
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "medicine"
})
@XmlRootElement(name = "medicines")
public class Medicines {

    @Override
    public String toString() {
        return "Medicines{" +
                "medicine=" + medicine +
                '}';
    }

    protected List<Medicine> medicine;

    public List<Medicine> getMedicine() {
        if (medicine == null) {
            medicine = new ArrayList<Medicine>();
        }
        return this.medicine;
    }

}
