<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div>
        <label> User Name : </label>
        <div>
            <input type="text" name="username" placeholder="User name"/>
        </div>
    </div>
    <div>
        <label> Password:  </label>
        <div>
            <input type="password" name="password" placeholder="Password"/>
        </div>
    </div>

    <#if isRegisterForm>
    <div>
        <label> Email:  </label>
        <div>
            <input type="email" name="email" placeholder="some@some.com"/>
        </div>
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
    <button type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Sign Out</button>
</form>
</#macro>