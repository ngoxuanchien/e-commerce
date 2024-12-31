package nxc.hcmus.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nxc.hcmus.domain.model.ObjectConverter;
import nxc.hcmus.domain.model.enums.RequestStatus;
import nxc.hcmus.domain.model.enums.RequestType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_request")
public abstract class AbstractRequest {

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID requestId;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Convert(converter = ObjectConverter.class)
    private Object payload;

    @CreationTimestamp
    private ZonedDateTime timestamp;

    public AbstractRequest(RequestType type, Object payload) {
        this.type = type;
        this.payload = payload;
        this.status = RequestStatus.PENDING;
    }

    public AbstractRequest accepted() {
        status = RequestStatus.ACCEPTED;
        return this;
    }
}

