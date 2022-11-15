package enicar.soc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notifcation_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "notifcation_id_sequence")
    private Long id;
    private String content;
    private String sender;
    private String receiver_email;
    private Long receiver_id;
}
