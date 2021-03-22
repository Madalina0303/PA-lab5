<html>
<head>
    <title>${title}</title>
        </head>
        <body>
        <h1>${title}</h1>
        <p>${book.id} at ${book.path}</p>
        <ul>
            <#list systems as system>
                <li>${system_index + 1}. ${system.id} at ${system.path}</li>
            </#list>
        </ul>
        </body>
        </html>