package mobral.himuro.farmers.mobralAPI.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.dto.FarmPostRequestBody;
import mobral.himuro.farmers.mobralAPI.service.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @GetMapping
    public List<Farm> list() {
        return farmService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Farm>> listByUser(@PathVariable long id){
        return ResponseEntity.ok(farmService.listByUser(id));
    }

    @PostMapping
    public ResponseEntity<Farm> save(@RequestBody @Valid FarmPostRequestBody farmPostRequestBody) {
        return new ResponseEntity<>(farmService.save(farmPostRequestBody), HttpStatus.CREATED);
    }
}
