<#-- @ftlvariable name="model" type="ru.qatools.school.switter.models.Post" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="post">
            <h2 class="entry-title"><a href="/post/${model.id}">${model.title}</a></h2>
            <p class="entry-meta">Posted on: ${model.createdAt} | By Unknown </p>
            <div class="entry-description">${model.body}</div>
        </div>
    </div>
</div>
</@layout.layout>
