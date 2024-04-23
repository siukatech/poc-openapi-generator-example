package com.siukatech.poc.openapi.generator.example.web.controller;

import com.siukatech.poc.openapi.generator.example.web.api.ComplexApi;
import com.siukatech.poc.openapi.generator.example.web.model.*;
import com.siukatech.poc.react.backend.parent.web.annotation.base.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@RestApiController
public class ComplexController implements ComplexApi {

    private SimpleModel simpleA = new SimpleModel(1, 1, "type", "title");
    private SimpleModel simpleB = new SimpleModel(2, 1, "type", "title");
    private List<ComplexModel> complexModelList = List.of(
            (new ComplexModel(1, 1, "type")).simpleA(simpleA).simpleB(simpleB)
            , (new ComplexModel(2, 1, "type")).simpleA(simpleA).simpleB(simpleB)
            , (new ComplexModel(3, 1, "type")).simpleA(simpleA).simpleB(simpleB)
    );

    @Override
    public ResponseEntity<PageResult> paginateComplex(Pageable pageable) {
        log.debug("paginateComplex - pageable: [{}]", pageable);
//        return ComplexApi.super.paginateComplex(pageable);
        List<DisPageModel> pageModels = complexModelList.stream().map(s -> (DisPageModel) s).toList();
        return ResponseEntity.ok(new PageResult()
                .content(pageModels).totalElements(complexModelList.size()));
    }

    @Override
    public ResponseEntity<DisPageResult> paginateComplexDis(Pageable pageable) {
        log.debug("paginateComplexDis - pageable: [{}]", pageable);
//        return ComplexApi.super.paginateComplexDis(pageable);
        return ResponseEntity.ok(new ComplexDisPageResult()
                .content(complexModelList).totalElements(complexModelList.size()));
    }

}
