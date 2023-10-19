package mobral.himuro.farmers.mobralAPI.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.domain.User;
import mobral.himuro.farmers.mobralAPI.dto.FarmPostRequestBody;
import mobral.himuro.farmers.mobralAPI.dto.FieldDto;
import mobral.himuro.farmers.mobralAPI.dto.FieldsPostBody;
import mobral.himuro.farmers.mobralAPI.dto.ResponseFarmDto;
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

import java.util.List;

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
        try{
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
                    .featuresCollection(farmPostRequestBody.getFeaturesCollection())
                    .build();

            System.out.println("fields: \n idFazenda: " +fields.getCdIdFazenda()+
                    "\n featuresCollection: " +fields.getFeaturesCollection());
            ResponseEntity<List<FieldDto>> fieldDtoList = new RestTemplate().exchange("http://localhost:8980/fields",
                    HttpMethod.POST,
                    new HttpEntity<>(fields),
                    new ParameterizedTypeReference<>() {}
            );
            ResponseFarmDto responseFarmDto = new ResponseFarmDto().builder()
                    .farm(savedFarm)
                    .fields(fieldDtoList.getBody())
                    .build();
            return responseFarmDto;
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public Page<Farm> findAllByUserId(Long cdIdUser, Pageable pageable) {
        User user = userService.findById(cdIdUser);
        return farmRepository.findAllByUser(user, pageable);
    }

}
