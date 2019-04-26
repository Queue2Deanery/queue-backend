package pl.ee.deanery.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.ee.deanery.dto.FieldOfStudyDTO;
import pl.ee.deanery.mapper.FieldOfStudyMapper;
import pl.ee.deanery.model.FieldOfStudyEntity;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.service.QueueService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FieldOfStudyMappingTest {

        @MockBean
        QueueService queueService;

        @Autowired
        FieldOfStudyMapper mapper;

        @Test
        public void entityToDTO(){

            QueueEntity queueEntity = QueueEntity.builder()
                    .id(10L)
                    .name("InformatykaQueue")
                    .shortName("INF_Q")
                    .build();

            FieldOfStudyEntity fieldOfStudyEntity = FieldOfStudyEntity.builder()
                    .id(1L)
                    .name("Informatyka")
                    .shortName("INF")
                    .queueEntity(queueEntity)
                    .build();

            assertNotNull(mapper);
            FieldOfStudyDTO dto = mapper.toFieldOfStudyDTO(fieldOfStudyEntity);

            assertNotNull(fieldOfStudyEntity);
            assertEquals(Long.valueOf(1L), dto.getId());
            assertEquals("Informatyka", dto.getName());
            assertEquals("INF", dto.getShortName());
            assertEquals(Long.valueOf(10L), dto.getQueueId());

        }

        @Test
        public void DTOtoEntity(){

            FieldOfStudyDTO dto = FieldOfStudyDTO.builder()
                    .id(15L)
                    .name("Elektrotechnika")
                    .shortName("ELEKTR")
                    .queueId(2L)
                    .build();

            QueueEntity queueFromDb = QueueEntity.builder()
                    .id(2L)
                    .name("ElektrotechnikaQueue")
                    .shortName("ELEKTR_Q")
                    .build();


            Mockito.when(queueService.getQueueById(2L)).thenReturn(queueFromDb);
            FieldOfStudyEntity entity = mapper.toFieldOfStudyEntity(dto);


            assertEquals(Long.valueOf(15L), entity.getId());
            assertEquals("Elektrotechnika", entity.getName());
            assertEquals("ELEKTR", entity.getShortName());
            assertEquals(Long.valueOf(2L), entity.getQueueEntity().getId());
            assertEquals("ElektrotechnikaQueue", entity.getQueueEntity().getName());
            assertEquals("ELEKTR_Q", entity.getQueueEntity().getShortName());

        }
    }
