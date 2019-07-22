<#import "parts/common.ftl" as common>
<@common.page>

<form action="/test" method="post">
    <div>
        <input type="text" name="firstname" placeholder="имя">
    </div>
    <div>
        <input type="text" name="oldname" placeholder="отчество">
    </div>
    <div>
        <input type="text" name="lastname" placeholder="фамилия">
    </div>
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Сохранить</button>
    </div>
</form>



</@common.page>