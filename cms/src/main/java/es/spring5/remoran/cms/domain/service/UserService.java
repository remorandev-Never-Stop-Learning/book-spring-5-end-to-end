package es.spring5.remoran.cms.domain.service;

import es.spring5.remoran.cms.domain.model.User;
import es.spring5.remoran.cms.domain.repository.UserRepository;
import es.spring5.remoran.cms.domain.vo.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(String id, UserRequest userRequest) {
        final User user = this.userRepository.findById(id).get();
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public User create(UserRequest userRequest) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return userRepository.save(user);
    }

    public void delete(String id) {
        final User user = this.userRepository.findById(id).get();
        this.userRepository.delete(user);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findOne(String id){
        return this.userRepository.findById(id).get();
    }
}
