<#import "parts/common.ftl" as common>

<@common.page>

<div>Здесь создаются задание для курьеров-фотографов</div>

<form action="/studiotasks" method="post">
        <div>
            <input type="text" name="taskname" placeholder="название задачи">
        </div>
        <div>
            <input type="text" name="product" placeholder="название товара">
            <input type="text" name="description" placeholder="описание товара">
        </div>
        <div>
            <input type="text" name="address" placeholder="адрес супермаркета">
        </div>
        <div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить заказ</button>
        </div>
</form>

<div>
<#list tasks as task>
    <div><id>${task.id}</id>
        <tname>${task.taskname}</tname></div>
    <div><product>${task.product}</product></div>
    <div><descr>${task.description}</descr></div>
    <div><addr>${task.address}</addr></div>
    <div><status>${task.taskstatus}</status></div>
    <#else>
    No message
</#list>
</div>
</@common.page>
