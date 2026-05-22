package invex.test.com.database.entity;

import java.io.Serializable;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OptionalUuidGeneratorImpl implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        if (object instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) object;
            if (entity.getId() != null && !entity.getId().trim().isEmpty()) {
                return entity.getId();
            }
        }
        return UUID.randomUUID().toString();
    }
}