package mobral.himuro.farmers.mobralAPI.service;

import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.domain.User;
import mobral.himuro.farmers.mobralAPI.dto.FarmPostRequestBody;
import mobral.himuro.farmers.mobralAPI.repository.FarmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;
    private final UserService userService;
    public Page<Farm> listAll(Pageable pageable){
        return farmRepository.findAll(pageable);
    }

    @Transactional
    public Farm save(FarmPostRequestBody farmPostRequestBody) {
        User user = userService.findById(farmPostRequestBody.getCdIdUser());
        Farm farm = Farm.builder()
                .nomeFazenda(farmPostRequestBody.getNomeFazenda())
                .user(user)
                .build();
        return farmRepository.save(farm);
    }

    public Page<Farm> findAllByUserId(Long cdIdUser, Pageable pageable) {
        User user = userService.findById(cdIdUser);
        return farmRepository.findAllByUser(user, pageable);
    }
}
