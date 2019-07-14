<div>
    <#list tasks as task>
    <div><id>${task.id}</id>
        <tname>${task.taskname}</tname></div>
    <div><product>${task.product}</product></div>
    <div><descr>${task.description}</descr></div>
    <div><addr>${task.address}</addr></div>
    <div><status>${task.taskstatus}</status></div>
    <div><a href="/user-tasks/${task.user.id}">${task.userName}</a></div>
    <#else>
    No message
    </#list>
</div>