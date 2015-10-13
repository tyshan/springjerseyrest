package cn.tyshan.rest.resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import cn.tyshan.rest.model.Campaign;
import cn.tyshan.rest.model.Target;

/**
 *
 */
@Component
@Path("/campaign")
@Produces(MediaType.APPLICATION_JSON)
public class CampaignGenerateResource {

	/**
	 * generate json output for a campaign list
	 * 
	 * @param x
	 *            attribute, attributes size in target
	 * @param y
	 *            less equal than 26, target size
	 * @param z
	 *            less equal than 10000, campaign size
	 * @return
	 */
	@GET
	public List<Campaign> generate(@QueryParam("x") @Max(1000) @DefaultValue("1") Integer x,
			@QueryParam("y") @Max(26) @DefaultValue("1") Integer y,
			@QueryParam("z") @Max(10000) @DefaultValue("1") Integer z) {
		List<Campaign> campaigns = new ArrayList<Campaign>();
		Campaign campaign = null;
		for (int i = 1; i <= z; i++) {
			campaign = new Campaign(getZ(i), getPrice());
			for (int j = 1; j <= y; j++) {
				campaign.addTarget(getTarget(y, x));
			}
			campaigns.add(campaign);
		}

		return campaigns;
	}

	private static String getZ(Integer z) {
		return String.format("campaign%d", z);
	}

	private static Target getTarget(Integer y, Integer z) {
		char c = (char) (64 + y);
		String attr = String.format("attr_%s", c);
		Target target = new Target(attr);
		for (int m = 0; m < z; m++) {
			target.addAttr(String.format("%c%d", c, m));
		}
		return target;
	}

	private static BigDecimal getPrice() {
		double d = Math.random() * 1000;
		BigDecimal b = new BigDecimal(d);
		b = b.setScale(2, BigDecimal.ROUND_HALF_UP);
		return b;
	}
}
