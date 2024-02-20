package piotr.hadala.buy4wheelscar.internal.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import piotr.hadala.buy4wheelscar.internal.entities.ModelEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ModelRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ModelRepository modelRepository;

    @Test
    public void when_FindByName_then_return_ModelEntity() {
        // Given
        ModelEntity savedModel = modelRepository.save(new ModelEntity(1, "TestModel", null, "TestDescription"));

        // When
        Optional<ModelEntity> foundModel = modelRepository.findByName("TestModel");

        // Then
        assertTrue(foundModel.isPresent());
        assertEquals(savedModel.getId(), foundModel.get().getId());
    }

    @Test
    public void when_FindAll_then_return_all_ModelEntities() {
        // Given
        modelRepository.save(new ModelEntity(2, "TestModel1", null, "Description1"));
        modelRepository.save(new ModelEntity(3, "TestModel2", null, "Description2"));

        // When
        List<ModelEntity> models = modelRepository.findAll();

        // Then
        assertEquals(2, models.size());
    }

    @Test
    @Transactional
    public void when_DeleteById_then_ModelEntity_should_be_deleted() {
        // Given
        ModelEntity savedModel = modelRepository
                .save(new ModelEntity(1, "TestModel", null, "TestDescription"));
        assertNotNull(savedModel.getId());
        entityManager.flush();

        // When
        modelRepository.deleteById(savedModel.getId());
        entityManager.flush();
        entityManager.clear();

        // Then
        Optional<ModelEntity> deletedModel = modelRepository.findById(savedModel.getId());
        assertFalse(deletedModel.isPresent());
    }

    @Test
    public void when_DeleteById_that_does_not_exist_then_should_not_throw_exception() {
        // Given
        Integer nonExistentId = -99;

        // When
        assertDoesNotThrow(() -> modelRepository.deleteById(nonExistentId));
    }
}
