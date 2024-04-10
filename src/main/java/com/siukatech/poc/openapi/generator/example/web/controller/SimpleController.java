package com.siukatech.poc.openapi.generator.example.web.controller;

import com.siukatech.poc.openapi.generator.example.web.api.SimpleApi;
import com.siukatech.poc.openapi.generator.example.web.model.SimpleModel;
import com.siukatech.poc.openapi.generator.example.web.model.SimplePage;
import com.siukatech.poc.react.backend.parent.web.annotation.base.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@RestApiController
//@PublicApiV1Controller
public class SimpleController implements SimpleApi {

    private List<SimpleModel> simpleModelList = List.of(new SimpleModel(1, 1, "type", "title")
            , new SimpleModel(2, 1, "type", "title")
            , new SimpleModel(3, 1, "type", "title")
    );

    @Override
    public ResponseEntity<List<SimpleModel>> listSimple() {
//        return SimpleApi.super.listSimple();
        return ResponseEntity.ok(simpleModelList);
    }

//    @Override
//    public ResponseEntity<PaginateSimple200Response> paginateSimple(Pageable pageable) {
//        log.debug("paginateSimple - pageable: [{}]", pageable);
////        return SimpleApi.super.paginateSimple(pageable);
//        return ResponseEntity.ok(new PaginateSimple200Response()
//                .content(simpleModelList).totalElements(simpleModelList.size()));
//    }

    @Override
    public ResponseEntity<SimplePage> paginateSimple(Pageable pageable) {
        log.debug("paginateSimple - pageable: [{}]", pageable);
//        return SimpleApi.super.paginateSimple(pageable);
        return ResponseEntity.ok(new SimplePage()
                .content(simpleModelList).totalElements(simpleModelList.size()));
    }

}
