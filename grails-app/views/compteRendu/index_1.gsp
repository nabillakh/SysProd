<html>
<head>
    <meta name="layout" content="main"/>
    <title>qu'as tu a dire?</title>
    <g:javascript library="jquery" plugin="jquery" />
</head>
<body>
    <h1>veux tu chercher des users?</h1>
    <div class="searchForm">
        <g:form controller="searchable" name="userSearchForm">
            <g:textField name="q" value=""/>
            <g:submitButton name="Search For Users" id="search_for_users_button"/>
        </g:form>
    </div>

    <h1>que fais tu?</h1>
    <div class="updateStatusForm">
        <g:formRemote url="[action: 'updateStatus']" update="messages" name="updateStatusForm"
                      onSuccess="document.getElementById('message').value='';">
            <g:textArea name="message" value=""/><br/>
            <g:submitButton name="Update Status" id="update_status_button"/>
        </g:formRemote>
    </div>
    <div id="messages">
        <compteRendus:renderMessages messages="${compteRenduMessages}"/>
    </div>
</body>
</html>