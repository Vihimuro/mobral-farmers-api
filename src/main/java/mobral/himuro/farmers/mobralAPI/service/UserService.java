package mobral.himuro.farmers.mobralAPI.service;

import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.User;
import mobral.himuro.farmers.mobralAPI.dto.UserPostRequestBody;
import mobral.himuro.farmers.mobralAPI.exception.BadRequestException;
import mobral.himuro.farmers.mobralAPI.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public Page<User> listAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User findById (long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Transactional
    public User save(UserPostRequestBody userPostRequestBody) {
        var user = User.builder().nome(userPostRequestBody.getNome()).build();
        return userRepository.save(user);
    }
}
