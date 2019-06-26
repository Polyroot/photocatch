<#import "parts/common.ftl" as common>
<@common.page>
<div>Здесь отображается подробная информация о задаче, а также можно комментировать задачи курьерам-фотографам</div>

<form action="/task" method="post">
    <div>
        <div><id>${task.id}</id>
        <tname>${task.taskname}</tname></div>
        <div><product>${task.product}</product></div>
        <div><descr>${task.description}</descr></div>
        <div><addr>${task.address}</addr></div>
        <div><status>${task.taskstatus}</status></div>
    </div>
    <input type="hidden" value="${task.id}" name="taskId">
    <div>
        <button type="submit">${task.taskstatus}</button>
    </div>
</form>

<form action="/task" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${task.id}" name="taskId">
    <div>
        <input type="file" name="photo">
        <button type="submit">Добавить</button>
    </div>

    <div>
        <#if task.photoname??>
        <img src="/img/${task.photoname}">
        </#if>
    </div>
</form>
</@common.page>
