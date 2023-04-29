# Backend del Portfolio
Esta es la parte backend del proyecto final de argentina programa 4.0

Tecnologias usadas: Java, Spring Boot, MySQL, Clever Cloud y Render

Si quieres ver la parte frontend del proyecto hace click <a href="https://github.com/AngelesDev/Portfolio-Frontend">acá</a>

## Como ejecutarlo con maven

Ten en cuenta que necesitas tener maven instalado, si no lo tienes instalado, acá te dejo una <a href="https://mkyong.com/maven/how-to-install-maven-in-windows/">guia</a> de como instalarlo y ejecutarlo desde cmd.

`$ mvn spring-boot:run`

**Aviso**: Para que la base de datos MySQL se ejecute, necesitas tener instalado `XAMPP` y en él ejecutar el servicio de `Apache` y el servicio de `MySQL`.

Cuando se ejecute el programa, las tablas SQL se crearán automaticamente, puedes checarlo desde <a href="http://localhost/phpmyadmin" target="_blank">phpMyAdmin</a>

## Como construirlo para producción

`$ mvn package`
