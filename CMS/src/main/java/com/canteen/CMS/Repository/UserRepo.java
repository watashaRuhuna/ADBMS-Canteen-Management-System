package com.canteen.CMS.Repository;
import com.canteen.CMS.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity,Integer> {

//    UserEntity findByEmailAndPassword(String user_email,String user_pwd);
    UserEntity findByEmailAndPassword(String email, String pwd);

}
