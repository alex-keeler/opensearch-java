package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class BoolQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        BoolQuery origin = new BoolQuery.Builder().must(buildDummyQuery()).build();
        BoolQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    private Query buildDummyQuery() {
        return Query.of(
            query -> query.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of(1)))))
            )
        );
    }
}
