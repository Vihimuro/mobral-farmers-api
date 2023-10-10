package mobral.himuro.farmers.mobralAPI.service;

import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.domain.User;
import mobral.himuro.farmers.mobralAPI.dto.FarmPostRequestBody;
import mobral.himuro.farmers.mobralAPI.repository.FarmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;
    private final UserService userService;
    public List<Farm> listAll(){
        return farmRepository.findAll();
    }

    public Farm save(FarmPostRequestBody farmPostRequestBody) {
        User user = userService.findById(farmPostRequestBody.getCdIdUser());
        Farm farm = Farm.builder()
                .nomeFazenda(farmPostRequestBody.getNomeFazenda())
                .user(user)
                .build();
        return farmRepository.save(farm);
    }

    public List<Farm> listByUser(Long cdIdUser) {
        User user = userService.findById(cdIdUser);
        return farmRepository.findAllUserFarms(user);
    }
}
