package com.github.springbootstarters;

import com.github.springbootstarters.model.GenericEntity;
import com.github.springbootstarters.repository.GenericEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class SpringBootJPATest {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {

        GenericEntity entity1 = new GenericEntity();
        entity1.setId(10L);
        entity1.setDescription("entity_10");


        GenericEntity genericEntity =
                genericEntityRepository.save(entity1);

        GenericEntity foundedEntity = this.genericEntityRepository.findById(genericEntity.getId()).get();

        assertNotNull(foundedEntity);
        assertEquals(genericEntity.getDescription(), foundedEntity.getDescription());
    }
}
