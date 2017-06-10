package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, Long>{
}
