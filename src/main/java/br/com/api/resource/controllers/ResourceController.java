package br.com.api.resource.controllers;

import br.com.api.resource.dtos.ResourceDTO;
import br.com.api.resource.models.ResourceEntity;
import br.com.api.resource.services.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/resources")
public class ResourceController {

    final static Logger logger = LoggerFactory.getLogger(ResourceController.class);

    private final ModelMapper mapper;
    private final ResourceService service;

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create a New Resource")
    @ApiResponses(value = {
            @ApiResponse(description = "Resource Created with Success", responseCode = "201",
                    content = @Content(schema = @Schema(implementation = ResourceEntity.class)))
    })
    public ResourceDTO create(@RequestBody ResourceDTO resourceDTO) {
        logger.info("Create new Resource={}", resourceDTO);

        ResourceEntity resourceEntity = service.create(mapper.map(resourceDTO, ResourceEntity.class));

        return mapper.map(resourceEntity, ResourceDTO.class);
    }

    @GetMapping
    @ResponseStatus(OK)
    @Operation(summary = "Find All Resources")
    @ApiResponses(value = {
            @ApiResponse(description = "Resources consulted with Success", responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResourceDTO.class))))
    })
    public List<ResourceDTO> findAll() {
        logger.info("Find All Resources");

        List<ResourceDTO> resourceDTOList = asList(mapper.map(service.findAll(), ResourceDTO[].class));

        logger.info("End of consult={}", resourceDTOList);

        return resourceDTOList;
    }

}