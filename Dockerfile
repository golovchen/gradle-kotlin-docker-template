FROM gradle:8.8-jdk21 AS build
COPY --chown=gradle:gradle settings.gradle.kts /home/gradle/src/
COPY --chown=gradle:gradle gradle.properties /home/gradle/src/
COPY --chown=gradle:gradle build.gradle.kts /home/gradle/src/
COPY --chown=gradle:gradle src /home/gradle/src/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:21-slim
# install xargs
RUN apt-get update && apt-get install -y --no-install-recommends findutils && rm -rf /var/lib/apt/lists/*
COPY --from=build /home/gradle/src/build/distributions/kotlin_template-1.0.tar /kotlin_template.tar
WORKDIR /
RUN tar xf kotlin_template.tar
RUN mv /kotlin_template-1.0 /kotlin_template
WORKDIR /kotlin_template
CMD ["/kotlin_template/bin/kotlin_template"]
