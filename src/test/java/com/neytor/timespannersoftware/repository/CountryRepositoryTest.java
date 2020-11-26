package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.DefaultPostgresContainer;
import com.neytor.timespannersoftware.model.CountryEntity;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.assertEquals;

//@DataJpaTest
//@Testcontainers
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@SpringBootTest
@ContextConfiguration(initializers = { DefaultPostgresContainer.Initializer.class })
public class CountryRepositoryTest {

    private EasyRandom generator = new EasyRandom(  );

    @Autowired
    CountryRepository repository;

    @AfterEach
    void afterEach() {
        repository.deleteAll();
    }



    @Test
    void test() {

        CountryEntity entity1 = new CountryEntity(null,"Costa Rica",187,"CS","CSR");
        CountryEntity entity2 = new CountryEntity(null,"Panama",11,"PA","PAN");

        List<CountryEntity> entities = repository.saveAll(Arrays.asList(entity1,entity2));

        assertEquals(3, repository.count());
    }
}
