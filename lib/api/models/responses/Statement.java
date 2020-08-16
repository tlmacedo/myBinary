package api.models.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Morteza Tavanarad
 * @version 1.0.0
 * @since 8/7/2017
 */
public class Statement {

    /**
     * Number of transactions returned in this call
     */
    @SerializedName("count")
    private int count;

    /**
     * Array of returned transactions
     */
    @SerializedName("transactions")
    private List<StatementTransaction> transactions;

    public int getCount() {
        return count;
    }

    public List<StatementTransaction> getTransactions() {
        return transactions;
    }
}
