<#import "parts/common.ftl" as common>
<@common.page>
<div>Здесь публикуются задания для фотографирования цен на определённые товары в различных магазинах и супермаркетах</div>

<form action="/boardtasks" method="post">
<div>
    <#list tasks as task>
    <div><tname>${task.taskname}</tname></div>
    <div><product>${task.product}</product></div>
    <div><descr>${task.description}</descr></div>
    <div><addr>${task.address}</addr></div>
    <div><status>${task.taskstatus}</status></div>
    <input type="hidden" value="${task.id}" name="taskId">
    <div>
        <a href="/task/${task.id}">Подробнее о задаче</a>
    </div>
    <div>
        <button type="submit">Взять в работу</button>
    </div>
    <#else>
    No message
</#list>
</div>

</form>


</@common.page>