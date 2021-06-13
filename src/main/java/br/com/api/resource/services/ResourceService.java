package br.com.api.resource.services;

import br.com.api.resource.models.ResourceEntity;

import java.util.List;

public interface ResourceService {

    ResourceEntity create(ResourceEntity resourceEntity);
    List<ResourceEntity> findAll();

}