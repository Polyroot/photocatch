<#import "parts/common.ftl" as common>
<#include "parts/security.ftl">
<@common.page>

<#if isCurrentUser>
<#include "parts/taskEdit.ftl" />
</#if>
<#include "parts/taskList.ftl" />

</@common.page>