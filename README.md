# mail-data-processing
Мой учебный проект, который был написан во время прохождения курсов по изучению Spring Framework. mail-data-processing-app обрабатывает входящие 
JSON данные (send-json-to-main-app имитирует трэкер посылки) от почтового трэкера, данные помещаются в базу данных (H2 или postgreSQL в зависимости от выбора
properties.yml). feign-client для микросервисной имитации (исследование возможности передачи данных в учебных целях между микросервисах)
    JDK 1.8  
    Spring(Boot  JPA  Validation  Web)    
PostgreSQL  
H2
