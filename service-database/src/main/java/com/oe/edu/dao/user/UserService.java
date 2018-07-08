package com.oe.edu.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
	public UserEntity Login(UserEntity user) {
		return user;
	}
	
	public UserEntity UpdateUser(String id, UserEntity user) {
		return user;
	}

	public UserEntity getUser(String userID) {
		return null;
	}

	public boolean deleteUser(String id) {
		return true;
	}
	
	@ResponseBody
    public List<UserEntity> queryAll(){
        List<UserEntity> list = new ArrayList<UserEntity>();
        list = userRepository.findAll();
        return list;
    }
}
