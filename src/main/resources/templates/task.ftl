<#import "parts/common.ftl" as common>
<@common.page>
<div>Здесь отображается подробная информация о задаче, а также можно комментировать задачи курьерам-фотографам</div>

<form action="/task" method="post">
    <#if task??>
    <div>
        <div><id>${task.id}</id>
        <tname>${task.taskname}</tname></div>
        <div><product>${task.product}</product></div>
        <div><descr>${task.description}</descr></div>
        <div><addr>${task.address}</addr></div>
        <div><status>${task.taskstatus}</status></div>
        <div><usr>${task.userName}</usr></div>
    </div>
    <input type="hidden" value="${task.id}" name="taskId">
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">${task.taskstatus}</button>
    </div>
    </#if>
</form>

<form action="resultphoto" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${task.id}" name="taskId">
    <div>
        <input type="file" name="photo">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </div>

    <#list task.photonames as photoname>
        <div>
            <#if photoname??>
            <img src="/img/${photoname}">
            </#if>
        </div>
        <#else>
        No picture
    </#list>
</form>





</@common.page>
