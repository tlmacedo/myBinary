package api.models.responses;

import api.models.requests.JapanKnowledgeTestRequest;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * @author Morteza Tavanarad
 * @version 1.0.0
 * @since 8/30/2017
 */
public class JapanKnowledgeTestResponse extends ResponseBase<JapanKnowledgeTestRequest> {

    @SerializedName("jp_knowledge_test")
    private Map<String, Integer> japanKnowledgeTest;

    public Map<String, Integer> getJapanKnowledgeTest() {
        return japanKnowledgeTest;
    }
}
