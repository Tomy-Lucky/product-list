package com.example.assignment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
