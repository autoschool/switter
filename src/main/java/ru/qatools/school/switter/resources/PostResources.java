package ru.qatools.school.switter.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.javalite.activejdbc.Model;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import ru.qatools.school.switter.models.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
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
    @Path("/{id}/delete")
    public Response deletePost(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Post postToDelete = Post.findById(id);
        if (postToDelete != null) {
            postToDelete.delete();
        }
        return Response.seeOther(
                uriInfo.getBaseUri()
        ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createPost(@FormParam("title") String title,
                           @FormParam("body") String rawBody,
                           @Context UriInfo uriInfo) {
        Post post = new Post();
        post.setTitle(title);

        String body = new PegDownProcessor(Extensions.ALL + Extensions.SUPPRESS_ALL_HTML)
                .markdownToHtml(rawBody);

        post.setBody(body);
        post.saveIt();
        return Response.seeOther(
                uriInfo.getAbsolutePathBuilder().path(
                        String.valueOf(post.getId())
                ).build()
        ).build();
    }

}
