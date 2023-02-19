theme: /
        
    # Стейт обрабатывает данные, поступающие из ТГ при клике на инлайн-кнопку    
    state: ReceiptCallbackQuery
        event: telegramCallbackQuery
        if: $request.rawRequest.callback_query.data === "Video" 
            go!: /MainMenu/Video
        if: $request.rawRequest.callback_query.data === "Schedule" 
            go!: /MainMenu/Schedule
        if: $request.rawRequest.callback_query.data === "Homework" 
            go!: /Homework            
        if: $request.rawRequest.callback_query.data === "Reminder" 
            go!: /Reminder
        if: $request.rawRequest.callback_query.data === "Bye" 
            go!: /Bye 
        if: $request.rawRequest.callback_query.data === "Yes" 
            go!: /MainMenu/Video/Yes
        if: $request.rawRequest.callback_query.data === "No" 
            go!: /MainMenu    

        if: $request.rawRequest.callback_query.data === "1" 
            a: {{links["presentation1"]}}
        if: $request.rawRequest.callback_query.data === "2" 
            a: {{links["presentation2"]}}           
        if: $request.rawRequest.callback_query.data === "3" 
            a: {{links["presentation3"]}}            
        if: $request.rawRequest.callback_query.data === "4" 
            a: {{links["presentation4"]}}
        if: $request.rawRequest.callback_query.data === "5" 
            a: {{links["presentation5"]}}            
        if: $request.rawRequest.callback_query.data === "6" 
            a: {{links["presentation6"]}}            
        if: $request.rawRequest.callback_query.data === "7" 
            a: {{links["presentation7"]}}            
        if: $request.rawRequest.callback_query.data === "8" 
            a: {{links["presentation8"]}}    
       