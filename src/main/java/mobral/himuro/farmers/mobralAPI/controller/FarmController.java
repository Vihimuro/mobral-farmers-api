package mobral.himuro.farmers.mobralAPI.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.dto.FarmPostRequestBody;
import mobral.himuro.farmers.mobralAPI.dto.FeatureCollectionJson;
import mobral.himuro.farmers.mobralAPI.dto.ResponseFarmDto;
import mobral.himuro.farmers.mobralAPI.service.FarmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @GetMapping
    public ResponseEntity<Page<Farm>> list(Pageable pageable) {
        return ResponseEntity.ok(farmService.listAll(pageable));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Page<Farm>> findAllByUser(@PathVariable long id, Pageable pageable){
        return ResponseEntity.ok(farmService.findAllByUserId(id, pageable));
    }

    @PostMapping
    public ResponseEntity<ResponseFarmDto> save(@RequestBody @Valid FarmPostRequestBody farmPostRequestBody) {
        System.out.println(farmPostRequestBody);
        return new ResponseEntity<>(farmService.save(farmPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}/fields")
    public ResponseEntity<FeatureCollectionJson> getFieldsByFarm(@PathVariable long id){
        FeatureCollectionJson featureCollectionJson = farmService.getFieldsByFarm(id);
        if(featureCollectionJson == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(farmService.getFieldsByFarm(id));
    }
}
