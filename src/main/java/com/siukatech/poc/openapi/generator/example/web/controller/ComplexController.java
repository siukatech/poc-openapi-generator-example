package com.siukatech.poc.openapi.generator.example.web.controller;

import com.siukatech.poc.openapi.generator.example.web.api.ComplexApi;
import com.siukatech.poc.openapi.generator.example.web.model.ComplexModel;
import com.siukatech.poc.openapi.generator.example.web.model.PageModel;
import com.siukatech.poc.openapi.generator.example.web.model.PageResult;
import com.siukatech.poc.openapi.generator.example.web.model.SimpleModel;
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
        List<PageModel> pageModels = complexModelList.stream().map(s -> (PageModel) s).toList();
        return ResponseEntity.ok(new PageResult()
                .content(pageModels).totalElements(complexModelList.size()));
    }
}
