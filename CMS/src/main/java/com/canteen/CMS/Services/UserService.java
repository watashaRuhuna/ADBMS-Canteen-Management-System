package com.canteen.CMS.Services;
import com.canteen.CMS.Entity.UserEntity;
import com.canteen.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void userLogin(String user_email, String user_pwd){
//        UserEntity userEntity= userRepo.findByEmailAndPassword(user_email,user_pwd);
        System.out.println(user_email);
        System.out.println(user_pwd);
//        return  userEntity;
    }
}