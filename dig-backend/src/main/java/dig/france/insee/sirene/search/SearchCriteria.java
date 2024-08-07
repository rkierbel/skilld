package dig.france.insee.sirene.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import dig.france.insee.InseeConstant;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;

@Serdeable
@Builder(toBuilder = true)
public record SearchCriteria(@JsonProperty("historicizedSearch-var") SearchVariable searchVar,
                             @JsonProperty("value") String value,
                             @JsonProperty("historicizedSearch-op") SearchOperator operator) {

    static SearchCriteria from(SearchVariable searchVar, String value, SearchOperator operator) {
        return new SearchCriteria(searchVar, value, operator);
    }

    static SearchCriteria from(SearchVariable searchVar, String value) {
        return new SearchCriteria(searchVar, value, SearchOperator.NONE);
    }

    @Override
    public String toString() {
        String stringified = String.join(":", searchVar().getFrenchVariableName(), value());

        return SearchOperator.NONE.equals(this.operator()) ?
                stringified :
                stringified + InseeConstant.WHITESPACE + operator();
    }
}
