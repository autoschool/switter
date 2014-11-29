package ru.qatools.school.switter.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.javalite.activejdbc.LazyList;
import ru.qatools.school.switter.models.Post;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Comparator;
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
        LazyList<Post> posts = Post.findAll();
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post first, Post second) {
                return second.getCreatedAt() == null ? 1 : second.getCreatedAt().compareTo(first.getCreatedAt());
            }
        });
        return posts;
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
