package invex.test.com.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Comment("Unique identifier of the entity")
    @Id
    @GeneratedValue(generator = "optional-uuid")
    @GenericGenerator(name = "optional-uuid", strategy = "invex.test.com.database.entity.OptionalUuidGeneratorImpl")
    @Column(name = "id", columnDefinition = "VARCHAR(36)", length = 36)
    private String id;

    @Comment("Indicates if the entity is active and available for operations")
    @Builder.Default
    private Boolean enabled = true;

    @Comment("Soft deletion flag")
    @Builder.Default
    private Boolean deleted = false;

    @Comment("Timestamp of the last modification to this entity")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    )
    @LastModifiedDate
    @Builder.Default
    private LocalDateTime lastUpdated = LocalDateTime.now();

    @Comment("Timestamp when this entity was first created")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    )
    @CreatedDate
    @Builder.Default
    private LocalDateTime createdOn = LocalDateTime.now();

    @Comment("Username or identifier of the user who performed the last modification")
    @LastModifiedBy
    private String modifiedBy;
}