package ru.qatools.school.switter.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.switter.models.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * eroshenkoam
 * 15/11/14
 */
@Path("post")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class PostResources {

    @GET
    @Path("/{id}")
    @Template(name = "/post/showPost.ftl")
    public Post showPost(@PathParam("id") int id) {
        return Post.findById(id);
    }

    @GET
    @Path("/all")
    @Template(name = "/post/showPosts.ftl")
    public List<Post> showPosts() {
        return Post.findAll();
    }

    @GET
    @Path("/new")
    @Template(name = "/post/newPost.ftl")
    public Post newPost() {
        return new Post();
    }

    @POST
    @Path("/")
    @Template(name = "/post/showPost.ftl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Post createPost(@FormParam("title") String title,
                           @FormParam("body") String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.saveIt();
        return post;
    }

}
