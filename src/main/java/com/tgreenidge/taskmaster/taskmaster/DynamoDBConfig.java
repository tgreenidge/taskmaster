package com.tgreenidge.taskmaster.taskmaster;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.tgreenidge.taskmaster")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

//    @Bean
//    public AmazonDynamoDB amazonDynamoDB(){
//        AmazonDynamoDB amazonDynamoDB;
//
//        if (amazonDynamoDBEndpoint.isEmpty()) {
//            amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
//                    .withCredentials(credentialsProvider())
//                    .withRegion(Regions.US_EAST_2)
//                    .build();
//            System.out.println("connecting to remote dynamo in region: " + Regions.US_EAST_2);
//        } else {
//            amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
//                    .withEndpointConfiguration(
//                            new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-east-2"))
//                    .build();
//            System.out.println("connecting to dynamo at endpoint: "+ amazonDynamoDBEndpoint);
//        }
//
//        return amazonDynamoDB;
//    }
//
//
//    public AWSCredentialsProvider credentialsProvider() {
//        return new AWSCredentialsProvider() {
//            @Override
//            public AWSCredentials getCredentials() {
//                return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
//            }
//
//            @Override
//            public void refresh() {
//
//            }
//        };
//    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB
                = new AmazonDynamoDBClient(amazonAWSCredentials());
        amazonDynamoDB.setRegion(Region.getRegion(Regions.US_EAST_2));

        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
}