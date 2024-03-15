
package ua.nure.order.dao.soap;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "Type")
@XmlEnum
public enum Type {

    LIQUID,
    TABLETS,
    MIXTURE;

    public String value() {
        return name();
    }

    public static Type fromValue(String v) {
        return valueOf(v);
    }

}
