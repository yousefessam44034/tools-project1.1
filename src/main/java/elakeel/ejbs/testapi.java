package elakeel.ejbs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class testapi {
	@GET
	public String testapi() {
	return "This is el akeel test";
	}
}
