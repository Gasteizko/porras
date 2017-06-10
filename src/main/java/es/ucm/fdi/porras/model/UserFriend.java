package es.ucm.fdi.porras.model;

import es.ucm.fdi.porras.model.compID.UserFriendCompId;
import es.ucm.fdi.porras.model.compID.UserPorraCompId;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_friend")
@Access(AccessType.FIELD)
@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserFriend implements Serializable {

  @EmbeddedId
  private UserFriendCompId userFriendCompId;

  @Column(nullable = false)
  @NonNull
  private Boolean active;

  @Column(name = "create_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createTime;

  @LastModifiedDate
  @Column(name = "update_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateTime;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
  @NonNull
  private User user;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "friend_id", nullable = false, updatable = false, insertable = false)
  @NonNull
  private User friend;

}
