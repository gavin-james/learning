# springboot-task

> 此 demo 主要演示了 Spring Boot 如何快速实现定时任务。

## build.gradle

```groovy
dependencies {
        implementation(
        "org.springframework.boot:spring-boot-starter-web",
        "org.springframework.boot:spring-boot-starter-undertow",
        "org.jboss.xnio:xnio-nio",
        "com.dtflys.forest:forest-spring-boot-starter:1.5.26"
        )
}
```

## TaskConfig.java

> 此处等同于在配置文件配置
>
> ```properties
> spring.task.scheduling.pool.size=20
> spring.task.scheduling.thread-name-prefix=Job-Thread-
> ```

```java
/**
 * <p>
 * 定时任务配置，配置线程池，使用不同线程执行任务，提升效率
 * </p>
 *
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = {"com.xkcoding.task.job"})
public class TaskConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    /**
     * 这里等同于配置文件配置
     * {@code spring.task.scheduling.pool.size=20} - Maximum allowed number of threads.
     * {@code spring.task.scheduling.thread-name-prefix=Job-Thread- } - Prefix to use for the names of newly created threads.
     * {@link org.springframework.boot.autoconfigure.task.TaskSchedulingProperties}
     */
    @Bean
    public Executor taskExecutor() {
        return new ScheduledThreadPoolExecutor(20, new BasicThreadFactory.Builder().namingPattern("Job-Thread-%d").build());
    }
}
```

## TaskJob.java

```java
/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author gavin james
 * @date Created in 2018-11-22 19:09
 */
@Component
@Slf4j
public class TaskJob {

    /**
     * 按照标准时间来算，每隔 10s 执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        log.info("【job1】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }

    /**
     * 从启动时间开始，间隔 2s 执行
     * 固定间隔时间
     */
    @Scheduled(fixedRate = 2000)
    public void job2() {
        log.info("【job2】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }

    /**
     * 从启动时间开始，延迟 5s 后间隔 4s 执行
     * 固定等待时间
     */
    @Scheduled(fixedDelay = 4000, initialDelay = 5000)
    public void job3() {
        log.info("【job3】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }
}
```

## application.yml

```yaml
server:
  port: 8080
# 下面的配置等同于 TaskConfig
#spring:
#  task:
#    scheduling:
#      pool:
#        size: 20
#      thread-name-prefix: Job-Thread-
```

## 参考

- Spring Boot官方文档：https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#boot-features-task-execution-scheduling
