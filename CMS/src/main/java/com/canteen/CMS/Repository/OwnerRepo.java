package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends CrudRepository<OwnerEntity,Integer> {

    OwnerEntity findAllByEmailAndPassword(String email, String pwd);
}
