package com.example.CrawlerTest;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

@SpringBootApplication
@EnableBatchProcessing
public class CrawlerTestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CrawlerTestApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("job.xml");
        final String jobName = "crawlerJob";
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job)context.getBean(jobName);
        JobParametersBuilder builder = new JobParametersBuilder();
        JobParameters jobParameters = builder.toJobParameters();
        try {
            JobExecution result = launcher.run(job,jobParameters);
            System.out.println("------------"+result.toString());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
	}
}
