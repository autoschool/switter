<#-- @ftlvariable name="model" type="ru.qatools.school.switter.models.Post" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="post">
            <h2 class="entry-title"><a href="/post/${model.id}">${model.title}</a>
                <span class="glyphicon glyphicon-remove pull-right clickable" data-toggle="modal" data-target="#confirm-delete" data-href="/post/${model.id}/delete" ></span>
            </h2>

            <p class="entry-meta">Posted on: ${model.createdAt} | By Unknown </p>

            <div class="entry-description">${model.body}</div>
        </div>
    </div>
</div>

<div class="modal fade" id="confirm-delete">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">Are you sure you want to delete the post "${model.title}"?</h4>
            </div>
            <div class="modal-footer">
                <form method="post" action="/post/${model.id}/delete">
                    <button type="reset" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button id="remove-post-btn" type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>

        </div>
    </div>
</div>
</@layout.layout>
