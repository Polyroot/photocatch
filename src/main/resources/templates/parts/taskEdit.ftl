<div>Task editor</div>

<form method="post">
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

        <input type="hidden" name="id" value="<#if task??>${task.id}</#if>" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Сохранить задачу</button>
    </div>
</form>
