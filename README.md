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

### Автоматическое связывание
- ``@Component( "lonelyHeartsClub" )`` или ``@Named( "lonelyHeartsClub" )``- задание пользовательского ID для компонента.
- ``@Configuration `` - отмечает класс конфигурации.
- ``@ComponentScan`` - сканирование будет запущено для директории, в которой находится класс конфигурации (по умолчанию). Задание нужных директорий: по имени - ``@ComponentScan(basePackages="soundsystem")``, или ``@ComponentScan(basePackages={"soundsystem", "video"})``; по классу (интерфейсу) из пакета - ``@ComponentScan(basePackageClasses={CDPlayer.class, DVDPlayer.class})``

### Явное связывание
- ``@Bean`` - говорит Spring, что метод возвратит объект, который надо зарегистрировать в контексте приложения Spring.

### Смешанное конфигурирование связывания (анотации + XML)
- ``@Import(CDPlayerConfig.class)`` - добавление конфигураций из класса CDPlayerConfig.class к тому классу, у которого есть такая аннотация.
- ``@ImportResource("classpath:cd-config.xml")`` - добавление конфигураций из XML файла к тому классу, у которого есть такая аннотация.
- ``<import resource="cd-config.xml" />`` - добавление конфигураций из другого XML файла к тому файлу, у которого есть такой тег.
- ``<bean class="soundsystem.CDConfig" />`` - добавление конфигураций из JAVA класса к тому файлу, у которого есть такой тег.

### Объемы созданных бинов
- **Singleton** (по умолчанию) - Создается один экземпляр бина для всего приложения. 
- **Prototype** - Новый бин создается для каждой инъекции.  
- **Session** - В web-приложении, создается один экземпляр бина для каждого сеанса, например, корзина в онлайн-магазине. 
- **Request** - В web-приложении, создается экземпляр бина на каждый запрос.

### SpEL

- ``#{artistSelector.selectArtist()?.toUpperCase()}`` - бин с ``ID=artistSelector`` вызывает метод ``selectArtist()``, которые возвращает ``String``. ``?.`` делает проверку: если метод верент ``null``, то метод ``toUpperCase()`` вызван не будет.
- ``T(java.lang.Math)`` - оператор, который возвращает объект ``Class``. 
- ``#{T(java.lang.Math).PI}`` - обращение к статическому полю ``PI`` класса ``Math``. Аналогично можно вызвать статические методы.
- ``#{admin.email matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}`` - пример использования регулярных выражений.
- ``[]`` - оператор, который используется для получения элемента коллекции или массива или одиночного символа из строки, например, ``#{'This is a test'[3]}`` вернет ``s``.
- ``.?[]`` - оператор, который выбирает из коллекции некоторое подмнжество, например, ``#{jukebox.songs.?[artist eq 'Aerosmith']}`` выбирает список песен, где ``artist == 'Aerosmith'``.
- ``.^[]`` - оператор для поиска первого вхождения.
- ``.$[] `` - оператор для поиска последнего вхождения.
- ``.![]`` - отображение коллекции с выбором определенного свойства каждого элемента оригинальной коллекции и помещением его в новую коллекцию. 

# Интересное
- Создание БД со схемой ``schema.sql`` и данными ``test-data.sql``, например, для тестирования:
>```
>@Bean(destroyMethod="shutdown")
>public DataSource dataSource() {
>return new EmbeddedDatabaseBuilder()
>.addScript("classpath:schema.sql")
>.addScript("classpath:test-data.sql")
>.build();
>}
>```
