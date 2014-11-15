<#-- @ftlvariable name="model" type="ru.qatools.school.switter.models.Post" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="page-header">
            <h2>${model.title}</h2>
        </div>
        <div class="post-body">
            ${model.body}
        </div>
    </div>
</div>
</@layout.layout>
