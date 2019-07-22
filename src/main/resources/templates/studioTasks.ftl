<#import "parts/common.ftl" as common>

<@common.page>

<div>Создание задачи для курьеров-фотографов</div>

<#include "parts/taskEdit.ftl" />
<form action="/studiotasks" method="post">
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
    </#if>
</form>


</@common.page>
