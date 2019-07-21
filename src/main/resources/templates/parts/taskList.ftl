<#macro showbutton tstatus>
<#if tstatus=="published">
<div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Взять в работу</button>
</div>
</#if>
</#macro>

<form  method="post">
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
            <a href="/user-tasks/${task.user.id}">${task.userName}</a>
        </div>
        <div>
            <a href="/task/${task.id}">Подробнее о задаче</a>
        </div>
        <div>
            <a button type="submit" href="/user-tasks/${task.user.id}?task=${task.id}">Изменить</a>
        </div>
        <@showbutton task.taskstatus/>
        <#else>
        No message
    </#list>
    </div>
</form>