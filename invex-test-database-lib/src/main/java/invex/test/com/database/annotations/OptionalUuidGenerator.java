package invex.test.com.database.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.hibernate.annotations.GenericGenerator;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@GenericGenerator(name = "optional-uuid", strategy = "invex.test.com.database.entity.OptionalUuidGeneratorImpl")
public @interface OptionalUuidGenerator {

    String value() default "optional-uuid";
}