package sPlanner;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author Kayode
 */
@XmlRootElement
public class RequestBody {
    @XmlElement String sType;
    @XmlElement String vMachines;
}
