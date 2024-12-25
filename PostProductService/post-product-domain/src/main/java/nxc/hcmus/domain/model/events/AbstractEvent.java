package nxc.hcmus.domain.model.events;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nxc.hcmus.domain.model.ObjectConverter;
import nxc.hcmus.domain.model.enums.EventType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
@Getter
@Setter
public class AbstractEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_id_seq")
    @SequenceGenerator(name = "events_id_seq", sequenceName = "events_id_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EventType type;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @Convert(converter = ObjectConverter.class)
    private Object payload;

    private boolean isProcessed;

    protected AbstractEvent(
            final Long id,
            final EventType type,
            final Object payload
    ) {
        this.id = id;
        this.type = type;
        this.payload = payload;
        this.isProcessed = false;
    }
}
