package france.insee.sirene;

import france.insee.sirene.messaging.SireneProducer;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Requires(notEnv = Environment.TEST)
@Slf4j
public class SireneService {

    @Inject
    SireneProducer sireneProducer;

    /*public void sireneSearch(Set<SearchCriteria> searchCriteria) {
        SireneSearchEvent event = SireneSearchEvent.builder()
                .id(UUID.randomUUID().toString())
                .searchCriteria(searchCriteria)
                .build();
        log.info(event.criteria()); //TODO -> error here -> rework encapsulation
        sireneProducer.sendSireneSearchEvent(event);
    }*/
}