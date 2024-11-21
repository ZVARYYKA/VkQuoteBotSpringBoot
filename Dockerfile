FROM openjdk:21-jdk-slim

ENV VK_API_TOKEN="your_vk_api_token" \
    VK_API_VERSION="5.236"

ENV APP_HOME /app

RUN mkdir $APP_HOME

COPY build/libs/VkQuoteBotSpringBoot-0.0.1-SNAPSHOT.jar $APP_HOME/VkQuoteBotSpringBoot-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME

EXPOSE 8080

CMD ["java", "-jar", "VkQuoteBotSpringBoot-0.0.1-SNAPSHOT.jar"]
