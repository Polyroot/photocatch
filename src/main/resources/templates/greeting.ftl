<#include "parts/security.ftl">
<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
<div>
    Это шикарный сервис для анализа рынка путём сканирования актуальных цен в магазинах и супермаркетах
</div>
<div><a href="/boardtasks">Опубликованные задания</a> </div>
<#if isAdmin>
<div><a href="/studiotasks">Создание заданий</a> </div>
</#if>
<div><a href="/login">Login</a> </div>

<@login.logout/>
</@common.page>