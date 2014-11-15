package ru.qatools.school.switter.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.switter.models.Post;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * eroshenkoam
 * 15/11/14
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class IndexResource {

    @GET
    @Path("/")
    @Template(name = "/index.ftl")
    public List<Post> showIndex() {
        return Post.findAll();
    }

    @GET
    @Path("/about")
    @Template(name = "/about.ftl")
    public String showAbout() {
        return null;
    }

    @GET
    @Path("/credits")
    @Template(name = "/credits.ftl")
    public String showCredits() {
        return null;
    }
}
