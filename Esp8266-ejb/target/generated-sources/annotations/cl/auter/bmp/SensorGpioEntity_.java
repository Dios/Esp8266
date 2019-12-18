package cl.auter.bmp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SensorGpioEntity.class)
public abstract class SensorGpioEntity_ {

	public static volatile SingularAttribute<SensorGpioEntity, Integer> id;
	public static volatile SingularAttribute<SensorGpioEntity, Integer> gpioValue;
	public static volatile SingularAttribute<SensorGpioEntity, Date> lastDate;

}

