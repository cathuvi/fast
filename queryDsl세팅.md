
[//]: # (spring boot 3.0 이상)
[//]: # (jpa - 5.0)
[//]: # (gradle - 7.x)
plugins {
id 'java'
id 'org.springframework.boot' version '3.0.2'
id 'io.spring.dependency-management' version '1.1.0'
}

group = 'com.usafe'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

configurations {
compileOnly {
extendsFrom annotationProcessor
}
}

repositories {
mavenCentral()
}

dependencies {

    implementation 'org.springframework.boot:spring-boot-starter-actuator'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    implementation 'org.springframework.data:spring-data-rest-hal-explorer'

    // Querydsl 추가
    implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
    annotationProcessor "com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jakarta"
    annotationProcessor "jakarta.annotation:jakarta.annotation-api"
    annotationProcessor "jakarta.persistence:jakarta.persistence-api"


    runtimeOnly 'com.h2database:h2'
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
useJUnitPlatform()
}
//querydsl 추가 끝