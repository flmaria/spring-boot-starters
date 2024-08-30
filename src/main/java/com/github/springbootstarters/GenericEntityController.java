package com.github.springbootstarters;

import com.github.springbootstarters.model.GenericEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GenericEntityController {

    private List<GenericEntity> entityList = new ArrayList<>();

    {
        GenericEntity entity1 = new GenericEntity();
        entity1.setId(1L);
        entity1.setDescription("entity_1");
        entityList.add(entity1);

        GenericEntity entity2 = new GenericEntity();
        entity2.setId(2L);
        entity2.setDescription("entity_2");
        entityList.add(entity2);
    }


    @RequestMapping("/entity/all")
    public List<GenericEntity> findAll() {
        return entityList;
    }

    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public GenericEntity addEntity(GenericEntity entity) {
        entityList.add(entity);
        return entity;
    }

    @RequestMapping("/entity/findby/{id}")
    public GenericEntity findById(@PathVariable Long id) {
        return entityList.stream().
                filter(entity -> entity.getId().equals(id)).
                findFirst().get();
    }

}
