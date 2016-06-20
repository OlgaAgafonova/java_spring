# Spring

### Загрузка контекста

- конфигурирование на основе Java (использование аннотаций)
>```
>ApplicationContext context = new AnnotationConfigApplicationContext(knights.config.KnightConfig.class);
>```
 
- из одного или нескольких XML файлов
>``` 
>ApplicationContext context = new ClassPathXmlApplicationContext( "knight.xml" );
>```

-  из файловой системы или из библиотеки классов
>```
>ApplicationContext context = new FileSystemXmlApplicationContext( "c:/knight.xml" );
>```

Различие между FileSystemXmlApplicationContext и ClassPathXmlApplication Context состоит в том, что FileSystemXmlApplicationContext будет искать файл knight.xml в определенном месте, внутри файловой системы, тогда как ClassPathXmlApplicationContext будет искать knight.xml по всей библиотеке классов (включая JAR-файлы).