package mobral.himuro.farmers.mobralAPI.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.domain.User;
import mobral.himuro.farmers.mobralAPI.dto.*;
import mobral.himuro.farmers.mobralAPI.exception.BadRequestException;
import mobral.himuro.farmers.mobralAPI.repository.FarmRepository;
import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;
    private final UserService userService;
    public Page<Farm> listAll(Pageable pageable){
        return farmRepository.findAll(pageable);
    }

    @Transactional
    public ResponseFarmDto save(FarmPostRequestBody farmPostRequestBody) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JtsModule());
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            User user = userService.findById(farmPostRequestBody.getCdIdUser());
            Farm farm = Farm.builder()
                    .nomeFazenda(farmPostRequestBody.getNomeFazenda())
                    .user(user)
                    .build();
            Farm savedFarm =  farmRepository.save(farm);

            FieldsPostBody fields = FieldsPostBody.builder()
                    .cdIdFazenda(savedFarm.getCdId())
                    .featureCollection(farmPostRequestBody.getFeatureCollection())
                    .build();

            ResponseEntity<FeatureCollectionJson> fieldCollectionResponse = new RestTemplate().exchange("http://localhost:8980/fields",
                    HttpMethod.POST,
                    new HttpEntity<>(fields),
                    new ParameterizedTypeReference<>() {}
            );

            ResponseFarmDto responseFarmDto = ResponseFarmDto.builder()
                    .cdIdUser(savedFarm.getUser().getCdId())
                    .featureCollectionJson(fieldCollectionResponse.getBody())
                    .build();
            return responseFarmDto;
    }

    public Farm findById(Long cdIdFarm) {
        return farmRepository.findById(cdIdFarm)
                .orElseThrow(() -> new BadRequestException("Farm not found"));
    }
    public Page<Farm> findAllByUserId(Long cdIdUser, Pageable pageable) {
        User user = userService.findById(cdIdUser);
        return farmRepository.findAllByUser(user, pageable);
    }

    public FeatureCollectionJson getFieldsByFarm(Long cdIdFarm) {
        Farm farm = findById(cdIdFarm);
        ResponseEntity<FeatureCollectionJson> fieldCollectionResponse = new RestTemplate()
                .exchange("http://localhost:8980/fields/farm/" + farm.getCdId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return fieldCollectionResponse.getBody();
    }

}
