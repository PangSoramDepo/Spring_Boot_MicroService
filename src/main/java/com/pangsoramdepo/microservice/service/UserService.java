package com.pangsoramdepo.microservice.service;

import com.pangsoramdepo.microservice.entity.User;
import com.pangsoramdepo.microservice.repository.UserRepository;
import com.pangsoramdepo.microservice.vo.Department;
import com.pangsoramdepo.microservice.vo.ResponseTemplateVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = this.userRepository.findByUserId(userId);
        Department department = this.restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
