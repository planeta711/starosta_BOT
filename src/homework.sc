theme: /
    
    state: Homework
        q: Отправить задание на проверку
        a: Нажми на скрепку (в окне набора сообщения). Выбери файл для отправки. Нажми "Открыть". В комментарии к файлу укажи свою фамилию и название работы. Нажми "Отправить".
        a: Либо размести ссылку на свою работу.

        state: ShiftfileEvent
            # событие fileEvent - событие отправки файла пользователем
            event: fileEvent
            script:            
                # сохраняем ссылку на файл с выполненной работой
                $session.filereport = $request.data.eventData[0].url;
                # получаем user.name
                if ($request && $request.rawRequest && $request.rawRequest.message && $request.rawRequest.message.from && $request.rawRequest.message.from.username) {
                    $client.username = "@"+$request.rawRequest.message.from.username;
                }
                # запоминаем user id 
                if ($request && $request.rawRequest && $request.rawRequest.message && $request.rawRequest.message.from && $request.rawRequest.message.from.id) {
                    $client.user_id = $request.rawRequest.message.from.id
                }
                var message = "Студент " + $client.username + " отправил файл с выполненной работой. Ссылка на работу: " + $session.filereport
                # отправляем сообщение куратору
                $temp.response = sendMessageToMentor(message);
            go!: /MainMenu    
            
            # стейт ловит ссылки студентов.    
        state: FileLink
            event: noMatch
            script:
                var message = "Студент " + $client.username + " отправил ссылку на работу: " + $request.query
                $temp.response = sendMessageToMentor(message);
            go!: /MainMenu      