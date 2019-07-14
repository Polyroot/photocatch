<#import "parts/common.ftl" as common>
<#include "parts/security.ftl">
<@common.page>
<div>Здесь публикуются задания для фотографирования цен на определённые товары в различных магазинах и супермаркетах</div>

<#macro showbutton tstatus>
<#if tstatus=="published">
<div>
    <button type="submit">Взять в работу</button>
</div>
</#if>
</#macro>

<div><a href="/user-tasks/${currentUserId}">My tasks</a></div>

<form action="/boardtasks" method="post">
<div>
    <#list tasks as task>
    <div><tname>${task.taskname}</tname></div>
    <div><product>${task.product}</product></div>
    <div><descr>${task.description}</descr></div>
    <div><addr>${task.address}</addr></div>
    <div><status>${task.taskstatus}</status></div>
    <div><usr>${task.userName}</usr></div>
    <input type="hidden" value="${task.id}" name="taskId">
    <div>
        <a href="/task/${task.id}">Подробнее о задаче</a>
    </div>
    <@showbutton task.taskstatus/>
    <#else>
    No message
    </#list>
</div>

</form>


</@common.page>