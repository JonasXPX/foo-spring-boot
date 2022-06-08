FROM maven:3-amazoncorretto-17 as build

COPY ./ /app

WORKDIR /app

RUN mvn install -DskipTests=true

FROM amazoncorretto:17-alpine as runner

WORKDIR /app

COPY --from=build /app/target/projeto.jar /app

ARG host
ARG port
ARG db
ARG user
ARG pass

ENV HOST=${host}
ENV PORT=${port}
ENV DB=${db}
ENV USER=${user}
ENV PASS=${pass}

CMD ["java", "-jar", "projeto.jar"]