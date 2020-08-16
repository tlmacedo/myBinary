package api.models.requests;

import api.models.requests.RequestBase;
import api.models.responses.PortfolioResponse;
import com.google.gson.annotations.SerializedName;

/**
 * <h1>PortfolioRequest</h1>
 *
 * <h2>Portfolio Send</h2>
 * <p>
 *     Receive information about my current portfolio of outstanding options
 * </p>
 *
 * @author Morteza Tavanarad
 * @version 1.0.0
 * @since 8/7/2017
 */
public class PortfolioRequest extends RequestBase {

    @SerializedName("portfolio")
    private final int portfolio = 1;

    public PortfolioRequest() {
        this.responseType = PortfolioResponse.class;
    }
}
