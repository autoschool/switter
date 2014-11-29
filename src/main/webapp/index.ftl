<#-- @ftlvariable name="model" type="ru.qatools.school.switter.models.Post[]" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: posts">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <#list model as post>
                <div class="post">
                    <h2 class="entry-title"><a href="/post/${post.id}">${post.title}</a></h2>
                    <p class="entry-meta">Posted on: ${post.createdAt} | By Unknown </p>
                    <div class="entry-description">${post.body}</div>
                </div>
            </#list>
        </div>
    </div>
</div>
</@layout.layout>