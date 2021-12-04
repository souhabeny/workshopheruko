package com.sip.ams.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;
import com.zaxxer.hikari.*;
@Configuration
public class Configdb {
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Bean
	public DataSource dataSource() {
	HikariConfig config = new HikariConfig();
	config.setJdbcUrl(dbUrl);
	return new HikariDataSource(config);
	}
}
