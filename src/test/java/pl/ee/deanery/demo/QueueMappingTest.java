package pl.ee.deanery.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.ee.deanery.dto.QueueDTO;
import pl.ee.deanery.mapper.QueueMapper;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.service.IssueService;

import static org.junit.Assert.*;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QueueMappingTest {

    @MockBean
    private IssueService issueService;

    @Autowired
    private QueueMapper mapper;


    @Test
    public void entityToDTO(){
        QueueEntity queueEntity = QueueEntity.builder()
                .id(10L)
                .name("InformatykaQueue")
                .shortName("INF_Q")
                .build();

        IssueEntity issueEntity1 = IssueEntity.builder()
                .id(6L)
                .studentIndex("12345")
                .queueEntity(queueEntity)
                .build();

        IssueEntity issueEntity2 = IssueEntity.builder()
                .id(20L)
                .studentIndex("45689")
                .queueEntity(queueEntity)
                .build();

        //queueEntity.setIssueEntities(List.of(issueEntity1, issueEntity2));

        assertNotNull(mapper);
        QueueDTO dto = mapper.toQueueDTO(queueEntity);

        assertEquals(Long.valueOf(10L), dto.getId());
        assertEquals("InformatykaQueue", dto.getName());
        assertEquals("INF_Q", dto.getShortName());
        //assertEquals(List.of(6L, 20L), dto.getIssueIds());
    }

    @Test
    public void DTOtoEntity(){
        QueueDTO dto = QueueDTO.builder()
                .id(19L)
                .name("InformatykaQueue")
                .shortName("INF_Q")
                //.issueIds(List.of(3L, 29L))
                .build();

        IssueEntity issueEntity1 = IssueEntity.builder()
                .id(3L)
                .studentIndex("11111")
                .build();

        IssueEntity issueEntity2 = IssueEntity.builder()
                .id(29L)
                .studentIndex("22222")
                .build();

        Mockito.when(issueService.getIssue(3L)).thenReturn(issueEntity1);
        Mockito.when(issueService.getIssue(29L)).thenReturn(issueEntity2);

        assertNotNull(mapper);
        QueueEntity entity = mapper.toQueueEntity(dto);

        assertEquals(Long.valueOf(19L), entity.getId());
        assertEquals("InformatykaQueue", entity.getName());
        assertEquals("INF_Q", entity.getShortName());
        //assertEquals(List.of(issueEntity1, issueEntity2), entity.getIssueEntities());
    }

}
