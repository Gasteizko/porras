package es.ucm.fdi.porras.model.compID;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserFriendCompId implements Serializable {

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "friend_id")
  private Long friendId;

  @Override
  public int hashCode() {
    return (int)(userId + friendId);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof UserFriendCompId) {
      UserFriendCompId otherId = (UserFriendCompId) object;
      return (otherId.userId.equals(this.userId)) && (otherId.friendId.equals(this.friendId));
    }
    return false;
  }
}
