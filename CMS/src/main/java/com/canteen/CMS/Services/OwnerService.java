package com.canteen.CMS.Services;

import com.canteen.CMS.Entity.OwnerEntity;
import com.canteen.CMS.Repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepo ownerRepo;
    public OwnerEntity ownerLogin(String email, String pwd){

        OwnerEntity ownerEntity= ownerRepo.findAllByEmailAndPassword(email,pwd);
//        OwnerEntity ownerEntity= (OwnerEntity) ownerRepo.findAll();

        return  ownerEntity;

    }

}
