
package shop.entity;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medicines", namespace = "http://it.nure.ua/medicine", propOrder = {
        "medicine"
})
public class Medicines {

    @XmlElement(namespace = "http://it.nure.ua/medicine")
    protected List<Medicine> medicine;

    public List<Medicine> getMedicine() {
        if (medicine == null) {
            medicine = new ArrayList<Medicine>();
        }
        return this.medicine;
    }

    @Override
    public String toString() {
        return "Medicines{" +
                "medicine=" + medicine +
                '}';
    }
}
